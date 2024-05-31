package assignment;

public class To_do {
	public static void main(String[] args) {
		ToDoList toDoList = new ToDoList();

		// Adding tasks to the to-do list
		toDoList.addToDo(new Task("Complete homework", "Finish math assignment by Friday"));
		toDoList.addToDo(new Task("Workout", "Go for a run in the evening"));

		// Viewing the to-do list
		System.out.println("Initial To-Do List:");
		toDoList.viewToDoList();

		// Marking a task as completed
		toDoList.markToDoAsCompleted("Workout");

		// Viewing the updated to-do list
		System.out.println("Updated To-Do List:");
		toDoList.viewToDoList();
	}


}
//Task Class
class Task {
	private String title;
	private String description;
	private boolean completed;

	public Task(String title, String description) {
		this.title = title;
		this.description = description;
		this.completed = false; // By default, a task is not completed
	}

	public String getTitle() {
		return title;
	}

	public String getDescription() {
		return description;
	}

	public boolean isCompleted() {
		return completed;
	}

	public void markCompleted() {
		completed = true;
	}
}

// Node1 Class
class Node1 {
	Task task;
	Node1 next;

	public Node1(Task task) {
		this.task = task;
		this.next = null;
	}
}

// ToDoList Class
class ToDoList {
	Node1 head;

	public ToDoList() {
		this.head = null;
	}

	public void addToDo(Task task) {
		Node1 newNode1 = new Node1(task);
		if (head == null) {
			head = newNode1;
		} else {
			Node1 temp = head;
			while (temp.next != null) {
				temp = temp.next;
			}
			temp.next = newNode1;
		}
	}

	public void markToDoAsCompleted(String title) {
		Node1 current = head;
		while (current != null) {
			if (current.task.getTitle().equals(title)) {
				current.task.markCompleted();
				return;
			}
			current = current.next;
		}
	}

	public void viewToDoList() {
		Node1 current = head;
		while (current != null) {
			System.out.println("Title: " + current.task.getTitle());
			System.out.println("Description: " + current.task.getDescription());
			System.out.println("Completed: " + current.task.isCompleted());
			System.out.println("--------------------------------------");
			current = current.next;
		}
	}
}