public abstract class BinaryNode extends Node {
    private Node left;
    private Node right;

    public BinaryNode(Node left, Node right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public void print_preorder_dfs() {
        System.out.println(this.toString());
        left.print_preorder_dfs();
        right.print_preorder_dfs();
    }

    @Override
    public void print_inorder_dfs() {
        left.print_inorder_dfs();
        System.out.println(this.toString());
        right.print_inorder_dfs();
    }

    @Override
    public void print_postorder_dfs() {
        left.print_postorder_dfs();
        right.print_postorder_dfs();
        System.out.println(this.toString());
    }

    public Node getLeft() {
        return left;
    }

    public Node getRight() {
        return right;
    }
}
