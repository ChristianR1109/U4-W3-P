package Christian_Ragonese.entities;


import jakarta.persistence.Entity;

@Entity
public class Book extends Element {

    private String author;
    private String genre;

    public Book() {

    }

    public Book(String isb, String title, int pub_year, int n_pages, Loan loan, String author, String genre) {
        super(isb, title, pub_year, n_pages, loan);
        this.author = author;
        this.genre = genre;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
}
