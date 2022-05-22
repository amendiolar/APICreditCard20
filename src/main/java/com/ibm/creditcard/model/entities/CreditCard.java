package com.ibm.creditcard.model.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name = "creditcard", schema = "creditcard")
public class CreditCard
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "your_passion", nullable = false, length =30)
    private String yourPassion;

    private Double monthlySalary;

    @Column(name = "monthly_salary_from")
    private Double monthlySalaryFrom;

    @Column(name = "monthly_salary_to")
    private Double monthlySalaryTo;

    private Integer age;

    @Column(name = "age_from")
    private Integer ageFrom;

    @Column(name = "age_to")
    private Integer ageTo;

    @Column(name = "credit_card_suggested", length = 150)
    private String creditCardSuggested;

    @Column(name = "usario_creacion", nullable = false)
    private String usuarioCreacion;

    @Column(name = "fecha_creacion", nullable = false)
    private Date fechaCreacion;

    @Column(name = "fecha_modificacion")
    private Date fechaModificacion;


    public CreditCard(Long id, String yourPassion, Double monthlySalary, Double monthlySalaryFrom, Double monthlySalaryTo, Integer age, Integer ageFrom, Integer ageTo, String creditCardSuggested) {
        this.id = id;
        this.yourPassion = yourPassion;
        this.monthlySalary = monthlySalary;
        this.monthlySalaryFrom = monthlySalaryFrom;
        this.monthlySalaryTo = monthlySalaryTo;
        this.age = age;
        this.ageFrom = ageFrom;
        this.ageTo = ageTo;
        this.creditCardSuggested = creditCardSuggested;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CreditCard)) return false;
        CreditCard that = (CreditCard) o;
        return Objects.equals(getId(), that.getId()) && Objects.equals(getYourPassion(), that.getYourPassion()) && Objects.equals(getMonthlySalary(), that.getMonthlySalary()) && Objects.equals(getMonthlySalaryFrom(), that.getMonthlySalaryFrom()) && Objects.equals(getMonthlySalaryTo(), that.getMonthlySalaryTo()) && Objects.equals(getAge(), that.getAge()) && Objects.equals(getAgeFrom(), that.getAgeFrom()) && Objects.equals(getAgeTo(), that.getAgeTo()) && Objects.equals(getCreditCardSuggested(), that.getCreditCardSuggested()) && Objects.equals(getUsuarioCreacion(), that.getUsuarioCreacion()) && Objects.equals(getFechaCreacion(), that.getFechaCreacion()) && Objects.equals(getFechaModificacion(), that.getFechaModificacion());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getYourPassion(), getMonthlySalary(), getMonthlySalaryFrom(), getMonthlySalaryTo(), getAge(), getAgeFrom(), getAgeTo(), getCreditCardSuggested(), getUsuarioCreacion(), getFechaCreacion(), getFechaModificacion());
    }

    @PrePersist
    private void antesPersistir()
    {
        this.fechaCreacion = new Date();
    }


    @PreUpdate
    private void antesActualizar()
    {
        this.fechaModificacion = new Date();
    }

}
