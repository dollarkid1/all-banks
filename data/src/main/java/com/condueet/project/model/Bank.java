package com.condueet.project.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Bank {

    @Id
    private Long id;

    private String name;

    private String ussdCode;

}
