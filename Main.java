import java.util.*;


public class Main {

	public static void main(String[] args) {
		//Set<Integer>treeSet = new TreeSet<>();
		//Set<Integer>hashSet = new HashSet<>();
		TreesEx<Integer> tree = new TreesEx<>();
		tree.Add(8);
		tree.Add(4);
		tree.Add(2);
		System.out.println(tree.contains(6));
		System.out.println(tree.contains(4));
		System.out.println(tree.contains(1));
	}

}
