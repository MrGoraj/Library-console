package pl.com.rbinternational.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
@NoArgsConstructor
@Getter
@Setter
@ToString
@Table(name = "loans")
public class Borrow {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "loan_id", nullable = false)
    private Long id;
    @Column(name = "loan_date")
    @Temporal(TemporalType.DATE)
    private Date loanDate;

    @Column(name = "return_date")
    private Date returnDate;
    @ManyToOne
    @JoinColumn(name = "reader_id", nullable = false)
    private Reader reader;
    @ManyToOne
    @JoinColumn(name = "book_id", nullable = false)
    private Book book;

    public Borrow(Date loanDate, Date returnDate, Reader reader, Book book) {
        this.loanDate = loanDate;
        this.returnDate = returnDate;
        this.reader = reader;
        this.book = book;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Borrow borrow = (Borrow) o;
        return id != null && Objects.equals(id, borrow.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
