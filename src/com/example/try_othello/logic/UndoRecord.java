package com.example.try_othello.logic;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import android.graphics.Point;
import android.util.Pair;

public class UndoRecord {
	private int max = 10;
	private List<Stack<Pair<Point, List<Point>>>> playersUndoList = new ArrayList<Stack<Pair<Point, List<Point>>>>();
	
	public void init(int playerNum){
		for(int i =0; i<playerNum; i++){
			playersUndoList.add(new Stack<Pair<Point, List<Point>>>());
		}
	}
	
	public void add(Point point, List<Point> points, int playerId){
		Stack<Pair<Point, List<Point>>> currentPlayerUndoList = playersUndoList.get(playerId);
		if(currentPlayerUndoList.size() < max){
			currentPlayerUndoList.add(new Pair<Point, List<Point>>(point, points));
		}else{
			currentPlayerUndoList.remove(0);
			currentPlayerUndoList.add(new Pair<Point, List<Point>>(point, points));
		}
		
	}
	
	public Pair<Point, List<Point>> get(int playerId){
		Stack<Pair<Point, List<Point>>> currentPlayerUndoList = playersUndoList.get(playerId);
		return currentPlayerUndoList.pop();
	}
	
	public void add(){
		
	}
	
}
