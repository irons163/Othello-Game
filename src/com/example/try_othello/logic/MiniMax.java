package com.example.try_othello.logic;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

import com.example.try_gameengine.framework.ArrayUtil;

import android.graphics.Point;

public class MiniMax implements IAILogic{
//	static final int x = 1;
//	static final int o = 0;
//	static final int empty = -1;
	
	static final int x = 2;
	static final int o = 1;
	static final int empty = 0;
	
//	static final int INFINITY = 100;
//	static final int WIN = +INFINITY;
//	static final int LOSE = -INFINITY;
//	static final int TRIPLE_LINK = INFINITY/2;
//	static final int DOUBLE_LINK = INFINITY/4;
//	static final int DRAW = 0;
//	static final int INPROGRESS = 1;
	static final int INFINITY = 100;
	static final int WIN = +INFINITY;
	static final int LOSE = -INFINITY;
	static final int Coner = INFINITY-10;
	static final int Lest = INFINITY/2;
	static final int NextConer = INFINITY/5;
	static final int DRAW = 0;
	static final int INPROGRESS = 1;
	
//	static final int[][] WIN_STATUS = {
//		{0, 1, 2},
//		{3, 4, 5},
//		{6, 7, 8},
//		{0, 3, 6},
//		{1, 4, 7},
//		{2, 5, 8},
//		{0, 4, 8},
//		{2, 4, 6}
//	};
	
	static final int[] VALUES = {
		LOSE, INPROGRESS, NextConer, Lest, Coner, WIN
	};
	
	// Âº???∂Ô?ÊØè‰∏™‰ΩçÁΩÆ?Ñ‰º∞??
	static final int[] INITIAL_POS_VALUE = {
		3,3,3,3
	};
	
	// test
	private int searchDeep;
	private int callTimes;
	NormalWinLoseLogic logic;
	int[][] board;
	
	public MiniMax(int[][] board){
		this.board = new int[board.length][board[0].length];
		for(int i = 0; i < board.length; i++){
		      System.arraycopy(board[i], 0, this.board[i], 0, board[i].length);
		}
		
		logic = new NormalWinLoseLogic(this.board);
		
	}
	
	public int[][] getNextBoard(int[][] board){
		int col = getNextPosition(board);
		int row=ArrayUtil.witchArrayColElementIsNotZeroOrderByRow(board, col);
		
		board[col][row] = x;
		return board;
	}
	
	public Point getNextPoint(){
		int col = getNextPosition(board);
		int row=ArrayUtil.witchArrayColElementIsNotZeroOrderByRow(board, col);
		
//		board[col][row] = x;
		return new Point(col, row);
	}
	
	@Override
	public int getNextPosition(int[][] board) {
//		char[] board = new char[9];
		
		int gameState = INPROGRESS;
//		while(!isGameOver(board)){
			
			int nextPos = getNextMove(board);
			System.out.println("nextPos:"+nextPos);
//			board[nextPos] = x;
//			printBoard(board);
			
//			if(isGameOver(board)){
//				break;
//			}
			
//			System.out.print("ËØ∑Ë??•Ô?");
//			Scanner input = new Scanner(System.in);
//			int playerChoice = input.nextInt();
//			while(playerChoice<0 || playerChoice>=9 || board[playerChoice]!=empty){
//				playerChoice = input.nextInt();
//			}
//			board[playerChoice] = o;
//			printBoard(board);
			
//		}
//		gameState = gameState(board);
//		switch(gameState){
//			case WIN:
//				System.out.println("You Lose!");
//				break;
//			
//			case LOSE:
//				System.out.println("You Win!");
//				break;
//			
//			case DRAW:
//				System.out.println("Draw!");
//				break;
//		}
		return nextPos;
	}
	
	/**
	 * ?ìÂç∞Ê£ãÁ?
	 */
	private static void printBoard(char[] board){
		int index = 0;
		for(char chess : board){
			index++;
			if(chess==empty){
				System.out.print("  ,");
			}else{
				System.out.print(" "+chess+',');
			}
			if(index%3==0){
				System.out.println();
			}
		}
		System.out.println("\n---------------------\n");
	}
	
	/**
	 * ?∑Â?'x'?Ñ‰?‰∏?≠•Ëµ∞Ê?
	 */
	public int getNextMove(int[][] board){
		int nextPos = minimax(board, 3);
		System.out.println("searchDeep:"+(6-searchDeep)+", callTimes:"+callTimes);
		return nextPos;
	}
	
	/**
	 * ?§Êñ≠Ê∏∏Ê??ØÂê¶ÁªìÊ?‰∫ÜÔ??úÂà©?ÅÂ§±Ë¥•Ê??åÂ?
	 */
//	public boolean isGameOver(int[] board){
//		int gameState = gameState(board);
//		return (gameState==WIN || gameState==LOSE || gameState==DRAW);
//	}
	
	/**
	 * ‰ª?x'?ÑË?Â∫¶Êù•?ÉË??ÑÊ?Â∞èÊ?Â§ßÁ?Ê≥?
	 */
	public int minimax(int[][] board, int depth){
		int[] bestMoves = new int[9];
		int index = 0;
		
		// test
		searchDeep = depth;
		callTimes = 0;
		
		int bestValue = -INFINITY;
		for(int pos=0; pos<7; pos++){
			int row=ArrayUtil.witchArrayColElementIsNotZeroOrderByRow(board, pos);
			
			if(row==-1){
				continue;
			}
			if(board[pos][row]==empty){
				board[pos][row] = x;
				
				int value = min(board, depth, pos, row);
				//System.out.println(pos+":"+value);
				if(value>bestValue){
					bestValue = value;
					index = 0;
					bestMoves[index] = pos;
				}else
				if(value==bestValue){
					index++;
					bestMoves[index] = pos;
				}
				
				board[pos][row] = empty;
			}
			
		}
		
		System.out.println("index:"+index+" bestValue:"+bestValue);
		if(index>1){
			index = (new Random(System.currentTimeMillis()).nextInt()>>>1)%index;
		}
		return bestMoves[index];
		
	}
	
	/**
	 * ‰º∞Â??ΩÊï∞ÔºåÊ?‰æõ‰?‰∏™ÂêØ?ëÂ??ÑÂ?ÔºåÂÜ≥ÂÆö‰?Ê∏∏Ê?AI?ÑÈ?‰Ω?
	 */
	public int gameState(int[][] board, int col, int rrow){
		int result = INPROGRESS;
		boolean isFull = true;
		int sum = 0;
		int index = 0;
		// is game over?
		for(int pos=0; pos<7; pos++){
			int row=ArrayUtil.witchArrayColElementIsNotZeroOrderByRow(board, pos);
			
			if(row==-1){
				continue;
			}
			
			int chess = board[pos][row];
			if(empty==chess){
				isFull = false;
			}else{
				sum += chess;
				index = pos;
			}
		}
		
		// Â¶ÇÊ??ØÂ?ÂßãÁä∂?ÅÔ??ô‰Ωø?®Â?Â±??
		boolean isInitial = (sum==x||sum==o);
		if(isInitial){
			return (sum==x?1:-1)*INITIAL_POS_VALUE[index];
		}
		
		// is Max win/lose?
//		for(int[] status : WIN_STATUS){
//			int chess = board[status[0]];
//			if(chess==empty){
//				break;
//			}
//			int i = 1;
//			for(; i<status.length; i++){
//				if(board[status[i]]!=chess){
//					break;
//				}
//			}
//			if(i==status.length){
//				result = chess==x ? WIN : LOSE;
//				break;
//			}
//		}
		
		int chess = board[col][rrow];

		
		if(logic.isWin(new Point(col, rrow))){
//		result = logic.isWin(new Point(col, rrow)) ? WIN : LOSE;
			if(chess == x){
				result = WIN;
			}else{
				result = LOSE;
			}
		}
		
		if(result!=WIN & result!=LOSE){
			
			if(isFull){
				// is draw
				result = DRAW;
			}else{
				// check double link
				// finds[0]->'x', finds[1]->'o'
				int[] finds = new int[2];
					
				
//				if(chess == x){
//					result = VALUES[logic.maxNum];
//				}else{
//					result = -VALUES[logic.maxNum];
//				}
				
				
			}
			
		}
		
		return result;
		
	}
	
	/**
	 * ÂØπ‰?'x'Ôºå‰º∞?ºË?Â§ßÂØπ?∂Ë??âÂà©
	 */
	public int max(int[][] board, int depth, int col, int rrow){
		
		int evalValue = gameState(board, col, rrow);
		
		boolean isGameOver = (evalValue==WIN || evalValue==LOSE || evalValue==DRAW);
		if(depth==0 || isGameOver){
			// test
			searchDeep = Math.min(searchDeep, depth);
			return evalValue;
		}
		
		// test
		callTimes++;
		
		int bestValue = -INFINITY;
		for(int pos=0; pos<7; pos++){
			int row=ArrayUtil.witchArrayColElementIsNotZeroOrderByRow(board, pos);
			
			if(row==-1){
				continue;
			}
			
			if(board[pos][row]==empty){
				// try
				board[pos][row] = x;
				
				// maximixing
				bestValue = Math.max(bestValue, min(board, depth-1, pos, row));
				
				// reset
				board[pos][row] = empty;
			}
			
		}
		
		return bestValue;
		
	}
	
	/**
	 * ÂØπ‰?'o'Ôºå‰º∞?ºË?Â∞èÂØπ?∂Ë??âÂà©
	 */
	public int min(int[][] board, int depth, int col, int rrow){
		
		int evalValue = gameState(board, col, rrow);
		
		boolean isGameOver = (evalValue==WIN || evalValue==LOSE || evalValue==DRAW);
		if(depth==0 || isGameOver){
			// test
			searchDeep = Math.min(searchDeep, depth);
			return evalValue;
		}
		
		// test
		callTimes++;
		
		int bestValue = +INFINITY;
		for(int pos=0; pos<7; pos++){
			int row=ArrayUtil.witchArrayColElementIsNotZeroOrderByRow(board, pos);
			
			if(row==-1){
				continue;
			}
			
			if(board[pos][row]==empty){
				// try
				board[pos][row] = o;
				
				// min
				bestValue = Math.min(bestValue, max(board, depth-1, pos, row));
				
				// reset
				board[pos][row] = empty;
			}
			
		}
		
		return bestValue;
		
	}

//	private int lastEmptypoint(int[] col){
//		for
//	}
	
}
