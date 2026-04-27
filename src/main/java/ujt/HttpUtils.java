package ujt;

import java.net.URI;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpRequest.BodyPublishers;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Duration;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Provides methods for making HTTP requests and handling URLs.
 * Built on the standard {@link java.net.http.HttpClient} introduced in Java 11.
 * <p>
 * All network methods return an {@link HttpResult} which carries the status code,
 * response headers, response body, and any error message. This makes failures
 * explicit instead of silently returning {@code null}.
 * @version 2.0.0
 * @see <a href="https://en.wikipedia.org/wiki/Hypertext_Transfer_Protocol">HTTP</a>
 * @see <a href="https://en.wikipedia.org/wiki/URL">URL</a>
 * @see <a href="https://en.wikipedia.org/wiki/Percent-encoding">Percent-encoding</a>
 * @see <a href="https://en.wikipedia.org/wiki/Query_string">Query string</a>
 * @see <a href="https://en.wikipedia.org/wiki/List_of_HTTP_status_codes">HTTP status codes</a>
 */
public class HttpUtils {
	/**
	 * The default request timeout in seconds used by the convenience methods.
	 */
	public static final int DEFAULT_TIMEOUT_SECONDS = 30;

	/**
	 * The result of an HTTP request.
	 * <p>
	 * On success, {@link #error()} is {@code null} and {@link #statusCode()},
	 * {@link #headers()} and {@link #body()} are populated. On failure (network error,
	 * timeout, malformed URL, etc.), {@link #error()} contains a description of what
	 * went wrong, {@link #statusCode()} is {@code -1}, {@link #headers()} is empty,
	 * and {@link #body()} may be {@code null}.
	 *
	 * @param statusCode The HTTP status code, or {@code -1} if the request failed before a response was received.
	 * @param headers    The response headers (multi-valued headers are joined with {@code ", "}).
	 * @param body       The response body, or {@code null} if no body was requested or the request failed.
	 * @param error      A description of the error, or {@code null} on success.
	 */
	public record HttpResult(int statusCode, Map<String, String> headers, String body, String error) {
		/**
		 * @return {@code true} if the request completed without an error (any status code).
		 */
		public boolean ok() {
			return error == null;
		}

		/**
		 * @return {@code true} if the request failed before producing a response.
		 */
		public boolean failed() {
			return error != null;
		}

		/**
		 * @return {@code true} if the request completed and the status code is in the 2xx range.
		 */
		public boolean isSuccess() {
			return error == null && statusCode >= 200 && statusCode < 300;
		}
	}

	private static HttpClient buildClient(int timeoutSeconds) {
		return HttpClient.newBuilder()
				.connectTimeout(Duration.ofSeconds(Math.max(1, timeoutSeconds)))
				.followRedirects(HttpClient.Redirect.NORMAL)
				.build();
	}

	private static HttpRequest.Builder baseRequest(String url, Map<String, String> headers, int timeoutSeconds) {
		HttpRequest.Builder b = HttpRequest.newBuilder()
				.uri(URI.create(url))
				.timeout(Duration.ofSeconds(Math.max(1, timeoutSeconds)));
		if (headers != null) {
			for (Map.Entry<String, String> e : headers.entrySet()) {
				b.header(e.getKey(), e.getValue());
			}
		}
		return b;
	}

	private static Map<String, String> flattenHeaders(HttpResponse<?> res) {
		Map<String, String> out = new LinkedHashMap<>();
		for (Map.Entry<String, List<String>> e : res.headers().map().entrySet()) {
			out.put(e.getKey(), String.join(", ", e.getValue()));
		}
		return out;
	}

	private static HttpResult fail(Exception e) {
		if (e instanceof InterruptedException) {
			Thread.currentThread().interrupt();
		}
		return new HttpResult(-1, Collections.emptyMap(), null, e.getClass().getSimpleName() + ": " + e.getMessage());
	}

	/**
	 * Sends an HTTP GET request and returns the result.
	 * @param url The URL to send the request to.
	 * @return The {@link HttpResult} for the request.
	 */
	public static HttpResult get(String url) {
		return get(url, null, DEFAULT_TIMEOUT_SECONDS);
	}

	/**
	 * Sends an HTTP GET request with the given headers and returns the result.
	 * @param url The URL to send the request to.
	 * @param headers The request headers (may be {@code null}).
	 * @param timeoutSeconds The timeout in seconds for the request.
	 * @return The {@link HttpResult} for the request.
	 */
	public static HttpResult get(String url, Map<String, String> headers, int timeoutSeconds) {
		try {
			HttpRequest req = baseRequest(url, headers, timeoutSeconds).GET().build();
			HttpResponse<String> res = buildClient(timeoutSeconds).send(req, BodyHandlers.ofString());
			return new HttpResult(res.statusCode(), flattenHeaders(res), res.body(), null);
		} catch (Exception e) {
			return fail(e);
		}
	}

	/**
	 * Sends an HTTP POST request with the given body and returns the result.
	 * @param url The URL to send the request to.
	 * @param body The request body.
	 * @return The {@link HttpResult} for the request.
	 */
	public static HttpResult post(String url, String body) {
		return post(url, body, null, DEFAULT_TIMEOUT_SECONDS);
	}

	/**
	 * Sends an HTTP POST request with the given body and headers and returns the result.
	 * The request body is sent as UTF-8.
	 * @param url The URL to send the request to.
	 * @param body The request body.
	 * @param headers The request headers (may be {@code null}).
	 * @param timeoutSeconds The timeout in seconds for the request.
	 * @return The {@link HttpResult} for the request.
	 */
	public static HttpResult post(String url, String body, Map<String, String> headers, int timeoutSeconds) {
		try {
			HttpRequest req = baseRequest(url, headers, timeoutSeconds)
					.POST(BodyPublishers.ofString(body == null ? "" : body, StandardCharsets.UTF_8))
					.build();
			HttpResponse<String> res = buildClient(timeoutSeconds).send(req, BodyHandlers.ofString());
			return new HttpResult(res.statusCode(), flattenHeaders(res), res.body(), null);
		} catch (Exception e) {
			return fail(e);
		}
	}

	/**
	 * Sends an HTTP PUT request with the given body and returns the result.
	 * @param url The URL to send the request to.
	 * @param body The request body.
	 * @return The {@link HttpResult} for the request.
	 */
	public static HttpResult put(String url, String body) {
		return put(url, body, null, DEFAULT_TIMEOUT_SECONDS);
	}

	/**
	 * Sends an HTTP PUT request with the given body and headers and returns the result.
	 * The request body is sent as UTF-8.
	 * @param url The URL to send the request to.
	 * @param body The request body.
	 * @param headers The request headers (may be {@code null}).
	 * @param timeoutSeconds The timeout in seconds for the request.
	 * @return The {@link HttpResult} for the request.
	 */
	public static HttpResult put(String url, String body, Map<String, String> headers, int timeoutSeconds) {
		try {
			HttpRequest req = baseRequest(url, headers, timeoutSeconds)
					.PUT(BodyPublishers.ofString(body == null ? "" : body, StandardCharsets.UTF_8))
					.build();
			HttpResponse<String> res = buildClient(timeoutSeconds).send(req, BodyHandlers.ofString());
			return new HttpResult(res.statusCode(), flattenHeaders(res), res.body(), null);
		} catch (Exception e) {
			return fail(e);
		}
	}

	/**
	 * Sends an HTTP DELETE request and returns the result.
	 * @param url The URL to send the request to.
	 * @return The {@link HttpResult} for the request.
	 */
	public static HttpResult delete(String url) {
		return delete(url, null, DEFAULT_TIMEOUT_SECONDS);
	}

	/**
	 * Sends an HTTP DELETE request with the given headers and returns the result.
	 * @param url The URL to send the request to.
	 * @param headers The request headers (may be {@code null}).
	 * @param timeoutSeconds The timeout in seconds for the request.
	 * @return The {@link HttpResult} for the request.
	 */
	public static HttpResult delete(String url, Map<String, String> headers, int timeoutSeconds) {
		try {
			HttpRequest req = baseRequest(url, headers, timeoutSeconds).DELETE().build();
			HttpResponse<String> res = buildClient(timeoutSeconds).send(req, BodyHandlers.ofString());
			return new HttpResult(res.statusCode(), flattenHeaders(res), res.body(), null);
		} catch (Exception e) {
			return fail(e);
		}
	}

	/**
	 * Sends an HTTP HEAD request and returns the result. The body in the result will be {@code null}.
	 * @param url The URL to send the request to.
	 * @return The {@link HttpResult} for the request (body is {@code null}).
	 * @see <a href="https://en.wikipedia.org/wiki/List_of_HTTP_status_codes">HTTP status codes</a>
	 */
	public static HttpResult head(String url) {
		try {
			HttpRequest req = baseRequest(url, null, DEFAULT_TIMEOUT_SECONDS)
					.method("HEAD", BodyPublishers.noBody())
					.build();
			HttpResponse<Void> res = buildClient(DEFAULT_TIMEOUT_SECONDS).send(req, BodyHandlers.discarding());
			return new HttpResult(res.statusCode(), flattenHeaders(res), null, null);
		} catch (Exception e) {
			return fail(e);
		}
	}

	/**
	 * Sends an HTTP GET request and returns the result without downloading the body.
	 * Useful when you only care about the status code or headers.
	 * @param url The URL to send the request to.
	 * @return The {@link HttpResult} for the request (body is {@code null}).
	 * @see <a href="https://en.wikipedia.org/wiki/List_of_HTTP_status_codes">HTTP status codes</a>
	 */
	public static HttpResult getStatusCode(String url) {
		try {
			HttpRequest req = baseRequest(url, null, DEFAULT_TIMEOUT_SECONDS).GET().build();
			HttpResponse<Void> res = buildClient(DEFAULT_TIMEOUT_SECONDS).send(req, BodyHandlers.discarding());
			return new HttpResult(res.statusCode(), flattenHeaders(res), null, null);
		} catch (Exception e) {
			return fail(e);
		}
	}

	/**
	 * Sends an HTTP GET request and returns the result without downloading the body.
	 * Equivalent to {@link #getStatusCode(String)}; provided for readability when you
	 * mainly care about headers.
	 * @param url The URL to send the request to.
	 * @return The {@link HttpResult} for the request (body is {@code null}).
	 */
	public static HttpResult getHeaders(String url) {
		return getStatusCode(url);
	}

	/**
	 * Downloads the content at a URL to a local file.
	 * Any missing parent directories of {@code destinationPath} must already exist.
	 * @param url The URL to download from.
	 * @param destinationPath The path of the file to write the response body to.
	 * @return The {@link HttpResult} for the request (body is {@code null}; the bytes are written to disk).
	 */
	public static HttpResult downloadFile(String url, String destinationPath) {
		try {
			HttpRequest req = baseRequest(url, null, DEFAULT_TIMEOUT_SECONDS).GET().build();
			Path dest = Paths.get(destinationPath);
			HttpResponse<Path> res = buildClient(DEFAULT_TIMEOUT_SECONDS).send(req, BodyHandlers.ofFile(dest));
			return new HttpResult(res.statusCode(), flattenHeaders(res), null, null);
		} catch (Exception e) {
			return fail(e);
		}
	}

	/**
	 * URL-encodes a string using UTF-8 (application/x-www-form-urlencoded form).
	 * @param str The string to encode.
	 * @return The percent-encoded string, or {@code null} if {@code str} is {@code null}.
	 * @see <a href="https://en.wikipedia.org/wiki/Percent-encoding">Percent-encoding</a>
	 */
	public static String urlEncode(String str) {
		if (str == null) return null;
		return URLEncoder.encode(str, StandardCharsets.UTF_8);
	}

	/**
	 * URL-decodes a string using UTF-8 (application/x-www-form-urlencoded form).
	 * @param str The string to decode.
	 * @return The decoded string, or {@code null} if {@code str} is {@code null} or invalid.
	 * @see <a href="https://en.wikipedia.org/wiki/Percent-encoding">Percent-encoding</a>
	 */
	public static String urlDecode(String str) {
		if (str == null) return null;
		try {
			return URLDecoder.decode(str, StandardCharsets.UTF_8);
		} catch (IllegalArgumentException e) {
			return null;
		}
	}

	/**
	 * Builds a URL query string from a map of parameters. Keys and values are URL-encoded.
	 * The result does not include a leading {@code "?"}.
	 * @param params The query parameters.
	 * @return The encoded query string (e.g. {@code "a=1&b=hello%20world"}), or {@code ""} if {@code params} is empty.
	 * @see <a href="https://en.wikipedia.org/wiki/Query_string">Query string</a>
	 */
	public static String buildQueryString(Map<String, String> params) {
		if (params == null || params.isEmpty()) return "";
		StringBuilder sb = new StringBuilder();
		boolean first = true;
		for (Map.Entry<String, String> e : params.entrySet()) {
			if (e.getKey() == null) continue;
			if (!first) sb.append('&');
			sb.append(urlEncode(e.getKey())).append('=').append(urlEncode(e.getValue() == null ? "" : e.getValue()));
			first = false;
		}
		return sb.toString();
	}

	/**
	 * Parses a URL query string into a map of parameters. Keys and values are URL-decoded.
	 * A leading {@code "?"} is allowed and ignored.
	 * @param query The query string to parse.
	 * @return A map of parameter names to their values. Later occurrences of the same key overwrite earlier ones.
	 * @see <a href="https://en.wikipedia.org/wiki/Query_string">Query string</a>
	 */
	public static Map<String, String> parseQueryString(String query) {
		Map<String, String> out = new LinkedHashMap<>();
		if (query == null || query.isEmpty()) return out;
		String q = query.startsWith("?") ? query.substring(1) : query;
		if (q.isEmpty()) return out;
		for (String pair : q.split("&")) {
			if (pair.isEmpty()) continue;
			int eq = pair.indexOf('=');
			if (eq < 0) {
				out.put(urlDecode(pair), "");
			} else {
				out.put(urlDecode(pair.substring(0, eq)), urlDecode(pair.substring(eq + 1)));
			}
		}
		return out;
	}

	/**
	 * Checks if the given HTTP status code indicates a successful response (2xx).
	 * @param statusCode The status code to check.
	 * @return {@code true} if the status code is in the range 200-299.
	 * @see <a href="https://en.wikipedia.org/wiki/List_of_HTTP_status_codes">HTTP status codes</a>
	 */
	public static boolean isSuccess(int statusCode) {
		return statusCode >= 200 && statusCode < 300;
	}

	/**
	 * Checks if the given HTTP status code indicates a redirection (3xx).
	 * @param statusCode The status code to check.
	 * @return {@code true} if the status code is in the range 300-399.
	 * @see <a href="https://en.wikipedia.org/wiki/List_of_HTTP_status_codes">HTTP status codes</a>
	 */
	public static boolean isRedirect(int statusCode) {
		return statusCode >= 300 && statusCode < 400;
	}

	/**
	 * Checks if the given HTTP status code indicates a client error (4xx).
	 * @param statusCode The status code to check.
	 * @return {@code true} if the status code is in the range 400-499.
	 * @see <a href="https://en.wikipedia.org/wiki/List_of_HTTP_status_codes">HTTP status codes</a>
	 */
	public static boolean isClientError(int statusCode) {
		return statusCode >= 400 && statusCode < 500;
	}

	/**
	 * Checks if the given HTTP status code indicates a server error (5xx).
	 * @param statusCode The status code to check.
	 * @return {@code true} if the status code is in the range 500-599.
	 * @see <a href="https://en.wikipedia.org/wiki/List_of_HTTP_status_codes">HTTP status codes</a>
	 */
	public static boolean isServerError(int statusCode) {
		return statusCode >= 500 && statusCode < 600;
	}
}
