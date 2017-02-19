package com.example.try_othello.logic;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import android.graphics.Point;
import android.util.Pair;

public class History {
	private int max = 10;
	private List<Stack<Pair<Point, List<Point>>>> playersUndoList = new ArrayList<Stack<Pair<Point, List<Point>>>>();
	private HistoryInfo historyInfo; 
	
	public History(int playerNum) {
		// TODO Auto-generated constructor stub
		init(playerNum);
	}
	
	private void init(int playerNum){
		historyInfo = new HistoryInfo();
		for(int i =0; i<playerNum; i++){
			playersUndoList.add(new Stack<Pair<Point, List<Point>>>());
		}
	}
	
	public void add(Point point, List<Point> points, int playerId){
		historyInfo.add(point);
		Stack<Pair<Point, List<Point>>> currentPlayerUndoList = playersUndoList.get(playerId-1);
		if(currentPlayerUndoList.size() < max){
			currentPlayerUndoList.add(new Pair<Point, List<Point>>(point, points));
		}else{
			currentPlayerUndoList.remove(0);
			currentPlayerUndoList.add(new Pair<Point, List<Point>>(point, points));
		}
		
	}
	
	public Pair<Point, List<Point>> pop(int playerId){
		historyInfo.removeLast();
		Stack<Pair<Point, List<Point>>> currentPlayerUndoList = playersUndoList.get(playerId);
		return currentPlayerUndoList.pop();
	}
	
	public HistoryInfo getHistoryInfo(){
		return historyInfo;
	}
}

class HistoryInfo{
	String player1Name, player2Name;
	String player1PlayerColor;
	String player2PlayerColor;
	List<Point> points = new ArrayList<Point>();
	
	public HistoryInfo() {
		// TODO Auto-generated constructor stub
		this.player1Name = "player1";
		this.player2Name = "player2";
	}
	
	public HistoryInfo(String player1Name, String player2Name) {
		// TODO Auto-generated constructor stub
		this.player1Name = player1Name;
		this.player2Name = player2Name;
	}
	
	public void add(Point point){
		points.add(point);
	}
	
	public void remove(Point point){
		points.remove(point);
	}
	
	public void removeLast(){
		points.remove(points.size()-1);
	}
}
