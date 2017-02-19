package com.example.try_othello;

import android.content.Context;

import com.example.try_gameengine.framework.ChessPointManager;
import com.example.try_gameengine.framework.IChessPoint;


public class MyChessPointManager extends ChessPointManager{
	MyChessPointFactory chessPointFactory;
	public MyChessPointManager(Context context, int chessPointWidth,
			int chessPointHeight) {
		super(context, chessPointWidth, chessPointHeight);
		// TODO Auto-generated constructor stub
		this.chessPointFactory = new MyChessPointFactory(context, chessPointWidth, chessPointHeight);;
		setChessPointFactory(chessPointFactory);
	}
	
	public IChessPoint createChessPointBlue() {
		// TODO Auto-generated method stub
		return chessPointFactory.createChessPointBlue();
	}

	public IChessPoint createChessPointWhite() {
		// TODO Auto-generated method stub
		return chessPointFactory.createChessPointWhite();
	}
	
	public IChessPoint createChessPointYellow() {
		// TODO Auto-generated method stub
		return chessPointFactory.createChessPointYellow();
	}
}
