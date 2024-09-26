package assign1.behavioral;

import java.util.ArrayList;
import java.util.List;

// Define the Observer interface
interface Observer {
    void update(String message);
}

// EmailNotifier and SMSNotifier implement Observer
class EmailNotifier implements Observer {
    public void update(String message) {
        System.out.println("Email Notification: " + message);
    }
}

class SMSNotifier implements Observer {
    public void update(String message) {
        System.out.println("SMS Notification: " + message);
    }
}

// Renamed TaskManager to ObserverTaskManager
class ObserverTaskManager {
    private List<Observer> observers = new ArrayList<>();

    // Method to add observers
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    // Method to notify all observers
    public void notifyObservers(String message) {
        for (Observer observer : observers) {
            observer.update(message);
        }
    }

    public void addTask(String task) {
        // Notify all observers when a task is added
        notifyObservers("New task added: " + task);
    }
}

public class ObserverPatternDemo {
    public static void main(String[] args) {
        ObserverTaskManager taskManager = new ObserverTaskManager();

        // Adding observers
        taskManager.addObserver(new EmailNotifier());
        taskManager.addObserver(new SMSNotifier());

        // Adding a task
        taskManager.addTask("Complete report by 5 PM");
    }
}
