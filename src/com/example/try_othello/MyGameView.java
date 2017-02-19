package com.example.try_othello;

import android.content.Context;
import android.graphics.Canvas;

import com.example.try_gameengine.framework.Data;
import com.example.try_gameengine.framework.GameModel;
import com.example.try_gameengine.framework.GameView;


public class MyGameView extends GameView{
	private Data data;
	private int[][] allExistPoints;
	MyGameController gameController;
	public MyGameView(Context context, MyGameController gameController,
			GameModel gameModel) {
		super(context, gameController, gameModel);
		// TODO Auto-generated constructor stub
		data = gameModel.getData();
		allExistPoints = (int[][]) data.getAllExistPoints();
		this.gameController = gameController;
	}


	
	private void drawChessboardLines(Canvas canvas) {
		gameController.drawAllExistPoints(canvas);
	}
	
	private void drawAllExistPoints(Canvas canvas) {
		gameController.drawChessboardLines(canvas, null);
	}
	
	private void drawPlayerPocessableMovePoints(Canvas canvas) {
		gameController.drawPlayerPocessableMovePoints(canvas);
	}
}
