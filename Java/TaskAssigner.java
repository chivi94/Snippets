import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class TaskAssigner {

	/**
	 * Creates a new File object
	 * 
	 * @param path
	 *            File's path
	 * @return true if the file is successfully created, false in another case
	 */
	public static boolean createFile(String path) {
		File file = null;
		try {
			file = new File(path + ".txt");
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
		return txt = Arrays.stream(txt).filter(s -> (s != null && s.length() > 0)).toArray(String[]::new);
	}

	/**
	 * Writting a file
	 * 
	 * @param file
	 *            File to write
	 * @param content
	 *            Content of file
	 */
	public static void writeFile(String filePath, String content, boolean append) {
		File file = new File(filePath);
		FileWriter fw = null;
		BufferedWriter writer = null;

		try {
			fw = new FileWriter(file.getAbsolutePath(), append);
			writer = new BufferedWriter(fw);
			writer.write(content + "\n");
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

	/**
	 * This method use an array to convert it into an ArrayList.
	 * 
	 * @param array
	 *            The array to convert.
	 * @return an ArrayList with the array elements.
	 */
	public static ArrayList<String> toList(String[] array) {
		ArrayList<String> list = new ArrayList<String>();
		for (int i = 0; i < array.length; i++) {
			list.add(array[i]);
		}
		return list;
	}

	/**
	 * Random numbers with max and min
	 * 
	 * @param min
	 * @param max
	 * @return the random number
	 */
	public static int random(int min, int max) {
		int range = (max - min) + 1;
		return (int) (Math.random() * range) + min;
	}

	/**
	 * This class can be use to assign tasks to people. Two files are needed:
	 * The file with the tasks and the file with the people to assign the tasks.
	 * The program will write a file with the tasks assigned to people in one
	 * file named "assigned.txt".
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		ArrayList<String> tasksList = toList(readFile("tasks.txt"));
		Collections.sort(tasksList);
		for (String grupo : tasksList) {
			writeFile("sortedTasks.txt", grupo, true);
		}
		
		ArrayList<String> peopleList = toList(readFile("people.txt"));
		double taskForPerson = tasksList.size() / peopleList.size();
		for (int i = 0; i < peopleList.size(); i++) {
			writeFile("assigned.txt", "----------" + peopleList.get(i) + "---------", true);
			for (int j = 0; j < taskForPerson; j++) {
				int r = random(0, tasksList.size() - 1);
				writeFile("assigned.txt", "*" + tasksList.remove(r), true);
			}
		}
	}

}
