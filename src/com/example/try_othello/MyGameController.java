package com.example.try_othello;

import android.app.Activity;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.SurfaceHolder;

import com.example.try_gameengine.framework.GameController;
import com.example.try_gameengine.framework.GameView;
import com.example.try_gameengine.framework.IDrawEvent;
import com.example.try_gameengine.framework.IGameModel;


public class MyGameController extends GameController implements IDrawEvent{
	MyGameModel myGameModel;
	public MyGameController(Activity activity, MyGameModel gameModel) {
		super(activity, gameModel);
		this.gameModel = gameModel;
		myGameModel = gameModel;
		GameView gameView = new MyGameView(activity, this, gameModel);
		activity.setContentView(gameView);
	}
	
	@Override
	public void drawChessboardLines(Canvas canvas, Paint paint) {
		myGameModel.drawChessboardLines(canvas, paint);
	}

	@Override
	public void drawAllExistPoints(Canvas canvas) {
		// TODO Auto-generated method stub
		myGameModel.drawAllExistPoints(canvas);
	}

	@Override
	public void drawPlayerPocessableMovePoints(Canvas canvas) {
		// TODO Auto-generated method stub
		myGameModel.drawPlayerPocessableMovePoints(canvas);
	}
	
	@Override
	public void runStart(){
//		gameModel.start();
		myGameModel.restart();
	}

	@Override
	public void surfaceChanged(SurfaceHolder holder, int format, int width,
			int height) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void initGameView(Activity activity, IGameModel gameModel) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void arrangeView() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void setActivityContentView(Activity activity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void beforeGameStart() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void afterGameStart() {
		// TODO Auto-generated method stub
		
	}
}
