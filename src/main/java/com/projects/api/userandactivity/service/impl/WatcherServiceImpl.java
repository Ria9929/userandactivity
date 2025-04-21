package com.projects.api.userandactivity.service.impl;

import com.fasterxml.jackson.core.util.RecyclerPool;
import com.projects.api.userandactivity.model.Watcher;
import com.projects.api.userandactivity.repository.WatcherRepository;
import com.projects.api.userandactivity.service.WatcherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WatcherServiceImpl implements WatcherService {

    @Autowired
    WatcherRepository watcherRepo;

    @Override
    public Watcher saveWatcher(Watcher watcher) {
        return watcherRepo.save(watcher);
    }

    @Override
    public List<Watcher> getAllWatchers() {
        return watcherRepo.findAll();
    }

    @Override
    public Watcher getWatcherById(String watcherId) {
        Optional<Watcher> watcher=watcherRepo.findById(watcherId);
        if(watcher.isPresent()){
            return watcher.get();
        } else {
            throw new RuntimeException();
        }

    }

    @Override
    public Watcher renameWatcher(String newName, String watcherId) {
        Watcher watcher=watcherRepo.findById(watcherId).orElseThrow(()-> new RuntimeException());
        watcher.setWatcherName(newName);
        watcherRepo.save(watcher);
        return watcher;

    }

    @Override
    public void deleteWatcher(String watcherId) {
        Watcher watcher=watcherRepo.findById(watcherId).orElseThrow(()-> new RuntimeException());
        watcherRepo.deleteById(watcherId);
    }

    @Override
    public List<Watcher> getAssociatedWatchers(long userId) {
        List<Watcher> ws= watcherRepo.findWatchersbyUserId(userId);
        return ws;
    }

    @Override
    public Watcher incrementWatcherAge(String watcherId) {
        Watcher watcher=watcherRepo.findById(watcherId).orElseThrow(()-> new RuntimeException());
        int currentAge= watcher.getWatcherAge();
        watcher.setWatcherAge(currentAge+1);
        watcherRepo.save(watcher);
        return watcher;
    }
}
