package com.example.try_othello;

import java.util.Iterator;

import com.example.try_gameengine.framework.Data;


public class MyData extends Data{
	private int[][] allExistPoints;

	public Object getAllExistPoints() {
		return allExistPoints;
	}

	public void setAllExistPoints(Object allExistPoints) {
		this.allExistPoints = (int[][]) allExistPoints;
	}

	@Override
	public Iterator getAllExistPointsIterator() {
		// TODO Auto-generated method stub
		return null;
	}
}
