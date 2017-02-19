package com.example.try_othello;

import java.util.List;

import android.graphics.Canvas;
import android.graphics.Point;

import com.example.try_gameengine.framework.ChessBoard;
import com.example.try_othello.logic.Logic;


public class MyChessBoard extends ChessBoard{

	public MyChessBoard(int width, int height, int colPointNum, int rowPointNum) {
		super(width, height, colPointNum, rowPointNum);
		// TODO Auto-generated constructor stub
		setyOffset(200);
	}

	@Override
	public void createPoints() {
		// TODO Auto-generated method stub
		allExistPoints = new int[][] { { 0, 1, 2, 0, 0, 0, 0, 0 },
				{ 0, 2, 1, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0 } };
//		allExistPoints = ArrayUtil.arrayTranspose(allExistPoints);
	}
	
	@Override
	public void drawPlayerPocessableMovePoints(Canvas canvas) {
		for(int i = 0; i < Logic.jumps.size(); i++){
			Point point = Logic.jumps.get(i);
			drawPlayerPoint(canvas, point, Logic.whoPlay);
		}
	}
	
	public void doTurnOverChess(List<Point> points){
		for(Point point : points){
			if(allExistPoints[point.x][point.y]==1)
				allExistPoints[point.x][point.y]=2;
			else 
				allExistPoints[point.x][point.y]=1;
		}
	}
}
