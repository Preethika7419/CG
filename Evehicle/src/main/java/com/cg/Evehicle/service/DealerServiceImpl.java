package com.cg.Evehicle.service;

//import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cg.Evehicle.dao.DealerDao;
import com.cg.Evehicle.exception.ResourceNotFoundException;
import com.cg.Evehicle.model.Book;


@Service
@Transactional
public class DealerServiceImpl implements DealerService{
	@Autowired
	private DealerDao dealerDao;
	

	@Override
	public Iterable<Book> getBooking() {
		
		return  dealerDao.findAll();
	}

	
	@Override
	public Book findBookById(Integer orderId) {
		return dealerDao.findById(orderId).map(getting->{
			getting.setOrderId(orderId);
			return dealerDao.save(getting);
		}).orElseThrow(()->new ResourceNotFoundException("OrderId "+orderId+" not found"));
	}


	

//	@Override
//	public Iterable<Book> findBookByVId(Integer vehicleId) {
//		
//		return dealerDao.findByVId(vehicleId);
//	}


}


