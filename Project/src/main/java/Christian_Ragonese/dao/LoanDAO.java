package Christian_Ragonese.dao;

import Christian_Ragonese.entities.Loan;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

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
}
