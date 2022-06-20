package com.ty.hospitalapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.ty.hospitalapi.dao.EncounterDao;
import com.ty.hospitalapi.dao.MedOrderDao;
import com.ty.hospitalapi.dto.Encounter;
import com.ty.hospitalapi.dto.Item;
import com.ty.hospitalapi.dto.MedOrder;
import com.ty.hospitalapi.dto.ResponsStructure;
import com.ty.hospitalapi.exception.NoIdFoundException;

@Service
public class MedOrderService {

	@Autowired
	MedOrderDao medOrderDao;
	
	@ Autowired
	EncounterDao encounterDao;
	public ResponsStructure<MedOrder> saveMedOrder(MedOrder medOrder , int id) {
		ResponsStructure<MedOrder> responseStructure = new ResponsStructure<MedOrder>();
		Encounter encounter = encounterDao.getEncounterById(id);
		medOrder.setEncounter(encounter);
		double total=0;
		for (Item item : medOrder.getItems()) {
			item.setMedOrder(medOrder);
			total+=(item.getItem_cost()*item.getItem_quantity());
		}
		medOrder.setTotal(total);
		responseStructure.setStatuscode(HttpStatus.CREATED.value());
		responseStructure.setMessage("Success");
		responseStructure.setData(medOrderDao.saveMedOrder(medOrder));
		return responseStructure;
	}
	public ResponsStructure<List<MedOrder>> getAllMedOrders(){
		ResponsStructure<List<MedOrder>> responsStructure=new ResponsStructure<List<MedOrder>>();
		responsStructure.setStatuscode(HttpStatus.CREATED.value());
		responsStructure.setMessage("Sucess");
		responsStructure.setData(medOrderDao.getAllmedorders());
		return responsStructure;
	}
	public ResponsStructure<MedOrder> updateMedOrder(MedOrder medOrder){
		ResponsStructure<MedOrder>  responsStructure=new ResponsStructure<MedOrder>();
		
		responsStructure.setStatuscode(HttpStatus.CREATED.value());
		responsStructure.setMessage("Sucess");
		responsStructure.setData(medOrderDao.upadateMedOrder(medOrder));
		return responsStructure;
	}

	public ResponsStructure<String> deleteMedOrderById(int id) {
		boolean flag = medOrderDao.deleteMedOrder(id);
			ResponsStructure<String> responseStructure = new ResponsStructure<String>();
		if (flag) {
			responseStructure.setStatuscode(HttpStatus.OK.value());
			responseStructure.setMessage("Success");
			responseStructure.setData("Data Deleted");
		} else {
			throw new NoIdFoundException("medOrder id " + id + " Does not exist");
		}
		return responseStructure;
	}

	public ResponsStructure<MedOrder> getMedOrderById(int id) {
		ResponsStructure<MedOrder> responseStructure = new ResponsStructure<MedOrder>();
		MedOrder medOrder = medOrderDao.getMedOrderId(id);
		if (medOrder != null) {
			responseStructure.setStatuscode(HttpStatus.OK.value());
			responseStructure.setMessage("Success");
			responseStructure.setData(medOrder);
		} else {
			throw new NoIdFoundException("medOrder id " + id + " Does not exist");
		}
		return responseStructure;
	}
}
