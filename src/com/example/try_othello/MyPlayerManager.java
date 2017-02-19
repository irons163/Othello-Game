package com.example.try_othello;

import java.util.List;

import android.graphics.Point;
import android.view.MotionEvent;

import com.example.try_gameengine.framework.AChessPlayerManager;
import com.example.try_gameengine.framework.IChessBoard;
import com.example.try_gameengine.framework.IChessPointManager;
import com.example.try_gameengine.framework.IPlayer;
import com.example.try_othello.logic.Logic;
import com.example.try_othello.logic.TurnOverLogic;

public class MyPlayerManager extends AChessPlayerManager{
	MyPlayerFactory playerFactory;
	MyChessPointManager chessPointManager;
	Logic logic;
	Logic turnOverLogic;
	private Point clickPoint;
	
	public MyPlayerManager(IChessBoard jumpChessBoard, MyChessPointManager chessPointManager) {
		super(jumpChessBoard, chessPointManager);
		// TODO Auto-generated constructor stub
		
	}

	@Override
	protected void initPlayerFactory(IChessPointManager chessPointManager) {
		// TODO Auto-generated method stub
		playerFactory = new MyPlayerFactory((MyChessPointManager)chessPointManager);
	}

	@Override
	protected void initPlayerFactoryCreate(List<IPlayer> playersBySquential) {
		// TODO Auto-generated method stub
		playersBySquential.add(playerFactory.createHumanPlayerWithRed());
//		playersBySquential.add(playerFactory.createHumanPlayerWithWhite());
		playersBySquential.add(playerFactory.createHumanPlayerWithYellow());
		
		initHisTory(playersBySquential.size());
	}

	private void initHisTory(int playerNum){
		turnOverLogic = new TurnOverLogic(jumpChessBoard.getAllExistPoints(), playerNum);
	}
	
	@Override
	protected void initChecssPointManagerCreate() {
		// TODO Auto-generated method stub
//		chessPointManager.createChessPointBlue();
	}
	
	@Override
	protected void touchPerform(MotionEvent paramMotionEvent){
		if (isPlayerCanRun()) {
			this.whoPlay = getCurrentPlayer();		
			isClick(paramMotionEvent, this.whoPlay);			
		} else if (isPlayerProcessing()) {
			if(isClick(paramMotionEvent, this.whoPlay)){
				whoRun = -1;
			} else
				playerRun(paramMotionEvent, this.whoPlay, this.clickPoint);
		}
	}
	
	private void playerRun(MotionEvent paramMotionEvent, IPlayer paramIPlayer,
			Point paramPoint) {

		this.whoRun = this.playersBySquential.indexOf(paramIPlayer);
//		this.whoRun 
		detectSomeOneWinAndToNextPlayerTurn();
	}
	
	private void decideNextPlayer() {
		this.whoRun = (1 + this.whoRun);
		if (this.whoRun != this.playersBySquential.size())
			return;
		this.whoRun = 0;
	}

	private void detectSomeOneWinAndToNextPlayerTurn() {
		decideNextPlayer();
		
	}

	@Override
	protected boolean isClick(MotionEvent paramMotionEvent, IPlayer player) {
		// TODO Auto-generated method stub
		boolean a = false;

		Point newPoint = jumpChessBoard.newPoint(
				Float.valueOf(paramMotionEvent.getX()),
				Float.valueOf(paramMotionEvent.getY()));
		if ((newPoint.x >= 0 && newPoint.x < jumpChessBoard.getAllExistPoints().length)
				&& (newPoint.y >= 0 && newPoint.y < jumpChessBoard
						.getAllExistPoints()[0].length)) {
			int playerIndex = playersBySquential.indexOf(player)+1;

			if (jumpChessBoard.getAllExistPoints()[newPoint.x][newPoint.y] != 0){
				a = true;
				int[][] allExistPoints = jumpChessBoard.getAllExistPoints();
//				allExistPoints[newPoint.x][newPoint.y] = getWhoRun()+1;
				clickPoint = new Point(newPoint.x, newPoint.y);
				whoRun = -1;
//				Logic.jumps.clear();
//				if(playerIndex==1){
//					logic.startToDetectedTopToDown(newPoint.x, newPoint.y, playerIndex);
//				}else{
//					logic.startToDetectedDownToTop(newPoint.x, newPoint.y, playerIndex);
//				}			
				Logic.jumps.clear();
				Logic.whoPlay = playerIndex;
				logic.startToDetectedTopToDown(newPoint.x, newPoint.y, playerIndex);	
				Logic.jumps.add(new Point(newPoint.x+1, newPoint.y));
			}else{
//				Logic.jumps.clear();
////				logic.startToDetectedTopToDown(newPoint.x, newPoint.y, playerIndex);	
//				Logic.jumps.add(new Point(newPoint.x+1, newPoint.y));
				if(!Logic.jumps.contains(new Point(newPoint.x, newPoint.y))){
					Logic.jumps.clear();
					a = true;
				}else{
					Logic.jumps.clear();
					turnOverLogic.startToDetectedTopToDown(newPoint.x, newPoint.y, playerIndex);
					int[][] allExistPoints = jumpChessBoard.getAllExistPoints();
					allExistPoints[newPoint.x][newPoint.y] = playerIndex;
					((MyChessBoard)jumpChessBoard).doTurnOverChess(turnOverLogic.getTurnOverList());
				}
				
			}				
		}else{
			a = true;
		}
		return a;
	}

	public void setLogic(Logic logic) {
		// TODO Auto-generated method stub
		this.logic = logic;
	}

	@Override
	protected void doAiProcess(IPlayer player, int[][] board) {
		// TODO Auto-generated method stub
		
	}
}
