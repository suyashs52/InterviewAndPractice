package com.gfg;

public class RatInMaze {
//https://www.geeksforgeeks.org/rat-in-a-maze-backtracking-2/
	public static void code() {

		int maze[][] = { { 1, 0, 0, 0 }, { 1, 1, 0, 1 }, { 0, 1, 0, 0 }, { 1, 1, 1, 1 } };
		int N = maze.length;
		int sol[][] = new int[N][N];

		maze(maze, 0, 0, sol, N);
		for (int i = 0; i < maze.length; i++) {
			for (int j = 0; j < maze[0].length; j++) {
				System.out.print(" " + sol[i][j] + " ");
			}
			System.out.println();
		}
	}

	static void maze(int maze[][], int x, int y, int sol[][], int n) {
		if (x > n-1 || y > n-1)
			return;
		if (maze[x][y] == 0)
			return;

		sol[x][y] = 1;
		maze(maze, x + 1, y, sol, n);
		maze(maze, x, y + 1, sol, n);
		
		

	}
}
