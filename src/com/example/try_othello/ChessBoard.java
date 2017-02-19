package com.example.try_othello;

import java.util.ArrayList;
import java.util.List;


public class ChessBoard implements IChessBoard{
	
	// 畫棋盤
		private List<Line> lines = new ArrayList<Line>();// 此Line集合在onSizeChange時已被初始化，內有數條線(EX:25)
	
	// 線類別
	class Line {
		float xStart, yStart, xStop, yStop;

		// 建構子
		public Line(float xStart, float yStart, float xStop, float yStop) {
			// onSizeChange初始化時，把各個座標傳入(開始的xy座標到結束的xy座標)
			this.xStart = xStart;
			this.yStart = yStart;
			this.xStop = xStop;
			this.yStop = yStop;
		}
	}


		private int maxX;
		private int maxY;
		private int xOffset;
		private int yOffset;
		private int lineDistance;
//		private List<Point> allFreePoints;
		private int[][] allExistPoints = new int[7][6];

		private int width, height;
		private int widthPaddingDimension;
		
		public ChessBoard() {
			
//			allFreePoints = new ArrayList<Point>();
			maxX = 8;
			maxY = 7;

			// int widthPaddingPersent = 1;

			lineDistance = width / (maxX);
			widthPaddingDimension = lineDistance / 2;
			
//			this.maxX = maxX;
//			this.maxY = maxY;
			this.xOffset = 0;
			this.yOffset = 0;
//			this.lineDistance = lineDistance;

		}
		
//		public ChessBoard(int maxX, int maxY, int xOffset, int yOffset,
//				int lineDistance) {
//			
////			allFreePoints = new ArrayList<Point>();
//			maxX = 8;
//			maxY = 7;
//
//			// int widthPaddingPersent = 1;
//
//			lineDistance = width / (maxX);
//			widthPaddingDimension = lineDistance / 2;
//			
//			this.maxX = maxX;
//			this.maxY = maxY;
//			this.xOffset = xOffset;
//			this.yOffset = yOffset;
//			this.lineDistance = lineDistance;
//
//		}

		// 產生棋盤上所有的線
		public void createLines() {
			for (int i = 0; i < maxX; i++) {// 豎線 0-24 共25條
				// (5+0-10) (240+20-10) (-5+480-10)
				lines.add(new Line((i + 1) * lineDistance
						- widthPaddingDimension, widthPaddingDimension, (i + 1)
						* lineDistance - widthPaddingDimension, maxY
						* lineDistance - widthPaddingDimension));
			}
			for (int i = 0; i < maxY; i++) {// 橫線
				lines.add(new Line(widthPaddingDimension, (i + 1)
						* lineDistance - widthPaddingDimension, maxX
						* lineDistance - widthPaddingDimension, (i + 1)
						* lineDistance - widthPaddingDimension));
			}
		}

		public void createPoints() {
//			allFreePoints.clear(); // 所有空白點集合先清空(因為重新開始了)
//			for (int i = 0; i < maxX; i++) { // 比線少1
//				for (int j = 0; j < maxY; j++) {
//					allFreePoints.add(new Point(i, j));// 空白點集合
//				}
//			}
			
			for(int i = 0 ; i < maxX-1 ; i++){
				for(int j = 0 ; j < maxY-1; j++){
					allExistPoints[i][j] = 0;
				}
			}
		}

		// 根據觸摸點座標找到對應點
		public int newPoint(Float x, Float y) {
//			Point p = new Point(-1, -1);// 創建橫軸編號為0(橫軸的第一個點)，縱軸編號也為0(縱軸的第一個點)的點
			int positionX = -1;
			if(y >= widthPaddingDimension + yOffset && y <= 6*lineDistance + widthPaddingDimension + yOffset)
			for (int i = 0; i < maxX-1; i++) {// 0-23 共24點
				// (0-5)<0 0<(20-5)
				if ((i * lineDistance + widthPaddingDimension + xOffset) <= x
						&& x < ((i + 1) * lineDistance + widthPaddingDimension + xOffset)) {
					// p.setX(i);//設定p的x為i，也就是橫軸第i+1個點
					positionX = i;
				}
			}

			return positionX; // 回傳 ponit p
		}

		public int getMaxX() {
			return maxX;
		}

		public void setMaxX(int maxX) {
			this.maxX = maxX;
		}

		public int getMaxY() {
			return maxY;
		}

		public void setMaxY(int maxY) {
			this.maxY = maxY;
		}

		public int getxOffset() {
			return xOffset;
		}

		public void setxOffset(int xOffset) {
			this.xOffset = xOffset;
		}

		public int getyOffset() {
			return yOffset;
		}

		public void setyOffset(int yOffset) {
			this.yOffset = yOffset;
		}

		public int getLineDistance() {
			return lineDistance;
		}

		public void setLineDistance(int lineDistance) {
			this.lineDistance = lineDistance;
		}

		public int[][] getAllExistPoints() {
			return allExistPoints;
		}

		public void setAllExistPoints(int[][] allExistPoints) {
			this.allExistPoints = allExistPoints;
		}


}
