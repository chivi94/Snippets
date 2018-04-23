import java.util.ArrayList;

public class Person {

	private String name;
	private ArrayList<Task> tasks;

	public Person(String name) {
		super();
		this.name = name;
		tasks = new ArrayList<Task>();
	}

	public String getName() {
		return name;
	}

	public ArrayList<Task> getTasks() {
		return tasks;
	}
	
	public void addTask(Task task){
		tasks.add(task);
	}
	
	public String toString(){
		return "Person name:" + getName();
	}
	
	

}
