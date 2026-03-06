package com.Autonation.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Autonation.Binding.AutonationStore;
import com.Autonation.Binding.Cars;
import com.Autonation.Repository.StoreRepository;

@Service
public class StoreServices {

	@Autowired
	private StoreRepository storeRepository;

	@Autowired
	private CarServices carServices;

	public AutonationStore addStore(AutonationStore store) {
		List<Cars> carList = carServices.getAllCars();
		store.setCars(carList);
		return storeRepository.save(store);

	}

	

	public List<AutonationStore> getAllStore() {
		return storeRepository.findAll();
	}

	public AutonationStore update(Long storeId, AutonationStore updateStore) {
		AutonationStore store = storeRepository.findById(storeId)
				.orElseThrow(() -> new RuntimeException("storeNotfound"));
		store.setStoreName(updateStore.getStoreName());
		store.setLocation(updateStore.getLocation());
		store.setServiceOffer(updateStore.getServiceOffer());
		return storeRepository.save(store);

	}

	public void deleteStore(Long storeId) {
		storeRepository.deleteById(storeId);
	}

}
