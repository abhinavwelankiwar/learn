package com.cognizant.menuitemservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cognizant.menuitemservice.model.MenuItem;
import com.cognizant.menuitemservice.repository.CartDTORepository;
import com.cognizant.menuitemservice.repository.MenuItemRepository;
import com.cognizant.menuitemservice.repository.UserRepository;


@Component
public class CartService {

	@Autowired
	private MenuItemRepository menuItemRepository;

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private CartDTORepository cartDTORepository;
	
	public CartService(){
		
	}
	
	public void addCartItem(long userId, long menuItemId)
	{
		//cartDao.addCartItem(userId, menuItemId);
		//Optional<User> user = userRepository.findUserByUserId(userId);
		//MenuItem menuItem = menuItemRepository.getMenuItem(menuItemId);
		cartDTORepository.addItemToCart(userId,menuItemId);
		
	}
	
	public List<MenuItem> getAllCartItems(long userId){
		return cartDTORepository.getAllCartItems(userId);
	}
	
	public double getTotal(long userId) {
		if(cartDTORepository.getTotal(userId) != null){
			return cartDTORepository.getTotal(userId);
		}else{
			return 0;
		}
	}
	
	public void deleteMenuItem(long userId, long menuItemId){
		cartDTORepository.deleteCartItem(userId, menuItemId);
	}
	
}

