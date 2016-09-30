package by.epam.tr.dom.service;

import java.util.ArrayList;
import java.util.List;

import by.epam.tr.dom.entity.Dish;
import by.epam.tr.dom.entity.Menu;
import by.tc.les03.entity.Document;
import by.tc.les03.entity.Element;

public class DomMenuParser {
	private final static String TAG_DISH_NS = "ns:dish";
	private final static String TAG_COLD_SNACK_NS = "ns:cold-snack";
	private final static String TAG_HOT_SNACK_NS = "ns:hot-snack";
	private final static String TAG_BREAKFAST_NS = "ns:breakfast";
	private final static String ATTR_ID = "id";
	private final static String TAG_PHOTO_NS = "ns:photo";
	private final static String TAG_NAME_NS = "ns:name";
	private final static String TAG_DESCRIPTION_NS = "ns:description";
	private final static String TAG_PORTION_NS = "ns:portion-grams";
	private final static String TAG_PRICE_NS = "ns:price";
	
	public static Menu parseAction(Document document){
		Menu menu = new Menu();
		Element root = document.getRoot();
		Element coldSnack = getSingleChild(root, TAG_COLD_SNACK_NS);
		Element hotSnack = getSingleChild(root, TAG_HOT_SNACK_NS);
		Element breakfast = getSingleChild(root, TAG_BREAKFAST_NS);
		
		List<Element> coldSnackElements = coldSnack.getChildsByName(TAG_DISH_NS);
		List<Element> hotSnackElements = hotSnack.getChildsByName(TAG_DISH_NS);
		List<Element> breakfastElements = breakfast.getChildsByName(TAG_DISH_NS);
		
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
			dish.setId(dishElement.getAttributeByName(ATTR_ID).getValue());
			dish.setPhoto(getSingleChild(dishElement, TAG_PHOTO_NS).getTextContent().getText());
			dish.setName(getSingleChild(dishElement, TAG_NAME_NS).getTextContent().getText());
			dish.setDescription(getSingleChild(dishElement, TAG_DESCRIPTION_NS).getTextContent().getText());
			dish.setPortion(getSingleChild(dishElement, TAG_PORTION_NS).getTextContent().getText());
			dish.setPrice(Integer.parseInt(getSingleChild(dishElement, TAG_PRICE_NS).getTextContent().getText().trim()));
			list.add(dish);
		}
		return list;
	}
}
