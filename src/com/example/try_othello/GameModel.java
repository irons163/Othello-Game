package com.example.try_othello;

public class GameModel implements IGameModel{
	private IChessBoard chessBoard;
	
	public GameModel() {
		// TODO Auto-generated constructor stub
		initChessBoard();
	}
	
	private void initChessBoard(){
		chessBoard = new ChessBoard();
	}
	
	@Override
	public void moveChess(ChessPoint chessPoint) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void registerObserver(IMoveObserver moveObserver) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeObserver(IMoveObserver moveObserver) {
		// TODO Auto-generated method stub
		
	}

}
