package minesweeper;
import java.util.Scanner;
import java.util.Arrays;
import java.util.Random;

public class MinesweeperGame {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner input = new Scanner(System.in);
		int row =0,col = 0;
		int user = -1;
		
		while (user != 0 && user != 1 && user != 2) {
			System.out.println("\n************************************");
			System.out.println("\nEnter difficulty level");
			System.out.println("Press 0 for BEGINNER 9*9 cells and 10 mines");
			System.out.println("Press 1 for INTERMEDIATE 16*16 cells and 40 mines");
			System.out.println("Press 2 for ADVANCED 24*24 cells and 99 mines\n");
			user = input.nextInt();
			System.out.println("\n************************************");
			if (user == 0) {
				
				row = 9; col = 9;
				
				}
			else if (user == 1){ 
				
				row = 16; col = 16;
				
			}
			else if (user == 2){
				
				row = 24; col = 24;
				
			}
		}
		
		
		
		char[][] board = new char[row][col];
		
		initBoard(board);
		
		int [][] solution = new int[row][col];
		int [][] playboard = new int[row][col];
		for(int i=0;i<solution.length;i++){
			
			for(int j=0;j<solution[0].length;j++){
				
				solution[i][j]=0;playboard[i][j] =0;
				}
			}
		
		int mine = 0;
		
		if (row == 9) mine = 10;
		else if (row == 16) mine = 40;
		else if (row == 24) mine = 99;
		
		
		
		int countplay = mine;fillBoard(board,mine);
		
		for(int i=0;i<board.length;i++){
			
			for(int j=0;j<board[0].length;j++){
				
				int r = i;
				int c =j;
				if(board[i][c] == '*'){
					
					if(r>0 && c>0){
						
						if(board[r-1][c-1] == '.'){
							
							solution[r-1][c-1] += 1;
							
						}
						
					}
					
					if(r >0){
						
						if(board[r-1][c] == '.'){
							
							solution[r-1][c] += 1;
							
						}
						
					}
					
					if(r >0 && c+1 < board[0].length){
						
						if(board[r-1][c+1] == '.'){
							
							solution[r-1][c+1] += 1;
							
						}
						
					}
					
					if(c >0){if(board[r][c-1] == '.'){
						
						solution[r][c-1] += 1;
						
					}
					
					}
					
					if(c+1 < board[0].length){
						
						if(board[r][c+1] == '.'){
							
							solution[r][c+1] += 1;
							
						}
						
					}
					
					if(r +1 < board.length && c >0){
						
						if(board[r+1][c-1] == '.'){
							
							solution[r+1][c-1] += 1;
							
						}
						
					}
					
					if(r +1 < board.length){
						
						if(board[r+1][c] == '.'){
							
							solution[r+1][c] += 1;
							
						}
						
					}
					
					if(r +1 < board.length && c+1 <board[0].length){
						
						if(board[r+1][c+1] == '.'){
							
							solution[r+1][c+1] += 1;
							}
						}
					}
				}
			}
		
		System.out.println("\n************************************");
		System.out.println("\nPlay Game");
		System.out.println("\nRows and Columns start from 0!");
		System.out.println("\n************************************");
		printBoard(board);
		
		while(countplay <=board.length * board[0].length){
			
			System.out.println("\nEnter row: ");
			
			int prow = input.nextInt();System.out.println("\nEnter col: ");
			int pcol = input.nextInt();
			
			
			
			for(int i=0;i<board.length;i++){
				for(int j=0;j<board[0].length;j++){
					
					if(board[prow][pcol] == '*'){
						
						System.out.println("GAME OVER\n");
						
						for(int k=0;k<solution.length;k++){
							
							for(int x=0;x<solution[0].length;x++){
								
								if(board[k][x]=='*')
									System.out.print("*" + " ");
								
								else
									System.out.print(solution[k][x] + "");
								
							}
							
							System.out.println("\n");
							
						}
						
						return;
						
					}
					else
					{playboard[prow][pcol] = solution[prow][pcol];
					i=board.length;
					j=board[0].length;break;
					}
					}
				}
			for(int k=0;k<playboard.length;k++){
				
				for(int x=0;x<playboard[0].length;x++){
					
					if(board[k][x]=='*')
						System.out.print("." + " ");
					
					else if(playboard[k][x]==0)
						System.out.print("." + " ");
					
					else
						System.out.print(playboard[k][x] + " ");
					
				}
				System.out.println("\n");
				
			}
			
			countplay++;
			
		}
		
		System.out.println("Congratulations");
		
	}
	
	private static void fillBoard(char[][] board, int mine){
		
		int i=0;
		
		int max = board.length;
		int min = 1;
		
		while(i< mine){
			
			int rm = (int)(Math.random() * (max - min) + min);
			int cm = (int)(Math.random() * (max - min) + min);
			 board[cm][rm] ='*';
			 i++;
			
		}
		
	}
	private static void printBoard(char[][] board){
		
		for(int i=0;i<board.length;i++){
			
			for(int j=0;j<board[0].length;j++){
				
				if(board[i][j] =='*')
					System.out.print("."+ " ");
				else
					System.out.print(board[i][j] + " ");
				
			}
			
			System.out.println("\n");
			
		}
		
	}
	
	private static void initBoard(char[][] board){
		
		for(int i=0;i<board.length;i++){
			
			for(int j=0;j<board[0].length;j++){ 
				
				board[i][j]='.';
				}
			}
		}
	
}


					
						
					



