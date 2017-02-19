package com.example.try_othello.logic;

public interface IAILogic {
	int[][] getNextBoard(int[][] board);
	int getNextPosition(int[][] board);
}
