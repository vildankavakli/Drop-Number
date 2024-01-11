package Project;

public class VildanKavakliNode<T extends Number> {

    T data;
    VildanKavakliNode<T> up;
    VildanKavakliNode<T> down;
    VildanKavakliNode<T> right;
    VildanKavakliNode<T> left;
    int column;

    public VildanKavakliNode(T data, int column) {
        this.data = data;
        this.column = column;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public VildanKavakliNode<T> getLeft() {
        return left;
    }

    public void setLeft(VildanKavakliNode<T> left) {
        this.left = left;
    }

    public VildanKavakliNode<T> getRight() {
        return right;
    }

    public void setRight(VildanKavakliNode<T> right) {
        /*
        This method sets the node to the right of the current node, and also sets the left node of the node to the right to the current node. 
        In other words, it establishes a two-way link between the current node and the node to the right of it.
         */
        this.right = right;
        right.setLeft(this);
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public VildanKavakliNode<T> getUp() {
        return up;
    }

    public void setUp(VildanKavakliNode<T> up) {
        /*
    This method sets the given node as the upward neighbor of the current node and establishes a two-way connection between them. 
    Then, it checks if the values of the nodes above and below the current node are equal. If they are equal, it multiplies the value of the 
    current node by two and assigns it to the lower node, effectively merging them into a single node. This process is repeated until there are 
    no more consecutive nodes with the same value below the current node.
         */
        this.up = up;
        up.down = this;
        VildanKavakliNode temp = up;
        while (temp.down != null && (int) (Integer) temp.getData() == (int) (Integer) (temp.down.getData())) {
            temp.down.setData((int) temp.data * 2);
            temp = temp.down;
            temp.up = null;
        }
    }

    public VildanKavakliNode<T> getDown() {
        return down;
    }

    public void setDown(VildanKavakliNode<T> down) {
        this.down = down;
    }

}
