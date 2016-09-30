package by.tc.les03.entity;

import java.util.ArrayList;
import java.util.List;

public class Element {
	private String tagName;
	private Text textContent = new Text();
	private List<Attribute>  attributes=new ArrayList<Attribute>();
	private List<Element> childs = new ArrayList<Element>();
	
	
	public Element(){}
	
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(Element.class.getSimpleName());
		sb.append(": <TagName = ");
		sb.append(tagName);
		sb.append(">, <attributes = ");
		sb.append(attributes);
		sb.append(">, <textContent = ");
		sb.append(textContent);
		sb.append(">, <childs = ");
		sb.append(childs);
		sb.append(">.");
		return sb.toString();
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((attributes == null) ? 0 : attributes.hashCode());
		result = prime * result + ((childs == null) ? 0 : childs.hashCode());
		result = prime * result + ((tagName == null) ? 0 : tagName.hashCode());
		result = prime * result + ((textContent == null) ? 0 : textContent.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj){
			return true;
		}
		if (obj == null){
			return false;
		}
		if (getClass() != obj.getClass()){
			return false;
		}
		Element other = (Element) obj;
		if (attributes == null) {
			if (other.attributes != null){
				return false;
			}
		} else if (!attributes.equals(other.attributes)){
			return false;
		}
		if (childs == null) {
			if (other.childs != null){
				return false;
			}
		} else if (!childs.equals(other.childs)){
			return false;
		}
		if (tagName == null) {
			if (other.tagName != null){
				return false;
			}
		} else if (!tagName.equals(other.tagName)){
			return false;
		}
		if (textContent == null) {
			if (other.textContent != null){
				return false;
			}
		} else if (!textContent.equals(other.textContent)){
			return false;
		}
		return true;
	}

	public String getTagName() {
		return tagName;
	}
	public void setTagName(String tagName) {
		this.tagName = tagName;
	}
	public List<Attribute> getAttributes() {
		return attributes;
	}
	public Attribute getAttributeByName(String name){
		for(Attribute a: attributes){
			if(a.getName().equals(name)){
				return a;
			}
		}
		return null;
	}
	public void setAttributes(List<Attribute> attributes) {
		this.attributes = attributes;
	}
	public Text getTextContent() {
		return textContent;
	}
	public void setTextContent(Text textContent) {
		this.textContent = textContent;
	}
	public List<Element> getChilds() {
		return childs;
	}
	public void setChilds(List<Element> childs) {
		this.childs = childs;
	}
	public List<Element> getChildsByName(String name){
		List<Element> listChilds = new ArrayList<Element>();
		for(Element e: childs){
			if(e.getTagName().equals(name)){
				listChilds.add(e);
			}
		}
		return listChilds;
	}
	
}
