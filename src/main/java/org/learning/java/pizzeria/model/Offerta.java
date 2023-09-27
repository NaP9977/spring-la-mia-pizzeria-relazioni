package org.learning.java.pizzeria.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

@Entity
@Table(name="Offerte_speciali")
public class Offerta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer offerta_Id;
    @NotBlank
    private String title;
    @NotNull
private LocalDate startDate;
    @NotNull
private LocalDate endDate;
    @ManyToOne
   /* @JoinColumn(name = "pizza_id", referencedColumnName = "id", nullable = false) */

    private Pizza pizza;

    public Pizza getPizza() {
        return pizza;
    }

    public void setPizza(Pizza pizza) {
        this.pizza = pizza;
    }

    public Integer getOfferta_Id() {
        return offerta_Id;
    }

    public void setOfferta_Id(Integer offerta_Id) {
        this.offerta_Id = offerta_Id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }
}
