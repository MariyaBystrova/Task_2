package by.epam.tr.cafe.parsers.dom;

import java.io.IOException;

import org.apache.xerces.parsers.DOMParser;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import by.epam.tr.cafe.entity.Menu;
import by.epam.tr.cafe.parsers.helper.StringValues;
import by.epam.tr.cafe.service.MenuService;

public class DomDemo {

	public static void main(String[] args) {
		DOMParser parser = new DOMParser();
		try {
			parser.parse(StringValues.RESOURCE);
			Document document = parser.getDocument();
			Menu menu = DomMenuParser.domParserAction(document);
			MenuService.printMenu(menu);
		} catch (SAXException | IOException e) {
			e.printStackTrace();
		}
		

	}

}
