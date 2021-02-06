package com.one.entity;

import java.util.List;

public class Grade {
	
	private List<Integer> stuIds;

	public List<Integer> getStuIds() {
		return stuIds;
	}
	public void setStuIds(List<Integer> stuIds) {
		this.stuIds = stuIds;
	}

	@Override
	public String toString() {
		return "Grade [stuIds=" + stuIds + "]";
	}
	
}
