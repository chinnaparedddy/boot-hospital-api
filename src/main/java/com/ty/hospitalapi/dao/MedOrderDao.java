package com.ty.hospitalapi.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.hospitalapi.dto.MedOrder;
import com.ty.hospitalapi.repository.MedOrderRepository;

@Repository
public class MedOrderDao {

	@Autowired
	MedOrderRepository medOrderRepository;
	
	public MedOrder saveMedOrder(MedOrder medOrder) {
		return medOrderRepository.save(medOrder);
	}
	public List<MedOrder> getAllmedorders(){
		return medOrderRepository.findAll();
	}
	
	public MedOrder getMedOrderId(int id) {
		Optional< MedOrder> optional=medOrderRepository.findById(id);
		if(optional!=null) {
			return optional.get();
		}else {
			return null;
		}
	}
	public MedOrder upadateMedOrder(MedOrder medOrder) {
		Optional< MedOrder> optional=medOrderRepository.findById(medOrder.getMedorder_id());
		if(optional!=null) {
			medOrderRepository.save(medOrder);
			return medOrder;
		}else {
			return null;
		}
	}
	public boolean deleteMedOrder(int id) {
		Optional< MedOrder> optional=medOrderRepository.findById(id);
		if(optional!=null) {
			medOrderRepository.delete(optional.get());
			return true;
		}else {
			return false;
		}
	}
}
