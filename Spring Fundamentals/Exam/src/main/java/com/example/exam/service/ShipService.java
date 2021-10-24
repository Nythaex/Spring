package com.example.exam.service;

import com.example.exam.CurrentUser;
import com.example.exam.model.entity.Ship;
import com.example.exam.model.view.ViewShip;

import java.util.List;
import java.util.Map;

public interface ShipService {
    void addShip(Ship map);


    public Map<String,List<ViewShip>> getAll(CurrentUser currentUser);

    void remove(Long id);

    Ship getShip(Long my);

    void save(Ship ship1);

    void fight(Long my, Long allInsteadOf);
}
