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
        LocalDate ginoLoan = LocalDate.of(2025, 6, 1);
        LocalDate mircoLoan = LocalDate.of(2025, 5, 26);
        LocalDate marcoLoan = LocalDate.of(2025, 5, 25);
        LocalDate mimmoLoan = LocalDate.of(2025, 5, 24);
        Loan loan1 = new Loan(franco, francoLoan, francoLoan.plusDays(30), null);
        User gino = new User("Gino", "Ginetto", LocalDate.of(1998, 5, 17), 1118766);
        User mirco = new User("Mirco", "Mirchetto", LocalDate.of(1995, 7, 7), 1114936);
        User marco = new User("Marco", "Marchetto", LocalDate.of(1994, 7, 7), 1113336);
        User mimmo = new User("Mimmo", "Mimmetto", LocalDate.of(1993, 7, 7), 1112226);
        Loan loan4 = new Loan(marco, marcoLoan, marcoLoan.plusDays(30), null);
        Loan loan5 = new Loan(mimmo, mimmoLoan, mimmoLoan.plusDays(30), null);
        ElementDAO ed = new ElementDAO(em);
        UserDAO ud = new UserDAO(em);
        LoanDAO ld = new LoanDAO(em);
        // ed.save(book1);
        // ed.save(magazine1);
        //ud.save(franco);
        //ld.save(loan1);
        //ud.save(gino);
        //ud.save(mirco);
        ud.save(marco);
        ud.save(mimmo);
        ld.save(loan4);
        ld.save(loan5);
        //ed.deleteByIsbn("123456");
        //  System.out.println(ed.findByPubYear(2021));

        //System.out.println(ed.findByAuthor("IononTu"));

        //System.out.println(ed.findByPartOfTheTitle("we"));

        //System.out.println(ld.findElOnLoanByCNumber(1113986));

        //ld.findExpAndNotRetLoans().forEach(System.out::println);


        System.out.println("Messaggio test");
        em.close();
        emf.close();
    }

}
