package by.epam.tr.cafe.parsers.dom;


import java.util.ArrayList;
import java.util.List;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import by.epam.tr.cafe.entity.Dish;
import by.epam.tr.cafe.entity.Menu;

public class DomMenuParser {
	
	public static Menu domParserAction(Document document){
		Menu menu = new Menu();
		Element root = document.getDocumentElement();
		
		Element coldSnack = (Element) root.getElementsByTagName("ns:cold-snack").item(0);
		Element hotSnack = (Element) root.getElementsByTagName("ns:hot-snack").item(0);
		Element breakfast = (Element) root.getElementsByTagName("ns:breakfast").item(0);
		
		
		NodeList coldSnackNodes = getAllChilds(coldSnack, "ns:dish");
		NodeList hotSnackNodes = getAllChilds(hotSnack, "ns:dish");
		NodeList breakfastNodes = getAllChilds(breakfast, "ns:dish");
		
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
			
			dish.setId(dishElement.getAttribute("id"));
			dish.setPhoto(getSingleChild(dishElement, "ns:photo").getTextContent().trim());
			dish.setName(getSingleChild(dishElement, "ns:name").getTextContent().trim());
			dish.setDescription(getSingleChild(dishElement, "ns:description").getTextContent().trim());
			dish.setPortion(getSingleChild(dishElement, "ns:portion-grams").getTextContent().trim());
			dish.setPrice(Integer.parseInt(getSingleChild(dishElement, "ns:price").getTextContent().trim()));
			
			list.add(dish);
		}
		return list;
	}
}
