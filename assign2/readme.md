
---

# Astronaut Daily Schedule Organizer

## Overview
This project implements a **console-based application** that helps astronauts organize their daily schedules. The application allows users to add, remove, and view tasks. The project demonstrates several design patterns, such as Singleton, Factory, and Observer.

---

## Project Structure
- `AstronautScheduler.java`: Main class containing the logic for task management and user interaction.
- `Task.java`: Defines the properties and methods for tasks.
- `ScheduleManager.java`: Implements the Singleton pattern to manage tasks.
- `TaskFactory.java`: Uses the Factory pattern to create task objects.

---

## Features
1. **Add a Task**: Allows astronauts to add tasks with a description, start time, end time, and priority.
2. **Remove a Task**: Deletes an existing task based on its description.
3. **View Tasks**: Displays all tasks sorted by start time.
4. **Task Conflict Handling**: Ensures tasks don't overlap.
5. **Factory Pattern**: Creates tasks with varying attributes using the factory pattern.

---

