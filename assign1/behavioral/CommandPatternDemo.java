package assign1.behavioral;

import java.util.ArrayList;
import java.util.List;

interface Command {
    void execute();
}

class AddTaskCommand implements Command {
    private String task;
    private TaskManager taskManager;

    public AddTaskCommand(TaskManager taskManager, String task) {
        this.taskManager = taskManager;
        this.task = task;
    }

    public void execute() {
        taskManager.addTask(task);
    }
}

class RemoveTaskCommand implements Command {
    private String task;
    private TaskManager taskManager;

    public RemoveTaskCommand(TaskManager taskManager, String task) {
        this.taskManager = taskManager;
        this.task = task;
    }

    public void execute() {
        taskManager.removeTask(task);
    }
}

class TaskManager {
    private List<String> tasks = new ArrayList<>();

    public void addTask(String task) {
        tasks.add(task);
        System.out.println("Task added: " + task);
    }

    public void removeTask(String task) {
        tasks.remove(task);
        System.out.println("Task removed: " + task);
    }
}

public class CommandPatternDemo {
    public static void main(String[] args) {
        TaskManager taskManager = new TaskManager();
        Command addTask = new AddTaskCommand(taskManager, "Complete report");
        Command removeTask = new RemoveTaskCommand(taskManager, "Complete report");

        addTask.execute();
        removeTask.execute();
    }
}