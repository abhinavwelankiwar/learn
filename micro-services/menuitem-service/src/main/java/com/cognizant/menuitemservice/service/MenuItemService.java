package com.cognizant.menuitemservice.service;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cognizant.menuitemservice.model.MenuItem;
import com.cognizant.menuitemservice.repository.MenuItemRepository;


@Component
public class MenuItemService {

	/*
	 * @Autowired private MenuItemDaoCollectionImpl menuItemDao;
	 */
	@Autowired
	private MenuItemRepository menuItemRepository;

	public MenuItemService() {

	}

	public Set<MenuItem> getMenuItemListCustomer() {
		System.out.println(menuItemRepository.getMenuItemListCustomer());
		return menuItemRepository.getMenuItemListCustomer();
	}

	public Set<MenuItem> getMenuItemListAdmin() {
		return menuItemRepository.getMenuItemListAdmin();
	}

	public MenuItem getMenuItem(long id) {
		return menuItemRepository.getMenuItem(id);
	}

	public MenuItem modifyMenuItem(MenuItem m) {
		String isActive=m.getActive()?"true":"false";
		String freeDelivery=m.getFreeDelivery()?"true":"false";
		int r = menuItemRepository.modifyMenuItem(m.getName(), m.getPrice(), isActive ,
				m.getDateOfLaunch(), m.getCategory(), freeDelivery, m.getImageURL(),
				m.getId());
		if(r>0){
			return menuItemRepository.getMenuItem(m.getId());
		}
		return m;
	}

}
