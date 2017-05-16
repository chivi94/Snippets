public class AsciiSnippet {

	public static void stringToAscii(String string) {
		int n= 0;
		for (int i = 0; i < string.length(); i++) {
			n = (int)string.charAt(i);
			System.out.println(string.charAt(i) + "="
					+ n);
		}
	}

	public static void asciiToString(int[] ascii) {
		char c;
		for (int i = 0; i < ascii.length; i++) {
			c = (char)ascii[i];
			System.out.println(ascii[i]+"="+c);
		}
	}

	public static void main(String args[]) {
		stringToAscii("hello world");
		asciiToString(new int[]{104,101,108,108,111,32,119,111,114,108,100});
	}

}
