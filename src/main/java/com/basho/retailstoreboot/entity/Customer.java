package com.basho.retailstoreboot.entity;

import com.basho.retailstoreboot.CustomerTypeEnum;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @EqualsAndHashCode.Include
    private Long id;

    @NotBlank
    private String name;

    private LocalDateTime dateCreated = LocalDateTime.now();

    @NotNull
    @Enumerated(EnumType.STRING)
    private CustomerTypeEnum type;

    @JsonIgnore
    @OneToMany(mappedBy = "customer")
    private Set<Bill> bills;
}
