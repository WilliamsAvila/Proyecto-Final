package org.amazon.finalproject.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Collection;

import static jakarta.persistence.FetchType.EAGER;

/**
 * Entity class for representing a User in the database
 */
@Entity
@Data
//@Getter
//@Setter
//@EqualsAndHashCode
//@ToString
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull (message = "debe haber un nombre")
    private String name;
    @NotNull
    private String username;
    @NotNull
    private String password;

    // We use EAGER to make sure the roles are retrieved immediately (without having to do additional queries)
    // We are not using @JoinTable, joinColumns, inverseJoinColumns because we are using the default naming strategy
    // similar to when we don't use @Column(name...) in a class attribute
    @ManyToMany(fetch = EAGER)
    private Collection<Role> roles = new ArrayList<>();

    // getters, setters, constructors, toString, equals, hashCode not needed thanks to lombok ;)
}
