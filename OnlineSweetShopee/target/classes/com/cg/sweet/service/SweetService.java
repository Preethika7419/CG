package com.cg.sweet.service;

import java.util.List;
import org.springframework.http.ResponseEntity;
import com.cg.sweet.model.Sweet;

public interface SweetService {
	
	 public List<Sweet> getAllSweets();
	 public Sweet createSweet( Sweet sweet);
	 public ResponseEntity<?> deleteSweet( Integer sweetId);
	 public Sweet updateSweet( Integer sweetId,  Sweet sweetRequest);

}
