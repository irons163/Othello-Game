package com.example.try_othello;

import com.example.try_gameengine.framework.HumanPlayer;
import com.example.try_gameengine.framework.IChessPointManager;
import com.example.try_gameengine.framework.IPlayer;
import com.example.try_gameengine.framework.PlayerFactory;

public class MyPlayerFactory extends PlayerFactory{
	MyChessPointManager chessPointManager;
	public MyPlayerFactory(MyChessPointManager chessPointManager) {
		super(chessPointManager);
		// TODO Auto-generated constructor stub
		this.chessPointManager = chessPointManager;
	}

	public IPlayer createHumanPlayerWithRed() {
		return new HumanPlayer(chessPointManager.createChessPointWhite(), chessPointManager.createChessPointBlue());		
	}
	
	public IPlayer createHumanPlayerWithWhite() {
		return new HumanPlayer(chessPointManager.createChessPointWhite(), chessPointManager.createChessPointBlue());		
	}
	
	public IPlayer createHumanPlayerWithYellow() {
		return new HumanPlayer(chessPointManager.createChessPointWhite(), chessPointManager.createChessPointYellow());		
	}
}
