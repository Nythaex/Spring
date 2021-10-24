package com.example.exam.service.impl;

import com.example.exam.CurrentUser;
import com.example.exam.model.entity.Ship;
import com.example.exam.model.view.ViewShip;
import com.example.exam.repo.ShipRepository;
import com.example.exam.service.ShipService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ShipServiceImpl implements ShipService {
    private ShipRepository shipRepository;
    private CurrentUser currentUser;
    private ModelMapper modelMapper;

    public ShipServiceImpl(ShipRepository shipRepository, CurrentUser currentUser, ModelMapper modelMapper) {
        this.shipRepository = shipRepository;
        this.currentUser = currentUser;
        this.modelMapper = modelMapper;
    }

    @Override
    public void addShip(Ship map) {
        shipRepository.save(map);
    }

    

    @Override
    public Map<String,List<ViewShip>> getAll(CurrentUser currentUser) {
        List<Ship> all = shipRepository.findAll();
        Map<String,List<ViewShip>> result = new HashMap<>();

        List<ViewShip> allViews=new ArrayList<>();
        List<ViewShip> my=new ArrayList<>();
        List<ViewShip> enemy=new ArrayList<>();

        result.put("all",allViews);
        result.put("my",my);
        result.put("enemy",enemy);

        for (Ship a : all) {
            if (a.getUser().getId() != currentUser.getId()) {
                result.get("enemy").add(modelMapper.map(a, ViewShip.class));
            }else {
                result.get("my").add(modelMapper.map(a, ViewShip.class));
            }
            result.get("all").add(modelMapper.map(a, ViewShip.class));
        }
        return result;
    }

    @Override
    public void remove(Long id) {
        shipRepository.deleteById(id);
    }

    @Override
    public Ship getShip(Long my) {
        Ship byId = shipRepository.findById(my).orElse(null);
        return  byId;


    }

    @Override
    public void save(Ship ship1) {
        shipRepository.save(ship1);
    }

    @Override
    public void fight(Long my, Long allInsteadOf) {
        Ship ship = getShip(my);
        Ship ship1 = getShip(allInsteadOf);

        ship1.setHealth(ship1.getHealth()-ship.getPower());
        save(ship1);
        if (ship1.getHealth()<=0){
            remove(ship1.getId());
        }else {
           save(ship1);
        }
    }
}
