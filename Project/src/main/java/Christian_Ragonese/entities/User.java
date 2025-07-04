package Christian_Ragonese.entities;


import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "Users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID user_id;
    private String name;
    private String surname;
    private LocalDate b_date;
    private long card_number;

    public User() {
    }

    public User(String name, String surname, LocalDate b_date, long card_number) {
        this.name = name;
        this.surname = surname;
        this.b_date = b_date;
        this.card_number = card_number;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public LocalDate getB_date() {
        return b_date;
    }

    public void setB_date(LocalDate b_date) {
        this.b_date = b_date;
    }

    public long getCard_number() {
        return card_number;
    }

    public void setCard_number(long card_number) {
        this.card_number = card_number;
    }
}
