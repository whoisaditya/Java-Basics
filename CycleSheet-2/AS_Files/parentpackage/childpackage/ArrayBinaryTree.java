package parentpackage.childpackage;

import parentpackage.BinaryTree;

public class ArrayBinaryTree implements BinaryTree{
	String arr_bin_tree[];
	
	public ArrayBinaryTree(int n){
		arr_bin_tree = new String[n];
		arr_bin_tree[0] = "0";
	}
	
	public void insert(){
		for(int i = 1; i < arr_bin_tree.length; i++){
			int p;
			if(i % 2 == 0){
				p = (i - 2) / 2;
				arr_bin_tree[i] = arr_bin_tree[p] + "1";
			}
			else{
				p = (i - 1) / 2;
				arr_bin_tree[i] = arr_bin_tree[p] + "0";
			}
			
		}
	}
	
	public void bfs(){
		System.out.println("BFS: ");
		for(String s : arr_bin_tree){
			System.out.println(s);
		}
	}
}
