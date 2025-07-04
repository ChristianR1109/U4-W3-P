package Christian_Ragonese.entities;

import jakarta.persistence.*;

import java.util.List;
import java.util.UUID;


@Entity
@Table(name = "Elements")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Element {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", updatable = false, nullable = false)
    private UUID id;
    @Column(name = "isbn", updatable = false, nullable = false)
    private String isbn;

    private String title;
    private int pub_year;
    private int n_pages;

    @OneToMany(mappedBy = "element")
    private List<Loan> loans;

    public Element() {

    }

    public Element(String isbn, String title, int pub_year, int n_pages, Loan lent_item) {

        this.isbn = isbn;
        this.title = title;
        this.pub_year = pub_year;
        this.n_pages = n_pages;

    }

    @Override
    public String toString() {
        return "Element{" +
                "id=" + id +
                ", isbn='" + isbn + '\'' +
                ", title='" + title + '\'' +
                ", pub_year=" + pub_year +
                ", n_pages=" + n_pages +
                ", loans=" + loans +
                '}';
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPub_year() {
        return pub_year;
    }

    public void setPub_year(int pub_year) {
        this.pub_year = pub_year;
    }

    public int getN_pages() {
        return n_pages;
    }

    public void setN_pages(int n_pages) {
        this.n_pages = n_pages;
    }


}
