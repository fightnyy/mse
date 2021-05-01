package ex.plea.component;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Embeddable;

@Getter
@Setter
@Embeddable
public class Chito {

    private int timepoint;
    private int grade;
    private int intelligence;
    private int health;
    private int speech;
}
