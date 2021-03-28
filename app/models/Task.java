package models;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import dto.TaskDTO;
import io.ebean.*;

@Entity

public class Task extends Model {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    public long id;

    @Column(nullable = false)
    public String title;

    @Column(nullable = false)
    public boolean done;

    public Task(long id, String title, boolean done) {
        this.id = id;
        this.title = title;
        this.done = done;
    }

    public Task(String title, boolean done) {
        this.title = title;
        this.done = done;
    }

    public static final Finder<Long, Task> find = new Finder<>(Task.class);

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


    public static Task findById(long id) {
        return Task.find.byId(id);
    }

    public static void deleteById(long id) {
        Task.find.deleteById(id);
    }


}
