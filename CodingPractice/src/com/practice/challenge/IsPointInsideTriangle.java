package com.practice.challenge;

public class IsPointInsideTriangle {
	
	public static int getAreaOfTriangle(int x1 ,int y1, int x2, int y2, int x3, int y3) {
		return Math.abs((x1*(y2-y3) + x2*(y3-y1) + x3*(y1-y2)));
	}
	
	public static boolean isPointInsideTriangle(int x1 ,int y1, int x2, int y2, int x3, int y3, int p1, int p2) {
		int triangle1 = getAreaOfTriangle(x1,y1,x2,y2,x3,y3);
		int triangle2 = getAreaOfTriangle(p1,p2,x2,y2,x3,y3);
		int triangle3 = getAreaOfTriangle(p1,p2,x1,y1,x3,y3);
		int triangle4 = getAreaOfTriangle(p1,p2,x1,y1,x2,y2);
		return (triangle1 == (triangle2+triangle3+triangle4));
	}
	
	public static void main(String[] args) {
		System.out.println(isPointInsideTriangle(0, 0, 20, 0, 10, 30, 10, 15));
	}
}
