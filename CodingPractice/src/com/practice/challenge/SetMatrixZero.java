package com.practice.challenge;


public class SetMatrixZero {
	
	public static void printMatrix(int[][] m) {
		for(int i=0;i<m.length;i++) {
			for(int j=0;j<m[i].length;j++)
				System.out.print(m[i][j] + "\t");
			System.out.println();
		}
	}
	
	public static void setMatrixZero(int[][] matrix) {
		if(matrix.length==0)
            return;
        boolean row = false;
        boolean col = false;
        
        for(int i=0;i<matrix.length;i++)
            if(matrix[i][0]==0)
                row = true;
                
        for(int i=0;i<matrix[0].length;i++)
            if(matrix[0][i]==0)
                col = true;
                
        for(int i=1;i<matrix.length;i++)
            for(int j=1;j<matrix[i].length;j++)
                if(matrix[i][j]==0)
                    matrix[i][0] = matrix[0][j] = 0;
        
        for(int i=1;i<matrix.length;i++)
            if(matrix[i][0]==0)
                for(int j=1;j<matrix[i].length;j++)
                    matrix[i][j] = 0;
        
        for(int i=1;i<matrix[0].length;i++)
            if(matrix[0][i]==0)
                for(int j=1;j<matrix.length;j++)
                    matrix[j][i] = 0;
        
        if(row)
        for(int i=0;i<matrix.length;i++)
            matrix[i][0]=0;
        
        if(col)
        for(int i=0;i<matrix[0].length;i++)
            matrix[0][i]=0;
        
	}
	
	public static void main(String[] args){
		int[][] matrix = {{0,0,0,5},{4,3,1,4},{0,1,1,4},{1,2,1,3},{0,0,1,1}};
		printMatrix(matrix);
		System.out.println();
		setMatrixZero(matrix);
		printMatrix(matrix);
	}
}
