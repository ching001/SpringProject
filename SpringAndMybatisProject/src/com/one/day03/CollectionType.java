package com.one.day03;

import java.util.*;

public class CollectionType {

	private String[] arrayElement;
	private List<String> listElement;
	private Set setElement;
	private Map<String,String> mapElement;
	private Properties propElement;
	
	
	public List<String> getListElement() {
		return listElement;
	}
	public void setListElement(List<String> listElement) {
		this.listElement = listElement;
	}
	public Set getSetElement() {
		return setElement;
	}
	public void setSetElement(Set setElement) {
		this.setElement = setElement;
	}
	public Map<String, String> getMapElement() {
		return mapElement;
	}
	public void setMapElement(Map<String, String> mapElement) {
		this.mapElement = mapElement;
	}
	public Properties getPropElement() {
		return propElement;
	}
	public void setPropElement(Properties propElement) {
		this.propElement = propElement;
	}
	public String[] getArrayElement() {
		return arrayElement;
	}
	public void setArrayElement(String[] arrayElement) {
		this.arrayElement = arrayElement;
	}
	@Override
	public String toString() {
		String arrays="";
		for(String str:arrayElement) {
			arrays+=str+",";
		}
		return "CollectionType [listElement=" + listElement + ",\nsetElement=" + setElement + ", \nmapElement="
				+ mapElement + ", \npropElement=" + propElement + ",\narrayElement=" + arrays + "]";
	}
	
	
}
