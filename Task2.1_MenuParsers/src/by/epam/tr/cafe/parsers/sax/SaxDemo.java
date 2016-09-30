package by.epam.tr.cafe.parsers.sax;

import java.io.IOException;

import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import by.epam.tr.cafe.entity.Menu;
import by.epam.tr.cafe.parsers.helper.StringValues;
import by.epam.tr.cafe.service.MenuService;

public class SaxDemo {
	public static void main(String[] args) throws SAXException, IOException {
		XMLReader reader = XMLReaderFactory.createXMLReader();
		MenuSaxHandler handler = new MenuSaxHandler();
		reader.setContentHandler(handler);
		reader.parse(new InputSource(StringValues.RESOURCE));

		reader.setFeature(StringValues.FEATURE_VALIDATION, true);
		reader.setFeature(StringValues.FEATURE_NAMESPACE, true);
		reader.setFeature(StringValues.FEATURE_STRING_INTERNING, true);
		reader.setFeature(StringValues.FEATURE_VALIDATION_SCHEMA, true);
		
		Menu menu = handler.getMenu();
		MenuService.printMenu(menu);
	}
}
