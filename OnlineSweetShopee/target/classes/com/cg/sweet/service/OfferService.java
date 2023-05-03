package com.cg.sweet.service;

import java.util.List;
import org.springframework.http.ResponseEntity;


import com.cg.sweet.model.Offer;

public interface OfferService {
	
	public List<Offer> getAllOffersBySweetId( Integer sweetId);
	public Offer createOffer( Integer sweetId, Offer offer);
	public Offer updateOffer(Integer sweetId, Integer offerId,Offer offerRequest);
	public ResponseEntity<?> deleteOffer(  Integer sweetId, Integer offerId);
}
