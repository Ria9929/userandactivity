package com.projects.api.userandactivity.model;


import jakarta.persistence.*;
import lombok.*;
import org.hibernate.proxy.HibernateProxy;

import java.util.List;
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
    @Column(name="user_id")
    private long userId;
    @Column(name="name")
    private String name;
    @Column(name="emailId")
    private String emailId;
    @Column(name="phoneNumber")
    private String phoneNumber;
    @Column(name="countryCode")
    private String countryCode;
    @Column(name="watcherIds")
    private List<Watcher> watchers;


}
