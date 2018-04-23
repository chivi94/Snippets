import java.util.ArrayList;

public class Launcher {
	
	public static void main(String[] args) {
		TaskAssigner taskAssigner = new TaskAssigner("putos.txt","grupos.txt","assign.txt");
		ArrayList<Person> people = new ArrayList<>();
		ArrayList<Task> tasks = new ArrayList<>();

		for (String person : taskAssigner.getPeople()) {
			Person p = new Person(person);
			people.add(p);
		}
		for (String task : taskAssigner.getTasks()) {
			Task t = new Task(task);
			tasks.add(t);
		}

		taskAssigner.assign(tasks, people);
	}

}
