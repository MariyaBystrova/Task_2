package by.epam.tr.dom.starter;

import by.epam.tr.dom.service.MenuService;
import by.epam.tr.dom.entity.Menu;
import by.epam.tr.dom.service.DomMenuParser;
import by.tc.les03.entity.Document;
import by.tc.les03.service.DomParser;
import by.tc.les03.service.impl.DomFactory;

public class Main {

	public static void main(String[] args) {
		DomFactory factory = DomFactory.getInstance();
		DomParser parser = factory.create();
		Document doc = parser.parse("src/resources/menu.xml");
		Menu menu = DomMenuParser.parseAction(doc);
		
		MenuService.printMenu(menu);

	}

}
