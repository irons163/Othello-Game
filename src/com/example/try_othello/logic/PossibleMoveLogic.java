package com.example.try_othello.logic;

import java.util.ArrayList;

import android.graphics.Point;

public class PossibleMoveLogic extends Logic{

	public PossibleMoveLogic(int[][] allExistPoints) {
		super(allExistPoints);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void possibleMove(Point currentDetectedPoint, int currentPointX, int currentPointY, Point lastDetectedPoint) {
		// TODO Auto-generated method stub
		if (notFreePointDetectedCount >= NOT_FREE_POINT_COUNT_FOR_JUMP) {
			notFreePointDetectedCount = 0;
		if (!jumps.contains(currentDetectedPoint)) {
//			currentDetectedPoint.setJumpableChecked(true);
			jumps.listIterator().add(currentDetectedPoint);
//			startToDetected(currentPointX, currentPointY,
//					lastDetectedPoint);
			pointMoveableDeteced(currentPointX, currentPointY,
					lastDetectedPoint);
		}
		} 
	}

	@Override
	protected void initCurrentTurnOverList() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void addHistoryAndTurnOverChessPoint() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void initPointsFor1directionDetect() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void addPointToTempList(Point currentDetectedPoint) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected boolean addPointCondition(int[][] allExistPoints,
			Point currentDetectedPoint) {
		// TODO Auto-generated method stub
		return allExistPoints[currentDetectedPoint.x][currentDetectedPoint.y] == 0;
	}
	
}
