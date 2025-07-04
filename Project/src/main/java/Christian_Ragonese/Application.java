package Christian_Ragonese;

import Christian_Ragonese.dao.ElementDAO;
import Christian_Ragonese.entities.Book;
import Christian_Ragonese.entities.Magazine;
import Christian_Ragonese.entities.Periodicity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Application {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("U4W3Ppu");


    public static void main(String[] args) {
        EntityManager em = emf.createEntityManager();

        Book book1 = new Book("12345", "wwewewe1", 2020, 278, null, "IononTu", "Fantasy");
        Magazine magazine1 = new Magazine("123456", "Gino1", 2021, 888, null, Periodicity.MENSILE);

        ElementDAO ed = new ElementDAO(em);

        // ed.save(book1);
        // ed.save(magazine1);

        //ed.deleteByIsbn("123456");
        //  System.out.println(ed.findByPubYear(2021));
        System.out.println(ed.findByAuthor("IononTu"));
        System.out.println("Messaggio test");
        em.close();
        emf.close();
    }

}
