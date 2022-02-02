/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */

import java.io.*;
import java.util.*;


/**
 *
 * @author onniv
 */
public class Sudoku {

    private static final int GRID_SIZE = 9;
    private char board [][] = new char[GRID_SIZE][GRID_SIZE];
    
    
    public Sudoku(){
        char[][]board2 ={
            {' ', ' ', ' ',' ',' ',' ',' ',' ', ' '},
            {' ', ' ', ' ',' ',' ',' ',' ',' ', ' '},
            {' ', ' ', ' ',' ',' ',' ',' ',' ', ' '},
            {' ', ' ', ' ',' ',' ',' ',' ',' ', ' '},
            {' ', ' ', ' ',' ',' ',' ',' ',' ', ' '},
            {' ', ' ', ' ',' ',' ',' ',' ',' ', ' '},
            {' ', ' ', ' ',' ',' ',' ',' ',' ', ' '},
            {' ', ' ', ' ',' ',' ',' ',' ',' ', ' '},
            {' ', ' ', ' ',' ',' ',' ',' ',' ', ' '}
        };
        board = board2;
    }
    

    
    public void set(int i, int j, char c){
        if (i > 8 || j > 8 || i < 0 || j<0){
            System.out.format("Trying to access illegal cell (%d, %d)!%n", i, j);      
    }
        else if (c == ' ' || c == '1' ||  c == '2' || c == '3' || c == '4' || c == '5' || c == '6' || c == '7' || c == '8' || c == '9'){
            board[i][j] = c;
              
        }
        else{
            System.out.format("Trying to set illegal character %c to (%d, %d)!%n", c,i,j); 
        }
        
        
    }
    
    boolean check(){
       
      ArrayList<Character> min_value = new ArrayList<>();
      for (int row = 0;row <9; row++){
          for(int col = 0; col <8; col++){
              for(int col2 = col +1;col2 <9;col2++){
                  if(board[row][col]==board[row][col2] && board[row][col] != ' '){   
                      min_value.add(board[row][col]);              
                  }
              }
          }
          if(min_value.size() > 0){
              System.out.println("Row "+ row + " has multiple " + Collections.min(min_value) + "'s!");
              return false;
          }
      }
      
      
      for (int col = 0;col <9; col++){
          for (int row = 0; row < 8;row++){
              for(int row2 = row +1;row2 < 9; row2++){
                  if(board[row][col] == board[row2][col]&& board[row][col] != ' '){
                      min_value.add(board[row][col]);
                      
                  }
              }
          }
          if(min_value.size() > 0){
              System.out.println("Column "+ col + " has multiple " + Collections.min(min_value) + "'s!");
              return false;
          }
      }
      
      
      for(int row = 0; row < 9; row +=3){
          for (int col = 0; col < 9; col += 3){
              for (int pos = 0; pos < 8; pos++){
                  for(int pos2 = pos +1;pos2<9;pos2++){
                      if(board[row + pos%3][col+pos/3]==board[row+pos2%3][col + pos2/3]&& board[row + pos%3][col+pos/3] != ' '){
                          min_value.add(board[row + pos%3][col+pos/3]);
                                                
                      }
                  }
              }
              if (min_value.size() > 0){
                System.out.format("Block at (%d, %d) has multiple %c's!%n",row , col,Collections.min(min_value));
                return false; 
          }
          }
          
      }
     
      return true;
        
        
    }
    
    
    
    public void print(){
        
        System.out.println("#####################################");
        for (int i = 0; i < GRID_SIZE;i++){
            System.out.println("# " + board[i][0] + " | " + board[i][1] +
                    " | " + board[i][2] + " # "+ board[i][3] + " | " + board[i][4] +
                    " | " + board[i][5] + " # "+ board[i][6] + " | " + board[i][7] +
                    " | " + board[i][8] + " #");
            if (i == 2 || i==5||i==8){
                System.out.println("#####################################");      
        }
            else {
                System.out.println("#---+---+---#---+---+---#---+---+---#");
            }      
        }
    }
    
    
}
