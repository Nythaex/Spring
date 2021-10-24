package com.example.lab.services.imp;

import com.example.lab.models.entity.Offer;
import com.example.lab.models.view.DetailsView;
import com.example.lab.models.view.OfferView;
import com.example.lab.repos.OfferRepository;
import com.example.lab.services.OfferService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OfferServiceImpl implements OfferService {
    private OfferRepository offerRepository;
    private ModelMapper mapper;

    public OfferServiceImpl(OfferRepository offerRepository, ModelMapper mapper) {
        this.offerRepository = offerRepository;
        this.mapper = mapper;
    }

    @Override
    public List<OfferView> getAllOffers() {
        List<OfferView> offerViews = offerRepository.findAll().stream().map(offer -> mapper.map(offer, OfferView.class)).collect(Collectors.toList());
        return offerViews;
    }

    @Override
    public DetailsView getOfferById(Long id) {
        Offer byId = offerRepository.getById(id);
        DetailsView view = mapper.map(offerRepository.getById(id), DetailsView.class);

        view.setModel(byId.getModel().getName());
        view.setBrand(byId.getModel().getBrand().getName());
        view.setSeller(byId.getSeller().getFirstName()+" "+byId.getSeller().getLastName());

        return view;
    }

    @Override
    public void deleteById(Long id) {
        offerRepository.deleteById(id);
    }

}
