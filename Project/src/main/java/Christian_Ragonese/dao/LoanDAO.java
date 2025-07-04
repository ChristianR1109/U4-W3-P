package Christian_Ragonese.dao;

import Christian_Ragonese.entities.Element;
import Christian_Ragonese.entities.Loan;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;

import java.time.LocalDate;
import java.util.List;

public class LoanDAO {
    private final EntityManager entityManager;


    public LoanDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void save(Loan newLoan) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(newLoan);
        transaction.commit();
        System.out.println("Prestito " + newLoan.getUser() + " salvato con successo!");

    }

    public List<Element> findElOnLoanByCNumber(long card_number) {

        TypedQuery<Element> query = entityManager.createQuery("SELECT l.element FROM Loan l WHERE l.user.card_number = :card_number AND l.effective_end IS NULL", Element.class);
        query.setParameter("card_number", card_number);
        return query.getResultList();
    }

    public List<Loan> findExpAndNotRetLoans() {
        TypedQuery<Loan> query = entityManager.createQuery("SELECT l FROM Loan l WHERE l.expected_end < :today AND l.effective_end IS NULL", Loan.class);
        query.setParameter("today", LocalDate.now());
        return query.getResultList();
    }
}
