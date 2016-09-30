package by.epam.tr.cafe.parsers.sax;

import java.io.IOException;

import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import by.epam.tr.cafe.entity.Menu;
import by.epam.tr.cafe.service.MenuService;

public class SaxDemo {
	public static void main(String[] args) throws SAXException, IOException {
		XMLReader reader = XMLReaderFactory.createXMLReader();
		MenuSaxHandler handler = new MenuSaxHandler();
		reader.setContentHandler(handler);
		reader.parse(new InputSource("src/resources/menu.xml"));

		reader.setFeature("http://xml.org/sax/features/validation", true);
		reader.setFeature("http://xml.org/sax/features/namespaces", true);
		reader.setFeature("http://xml.org/sax/features/string-interning", true);
		reader.setFeature("http://apache.org/xml/features/validation/schema", true);
		
		Menu menu = handler.getMenu();
		MenuService.printMenu(menu);
	}
}
