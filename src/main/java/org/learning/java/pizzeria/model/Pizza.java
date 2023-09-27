package org.learning.java.pizzeria.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "pizza_list")
public class Pizza {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank(message = "Scrivi il nome della pizza!")
    private String name;
    @NotBlank(message = "Si prega di riempire tutti i campi del form" )
    @Size(min = 10, max=100)
    @Column(length = 100, nullable = false, unique = true)
    private String description;
    @Min(0)
    @NotNull
    private BigDecimal price;
    @OneToMany(mappedBy = "pizza")
    private List<Offerta> Offerta_List;


    public List<Offerta> getOfferta_List() {
        return Offerta_List;
    }

    public void setOfferta_List(List<Offerta> offerta_List) {
        Offerta_List = offerta_List;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

public boolean isEnough(){
        if(Offerta_List.size() >= 10){
            return true;
        }
        return false;
    }
}
