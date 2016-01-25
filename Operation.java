package task;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.util.*;
import java.io.*;

public class Operation {
	
	int[][] matrix;

	
	public void filling(int rand){
		
		int number = 201;
		String str;
		
		Random random = new Random();
		
		matrix = new int[rand][rand];
		
		for(int i=0; i<rand; i++)
		{
			for(int j=0; j<rand; j++)
			{
				matrix[i][j]= random.nextInt(number) - 100;
			}
		}
		
	}
	
	
	
	public void display()
	{
		for(int i=0; i<matrix.length; i++)
		{
			for(int j=0; j<matrix.length; j++)
			{
				System.out.print("      " +matrix[i][j]);
				
			}
			System.out.println("");
		}
		
	}
	
	
	
	public void leftright()
	{
		
		boolean rightDirection = true;
		for(int i = 0; i< matrix.length; i++){
			//If you need to move in right direction
			if(rightDirection){
				//Move into right direction
				for(int j = 0; j < matrix.length; j++){
					
					System.out.print(" " +matrix[i][j]);
				}
			}
			//If there is time to move backward
			else{
				//Move into left direction
				for(int j = matrix.length-1; j >=0; j--){
					
					System.out.print(" " +matrix[i][j]);
					
				}
			}
			rightDirection = !rightDirection;
		}
		
		
	}
	
	public void spiral(){
		int row_start = 0, row_end = matrix.length-1, col_start = 0, col_end = matrix.length-1;
		char direction = 'r';	//r - right
								//l - left
								//u - up
								//d - down directions.
		int i = 0, j = 0;
		boolean needContinue = true;
		if((matrix.length-1) < 0){
			return;
		}
		while(needContinue){
			if(direction == 'r'){
				//because we start from left upper corner 
				//and move to right upper corner
				i = row_start;
				//Move in right direction
				for(i = row_start; i <= row_end; i++){
					
					System.out.println(" " +matrix[i][j]);
					
				}		
				//change direction after corner destination
				//from 'right' to 'down'
				direction = 'd';
				//sliding down to one level, 
				//because we need to start from next element
				col_start = col_start + 1;
			}
			if(direction == 'd'){
				//because we start from right upper corner
				//and move to right lower corner
				j = col_start;
				i-=1;
				//Move in down direction
				for(j = col_start; j <= col_end; j++){
					
					System.out.println(" " +matrix[i][j]);
					
				}
				//chage direction after corner destination
				//from 'down' to 'left'
				direction = 'l';
				//sliding left to one column
				//because we need to start from next element
				row_end = row_end - 1;
			}
			if(direction == 'l'){
				//because we start from right lower corner
				//and move to left lower corner
				i = row_end;
				j-=1;
				//Move in left direction
				for(i = row_end; i > row_start; i--){
					
					System.out.println(" " +matrix[i][j]);
					
				}
				//change direction after corner destination
				//from 'left' to 'up'
				direction = 'u';
				//sliding up to one level
				//because we need to start from next element
				col_end = col_end - 1;
			}
			if(direction == 'u'){
				//because we start from left lower corner
				//and move to left upper corner
				j = col_end;
				
				//Move in up direction
				for(j = col_end; j > col_start; j--){
					
					System.out.println(" " +matrix[i][j]);
					
				}
				//change direction after corner destination
				//from 'up' to 'left'
				direction = 'l';
				//sliding left to one level
				//because we complite one tour by array
				//and we must start another tour with cycle
				row_start = row_start + 1;
			}
			//check if we bypassed ALL array
			if((col_end - col_start <= 1) || (row_end - row_start <= 1)){
				needContinue = false;
			}
			else{
				needContinue = true;
			}
		}
		if((row_end - row_start <= 1)){
			for(i = row_start; i <= row_end; i++){
				System.out.println(" " +matrix[i][j]);
			}
		}

}
}