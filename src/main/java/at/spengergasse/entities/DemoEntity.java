package at.spengergasse.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class DemoEntity {
    @Id
    @GeneratedValue
    private int id;
    private String text;

    @Override
    public String toString() {
        return "DemoEntity{" +
                "id=" + id +
                ", text='" + text + '\'' +
                '}';
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
