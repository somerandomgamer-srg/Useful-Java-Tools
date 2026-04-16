package UsefulJavaTools;

/**
	* Provides methods for color conversion and manipulation.
	* @version 1.0.0
	* @see <a href="https://en.wikipedia.org/wiki/RGB_color_model">RGB</a>
	* @see <a href="https://en.wikipedia.org/wiki/HSL_and_HSV">HSL and HSV</a>
	* @see <a href="https://en.wikipedia.org/wiki/Relative_luminance">Relative luminance</a>
	* @see <a href="https://en.wikipedia.org/wiki/Complementary_colors">Complementary colors</a>
	* @see <a href="https://en.wikipedia.org/wiki/Contrast_ratio">Contrast ratio</a>
*/
public class ColorUtils {
	static {
		Ujt.checkJavaVersion();
	}

	/**
		* Converts RGB values to a hex color string (e.g. {@code "#ff8800"}).
		* @param r Red (0–255).
		* @param g Green (0–255).
		* @param b Blue (0–255).
		* @return The hex color string.
		* @see <a href="https://en.wikipedia.org/wiki/RGB_color_model">RGB</a>
	*/
	public static String toHex(int r, int g, int b) {
		return String.format("#%02x%02x%02x", r, g, b);
	}

	/**
		* Converts a hex color string to an RGB array {@code [r, g, b]}.
		* Accepts formats {@code "#rrggbb"} and {@code "rrggbb"}.
		* @param hex The hex color string.
		* @return An array {@code [r, g, b]} with values 0–255.
		* @throws IllegalArgumentException If the hex string is invalid.
	*/
	public static int[] fromHex(String hex) {
		hex = hex.startsWith("#") ? hex.substring(1) : hex;
		if (hex.length() != 6) {
			throw new IllegalArgumentException("Invalid hex color: " + hex);
		}
		return new int[]{
			Integer.parseInt(hex.substring(0, 2), 16),
			Integer.parseInt(hex.substring(2, 4), 16),
			Integer.parseInt(hex.substring(4, 6), 16)
		};
	}

	/**
		* Converts RGB values to HSL (hue 0–360, saturation 0–1, lightness 0–1).
		* @param r Red (0–255).
		* @param g Green (0–255).
		* @param b Blue (0–255).
		* @return An array {@code [h, s, l]}.
		* @see <a href="https://en.wikipedia.org/wiki/HSL_and_HSV">HSL</a>
	*/
	public static double[] toHsl(int r, int g, int b) {
		double rf = r / 255.0, gf = g / 255.0, bf = b / 255.0;
		double max = Math.max(rf, Math.max(gf, bf));
		double min = Math.min(rf, Math.min(gf, bf));
		double d = max - min;
		double l = (max + min) / 2.0;
		double h = 0, s = 0;

		if (d != 0) {
			s = d / (1 - Math.abs(2 * l - 1));
			if (max == rf) {
				h = ((gf - bf) / d + 6) % 6;
			} else if (max == gf) {
				h = (bf - rf) / d + 2;
			} else {
				h = (rf - gf) / d + 4;
			}
			h *= 60;
		}
		return new double[]{h, s, l};
	}

	/**
		* Converts HSL values to RGB (each 0–255).
		* @param h Hue (0–360).
		* @param s Saturation (0–1).
		* @param l Lightness (0–1).
		* @return An array {@code [r, g, b]} with values 0–255.
		* @see <a href="https://en.wikipedia.org/wiki/HSL_and_HSV">HSL</a>
	*/
	public static int[] fromHsl(double h, double s, double l) {
		double c = (1 - Math.abs(2 * l - 1)) * s;
		double x = c * (1 - Math.abs((h / 60) % 2 - 1));
		double m = l - c / 2;
		double rf, gf, bf;

		if (h < 60) {
			rf = c; gf = x; bf = 0;
		} else if (h < 120) {
			rf = x; gf = c; bf = 0;
		} else if (h < 180) {
			rf = 0; gf = c; bf = x;
		} else if (h < 240) {
			rf = 0; gf = x; bf = c;
		} else if (h < 300) {
			rf = x; gf = 0; bf = c;
		} else {
			rf = c; gf = 0; bf = x;
		}

		return new int[]{
			(int) Math.round((rf + m) * 255),
			(int) Math.round((gf + m) * 255),
			(int) Math.round((bf + m) * 255)
		};
	}

	/**
		* Converts RGB values to HSV (hue 0–360, saturation 0–1, value 0–1).
		* @param r Red (0–255).
		* @param g Green (0–255).
		* @param b Blue (0–255).
		* @return An array {@code [h, s, v]}.
		* @see <a href="https://en.wikipedia.org/wiki/HSL_and_HSV">HSV</a>
	*/
	public static double[] toHsv(int r, int g, int b) {
		double rf = r / 255.0, gf = g / 255.0, bf = b / 255.0;
		double max = Math.max(rf, Math.max(gf, bf));
		double min = Math.min(rf, Math.min(gf, bf));
		double d = max - min;
		double h = 0, s = (max == 0) ? 0 : d / max, v = max;

		if (d != 0) {
			if (max == rf) {
				h = ((gf - bf) / d + 6) % 6;
			} else if (max == gf) {
				h = (bf - rf) / d + 2;
			} else {
				h = (rf - gf) / d + 4;
			}
			h *= 60;
		}
		return new double[]{h, s, v};
	}

	/**
		* Converts HSV values to RGB (each 0–255).
		* @param h Hue (0–360).
		* @param s Saturation (0–1).
		* @param v Value (0–1).
		* @return An array {@code [r, g, b]} with values 0–255.
		* @see <a href="https://en.wikipedia.org/wiki/HSL_and_HSV">HSV</a>
	*/
	public static int[] fromHsv(double h, double s, double v) {
		double c = v * s;
		double x = c * (1 - Math.abs((h / 60) % 2 - 1));
		double m = v - c;
		double rf, gf, bf;

		if (h < 60) {
			rf = c; gf = x; bf = 0;
		} else if (h < 120) {
			rf = x; gf = c; bf = 0;
		} else if (h < 180) {
			rf = 0; gf = c; bf = x;
		} else if (h < 240) {
			rf = 0; gf = x; bf = c;
		} else if (h < 300) {
			rf = x; gf = 0; bf = c;
		} else {
			rf = c; gf = 0; bf = x;
		}

		return new int[]{
			(int) Math.round((rf + m) * 255),
			(int) Math.round((gf + m) * 255),
			(int) Math.round((bf + m) * 255)
		};
	}

	/**
		* Blends two RGB colors together.
		* @param r1 Red of the first color (0–255).
		* @param g1 Green of the first color (0–255).
		* @param b1 Blue of the first color (0–255).
		* @param r2 Red of the second color (0–255).
		* @param g2 Green of the second color (0–255).
		* @param b2 Blue of the second color (0–255).
		* @param ratio How much of the first color to use (0.0 = all second, 1.0 = all first).
		* @return An array {@code [r, g, b]} of the blended color.
	*/
	public static int[] blend(int r1, int g1, int b1, int r2, int g2, int b2, double ratio) {
		return new int[] {
			(int) Math.round(r1 * ratio + r2 * (1 - ratio)),
			(int) Math.round(g1 * ratio + g2 * (1 - ratio)),
			(int) Math.round(b1 * ratio + b2 * (1 - ratio))
		};
	}

	/**
		* Returns the complementary color (opposite on the color wheel).
		* @param r Red (0–255).
		* @param g Green (0–255).
		* @param b Blue (0–255).
		* @return An array {@code [r, g, b]} of the complementary color.
		* @see <a href="https://en.wikipedia.org/wiki/Complementary_colors">Complementary colors</a>
	*/
	public static int[] complementary(int r, int g, int b) {
		double[] hsl = toHsl(r, g, b);
		double newHue = (hsl[0] + 180) % 360;
		return fromHsl(newHue, hsl[1], hsl[2]);
	}

	/**
		* Lightens a color by increasing its HSL lightness by the given amount.
		* @param r Red (0–255).
		* @param g Green (0–255).
		* @param b Blue (0–255).
		* @param amount Amount to add to lightness (0–1).
		* @return An array {@code [r, g, b]} of the lightened color.
	*/
	public static int[] lighten(int r, int g, int b, double amount) {
		double[] hsl = toHsl(r, g, b);
		return fromHsl(hsl[0], hsl[1], Math.min(1.0, hsl[2] + amount));
	}

	/**
		* Darkens a color by decreasing its HSL lightness by the given amount.
		* @param r Red (0–255).
		* @param g Green (0–255).
		* @param b Blue (0–255).
		* @param amount Amount to subtract from lightness (0–1).
		* @return An array {@code [r, g, b]} of the darkened color.
	*/
	public static int[] darken(int r, int g, int b, double amount) {
		double[] hsl = toHsl(r, g, b);
		return fromHsl(hsl[0], hsl[1], Math.max(0.0, hsl[2] - amount));
	}

	/**
		* Calculates the relative luminance of a color (WCAG definition).
		* @param r Red (0–255).
		* @param g Green (0–255).
		* @param b Blue (0–255).
		* @return The relative luminance (0–1).
		* @see <a href="https://en.wikipedia.org/wiki/Relative_luminance">Relative luminance</a>
	*/
	public static double luminance(int r, int g, int b) {
		double[] c = {r / 255.0, g / 255.0, b / 255.0};
		for (int i = 0; i < 3; i++) {
			c[i] = c[i] <= 0.03928 ? c[i] / 12.92 : Math.pow((c[i] + 0.055) / 1.055, 2.4);
		}
		return 0.2126 * c[0] + 0.7152 * c[1] + 0.0722 * c[2];
	}

	/**
		* Returns {@code true} if the color is perceived as light.
		* @param r Red (0–255).
		* @param g Green (0–255).
		* @param b Blue (0–255).
		* @return {@code true} if the color is light.
	*/
	public static boolean isLight(int r, int g, int b) {
		return luminance(r, g, b) > 0.179;
	}

	/**
		* Returns {@code true} if the color is perceived as dark.
		* @param r Red (0–255).
		* @param g Green (0–255).
		* @param b Blue (0–255).
		* @return {@code true} if the color is dark.
	*/
	public static boolean isDark(int r, int g, int b) {
		return !isLight(r, g, b);
	}

	/**
		* Calculates the WCAG contrast ratio between two colors.
		* A ratio of 4.5:1 or higher passes AA accessibility standards for normal text.
		* @param r1 Red of the first color (0–255).
		* @param g1 Green of the first color (0–255).
		* @param b1 Blue of the first color (0–255).
		* @param r2 Red of the second color (0–255).
		* @param g2 Green of the second color (0–255).
		* @param b2 Blue of the second color (0–255).
		* @return The contrast ratio.
		* @see <a href="https://en.wikipedia.org/wiki/Contrast_ratio">Contrast ratio</a>
	*/
	public static double contrastRatio(int r1, int g1, int b1, int r2, int g2, int b2) {
		double l1 = luminance(r1, g1, b1);
		double l2 = luminance(r2, g2, b2);
		double lighter = Math.max(l1, l2);
		double darker  = Math.min(l1, l2);
		return (lighter + 0.05) / (darker + 0.05);
	}
}
