package by.epam.tr.dom.service;

import by.epam.tr.dom.entity.Dish;
import by.epam.tr.dom.entity.Menu;
import by.epam.tr.dom.entity.MenuTagName;

public class MenuService {
	private MenuService() {
	}

	public static void printMenu(Menu menu) {
		
		System.out.println(MenuTagName.COLD_SNACK);
		for (Dish dish : menu.getColdSnackList()) {
			System.out.println(dish);
		}
		System.out.println(MenuTagName.HOT_SNACK);
		for (Dish dish : menu.getHotSnackList()) {
			System.out.println(dish);
		}
		System.out.println(MenuTagName.BREAKFAST);
		for (Dish dish : menu.getBreakfastList()) {
			System.out.println(dish);
		}
	}
}
