package com.Autonation.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Autonation.Binding.Autoparts;
import com.Autonation.Binding.Cars;
import com.Autonation.Binding.Cart;
import com.Autonation.Repository.CartRepository;

@Service
public class CartServices {
	
	@Autowired
	private CartRepository cartRepository;
	
	public Cart addCart(Cart cart) {
	return	cartRepository.save(cart);
		
	}
	
	public Cart addCarsToCart(Long cartId,List<Cars> car) {
		Cart cart = cartRepository.findById(cartId).orElseThrow(()->new RuntimeException("cartId not found"));
		car.forEach(cars->cars.setCart(cart));
		cart.getCars().addAll(car);
		return cartRepository.save(cart);
		
	}
	public Cart addAutopartsToCart(Long cartId, List<Autoparts> autoparts) {
        Cart cart = cartRepository.findById(cartId).orElseThrow(() -> new RuntimeException("Cart not found"));
        autoparts.forEach(part -> part.setCart(cart));
        cart.getAutoparts().addAll(autoparts);
        return cartRepository.save(cart);
    }

}
