
package documentundomanagement;

public class ActionStack {

    private StackedLinkedList stack;

    public ActionStack(int capacity) {
        stack = new StackedLinkedList();
    }

    public void push(ActionRecord action) {
        stack.push(action);
    }

    public ActionRecord pop() {
        return stack.pop();
    }

    public ActionRecord peek() {
        return stack.peek();
    }

    public boolean isEmpty() {
        return stack.isEmpty();
    }

    public void display() {
        stack.display();
    }
}
