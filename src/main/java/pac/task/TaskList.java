package pac.task;

import java.util.ArrayList;

/**
 * For the list of Tasks
 */
public class TaskList {
    public ArrayList<Task> tasks;

    public TaskList() {
        this.tasks = new ArrayList<>();
    }

    public TaskList(ArrayList<Task> tasks) {
        this.tasks = tasks;
    }

    public ArrayList<Task> getTasks() {
        return this.tasks;
    }

    public Task get(int i) {
        return this.tasks.get(i);
    }

    public int getSize() {
        return this.tasks.size();
    }

    public boolean isEmpty() {
        return this.tasks.isEmpty();
    }

    public void mark(int index) throws IndexOutOfBoundsException {
        tasks.get(index).markAsDone();
    }

    public void unmark(int index) throws IndexOutOfBoundsException{
        tasks.get(index).markAsNotDone();
    }

    /**
     * returns new TaskList with list of tasks containing the keyword
     * @param keyword
     * @return
     */
    public TaskList find(String keyword) {
        ArrayList<Task> matchingTasks = new ArrayList<>();
        for (Task t : tasks) {
            if(t.getDescription().contains(keyword)) {
                matchingTasks.add(t);
            }
        }
        return new TaskList(matchingTasks);
    }

    public void add(Task task) {
        this.tasks.add(task);
    }

    public void delete(int index) {
        tasks.remove(index);
    }
}
