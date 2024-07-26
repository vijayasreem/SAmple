
package com.sacral.model;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false)
    private String password;

    // Add additional fields for user roles, email, etc.

    // Add getters and setters for all fields

    // Add constructors

    // Add toString() method

    // Add equals() and hashCode() methods if needed

}
