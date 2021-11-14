package com.example.lab.services.imp;

import com.example.lab.models.binding.AddOfferBinding;
import com.example.lab.models.entity.Enums.Engine;
import com.example.lab.models.entity.Enums.Transmission;
import com.example.lab.models.entity.Offer;
import com.example.lab.models.view.DetailsView;
import com.example.lab.models.view.OfferView;
import com.example.lab.repos.ModelRepository;
import com.example.lab.repos.OfferRepository;
import com.example.lab.repos.UserRepository;
import com.example.lab.services.OfferService;
import com.example.lab.user.CurrentUser;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OfferServiceImpl implements OfferService {
    private OfferRepository offerRepository;
    private ModelMapper mapper;
    private CurrentUser currentUser;
    private UserRepository userRepository;
    private ModelRepository modelRepository;

    public OfferServiceImpl(OfferRepository offerRepository, ModelMapper mapper, CurrentUser currentUser, UserRepository userRepository, ModelRepository modelRepository) {
        this.offerRepository = offerRepository;
        this.mapper = mapper;
        this.currentUser = currentUser;
        this.userRepository = userRepository;
        this.modelRepository = modelRepository;
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

    @Override
    public void save(AddOfferBinding addOfferBinding) {
        Offer offer=mapper.map(addOfferBinding,Offer.class);
        offer.setCreated(LocalDateTime.now());
        offer.setModified(LocalDateTime.now());
        offer.setSeller(userRepository.getById(currentUser.getId()));
        offer.setModel(modelRepository.findByName(addOfferBinding.getModel()));

        offerRepository.save(offer);
    }

    @Override
    public void update(AddOfferBinding addOfferBinding, Long id) {
        Offer byId = offerRepository.getById(id);
        byId.setTransmission(Transmission.valueOf(addOfferBinding.getTransmission()));
        byId.setEngine(Engine.valueOf(addOfferBinding.getEngine()));
        byId.setModel(modelRepository.getByName(addOfferBinding.getModel()));
          byId.setModified(LocalDateTime.now());
          byId.setDescription(addOfferBinding.getDescription());
            byId.setImageUrl(addOfferBinding.getImageUrl());
            byId.setMileage(addOfferBinding.getMileage());
            byId.setPrice(addOfferBinding.getPrice());
            byId.setYear(addOfferBinding.getYear());
            offerRepository.save(byId);
    }


}
