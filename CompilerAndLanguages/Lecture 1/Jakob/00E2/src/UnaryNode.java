public abstract class UnaryNode extends Node {
    private Node child;

    public UnaryNode(Node child) {
        this.child = child;
    }

    @Override
    public void print_preorder_dfs() {
        System.out.println(this.toString());
        System.out.println(child.toString());
    }

    @Override
    public void print_inorder_dfs() {
        child.print_inorder_dfs();
        System.out.println(this.toString());
    }

    @Override
    public void print_postorder_dfs() {
        System.out.println(child.toString());
        System.out.println(this.toString());
}
}
