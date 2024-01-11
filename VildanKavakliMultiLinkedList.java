package Project;

public class VildanKavakliMultiLinkedList<T extends Number> {

    VildanKavakliNode<T> head;
    int matrix[][] = new int[7][5];

    int[][] fillMatrix() {// "fillMatrix" that returns a 2D integer array
        //It starts by initializing two Node objects "right" and "up" to the head of a linked list.
        VildanKavakliNode right = head;
        VildanKavakliNode up = head;
        //initializes the variable "row" to 6 and creates a 7x5 integer matrix.
        int row = 6;
        matrix = new int[7][5];
        while (right != null) { //The while loop iterates while the "right" node is not null. 
            while (up != null) { //The while loop iterates while the "up" node is not null. 
                /*The code then sets the value of the matrix at the position (row, up.getColumn()) to the data stored in the "up" node. 
                The "up" node is then updated to the next node above it, and the "row" variable is decremented.*/
                matrix[row][up.getColumn()] = (int) up.getData();
                up = up.getUp();
                row--;
            }
            row = 6; //the "row" variable is reset to 6
            right = right.getRight();//the "right" node is updated to the next node to the right. 
            up = right;
            /*
            The "up" node is then set to the "right" node, so that the next iteration of the inner while loop starts from the correct position.
             */
        }
        /*
        After the while loop has finished, the matrix is printed to the console, and the function returns the matrix.
         */
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 5; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("-----------");
        return matrix;
    }

    public VildanKavakliNode<T> add(T value, int column) { // This is a generic method that takes a value and a column number as inputs and returns a node of type T.
        VildanKavakliNode<T> newNode = new VildanKavakliNode<>(value, column);
        if (head == null) {// If the head node is null, then set the new node as the head node.
            head = newNode;
        } else {
            // Traverse through the linked list until the end or the specified column is reached.
            VildanKavakliNode temp = head;
            while (temp.getRight() != null && temp.getColumn() != column) {
                temp = temp.right;
            }
        // If the specified column is found, then traverse to the bottom of the column and add the new node.
            if (temp.getColumn() == column) {
                while (temp.getUp() != null) {
                    temp = temp.getUp();
                }
                temp.setUp(newNode);
            } else {// Otherwise, add the new node to the right of the last node.
                temp.setRight(newNode);
            }
        }
        return newNode;// Returns the newly created node.

    }

}
