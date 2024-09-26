package assign1.structural;

// Renamed Task to DecoratedTask
interface DecoratedTask {
    void perform();
}

// BasicTask implementing DecoratedTask
class BasicTask implements DecoratedTask {
    private String description;

    public BasicTask(String description) {
        this.description = description;
    }

    public void perform() {
        System.out.println("Performing task: " + description);
    }
}

// Decorator to add completion functionality
class CompletedTaskDecorator implements DecoratedTask {
    private DecoratedTask task;

    public CompletedTaskDecorator(DecoratedTask task) {
        this.task = task;
    }

    public void perform() {
        task.perform();
        System.out.println("Task completed");
    }
}

public class DecoratorPatternDemo {
    public static void main(String[] args) {
        DecoratedTask task = new CompletedTaskDecorator(new BasicTask("Submit report"));
        task.perform();
    }
}
