package com.example.try_othello;

public interface IGameController {
	public void moveChess(ChessPoint chessPoint);
	public void start();
	public void stop();
	public void showWin();
	public void showLose();
}
