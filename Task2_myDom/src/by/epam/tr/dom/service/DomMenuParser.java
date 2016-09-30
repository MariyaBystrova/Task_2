package by.epam.tr.dom.service;

import java.util.ArrayList;
import java.util.List;

import by.epam.tr.dom.entity.Dish;
import by.epam.tr.dom.entity.Menu;
import by.tc.les03.entity.Document;
import by.tc.les03.entity.Element;

public class DomMenuParser {
	public static Menu parseAction(Document document){
		Menu menu = new Menu();
		Element root = document.getRoot();
		Element coldSnack = getSingleChild(root, "ns:cold-snack");
		Element hotSnack = getSingleChild(root, "ns:hot-snack");
		Element breakfast = getSingleChild(root, "ns:breakfast");
		
		List<Element> coldSnackElements = coldSnack.getChildsByName("ns:dish");
		List<Element> hotSnackElements = hotSnack.getChildsByName("ns:dish");
		List<Element> breakfastElements = breakfast.getChildsByName("ns:dish");
		
		menu.setColdSnackList(elementListAction(coldSnackElements));
		menu.setHotSnackList(elementListAction(hotSnackElements));
		menu.setBreakfastList(elementListAction(breakfastElements));
		
		return menu;
	}
	
	private static Element getSingleChild(Element element, String childName){
		List<Element> eList = element.getChildsByName(childName);
		Element child = (Element) eList.get(0);
		return child;
	}

	private static List<Dish> elementListAction(List<Element> nList){
		List<Dish> list = new ArrayList<Dish>();
		for(int i=0; i<nList.size(); i++){
			Dish dish=new Dish();
			Element dishElement = (Element) nList.get(i);
			dish.setId(dishElement.getAttributeByName("id").getValue());
			dish.setPhoto(getSingleChild(dishElement, "ns:photo").getTextContent().getText());
			dish.setName(getSingleChild(dishElement, "ns:name").getTextContent().getText());
			dish.setDescription(getSingleChild(dishElement, "ns:description").getTextContent().getText());
			dish.setPortion(getSingleChild(dishElement, "ns:portion-grams").getTextContent().getText());
			dish.setPrice(Integer.parseInt(getSingleChild(dishElement, "ns:price").getTextContent().getText().trim()));
			list.add(dish);
		}
		return list;
	}
}
