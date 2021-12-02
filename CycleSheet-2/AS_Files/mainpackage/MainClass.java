package mainpackage;
import parentpackage.*;
import parentpackage.childpackage.*;

public class MainClass{
	public static void main(String[] args){
		ArrayBinaryTree abt_obj = new ArrayBinaryTree(7);
		abt_obj.insert();
		abt_obj.bfs();
		
		System.out.println();
		System.out.println("Linked Binary Tree:");
		LinkedBinaryTree lbt_obj = new LinkedBinaryTree(7);
		lbt_obj.insert();
		lbt_obj.bfs();
	}
}
