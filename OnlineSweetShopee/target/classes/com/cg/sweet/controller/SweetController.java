package com.cg.sweet.controller;


import com.cg.sweet.model.Sweet;
import com.cg.sweet.service.SweetService;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("api/v1")
public class SweetController {
	private static final Logger logger = LogManager.getLogger(SweetController.class);

    
    @Autowired
    private SweetService sweetService;

    @GetMapping("/getSweet")
    public List<Sweet> getAllSweets() {
    	logger.info("in controller");
        return sweetService.getAllSweets();
    }
    

    @PostMapping("/newSweet")
    public Sweet createSweet( @RequestBody Sweet sweet) {
    	logger.info("in controller");

        return sweetService.createSweet(sweet);
    }
    

    @PutMapping("/sweet/{sweetId}")
    public Sweet updateSweet(@PathVariable Integer sweetId,  @RequestBody Sweet sweetRequest) {
    	logger.info("in controller");

        return sweetService.updateSweet(sweetId, sweetRequest);
    }


    @DeleteMapping("/sweet/{sweetId}")
    public ResponseEntity<?> deleteSweet(@PathVariable Integer sweetId) {
    	logger.info("in controller");

        return sweetService.deleteSweet(sweetId);
    }

}
//{ "categoryName":"gheesweet","productName":"mysorepak","rate":150.0}