public class SplitStringSnippet {

	public static String[] splitString(String string, String separator) {
		return string.split(separator);
	}

	public static void main(String args[]) {
		String[] word = splitString("hello beautiful huge world", "..");
		System.out.print("[");
		for (int i = 0; i < word.length; i++) {
			System.out.print(word[i]);
			if (i < word.length - 1) {
				System.out.print(",");
			}
		}
		System.out.print("]");
	}

}
