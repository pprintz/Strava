public abstract class Node {
    private Node parent;
    private boolean visited;

    public abstract void print_preorder_dfs();
    public abstract void print_inorder_dfs();
    public abstract void print_postorder_dfs();

    @Override
    public String toString() {
        return this.getClass().getName();
    }
}
