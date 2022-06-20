package com.ty.hospitalapi.dao;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.hospitalapi.dto.Encounter;
import com.ty.hospitalapi.repository.EncounterRepositiry;

@Repository
public class EncounterDao {

	@Autowired
	EncounterRepositiry encounterRepositiry;
	public Encounter saveEncounter(Encounter encounter) {
		return encounterRepositiry.save(encounter);
	}

	public List<Encounter> getAllEncounters() {
		return encounterRepositiry.findAll();
	}

	public Encounter getEncounterById(int id) {
		Optional<Encounter> optional = encounterRepositiry.findById(id);
		if (optional.isPresent()) {
			return optional.get();
		} else {
			return null;
		}
	}

	public Encounter updateEncounterById(Encounter encounter, int id) {
		Optional<Encounter> optional = encounterRepositiry.findById(id);
		if (optional.isPresent()) {
			Encounter e = optional.get();
			encounter.setBranch(e.getBranch());
			encounter.setPerson(e.getPerson());
			encounter.setAdmitDateAndTime(e.getAdmitDateAndTime());
			encounter.setDischargeDateAndTime(LocalDateTime.now());
			return encounterRepositiry.save(encounter);
		} else {
			return null;
		}
	}

	public boolean deleteEncounterById(int id) {
		Optional<Encounter> optional = encounterRepositiry.findById(id);
		if (optional.isPresent()) {
			encounterRepositiry.delete(optional.get());
			return true;
		} else {
			return false;
		}
	}

}
