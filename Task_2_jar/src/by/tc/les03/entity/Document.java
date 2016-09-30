package by.tc.les03.entity;

import java.util.ArrayList;
import java.util.List;

public class Document {
	private List<Element> tree = new ArrayList<Element>();
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((tree == null) ? 0 : tree.hashCode());
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
		if (getClass() != obj.getClass())
			return false;
		Document other = (Document) obj;
		if (tree == null) {
			if (other.tree != null){
				return false;
			}
		} else if (!tree.equals(other.tree)){
			return false;
		}
		return true;
	}
	
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(Document.class.getSimpleName());
		sb.append(": <tree = ");
		sb.append(tree);
		sb.append(">.");
		return sb.toString();
	}
	
	public Element getRoot(){
		if(!tree.isEmpty()){
			return tree.get(0);
		}
		return new Element();
	}
	public List<Element> getTree() {
		return tree;
	}
	public void setTree(List<Element> tree) {
		this.tree = tree;
	}
	
}
