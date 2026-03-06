package com.Autonation.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Autonation.Binding.Autoparts;
import com.Autonation.Repository.AutopartsRepo;
import com.Autonation.Repository.StoreRepository;

@Service
public class PartService {

	@Autowired
	private AutopartsRepo autoRepo;
	
	@Autowired
	private StoreRepository storeRepository;
	
	
	
	public Autoparts addAutoparts(Autoparts autoparts) {
	return	autoRepo.save(autoparts);
		
	}

	/*
	 * public Autoparts addPartsToDatabase(Autoparts carsparts) {
	 * System.out.println("save carparts to database " + carsparts); AutonationStore
	 * autonationStore =
	 * storeRepository.findById(carsparts.getAutonationStore().getStoreId())
	 * .orElseThrow(() -> new RuntimeException("Store not found"));
	 * 
	 * carsparts.setAutonationStore(autonationStore); return
	 * autoRepo.save(carsparts);
	 * 
	 * }
	 */

	
	public List<Autoparts> getAllparts() {
		List<Autoparts> list = autoRepo.findAll();
		if (list == null)
			throw new RuntimeException("autoparts Found..!");
		return list;
	}

	public Autoparts partById(Long autopartId) {
		return autoRepo.findById(autopartId).orElseThrow(() -> new RuntimeException("Part not found"));

	}

	public List<Autoparts> getPartsByName(String partName) {
		return autoRepo.findByPartName(partName);
	}

	public void deleteAutoPart(Long autopartId) {
		autoRepo.deleteById(autopartId);

	}

}
