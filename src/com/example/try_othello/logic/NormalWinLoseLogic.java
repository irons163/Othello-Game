package com.example.try_othello.logic;

import java.util.ArrayList;
import java.util.List;

import android.graphics.Point;

public class NormalWinLoseLogic implements IWinLoseLogic {
	private int[][] allExistPoints;
	int who;
	public List<Point> removePoints = new ArrayList<Point>();
	
	public NormalWinLoseLogic(int[][] allExistPoints){
		this.allExistPoints = allExistPoints;
	}
	
	@Override
	public boolean isWin(Point p) {
		boolean isWin = true;
		int x = p.x;
		int y = p.y;
		who = allExistPoints[x][y];
		
//		if(detectLeftAndRight(x, y) || 
//		detectLeftTopAndRightBottom(x, y) ||
//		detectTopAndBottom(x, y) ||
//		detectLeftBottomAndRightTop(x, y)){
//			isWin = true;
//		}
			
			for(int col = 0 ;col < allExistPoints.length ; col++){
				for(int row = 0 ; row < allExistPoints[col].length ; row++){
					int whosePoint = allExistPoints[col][row];
					if(whosePoint!=0 && whosePoint!=who){
						isWin = false;
						break;
					}
				}
			}
		
		return isWin;
	}
	
	public boolean isClear(Point p){
		boolean isWin = false;
		int x = p.x;
		int y = p.y;
		who = allExistPoints[x][y];
//		
//		if(detectLeftAndRight(x, y)){
//			removePoints.clear();
//			isWin = true;
//		}else if(detectLeftTopAndRightBottom(x, y)){
//			removePoints.clear();
//			isWin = true;
//		}else if(){
//			removePoints.clear();
//			isWin = true;
//		}else if(){
//			removePoints.clear();
//			isWin = true;
//		}
//		
		if(detectLeftAndRight(x, y) || 
		detectLeftTopAndRightBottom(x, y) ||
		detectTopAndBottom(x, y) ||
		detectLeftBottomAndRightTop(x, y)){
//			removePoints.clear();
			isWin = true;
		}
		
		return isWin;
	}
	
	private boolean detect(int x, int y){
		boolean isDeteced = false;
		if(x >= 0 && x < allExistPoints.length && y >= 0 && y < allExistPoints[x].length){
			if(allExistPoints[x][y]==who){
				isDeteced = true;
			}
		}
			
		return isDeteced;
	}
	
	private int detect(int x, int y, int offsetX, int offsetY){
		int num = 0;
		if(detect(x + offsetX, y + offsetY)){
			num = detect(x + offsetX, y + offsetY , offsetX, offsetY);
			removePoints.add(new Point(x + offsetX, y + offsetY));
			return ++num;
		}else{
			return num;
		}
	}
	
	private boolean detectLeftAndRight(int x, int y){
		boolean b = isWin(detectLeft(x, y), detectRight(x, y));
		if(!b)
			removePoints.clear();
		return b;
	}
	
	private int detectLeft(int x, int y){
		return detect(x, y, -1, 0);
	}
	
	private int detectRight(int x, int y){
		return detect(x, y, 1, 0);
	}
	
	private boolean detectLeftTopAndRightBottom(int x, int y){	
		boolean b = isWin(detectLeftTop(x, y), detectRightBottom(x, y));
		if(!b)
			removePoints.clear();
		return b;
	}
	
	private int detectLeftTop(int x, int y){
		return detect(x, y, -1, -1);
	}
	
	private int detectRightBottom(int x, int y){
		return detect(x, y, 1, 1);
	}
	
	private boolean detectTopAndBottom(int x, int y){	
		boolean b = isWin(detectTop(x, y), detectBottom(x, y));
		if(!b)
			removePoints.clear();
		return b;
	}
	
	private int detectTop(int x, int y){
		return detect(x, y, 0, -1);
	}
	
	private int detectBottom(int x, int y){
		return detect(x, y, 0, 1);
	}
	
	private boolean detectLeftBottomAndRightTop(int x, int y){	
		boolean b = isWin(detectLeftBottom(x, y), detectRightTop(x, y));
		if(!b)
			removePoints.clear();
		return b;
	}
	
	private int detectLeftBottom(int x, int y){
		return detect(x, y, -1, 1);
	}
	
	private int detectRightTop(int x, int y){
		return detect(x, y, 1, -1);
	}
	
	private boolean isWin(int oneSideNum, int theOtherSideNum){
		int totalNum = oneSideNum + theOtherSideNum;
		boolean isWin = false;
		if(totalNum>=3)
			isWin = true;
		return isWin;
	}

	@Override
	public void rank() {
		// TODO Auto-generated method stub

	}

	@Override
	public void countScore() {
		// TODO Auto-generated method stub

	}
}