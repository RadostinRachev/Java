

public class TreesEx<T extends Comparable<T>> implements TreeExBase<T> {
	private TreeNode<T> root;
	private int size;

    TreesEx() {
	 root = null;
	 size = 0;
 }

class TreeNode<T> {
		T value;
		
	TreeNode<T> left;
	TreeNode<T> right;
		public TreeNode(T value){
			
			setValue(value);
			setLeft(null);
			setRight(null);
		}
		public T getValue(){
			return value;
		}
		public void setRight(TreeNode<T> right) {
           this.right = right;			
		}
		public void setLeft(TreeNode<T> left) {
			this.left = left;
		}
		public void setValue(T value) {
			this.value = value;
			
		}
		public TreeNode<T> getLeft() {
			return left;
		}
		public TreeNode<T> getRight() {
			return right;
		}
		
	}



	@Override
	public void Add(T value) {
		TreeNode<T> node = new TreeNode<>(value);
		if (root == null) {
			root=node;
			return;
		}
		TreeNode<T> current = root;
		while (true) {  //Dobavqne s cikul , moje da se suzdade i rekusrsiq.
			if(node.getValue().compareTo(current.getValue()) < 0) {
				//go left
				if (current.getLeft()== null){
					//there is no left
					current.setLeft(node);
					break;
				}
				current = current.getLeft();
			
			}
			else {
				//go right
				if (current.getRight()== null) {
					current.setRight(node);
					break;
				}
				current = current.getRight();
				
			}
			
		}
	}



	@Override
	public void Remove(T value) {
		
	}



	@Override
	public boolean contains(T value) {
		return containsTraverse(root , value);
	}



	@Override
	public int size() {
		return 0;
	}



	@Override
	public boolean isEmpty() {
		return false;
	}
	private boolean containsTraverse(TreeNode<T> node, T value){
		// RECURSIQ
		
		if (node == null){ // Duno ,ako ne go e nameril
			return false;
			
		}
		if (value.compareTo(node.getValue()) == 0) {
			return true; // Duno, ako go e nameril
		}
		if (value.compareTo(node.getValue()) < 0) {
			return containsTraverse(node.getLeft(), value); // Zadulbavaniq navutre
			} 
		else {
			return containsTraverse(node.getRight(), value);
		}
	}
}
