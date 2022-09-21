package pl.com.rbinternational.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@PrimaryKeyJoinColumn(name = "reader_id")
@Table(name = "child")
public class Child extends Reader {

    @ManyToOne
    @JoinColumn(name = "parent_id", nullable = false)
    private Parent parent;

    public Child(String firstName, String lastName, Parent parent) {
        super(firstName, lastName);
        this.parent = parent;
    }
}
