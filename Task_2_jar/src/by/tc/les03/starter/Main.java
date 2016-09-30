package by.tc.les03.starter;

import by.tc.les03.entity.Document;
import by.tc.les03.entity.Element;
import by.tc.les03.service.DomParser;
import by.tc.les03.service.impl.DomFactory;

public class Main {
	private static final String RESOURCE = "src/resources/menu.xml";
	
	public static void main(String[] args) {
		
		DomFactory d = DomFactory.getInstance();
		DomParser parser = d.create();
		Document doc = parser.parse(RESOURCE);
		doc.getTree().get(0);
		for(Element e: doc.getTree()){
			System.out.println("    tagName:" + e.getTagName());
			System.out.println("    Attributes:" + e.getAttributes());
			System.out.println("    Text:" + e.getTextContent().getText());
			System.out.println("    Childs:" + e.getChilds());
			System.out.println("===========");
		}

	}

}
