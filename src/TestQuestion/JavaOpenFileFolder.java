package TestQuestion;
import java.io.File;
import java.io.IOException;

public class JavaOpenFileFolder {
	public static void main(String[] args) throws IOException {
		java.awt.Desktop.getDesktop().open(new File("D:\\LeetCode"));
		// java.awt.Desktop.getDesktop().browse();
	}
}