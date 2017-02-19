package com.example.try_othello;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.MotionEvent;

import com.example.try_gameengine.framework.AChessGameModel;
import com.example.try_gameengine.framework.CommonUtil;
import com.example.try_gameengine.framework.Data;
import com.example.try_othello.logic.Logic;
import com.example.try_othello.logic.PossibleMoveLogic;


public class MyGameModel extends AChessGameModel{
	private MyPlayerManager playerManager;
	
	public MyGameModel(Context context, Data data) {
		super(context, data);
		// TODO Auto-generated constructor stub
		chessBoard.setPlayersBySquential(playerManager.getPlayersBySquential());
	}
	@Override
	public void initChessBoard(){
		chessBoard = new MyChessBoard(CommonUtil.screenWidth, CommonUtil.screenHeight, 8, 8);
		chessBoard.createLines();
		chessBoard.createPoints();
		allExistPoints = chessBoard.getAllExistPoints();
		data.setAllExistPoints(allExistPoints);
	}
	@Override
	public void initChessPointManager(){
		chessPointManager = new MyChessPointManager(context, chessBoard.getLineDistance(), chessBoard.getLineDistance());
	}
	@Override
	public void initPlayerManager(){
//		playerManager = new PlayerManager(chessBoard, chessPointManager);
		playerManager = (new MyPlayerManager(chessBoard, (MyChessPointManager)chessPointManager));
//		Logic logic = new Logic(allExistPoints);
		Logic logic = new PossibleMoveLogic(allExistPoints);
		playerManager.setLogic(logic);
//		playerManager.setPlayersBySquential(players);
//		playerManager.setBoard(jumpChessBoard);
	}
	
	@Override
	protected void doDraw(Canvas canvas) {
		// TODO Auto-generated method stub
		drawChessboardLines(canvas, null);
		drawAllExistPoints(canvas);
		drawPlayerPocessableMovePoints(canvas);
	}

	@Override
	public void drawChessboardLines(Canvas canvas, Paint paint) {
		// TODO Auto-generated method stub
		paint = new Paint();
		paint.setColor(Color.LTGRAY);
		
		chessBoard.drawChessboardLines(canvas, paint);
	}

	@Override
	public void drawAllExistPoints(Canvas canvas) {
		// TODO Auto-generated method stub
		chessBoard.drawAllExistPoints(canvas);
	}

	@Override
	public void drawPlayerPocessableMovePoints(Canvas canvas) {
		// TODO Auto-generated method stub
		chessBoard.drawPlayerPocessableMovePoints(canvas);
	}
	@Override
	public void onTouchEvent(MotionEvent event) {
		// TODO Auto-generated method stub
		playerManager.onTouchEvent(event);
	}

}
