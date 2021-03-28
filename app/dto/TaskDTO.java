package dto;

import models.Task;

public class TaskDTO {
    public long id;
    public String title;
    public boolean done;

    public TaskDTO(long id, String title, boolean done) {
        this.id = id;
        this.title = title;
        this.done = done;
    }

    public TaskDTO(Task task){
        this.id = task.id;
        this.title = task.title;
        this.done = task.done;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }
}
