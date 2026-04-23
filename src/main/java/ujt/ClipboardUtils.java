package ujt;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;

/**
 * Provides methods for reading and writing to the system clipboard.
 * Requires a graphical environment — will not work in headless server contexts.
 * @version 1.0.0
 * @see <a href="https://en.wikipedia.org/wiki/Clipboard_(computing)">Clipboard</a>
 */
public class ClipboardUtils {
	static {
		Ujt.ujtCheckJavaVersion();
	}

	/**
	 * Reads the current text content of the system clipboard.
	 * @return The clipboard text, or {@code null} if the clipboard contains no text.
	 * @throws RuntimeException If the clipboard cannot be accessed.
	 */
	public static String read() {
		try {
			Clipboard cb = Toolkit.getDefaultToolkit().getSystemClipboard();
			if (!cb.isDataFlavorAvailable(DataFlavor.stringFlavor)) {
				return null;
			}
			return (String) cb.getData(DataFlavor.stringFlavor);
		} catch (UnsupportedFlavorException | IOException e) {
			throw new RuntimeException("Could not read from clipboard", e);
		}
	}

	/**
	 * Writes a string to the system clipboard, replacing any existing content.
	 * @param text The text to write.
	 * @throws RuntimeException If the clipboard cannot be accessed.
	 */
	public static void write(String text) {
		try {
			Clipboard cb = Toolkit.getDefaultToolkit().getSystemClipboard();
			cb.setContents(new StringSelection(text), null);
		} catch (Exception e) {
			throw new RuntimeException("Could not write to clipboard", e);
		}
	}

	/**
	 * Clears the system clipboard.
	 * @throws RuntimeException If the clipboard cannot be accessed.
	 */
	public static void clear() {
		write("");
	}

	/**
	 * Checks whether the system clipboard currently contains text.
	 * @return {@code true} if the clipboard has text content.
	 */
	public static boolean hasText() {
		try {
			Clipboard cb = Toolkit.getDefaultToolkit().getSystemClipboard();
			return cb.isDataFlavorAvailable(DataFlavor.stringFlavor);
		} catch (Exception e) {
			return false;
		}
	}
}
