package com.basho.retailstoreboot.entity;

import com.basho.retailstoreboot.DiscountKeyEnum;
import com.basho.retailstoreboot.DiscountTypeEnum;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "key", discriminatorType = DiscriminatorType.STRING)
public abstract class Discount {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @EqualsAndHashCode.Include
    private Long id;

    @NotBlank
    @Enumerated(EnumType.STRING)
    @Column(unique = true, insertable = false, updatable = false)
    private DiscountKeyEnum key;

    @PositiveOrZero
    private Double ratio;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(insertable = false, updatable = false)
    private DiscountTypeEnum type;


    @JsonIgnore
    @ManyToMany(mappedBy = "discounts")
    private Set<Bill> bills;

    public Discount(Long id, DiscountKeyEnum key, Double ratio, DiscountTypeEnum type) {
        this(id, key, ratio, type, null);
    }

    @Transient
    public abstract double getDiscount(Bill bill);

    @Transient
    public abstract boolean isApplicable(Bill bill);

}
