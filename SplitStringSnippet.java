public class SplitStringSnippet {

	/**
	 * Method that returns an array of the string words, dividing through the separator
	 * @param string Word to split
	 * @param separator Separator that indicates where to split
	 * @return The array of the string words
	 */
	public static String[] splitString(String string, String separator) {
		return string.split(separator);
	}

	public static void main(String args[]) {
		String[] word = splitString("hello beautiful huge world", " ");
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
