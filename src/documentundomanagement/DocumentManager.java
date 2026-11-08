/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package documentundomanagement;

/**
 *
 * @author gamon
 */
public class DocumentManager {
    
    private ActionStack actionStack;
    private String documentContent;
    private int nextActionId;
    
    public DocumentManager(int stackCapacity) {
        actionStack = new ActionStack(stackCapacity);
        documentContent = "";
        nextActionId = 1;
    }
    
    public void editDocument(String newText) {
    EditAction action = new EditAction(nextActionId++, documentContent);

    actionStack.push(action);

    documentContent = newText;
}
    public void undoDocument() {
    if (actionStack.isEmpty()) {
        System.out.println("Nothing to undo!");
        return;
    }

    EditAction action = (EditAction) actionStack.pop();

    documentContent = action.getEditedText();
}
    public String getDocumentContent() {
    return documentContent;
}
    public ActionStack getActionStack() {
    return actionStack;
}
    public boolean canUndo() {
    return !actionStack.isEmpty();
}
    
    
    
}
