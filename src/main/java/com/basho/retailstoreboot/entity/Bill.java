package com.basho.retailstoreboot.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Transient;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Bill {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @EqualsAndHashCode.Include
    private Long id;

    @NotNull
    @ManyToOne
    private Customer customer;

    @PositiveOrZero
    private Double groceryTotal;
    @PositiveOrZero
    private Double nonGroceryTotal;
    @PositiveOrZero
    private Double netPayable;
    @PositiveOrZero
    private Double discount;

    @JsonIgnore
    @ManyToMany
    private Set<Discount> discounts;

    @Transient
    public double getTotal() {
        return this.groceryTotal + this.nonGroceryTotal;
    }
}
