package com.example.try_othello.logic;

import java.util.ArrayList;
import java.util.List;

import com.example.try_gameengine.framework.PlayerManager;
import com.example.try_othello.MyPlayerFactory;
import com.example.try_othello.MyPlayerManager;

import android.graphics.Point;

public class TurnOverLogic extends Logic{
	private List<Point> tempPoints;
	
	public TurnOverLogic(int[][] allExistPoints, int playerNum) {
		super(allExistPoints);
		// TODO Auto-generated constructor stub
		history = new History(playerNum);
	}

	@Override
	protected void possibleMove(Point currentDetectedPoint, int currentPointX, int currentPointY, Point lastDetectedPoint) {
		// TODO Auto-generated method stub
		if (notFreePointDetectedCount >= NOT_FREE_POINT_COUNT_FOR_JUMP) {
			notFreePointDetectedCount = 0;
		if (!points.contains(currentDetectedPoint)) {
			points.addAll(tempPoints);
			pointMoveableDeteced(currentPointX, currentPointY,
					lastDetectedPoint);
		}
		} 
	}

	@Override
	protected void initCurrentTurnOverList() {
		// TODO Auto-generated method stub
		points = new ArrayList<Point>();
	}

	@Override
	protected void addHistoryAndTurnOverChessPoint() {
		// TODO Auto-generated method stub
		history.add(clickPoint, points, whoPlay);
	}

	@Override
	protected void initPointsFor1directionDetect() {
		// TODO Auto-generated method stub
		tempPoints  = new ArrayList<Point>();
	}

	@Override
	protected void addPointToTempList(Point currentDetectedPoint) {
		// TODO Auto-generated method stub
		tempPoints.add(currentDetectedPoint);
	}

	@Override
	protected boolean addPointCondition(int[][] allExistPoints,
			Point currentDetectedPoint) {
		// TODO Auto-generated method stub
		return allExistPoints[currentDetectedPoint.x][currentDetectedPoint.y] == whoPlay;
	}
	
}
