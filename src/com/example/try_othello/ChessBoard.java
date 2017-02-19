package com.example.try_othello;

import java.util.ArrayList;
import java.util.List;


public class ChessBoard implements IChessBoard{
	
	// �e�ѽL
		private List<Line> lines = new ArrayList<Line>();// ��Line���X�bonSizeChange�ɤw�Q��l�ơA�����Ʊ��u(EX:25)
	
	// �u���O
	class Line {
		float xStart, yStart, xStop, yStop;

		// �غc�l
		public Line(float xStart, float yStart, float xStop, float yStop) {
			// onSizeChange��l�ƮɡA��U�Ӯy�жǤJ(�}�l��xy�y�Ш쵲����xy�y��)
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

		// ���ʹѽL�W�Ҧ����u
		public void createLines() {
			for (int i = 0; i < maxX; i++) {// �ݽu 0-24 �@25��
				// (5+0-10) (240+20-10) (-5+480-10)
				lines.add(new Line((i + 1) * lineDistance
						- widthPaddingDimension, widthPaddingDimension, (i + 1)
						* lineDistance - widthPaddingDimension, maxY
						* lineDistance - widthPaddingDimension));
			}
			for (int i = 0; i < maxY; i++) {// ��u
				lines.add(new Line(widthPaddingDimension, (i + 1)
						* lineDistance - widthPaddingDimension, maxX
						* lineDistance - widthPaddingDimension, (i + 1)
						* lineDistance - widthPaddingDimension));
			}
		}

		public void createPoints() {
//			allFreePoints.clear(); // �Ҧ��ť��I���X���M��(�]�����s�}�l�F)
//			for (int i = 0; i < maxX; i++) { // ��u��1
//				for (int j = 0; j < maxY; j++) {
//					allFreePoints.add(new Point(i, j));// �ť��I���X
//				}
//			}
			
			for(int i = 0 ; i < maxX-1 ; i++){
				for(int j = 0 ; j < maxY-1; j++){
					allExistPoints[i][j] = 0;
				}
			}
		}

		// �ھ�Ĳ�N�I�y�Ч������I
		public int newPoint(Float x, Float y) {
//			Point p = new Point(-1, -1);// �Ыؾ�b�s����0(��b���Ĥ@���I)�A�a�b�s���]��0(�a�b���Ĥ@���I)���I
			int positionX = -1;
			if(y >= widthPaddingDimension + yOffset && y <= 6*lineDistance + widthPaddingDimension + yOffset)
			for (int i = 0; i < maxX-1; i++) {// 0-23 �@24�I
				// (0-5)<0 0<(20-5)
				if ((i * lineDistance + widthPaddingDimension + xOffset) <= x
						&& x < ((i + 1) * lineDistance + widthPaddingDimension + xOffset)) {
					// p.setX(i);//�]�wp��x��i�A�]�N�O��b��i+1���I
					positionX = i;
				}
			}

			return positionX; // �^�� ponit p
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
