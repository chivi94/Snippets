import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class ReadingKeyboardSnippet {

	public static void main(String args[]) {
		// Reading with Scanner
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		int n = sc.nextInt();
		

		System.out.println(n);
		System.out.println(s);

		// Reading with BufferedReader
		InputStreamReader isr = null;
		BufferedReader br = null;
		String _s = "";
		int _n = 0;
		try {
			isr = new InputStreamReader(System.in);
			br = new BufferedReader(isr);
			_s = br.readLine();
			_n = Integer.parseInt(br.readLine());

			System.out.println(_s);
			System.out.println(_n);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		sc.close();
	}

}
