import java.util.Stack;

public class Tree {
    private Node root;

    public Tree(Node root) {
        this.root = root;
    }

    public void print_preorder_dfs() {
        root.print_preorder_dfs();
    }

    public void print_inorder_dfs() {
        root.print_inorder_dfs();
    }

    public void print_postorder_dfs() {
        root.print_postorder_dfs();
    }
}
