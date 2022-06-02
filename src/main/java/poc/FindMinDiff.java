package poc;

import java.util.*;

public class FindMinDiff {

	static class Node {

		private int value;

		private int index;

		private int position;

		public Node(int value, int index, int position) {
			this.value = value;
			this.index = index;
			this.position = position;
		}
	}

	public static void minDiff(int[][] list) {

		Node min = null;
		int n = list.length;
		List<Node> nodes = new ArrayList<>();

		Queue<Node> nodesQueue = new PriorityQueue<>(new Comparator<Node>() {
			@Override
			public int compare(Node node, Node t1) {
				if (node.value < t1.value) {
					return 1;
				} else if (node.value > t1.value) {
					return -1;
				} else {
					return 0;
				}
			}
		});

		for (int i = 0; i < n; i++) {
			int[] subList = list[i];
			int value = subList[subList.length - 1];
			Node node = new Node(value, i, subList.length - 1);

			nodesQueue.add(node);

			if (min == null) {
				min = node;
			} else if (node.value < min.value) {
				min = node;
			}
		}

		int diff = nodesQueue.peek().value - min.value;
		while (true) {
			Node node = nodesQueue.poll();
			//int nDiff =
			int index = node.index;
			int[] subArray = list[index];
			int position = node.position;
			int value = subArray[position - 1];
			Node n1 = new Node(value, node.index, node.position);
			nodesQueue.add(n1);
		}
	}

	public static void main(String[] args) {

		int[][] A = {{2, 10, 25, 39, 50, 100},
				{1, 3, 4, 7, 15, 20},
				{5, 51, 75},
				{61, 67, 72, 73, 101, 105, 107}};

		minDiff(A);
	}
}
