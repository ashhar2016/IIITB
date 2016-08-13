/*A number 'p' is given as input. A set of numbers which can contain duplicate values. A number is allowed 
at its position if it is less than or equal to sum of all numbers preceding it including 'p'. If it 
violates then a new number can be inserted without violating the constraint. A number can be deleted also 
to maintain the above property. Each insertion of new number or deletion of an existing number is considered 
one move. Find the minimum number of moves.*/

package org.learnservlet;
import java.util.*;
import java.lang.*;
import java.math.*;

public class InfosysQ1 {
	
	public static void main(String[] args)
	{
		System.out.println("enter string");
	   	Scanner sc = new Scanner(System.in);
	    String input = sc.nextLine();
	    int moves = minMoves(input);
	    System.out.println(moves);
	}
	
	public static int minMoves(String input)
	{
		String[] str = input.split("[#,]");
		int[] arr = new int[str.length - 1];
		int p = Integer.parseInt(str[0]);
		int sum = p;
	
		for(int i=0;i<str.length - 1;i++)
			arr[i] = Integer.parseInt(str[i+1]);
		Arrays.sort(arr);
		int moves = minMovesUtil(arr, sum, 0, 0);
		return moves;
	}
	
	public static int minMovesUtil(int[] arr, int sum, int i, int moves)
	{
		if(i == arr.length)
			return moves;
		int diff = sum - arr[i];
		if(diff<0)
		{
			int absDif = Math.abs(diff);
			if(absDif<=sum)
			{
				sum = sum * 2;
				moves = 1 + minMovesUtil(arr, sum, i+1, moves);
			}
			else
			{
				moves = 1 + Math.min(minMovesUtil(arr, sum*2, i, moves), minMovesUtil(arr, sum, i+1, moves));
			}	
		}
		else
			moves = minMovesUtil(arr, sum + arr[i], i+1, moves);
		return moves;
	}
     
}
