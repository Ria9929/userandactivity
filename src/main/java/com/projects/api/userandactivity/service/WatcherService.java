package com.projects.api.userandactivity.service;

import com.projects.api.userandactivity.model.User;
import com.projects.api.userandactivity.model.Watcher;

import java.util.List;

public interface WatcherService {
    Watcher saveWatcher(Watcher watcher);
    List<Watcher> getAllWatchers();
    Watcher getWatcherById(String watcherId);
    Watcher renameWatcher(String newName,String watcherId);
    void deleteWatcher(String watcherId);
    List<Watcher> getAssociatedWatchers(long userId);
    Watcher incrementWatcherAge(String watcherId);
}
