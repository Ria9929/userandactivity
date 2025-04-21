package com.projects.api.userandactivity.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

import java.util.Date;


@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@AllArgsConstructor
@Table(name="watchers")
public class Watcher {
    @Id
    @Column(name="watcher_id")
    private String watcherId;
    @Column(name="user_id")
    private Long userId;
    @Column(name="watcherName")
    private String watcherName;
    @Column(name="watcherAge")
    private int watcherAge;
    @Column(name="watcherCreationTimestamp")
    private Date watcherCreationTimestamp;
}
