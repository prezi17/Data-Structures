
public class BinarySearchTree {
    class TreeNode {
            public int key;
            public TreeNode p;
            public TreeNode left;
            public TreeNode right;
            
            public TreeNode() {
                    p = left = right = null;
            }

            public TreeNode(int k) {
                    key = k;
                    p = left = right = null;
            }
    }

    public TreeNode root;

    public BinarySearchTree() {
            root = null;
    }

    public void insert(int k) {
            TreeNode newNode = new TreeNode(k);
            
            if(root == null) {
                    root = newNode;
            } else {
                    TreeNode parent = root;
                    while(true) {
                            if(parent.key == k) {
                                    return;
                            }
                            if(parent.key > k) {
                                    if(parent.left == null) {
                                            parent.left = newNode;
                                            newNode.p = parent;
                                            return;
                                    } else {
                                            parent = parent.left;
                                    }
                            } else {
                                    if(parent.right == null) {
                                            parent.right = newNode;
                                            newNode.p = parent;
                                            return;
                                    } else {
                                            parent = parent.right;
                                    }
                            }
                    }
            }
    }
    
    public void printReport() {
            System.out.printf("%-5s%-8s%-5s\n", "Key", "Height", "Balance Factor");
            printReport(root, 1);
    }
    
    private void printReport(TreeNode start, int height) {
            if(start == null) {
                    return;
            }
            System.out.printf("%-5d%-8d%-5d\n", start.key, height, balanceFactor(start));
            printReport(start.left, height + 1);
            printReport(start.right, height + 1);
    }
    private int depth(TreeNode start) {
            if(start == null) {
                    return 0;
            }
            return 1 + Math.max(depth(start.left), depth(start.right));
    }
    private int balanceFactor(TreeNode start) {
            return depth(start.left) - depth(start.right);
    }
    
    public static void main(String[] args) {
            int[] array = { 5, 85, 89, 3, 2, 8, 65, 92 };
            BinarySearchTree bst = new BinarySearchTree();
            for (int i = 0; i < array.length; i++)
                    bst.insert(array[i]);
            
            bst.printReport();
    }

}