package com.example.lab.services;

import com.example.lab.models.entity.Offer;
import com.example.lab.models.view.DetailsView;
import com.example.lab.models.view.OfferView;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface OfferService {

    List<OfferView> getAllOffers();

    DetailsView getOfferById(Long id);

    void deleteById(Long id);
}
