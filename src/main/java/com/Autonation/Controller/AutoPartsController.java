package com.Autonation.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.Autonation.Binding.Autoparts;
import com.Autonation.Service.PartService;

@RestController
@RequestMapping("/part")
public class AutoPartsController {

	@Autowired
	private PartService partService;

	@PostMapping(value = "/save")
	public ResponseEntity<String> addAutoparts(@RequestBody Autoparts autoparts) {
		 partService.addAutoparts(autoparts);
		return new ResponseEntity<String>("part add sucessfully", HttpStatus.OK);

	}

	/*
	 * @PostMapping(value = "/addpart") public ResponseEntity<Autoparts>
	 * addParts(@RequestBody Autoparts autoparts) { Autoparts partadd =
	 * partService.addPartsToStore(autoparts); return new ResponseEntity<>(partadd,
	 * HttpStatus.CREATED);
	 * 
	 * }
	 */

	@GetMapping(value = "/getAllparts")
	public List<Autoparts> getAllparts() {
		return partService.getAllparts();

	}

	@GetMapping(value = "/findpart/{partId}")
	public ResponseEntity<Autoparts> getPartsById(@PathVariable Long autopartId) {
		Autoparts autopartById = partService.partById(autopartId);
		return new ResponseEntity<>(autopartById, HttpStatus.CREATED);

	}

	@GetMapping(value = "/searchCarspart")
	public ResponseEntity<List<Autoparts>> searchPartByName(@RequestParam String partName) {
		List<Autoparts> searchpartBypartName = partService.getPartsByName(partName);
		return new ResponseEntity<>(searchpartBypartName, HttpStatus.CREATED);

	}

	@DeleteMapping(value = "/deletepart/{partId}")
	public ResponseEntity<String> deletePartsById(@PathVariable Long autopartId) {
		partService.deleteAutoPart(autopartId);
		return ResponseEntity.ok("PartsId " + autopartId + "part delete sucessfully");

	}

}
