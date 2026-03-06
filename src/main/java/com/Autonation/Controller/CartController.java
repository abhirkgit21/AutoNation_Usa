package com.Autonation.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.Autonation.Binding.Autoparts;
import com.Autonation.Binding.Cars;
import com.Autonation.Binding.Cart;
import com.Autonation.Service.CartServices;

@RestController
@RequestMapping("/api")

public class CartController {
	
	@Autowired
    private CartServices cartService;
	
	
	@PostMapping("/addCart")
	public ResponseEntity<String> addCart(@RequestBody Cart cartId){
		cartService.addCart(cartId);
		return ResponseEntity.ok("Cart Added");
		
	}

    @PutMapping("/{cartId}/add-cars")
    public Cart addCarsToCart(@PathVariable Long cartId, @RequestBody List<Cars> cars) {
        return cartService.addCarsToCart(cartId, cars);
    }

    @PutMapping("/{cartId}/add-autoparts")
    public Cart addAutopartsToCart(@PathVariable Long cartId, @RequestBody List<Autoparts> autoparts) {
        return cartService.addAutopartsToCart(cartId, autoparts);
    }

}
