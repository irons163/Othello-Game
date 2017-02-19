package com.example.try_othello;

import android.content.Context;

import com.example.try_gameengine.framework.BitmapUtil;
import com.example.try_gameengine.framework.ChessPoint;
import com.example.try_gameengine.framework.ChessPointFactory;
import com.example.try_gameengine.framework.IChessPoint;


public class MyChessPointFactory extends ChessPointFactory{

	public MyChessPointFactory(Context context, int chessPointWidth,
			int chessPointHeight) {
		super(context, chessPointWidth, chessPointHeight);
		// TODO Auto-generated constructor stub
	}
	
	public IChessPoint createChessPointBlue() {
		IChessPoint chessPoint = new ChessPoint();
		chessPoint.setChessPointBitmap(BitmapUtil.createSpecificSizeBitmap(resources.getDrawable(R.drawable.red_point), chessPointWidth, chessPointHeight));
		return chessPoint;
	}

	public IChessPoint createChessPointWhite() {
		IChessPoint chessPoint = new ChessPoint();
		chessPoint.setChessPointBitmap(BitmapUtil.createSpecificSizeBitmap(resources.getDrawable(R.drawable.white_point), chessPointWidth, chessPointHeight));
		return chessPoint;
	}
	
	public IChessPoint createChessPointYellow() {
		IChessPoint chessPoint = new ChessPoint();
		chessPoint.setChessPointBitmap(BitmapUtil.createSpecificSizeBitmap(resources.getDrawable(R.drawable.yellow_point), chessPointWidth, chessPointHeight));
		return chessPoint;
	}
}
