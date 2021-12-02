package parentpackage.childpackage;

import parentpackage.*;
import java.util.Queue;
import java.util.LinkedList;

class Node {
	Node left;
	Node right;
	String data;

	Node() {
		left = null;
		right = null;
		data = "";
	}
}

public class LinkedBinaryTree implements BinaryTree {
	Node root;
	int cnt;

	Queue<Node> queue = new LinkedList<Node>();

	public LinkedBinaryTree(int n) {
		cnt = n;
		root = null;
	}

	public void insert() {
		queue.clear();
		root = new Node();
		root.data = "0";
		cnt--;
		queue.add(root);

		while (cnt > 0) {
			Node current = queue.remove();
			current.left = new Node();
			current.left.data = current.data + "0";
			queue.add(current.left);
			cnt--;
			if (cnt == 0)
				break;

			current.right = new Node();
			current.right.data = current.data + "1";
			queue.add(current.right);
			cnt--;
		}
	}

	public void bfs() {
		queue.clear();
		queue.add(root);
		while (queue.peek() != null) {
			Node current = queue.remove();
			System.out.println(current.data);
			queue.add(current.left);
			queue.add(current.right);
		}
	}
}
