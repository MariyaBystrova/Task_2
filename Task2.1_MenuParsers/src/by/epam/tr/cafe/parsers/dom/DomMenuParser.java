package by.epam.tr.cafe.parsers.dom;


import java.util.ArrayList;
import java.util.List;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import by.epam.tr.cafe.entity.Dish;
import by.epam.tr.cafe.entity.Menu;
import by.epam.tr.cafe.parsers.helper.StringValues;

public class DomMenuParser {
	
	public static Menu domParserAction(Document document){
		Menu menu = new Menu();
		Element root = document.getDocumentElement();
		
		Element coldSnack = (Element) root.getElementsByTagName(StringValues.TAG_COLD_SNACK_NS).item(0);
		Element hotSnack = (Element) root.getElementsByTagName(StringValues.TAG_HOT_SNACK_NS).item(0);
		Element breakfast = (Element) root.getElementsByTagName(StringValues.TAG_BREAKFAST_NS).item(0);
		
		
		NodeList coldSnackNodes = getAllChilds(coldSnack, StringValues.TAG_DISH_NS);
		NodeList hotSnackNodes = getAllChilds(hotSnack, StringValues.TAG_DISH_NS);
		NodeList breakfastNodes = getAllChilds(breakfast, StringValues.TAG_DISH_NS);
		
		menu.setColdSnackList(nodeListAction(coldSnackNodes));
		menu.setHotSnackList(nodeListAction(hotSnackNodes));
		menu.setBreakfastList(nodeListAction(breakfastNodes));
		
		return menu;
	}	
	
	private static Element getSingleChild(Element element, String childName){
		NodeList nList = element.getElementsByTagName(childName);
		Element child = (Element) nList.item(0);
		return child;
	}
	private static NodeList getAllChilds(Element element, String childName){
		NodeList nList = element.getElementsByTagName(childName);
		return nList;
	}
	private static List<Dish> nodeListAction(NodeList nList){
		List<Dish> list = new ArrayList<Dish>();
		for(int i=0; i<nList.getLength(); i++){
			Dish dish=new Dish();
			Element dishElement = (Element) nList.item(i);
			
			dish.setId(dishElement.getAttribute(StringValues.ATTR_ID));
			dish.setPhoto(getSingleChild(dishElement, StringValues.TAG_PHOTO_NS).getTextContent().trim());
			dish.setName(getSingleChild(dishElement, StringValues.TAG_NAME_NS).getTextContent().trim());
			dish.setDescription(getSingleChild(dishElement, StringValues.TAG_DESCRIPTION_NS).getTextContent().trim());
			dish.setPortion(getSingleChild(dishElement, StringValues.TAG_PORTION_NS).getTextContent().trim());
			dish.setPrice(Integer.parseInt(getSingleChild(dishElement, StringValues.TAG_PRICE_NS).getTextContent().trim()));
			
			list.add(dish);
		}
		return list;
	}
}
