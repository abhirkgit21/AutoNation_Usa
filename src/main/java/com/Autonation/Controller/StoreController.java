package com.Autonation.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Autonation.Binding.AutonationStore;
import com.Autonation.Service.StoreServices;

@RestController
@RequestMapping("/store")
public class StoreController {

	@Autowired
	private StoreServices storeServices;

	@PostMapping(value = "/add")
	public ResponseEntity<String> addStore(@RequestBody AutonationStore store) {

		 storeServices.addStore(store);
		return ResponseEntity.ok("Store Add successfully");

	}

	@GetMapping(value = "/getStore")
	public List<AutonationStore> getAllStore() {
		return storeServices.getAllStore();
	}

	@PutMapping("/updateStore/{storeId}")
	public ResponseEntity<AutonationStore> updatestore(@PathVariable Long storeId,
			@RequestBody AutonationStore updatestore) {
		AutonationStore update = storeServices.update(storeId, updatestore);
		return ResponseEntity.ok(update);

	}

	@DeleteMapping(value = "/delete/{storeId}")
	public ResponseEntity<String> deleteStore(Long storeId) {
		storeServices.deleteStore(storeId);
		return ResponseEntity.ok("store with Id " + storeId + "store delete sucessfully");
	}

}
