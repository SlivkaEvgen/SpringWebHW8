package com.homework.springwebhw8.entity;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "user")
public class User implements EntityModel<Long> {

    private static final long serialVersionUID = 7854356677894828996L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false, length = 15)
    private Long id;

    @Column(name = "name", nullable = false, length = 15)
    private String name;

    @Column(name = "last_name", nullable = false, length = 15)
    private String lastName;

    @Column(name = "gender", nullable = false, length = 15)
    private String gender;

    @Column(name = "email", nullable = false, length = 15)
    private String email;

    @Column(name = "password", nullable = false, length = 15)
    private String password;

    @ManyToOne
    private Role role;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        User user = (User) o;
        return id != null && Objects.equals(id, user.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
