package com.projects.api.userandactivity.repository;

import com.projects.api.userandactivity.model.Watcher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WatcherRepository extends JpaRepository<Watcher, String> {

    @Query(value="SELECT * from watchers WHERE user_id=:userId",nativeQuery = true)
    List<Watcher> findWatchersbyUserId(@Param("userId") Long userId);
}
