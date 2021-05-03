package ex.plea.component;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Embeddable;

@Getter
@Setter
@Embeddable
public class Chito {

    private int time_point;
    private int grade;
    private int intelligence;
    private int health;
    private int speech;

    public Chito()
    {

    }
    public Chito(int time_point, int grade, int intelligence, int health, int speech) {
        this.time_point = time_point;
        this.grade = grade;
        this.intelligence = intelligence;
        this.health = health;
        this.speech = speech;
    }
}
