import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

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
	 * This method assign tasks to people. Two options are available:
	 * <ul>
	 * <li>The size of the tasks list is less or equal than the size of the
	 * people list.
	 * <li>The size of the tasks list is greater than the size of the people
	 * list. In this case, other two options are available:
	 * <ul>
	 * <li>Each person have the same number of tasks.
	 * <li>Some people have more tasks than other.
	 * <ul>
	 * <ul>
	 * 
	 * @param tasks
	 *            List of tasks.
	 * @param people
	 *            List of people.
	 */
	public static void assign(ArrayList<String> tasks, ArrayList<String> people) {
		double tasksSize = tasks.size();
		double peopleSize = people.size();
		double taskPerPerson = Math.round(tasksSize / peopleSize);
		if (tasksSize < peopleSize || tasksSize == peopleSize) {
			tasksLessOrEqualThanPeople(tasks, people);
		} else if (tasksSize > peopleSize) {
			double remainder = tasksSize % peopleSize;
			boolean zero = remainder == 0;
			if (zero) {
				remainderZero(tasks, people, taskPerPerson);
			} else {
				while (tasks.size() >= people.size()) {
					remainderZero(tasks, people, taskPerPerson);
				}
				tasksLessOrEqualThanPeople(tasks, people);
			}
		}
	}

	/**
	 * This method can be used when the size of the tasks list is less or equal
	 * than the size of the people list.
	 * 
	 * @param tasks
	 *            List of tasks.
	 * @param people
	 *            List of people.
	 */
	public static void remainderZero(ArrayList<String> tasks, ArrayList<String> people, double taskPerPerson) {
		for (int i = 0; i < people.size(); i++) {
			writeFile("assigned.txt", "----------" + people.get(i) + "---------", true);
			for (int j = 0; j < taskPerPerson; j++) {
				int r = random(0, tasks.size() - 1);
				writeFile("assigned.txt", "*" + tasks.remove(r), true);
			}
		}
	}

	/**
	 * This method can be used when each person have the same number of tasks.
	 * 
	 * @param tasks
	 *            List of tasks.
	 * @param people
	 *            List of people.
	 * @param taskPerPerson
	 *            tasksList.size() / peopleList.size().
	 */
	public static void tasksLessOrEqualThanPeople(ArrayList<String> tasks, ArrayList<String> people) {
		int randomTask, randomPerson;
		String task, person;
		while (tasks.size() > 0) {
			randomTask = random(0, tasks.size() - 1);
			task = tasks.remove(randomTask);
			randomPerson = random(0, people.size() - 1);
			person = people.remove(randomPerson);
			writeFile("assigned.txt", "----------" + person + "----------\n" + task, true);
		}
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
		ArrayList<String> tasks = toList(readFile("tasks.txt"));
		ArrayList<String> people = toList(readFile("people.txt"));
		assign(tasks, people);

	}

}
