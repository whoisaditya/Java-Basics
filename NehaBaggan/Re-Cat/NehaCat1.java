/*
Consider a grid of 4X4 which can have 4-queens randomly placed in the 
grid. In this context, a conflict means if any two queens are in same 
sequence of horizontally or Vertically or Diagonally. 
Write a Java program to display list of conflicts along with their positions. 
For instance the following diagram shows the 4X4 grid with 4 queens and 
there are two conflicts: { (3,2), (3,4)}, {(3,2),(4,2)}. Assume that Top-Left 
Cell is considered as position (1,1).
*/

import java.util.Scanner;

public class NehaCat1{
    public static void main(String[] args)
    {
        int board[][] = new int[4][4];

        for(int i=0;i<4;i++)
        {
            for(int j=0;j<4;j++)
            {
                board[i][j] = 0;
            }
        }
        
    }
}