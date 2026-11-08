/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package documentundomanagement;

/**
 *
 * @author gamon
 */
public class ActionStack {
    
    private ActionRecord[] stack;
    private int top;
    
    public ActionStack(int capacity) {
        stack = new ActionRecord[capacity];
        top = -1;
    }
    
    public void push(ActionRecord action) {
    if (top == stack.length - 1) {
        System.out.println("Stack is full!");
        return;
    }

    top++;
    stack[top] = action;
}
    public ActionRecord pop() {
    if (top == -1) {
        System.out.println("Stack is empty!");
        return null;
    }

    ActionRecord action = stack[top];
    stack[top] = null;
    top--;

    return action;
}
    public ActionRecord peek() {
    if (top == -1) {
        return null;
    }

    return stack[top];
}
    public boolean isEmpty() {
    return top == -1;
}
    
}
