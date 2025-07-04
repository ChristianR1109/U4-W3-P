package Christian_Ragonese.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.UUID;

@Entity
public class Loan {
    @Id
    @GeneratedValue
    private UUID loan_id;

    @ManyToOne
    private User user;

    private LocalDate loan_start;
    private LocalDate expected_end;
    private LocalDate effective_end;

    @ManyToOne
    @JoinColumn(name = "element_id")
    private Element element;

    public Loan() {
    }

    public Loan(UUID loan_id, User user, LocalDate loan_start, LocalDate expected_end, LocalDate effective_end) {
        this.loan_id = loan_id;
        this.user = user;
        this.loan_start = loan_start;
        this.expected_end = expected_end;
        this.effective_end = effective_end;

    }

    public UUID getLoan_id() {
        return loan_id;
    }

    public void setLoan_id(UUID loan_id) {
        this.loan_id = loan_id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public LocalDate getLoan_start() {
        return loan_start;
    }

    public void setLoan_start(LocalDate loan_start) {
        this.loan_start = loan_start;
    }

    public LocalDate getExpected_end() {
        return expected_end;
    }

    public void setExpected_end(LocalDate expected_end) {
        this.expected_end = expected_end;
    }

    public LocalDate getEffective_end() {
        return effective_end;
    }

    public void setEffective_end(LocalDate effective_end) {
        this.effective_end = effective_end;
    }

    public Element getElement() {
        return element;
    }

    public void setElement(Element element) {
        this.element = element;
    }
}

