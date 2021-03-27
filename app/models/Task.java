package models;

import javax.persistence.*;
import io.ebean.*;

@Entity
public class Task extends Model {

    @Id
    public long id;

    @Column(nullable = false)
    public String title;

    @Column(nullable = false)
    public boolean done;

    public Task(String title, boolean done) {
        this.title = title;
        this.done = done;
    }

    public Task() {
    }

    //public static final Finder<Long, Task> find = new Finder<>(Task.class);


}
