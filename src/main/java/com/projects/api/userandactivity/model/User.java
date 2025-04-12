package com.projects.api.userandactivity.model;


import jakarta.persistence.*;
import lombok.*;
import org.hibernate.proxy.HibernateProxy;

import java.util.Objects;


@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@AllArgsConstructor
@Table(name="users")
public class User {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long userId;
    private String name;
    private String emailId;
    private String phoneNumber;
    private String countryCode;

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return userId == user.userId && Objects.equals(name, user.name) && Objects.equals(emailId, user.emailId) && Objects.equals(phoneNumber, user.phoneNumber) && Objects.equals(countryCode, user.countryCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, name, emailId, phoneNumber, countryCode);
    }
}
