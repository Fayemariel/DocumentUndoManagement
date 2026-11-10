package documentundomanagement;

public class StackedLinkedList {

    private class Node {

        ActionRecord data;
        Node next;

        Node(ActionRecord data) {
            this.data = data;
            this.next = null;
        }
        
    }

    private Node top;

    public StackedLinkedList() {
        top = null;
    }
    
     public void push(ActionRecord value) {

        Node newNode = new Node(value);
        newNode.next = top;
        top = newNode;
        
}

    public ActionRecord pop() {

        if (isEmpty()) {
            return null;
        }

        ActionRecord value = top.data;
        top = top.next;

        return value;
    }

    public ActionRecord peek() {

        if (isEmpty()) {
            return null;
        }

        return top.data;
    }

    public void display() {

        if (isEmpty()) {
            System.out.println("Stack is empty.");
            return;
        }

        Node current = top;

        while (current != null) {
            System.out.println(
                current.data.getActionId() + " - "
                + current.data.getDescription()
            );

            current = current.next;
        }
    }

    public boolean isEmpty() {
        return top == null;
    }
}