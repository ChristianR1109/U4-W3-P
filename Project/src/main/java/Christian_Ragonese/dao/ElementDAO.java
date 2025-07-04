package Christian_Ragonese.dao;

import Christian_Ragonese.entities.Element;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;

import java.util.List;


public class ElementDAO {
    private final EntityManager entityManager;


    public ElementDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void save(Element newElement) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(newElement);
        transaction.commit();
        System.out.println("L'elemento " + newElement.getTitle() + " è stato creato correttamente!");
    }

    public Element findByIsbn(String isbn) {
        TypedQuery<Element> query = entityManager.createQuery("SELECT e FROM Element e WHERE e.isbn = :isbn", Element.class);
        query.setParameter("isbn", isbn);
        return query.getSingleResult();

    }

    public void deleteByIsbn(String isbn) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        Query query = entityManager.createQuery("DELETE FROM Element e WHERE e.isbn = :isbn");
        query.setParameter("isbn", isbn);
        query.executeUpdate();
        transaction.commit();
        System.out.println("Elemento cancellato con successo");
    }


    public List<Element> findByPubYear(int pub_year) {

        TypedQuery<Element> query = entityManager.createQuery("SELECT e FROM Element e WHERE e.pub_year = :pub_year ", Element.class);
        query.setParameter("pub_year", pub_year);
        return query.getResultList();
    }

    public List<Element> findByAuthor(String author) {
        TypedQuery<Element> query = entityManager.createQuery("SELECT e FROM Element e WHERE e.author = :author ", Element.class);
        query.setParameter("author", author);
        return query.getResultList();
    }

    public List<Element> findByPartOfTheTitle(String title) {
        TypedQuery<Element> query = entityManager.createQuery("SELECT e FROM Element e WHERE LOWER(e.title) LIKE LOWER(:title) ", Element.class);
        query.setParameter("title", "%" + title + "%");
        return query.getResultList();
    }
}