import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class FileSnippet {

	/**
	 * Creates a new File object
	 * @param path File's path
	 * @return true if the file is successfully created, false in another case
	 */
	public static boolean createFile(String path){
		File file = null;
		try {
			file =new File(path+".txt");
			return file.createNewFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * Read plain text file
	 * 
	 * @param file
	 *            File to read
	 * @return a String array without the null values of the file
	 */
	public static String[] readFile(String filePath) {
		File file = new File(filePath);
		FileReader fr = null;
		BufferedReader reader = null;
		String txt[] = new String[(int) file.length()];
		try {
			fr = new FileReader(file);
			reader = new BufferedReader(fr);
			for (int i = 0; i < txt.length; i++) {
				txt[i] = reader.readLine();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (fr != null && reader != null) {
				try {
					fr.close();
					reader.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return txt = Arrays.stream(txt)
				.filter(s -> (s != null && s.length() > 0))
				.toArray(String[]::new);
	}

	/**
	 * Writting a file
	 * 
	 * @param file
	 *            File to write
	 * @param content
	 *            Content of file
	 */
	public static void writeFile(String filePath, String content) {
		File file = new File(filePath);
		FileWriter fw = null;
		BufferedWriter writer = null;

		try {
			fw = new FileWriter(file.getAbsolutePath(),true);
			writer = new BufferedWriter(fw);
			writer.write(content+"\n");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (fw != null && writer != null) {
				try {
					writer.close();
					fw.close();
				} catch (IOException ex) {
					ex.printStackTrace();
				}
			}
		}
	}

	public static void main(String args[]) {
		boolean go = true;
		System.out.println("Welcome to file example.");
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String path = "";
		int option = 0;
		do {
			try {

				System.out.println("What do you want?.");
				System.out.print("1-Exit\n" + "2-Create a file\n"
						+ "3-Read a file\n" + "4-Write a file.\n\n"
						+ "Your option: ");
				option = Integer.parseInt(in.readLine());
				switch (option) {
				case 1:
					System.out.println("Bye Bye!");
					go = false;
					break;
				case 2:
					
					System.out.print("Write the file name: ");
					path = in.readLine();
					createFile(path);
					break;
				case 3:
					String[] lines=readFile(path+".txt");
					for (int i = 0; i < lines.length; i++) {
						System.out.println(lines[i]);
					}
					break;
				case 4:
					System.out.println("What do you want to write in the file?:\n");
					String textToWrite = in.readLine();
					writeFile(path+".txt", textToWrite);
					break;
				default:
					System.out.println("Ooops!! Try again.");
					break;
				}

			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				System.out.println("Input a number please.\n");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} while (go);
	}

}
