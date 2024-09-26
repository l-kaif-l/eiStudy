package assign1.structural;

interface TaskExecutor {
    void executeTask();
}

class Task {
    public void runTask(String taskDetails) {
        System.out.println("Running task: " + taskDetails);
    }
}

class TaskAdapter implements TaskExecutor {
    private Task task;

    public TaskAdapter(Task task) {
        this.task = task;
    }

    @Override
    public void executeTask() {
        task.runTask("Adapted task details");
    }
}

public class AdapterPatternDemo {
    public static void main(String[] args) {
        Task task = new Task();
        TaskExecutor executor = new TaskAdapter(task);
        executor.executeTask();
    }
}