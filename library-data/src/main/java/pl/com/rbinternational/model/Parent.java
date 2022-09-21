package pl.com.rbinternational.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Embeddable
@Getter
@Setter
@NoArgsConstructor
@PrimaryKeyJoinColumn(name = "reader_id")
@Table(name = "parent")
public class Parent extends Reader {
    @Column(name = "address")
    private String address;
    @Column(name = "phone_number")
    private String phoneNumber;

    public Parent(String firstName, String lastName, String address, String phoneNumber) {
        super(firstName, lastName);
        this.address = address;
        this.phoneNumber = phoneNumber;
    }
}
