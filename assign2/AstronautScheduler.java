package assign2;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

// Task Class
class Task {
    private String description;
    private String startTime;
    private String endTime;
    private String priority;

    public Task(String description, String startTime, String endTime, String priority) {
        this.description = description;
        this.startTime = startTime;
        this.endTime = endTime;
        this.priority = priority;
    }

    public String getDescription() {
        return description;
    }

    public String getStartTime() {
        return startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public String getPriority() {
        return priority;
    }

    public boolean isOverlapping(Task other) {
        return this.endTime.compareTo(other.startTime) > 0 && this.startTime.compareTo(other.endTime) < 0;
    }

    @Override
    public String toString() {
        return startTime + " - " + endTime + ": " + description + " [" + priority + "]";
    }
}

// Singleton Pattern for ScheduleManager
class ScheduleManager {
    private static ScheduleManager instance;
    private List<Task> tasks = new ArrayList<>();

    private ScheduleManager() { }

    public static ScheduleManager getInstance() {
        if (instance == null) {
            instance = new ScheduleManager();
        }
        return instance;
    }

    public void addTask(Task task) {
        for (Task t : tasks) {
            if (task.isOverlapping(t)) {
                System.out.println("Error: Task conflicts with existing task " + t.getDescription());
                return;
            }
        }
        tasks.add(task);
        System.out.println("Task added successfully.");
    }

    public void removeTask(String description) {
        tasks.removeIf(t -> t.getDescription().equals(description));
        System.out.println("Task removed successfully.");
    }

    public void viewTasks() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks scheduled for the day.");
        } else {
            tasks.sort(Comparator.comparing(Task::getStartTime));
            for (Task t : tasks) {
                System.out.println(t);
            }
        }
    }
}

// Factory Pattern for creating tasks
class TaskFactory {
    public static Task createTask(String description, String startTime, String endTime, String priority) {
        return new Task(description, startTime, endTime, priority);
    }
}

// Main class for the Astronaut Scheduler
public class AstronautScheduler {
    private static Scanner scanner = new Scanner(System.in);
    private static ScheduleManager manager = ScheduleManager.getInstance();

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n1. Add Task");
            System.out.println("2. Remove Task");
            System.out.println("3. View Tasks");
            System.out.println("4. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    addTask();
                    break;
                case 2:
                    removeTask();
                    break;
                case 3:
                    manager.viewTasks();
                    break;
                case 4:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }

    private static void addTask() {
        System.out.println("Enter task description:");
        String description = scanner.nextLine();

        System.out.println("Enter start time (HH:MM):");
        String startTime = scanner.nextLine();

        System.out.println("Enter end time (HH:MM):");
        String endTime = scanner.nextLine();

        System.out.println("Enter priority (High, Medium, Low):");
        String priority = scanner.nextLine();

        Task task = TaskFactory.createTask(description, startTime, endTime, priority);
        manager.addTask(task);
    }

    private static void removeTask() {
        System.out.println("Enter task description to remove:");
        String description = scanner.nextLine();
        manager.removeTask(description);
    }
}
