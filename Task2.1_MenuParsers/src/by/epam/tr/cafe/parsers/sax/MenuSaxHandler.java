package by.epam.tr.cafe.parsers.sax;

import java.util.ArrayList;
import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.helpers.DefaultHandler;

import by.epam.tr.cafe.entity.Dish;
import by.epam.tr.cafe.entity.Menu;
import by.epam.tr.cafe.entity.MenuTagName;
import by.epam.tr.cafe.parsers.helper.StringValues;

public class MenuSaxHandler extends DefaultHandler {

	private Menu menu = new Menu();
	private List<Dish> dishList = new ArrayList<Dish>();
	private Dish dish;
	private StringBuilder text;

	public void startDocument() throws SAXException {
		System.out.println("Parsing started.");
	}

	public void endDocument() throws SAXException {
		System.out.println("Parsing ended.");
	}

	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		text = new StringBuilder();

		if (qName.equals(StringValues.TAG_DISH_NS)) {
			dish = new Dish();
			dish.setId(attributes.getValue(StringValues.ATTR_ID));
		}

	}

	public void characters(char[] buffer, int start, int length) {
		text.append(buffer, start, length);
	}

	public void endElement(String uri, String localName, String qName) throws SAXException {

		MenuTagName tagName = MenuTagName.valueOf(localName.toUpperCase().replace(StringValues.DASH, StringValues.UNDERLINE));
		switch (tagName) {
		case PHOTO:
			dish.setPhoto(text.toString());
			break;
		case NAME:
			dish.setName(text.toString());
			break;
		case DESCRIPTION:
			dish.setDescription(text.toString());
			break;
		case PORTION_GRAMS:
			dish.setPortion(text.toString());
			break;
		case PRICE:
			dish.setPrice(Integer.parseInt(text.toString()));
			break;
		case DISH:
			dishList.add(dish);
			dish = null;
			break;
		case COLD_SNACK:	
			menu.setColdSnackList(dishList);
			dishList = new ArrayList<Dish>();
			break;
		case HOT_SNACK:	
			menu.setHotSnackList(dishList);
			dishList = new ArrayList<Dish>();
			break;
		case BREAKFAST:	
			menu.setBreakfastList(dishList);
			dishList = new ArrayList<Dish>();
			break;
		default:
			break;
		}
	}

	public void warning(SAXParseException exception) {
		System.err.println("WARNING: line " + exception.getLineNumber() + ": " + exception.getMessage());
	}

	public void fatalError(SAXParseException exception) throws SAXParseException {
		System.err.println("FATAL: line " + exception.getLineNumber() + ": " + exception.getMessage());
		throw exception;
	}


	public Dish getDish() {
		return dish;
	}

	public void setDish(Dish dish) {
		this.dish = dish;
	}

	public List<Dish> getColdDishList() {
		return dishList;
	}

	public void setColdDishList(List<Dish> dishList) {
		this.dishList = dishList;
	}

	public StringBuilder getText() {
		return text;
	}

	public void setText(StringBuilder text) {
		this.text = text;
	}

	public Menu getMenu() {
		return menu;
	}

	public void setMenu(Menu menu) {
		this.menu = menu;
	}

}
