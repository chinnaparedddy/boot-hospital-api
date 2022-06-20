package com.ty.hospitalapi.controler;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ty.hospitalapi.dto.MedOrder;
import com.ty.hospitalapi.dto.ResponsStructure;
import com.ty.hospitalapi.service.MedOrderService;

@RestController
public class MedOrderController {
	@Autowired
	MedOrderService medOrderService;
	
	@PostMapping("/medOrders/{eid}")
	public ResponsStructure<MedOrder> saveMedOrder(@RequestBody MedOrder medOrder , @PathVariable int eid) {
		return medOrderService.saveMedOrder(medOrder,eid);
	}
	
	@GetMapping("/medOrders")
	public ResponsStructure<List<MedOrder>> getAllMedOrders(){
		return medOrderService.getAllMedOrders();
	}
	
	@GetMapping("/medOrders/{id}")
	public ResponsStructure<MedOrder> getMedOrderById(@PathVariable int id){
		return medOrderService.getMedOrderById(id);
	}
	
	@PutMapping("/medOrders")
	public ResponsStructure<MedOrder> updateMedOrderById(@RequestBody MedOrder medOrder , @PathVariable int id){
		return medOrderService.updateMedOrder(medOrder);
	}
	
	@DeleteMapping("/medOrders/{id}")
	public ResponsStructure<String> deleteMedOrderById(@PathVariable int id){
		return medOrderService.deleteMedOrderById(id);
	}
}