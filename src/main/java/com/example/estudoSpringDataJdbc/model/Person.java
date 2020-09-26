package com.example.estudoSpringDataJdbc.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;

@Getter @Setter @AllArgsConstructor @NoArgsConstructor
public class Person {
    @Id
    private long id;
    private String firstName;
    private String lastName;

    public Person(String firstName, String lastName) {
        this.id = -1L;
        this.firstName = firstName;
        this.lastName = lastName;
    }

}
