package Christian_Ragonese;

import Christian_Ragonese.dao.ElementDAO;
import Christian_Ragonese.dao.LoanDAO;
import Christian_Ragonese.dao.UserDAO;
import Christian_Ragonese.entities.*;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.time.LocalDate;

public class Application {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("U4W3Ppu");


    public static void main(String[] args) {
        EntityManager em = emf.createEntityManager();

        Book book1 = new Book("12345", "wwewewe1", 2020, 278, null, "IononTu", "Fantasy");
        Magazine magazine1 = new Magazine("123456", "Gino1", 2021, 888, null, Periodicity.MENSILE);
        User franco = new User("Franco", "Franchetto", LocalDate.of(1999, 11, 27), 1113986);
        LocalDate francoLoan = LocalDate.of(2025, 7, 1);
        Loan loan1 = new Loan(franco, francoLoan, francoLoan.plusDays(30), null);

        ElementDAO ed = new ElementDAO(em);
        UserDAO ud = new UserDAO(em);
        LoanDAO ld = new LoanDAO(em);
        // ed.save(book1);
        // ed.save(magazine1);
        ud.save(franco);
        ld.save(loan1);
        //ed.deleteByIsbn("123456");
        //  System.out.println(ed.findByPubYear(2021));

        //System.out.println(ed.findByAuthor("IononTu"));

        //System.out.println(ed.findByPartOfTheTitle("we"));


        System.out.println("Messaggio test");
        em.close();
        emf.close();
    }

}
