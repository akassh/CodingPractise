package com.practice.challenge;

public class SudokuSolver {
	int[][] sudoku;
	
	public SudokuSolver(int[][] m) {
		assert(m!=null);
		assert(m.length==9);
		for(int[] a : m)
			assert(a.length==9);
		this.sudoku = m;
	}
	
	public boolean solveSudoku() {
		int x = -1;
		int y = -1;
		outer : for(int i=0;i<sudoku.length;++i)
					for(int j=0;j<sudoku.length;++j)
						if(sudoku[i][j]==0) {
							x=i;
							y=j;
							break outer;
						}
		if(x==-1&&y==-1)
			return true;
		for(int i=1;i<=9;++i)
			if(isSafe(x, y, i)) {
				sudoku[x][y] = i;
				if(solveSudoku())
					return true;
				sudoku[x][y] = 0;
			}
		return false;
	}
	
	private boolean isSafe(int row, int column, int number) {
		return 	!(	isNumberPresentInRow(row, column, number) 
				|| 	isNumberPresentInColumn(row, column, number) 
				|| 	isNumberPresentInBox(row - row%3, column - column%3, number));
	}
	
	private boolean isNumberPresentInColumn(int row,int column, int number) {
		for(int i=0;i<sudoku.length;++i)
			if(sudoku[i][column] == number)
				return true;
		return false;
	}
	
	private boolean isNumberPresentInRow(int row,int column, int number) {
		for(int i=0;i<sudoku.length;++i)
			if(sudoku[row][i] == number)
				return true;
		return false;
	}
	
	private boolean isNumberPresentInBox(int row,int column, int number) {
		for(int i=0;i<3;++i)
			for(int j=0;j<3;++j)
				if(sudoku[row+i][column+j] == number)
					return true;
		return false;
	}
	
	public void printSolution() {
		ArraysUtility.printMatrix(sudoku);
	}
	
	public static void main(String[] args) {
		int[][] m = {	{3, 0, 6, 5, 0, 8, 4, 0, 0},
                		{5, 2, 0, 0, 0, 0, 0, 0, 0},
                		{0, 8, 7, 0, 0, 0, 0, 3, 1},
                		{0, 0, 3, 0, 1, 0, 0, 8, 0},
                		{9, 0, 0, 8, 6, 3, 0, 0, 5},
                		{0, 5, 0, 0, 9, 0, 6, 0, 0},
                		{1, 3, 0, 0, 0, 0, 2, 5, 0},
                		{0, 0, 0, 0, 0, 0, 0, 7, 4},
                		{0, 0, 5, 2, 0, 6, 3, 0, 0}};
		SudokuSolver s = new SudokuSolver(m);
		s.solveSudoku();
		s.printSolution();
	}
}
