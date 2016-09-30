package by.tc.les03.service.impl;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PushbackReader;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import by.tc.les03.entity.Attribute;
import by.tc.les03.entity.Document;
import by.tc.les03.entity.Element;
import by.tc.les03.entity.Text;
import by.tc.les03.service.DomParser;

public class BaseDomParser implements DomParser {
	private final static String REGEX = "(<((/?)([\\w:\\-]+)((([ \\s]+)([\\w:\\-]+)=(\"[\\.\\w\\-:/ ]+\"))*))>)|"
			+ "(([/а-яА-Я\\., :\\w\\-&&[^<>]]+)<)";
	private final static String ATTRIBUTE_REGEX = "([\\w:\\-]+)=\"([\\.\\w\\-:/ ]+)\"";
	private final static String ENCODING = "UTF-8";

	public Document parse(String fileName) {
		List<Element> stackOfElements = new ArrayList<Element>();
		Document document = new Document();

		BufferedReader br = null;
		PushbackReader pb = null;
		try {
			Path path = Paths.get(fileName);
			br = Files.newBufferedReader(path, Charset.forName(ENCODING));
			pb = new PushbackReader(br);

			Pattern p = Pattern.compile(REGEX);
			Matcher m;
			StringBuilder s = new StringBuilder();

			while (pb.ready()) {
				char c = (char) pb.read();
				s.append(c);
				m = p.matcher(s);

				Element element = new Element();
				if (m.find()) {
					s = new StringBuilder();
					if ((m.group(2) != null) && (m.group(3).isEmpty())) { // startElement
						startElementProcess(m, stackOfElements, element, document);
					}
					if (m.group(10) != null) { // content
						s = textContentProcess(m, stackOfElements);
					}
					if ((m.group(2) != null) && (!m.group(3).isEmpty())) { // endElement
						endElementProcess(m, stackOfElements);
						element = new Element();
					}
				}
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				pb.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return document;
	}

	private static void startElementProcess(Matcher m, List<Element> stackOfElements, Element e, Document document) {
		e.setTagName(m.group(4));
		if (!m.group(5).isEmpty()) { // attribute
			attributeProcess(m, e);
		}

		if (!stackOfElements.isEmpty()) {
			Element parent = stackOfElements.get(stackOfElements.size() - 1);
			parent.getChilds().add(e);
		}
		stackOfElements.add(e);
		document.getTree().add(stackOfElements.get(stackOfElements.size() - 1));
	}

	private static void attributeProcess(Matcher m, Element e) {
		String attrs = m.group(5);
		Matcher matcherAttr = Pattern.compile(ATTRIBUTE_REGEX).matcher(attrs);
		while (matcherAttr.find()) {
			Attribute a = new Attribute();
			a.setName(matcherAttr.group(1));
			a.setValue(matcherAttr.group(2));
			e.getAttributes().add(a);
		}
	}

	private static StringBuilder textContentProcess(Matcher m, List<Element> stackOfElements) {
		StringBuilder s = new StringBuilder();
		s.append('<');
		Text text = new Text();
		if (m.group(11) != null) {
			text.setText(m.group(11));
		}
		stackOfElements.get(stackOfElements.size() - 1).setTextContent(text);
		return s;
	}

	private static void endElementProcess(Matcher m, List<Element> stackOfElements) {
		if (stackOfElements.get(stackOfElements.size() - 1).getTagName().equals(m.group(4))) {
			stackOfElements.remove(stackOfElements.size() - 1);
		}
	}
}