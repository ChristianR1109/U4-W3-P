package Christian_Ragonese.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

@Entity
public class Magazine extends Element {
    @Enumerated(EnumType.STRING)
    private Periodicity period;

    public Magazine() {
    }

    public Magazine(String isbn, String title, int pub_year, int n_pages, Loan loan, Periodicity period) {
        super(isbn, title, pub_year, n_pages, loan);
        this.period = period;
    }

    public Periodicity getPeriod() {
        return period;
    }

    public void setPeriod(Periodicity period) {
        this.period = period;
    }
}
