package toDoList;
public class ToDoList {
    private Node head;

    public ToDoList() {
        this.head = null;
    }
    public void addToDo(Task task) {
        Node newNode = new Node(task);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }
    public void markToDoAsCompleted(String title) {
        Node current = head;
        while (current != null) {
            if (current.task.getTitle().equals(title)) {
                current.task.markCompleted();
                return;
            }
            current = current.next;
        }
        System.out.println("Task with title \"" + title + "\" not found.");
    }

    public void viewToDoList() {
        Node current = head;
        if (current == null) {
            System.out.println("The to-do list is empty.");
            return;
        }
        while (current != null) {
            Task task = current.task;
            System.out.println("Title: " + task.getTitle());
            System.out.println("Description: " + task.getDescription());
            System.out.println("Completed: " + task.isCompleted());
            System.out.println();
            current = current.next;
        }
    }

    public static void main(String[] args) {
        ToDoList toDoList = new ToDoList();

        Task task1 = new Task("Prepare for final exam", "Review all lecture notes and textbooks.");
        Task task2 = new Task("Complete project", "Finish DSA projects before the deadline.");
        Task task3 = new Task("call sister", "Prepare some questions and call sister to help with her exam.");

        toDoList.addToDo(task1);
        toDoList.addToDo(task2);
        toDoList.addToDo(task3);

        System.out.println("To-Do List:");
        toDoList.viewToDoList();

        System.out.println("Marking 'Complete project' as completed.");
        toDoList.markToDoAsCompleted("Complete project");

        System.out.println("To-Do List after marking 'Complete project' as completed:");
        toDoList.viewToDoList();
    }
}
