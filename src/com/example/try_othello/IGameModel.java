package com.example.try_othello;

public interface IGameModel {
	public void moveChess(ChessPoint chessPoint);
	public void registerObserver(IMoveObserver moveObserver);
	public void removeObserver(IMoveObserver moveObserver);
}
