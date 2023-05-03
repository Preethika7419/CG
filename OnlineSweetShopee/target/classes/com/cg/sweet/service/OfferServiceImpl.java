package com.cg.sweet.service;

import java.util.List;

import javax.transaction.Transactional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.cg.sweet.controller.OfferController;
import com.cg.sweet.exception.ResourceNotFoundException;
import com.cg.sweet.model.Offer;
import com.cg.sweet.repository.OfferRepository;
import com.cg.sweet.repository.SweetRepository;

@Service
@Transactional
public class OfferServiceImpl implements OfferService {
	
	private static final Logger logger = LogManager.getLogger(OfferServiceImpl.class);
	
	@Autowired
	private SweetRepository sweetRepository;
	
	@Autowired
	private OfferRepository offerRepository;

	@Override
	public List<Offer> getAllOffersBySweetId(Integer sweetId) {
		logger.info("in service");
		
		 return offerRepository.findAll();
	}

	@Override
	public Offer createOffer(Integer sweetId, Offer offer) 
	{
		logger.info("in service");
        return sweetRepository.findById(sweetId).map(sweet -> {
        	offer.setSweet(sweet);
            return offerRepository.save(offer);
        }).orElseThrow(() -> new ResourceNotFoundException("SweetId: " + sweetId + " not found"));
    }

	@Override
	public Offer updateOffer(Integer sweetId, Integer offerId, Offer offerRequest){
		logger.info("in service");
        if(!sweetRepository.existsById(sweetId)) {
            throw new ResourceNotFoundException("SweetId:  " + sweetId + " not found");
        }

        return offerRepository.findById(offerId).map(offer -> {
            offer.setOfferName(offerRequest.getOfferName());
            offer.setOfferRate(offerRequest.getOfferRate());
            return offerRepository.save(offer);
        }).orElseThrow(() -> new ResourceNotFoundException("OfferId:   " + offerId + "   not found"));
    }

	@Override
	public ResponseEntity<?> deleteOffer(Integer sweetId, Integer offerId)  {
		logger.info("in service");
        return offerRepository.findByIdAndSweetId(offerId, sweetId).map(offer -> {
            offerRepository.delete(offer);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundException("offer not found with id " + offerId + " and SweetId " + sweetId));
    }

}
