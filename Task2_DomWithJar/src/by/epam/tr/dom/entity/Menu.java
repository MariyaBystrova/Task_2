package by.epam.tr.dom.entity;

import java.util.ArrayList;
import java.util.List;

public class Menu {
	private List<Dish> coldSnackList;
	private List<Dish> hotSnackList;
	private List<Dish> breakfastList;
	
	public Menu(){
		coldSnackList = new ArrayList<Dish>();
		hotSnackList = new ArrayList<Dish>();
		breakfastList = new ArrayList<Dish>();
	}
	
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((breakfastList == null) ? 0 : breakfastList.hashCode());
		result = prime * result + ((coldSnackList == null) ? 0 : coldSnackList.hashCode());
		result = prime * result + ((hotSnackList == null) ? 0 : hotSnackList.hashCode());
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
		Menu other = (Menu) obj;
		if (breakfastList == null) {
			if (other.breakfastList != null){
				return false;
			}
		} else if (!breakfastList.equals(other.breakfastList)){
			return false;
		}
		if (coldSnackList == null) {
			if (other.coldSnackList != null){
				return false;
			}
		} else if (!coldSnackList.equals(other.coldSnackList)){
			return false;
		}
		if (hotSnackList == null) {
			if (other.hotSnackList != null){
				return false;
			}
		} else if (!hotSnackList.equals(other.hotSnackList)){
			return false;
		}
		return true;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(Menu.class.getSimpleName());
		sb.append(": <coldSnackList = ");
		sb.append(coldSnackList);
		sb.append(">, <hotSnackList = ");
		sb.append(hotSnackList);
		sb.append(">, <breakfastList = ");
		sb.append(breakfastList);
		sb.append(">.");
		return sb.toString();
	}



	public List<Dish> getColdSnackList() {
		return coldSnackList;
	}
	public void setColdSnackList(List<Dish> coldSnackList) {
		this.coldSnackList = coldSnackList;
	}
	public List<Dish> getHotSnackList() {
		return hotSnackList;
	}
	public void setHotSnackList(List<Dish> hotSnackList) {
		this.hotSnackList = hotSnackList;
	}
	public List<Dish> getBreakfastList() {
		return breakfastList;
	}
	public void setBreakfastList(List<Dish> breakfastList) {
		this.breakfastList = breakfastList;
	}
	
	
}
