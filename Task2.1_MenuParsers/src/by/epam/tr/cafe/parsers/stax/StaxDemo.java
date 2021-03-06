package by.epam.tr.cafe.parsers.stax;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

import by.epam.tr.cafe.entity.Menu;
import by.epam.tr.cafe.parsers.helper.StringValues;
import by.epam.tr.cafe.service.MenuService;

public class StaxDemo {

	public static void main(String[] args) {
		XMLInputFactory inputFactory = XMLInputFactory.newInstance();
		
		try {
			InputStream input = new FileInputStream(StringValues.RESOURCE);
			XMLStreamReader reader = inputFactory.createXMLStreamReader(input);
			Menu menu = StaxMenuParser.process(reader);
			MenuService.printMenu(menu);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (XMLStreamException e) {
			e.printStackTrace();
		}
	}

}
