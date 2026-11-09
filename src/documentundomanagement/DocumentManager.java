
package documentundomanagement;

public class DocumentManager {

    private ActionStack actionStack;
    private String documentContent;
    private int nextActionId;
    private ActionStack redoStack;

    public DocumentManager(int stackCapacity) {

        actionStack = new ActionStack(stackCapacity);
        redoStack = new ActionStack(stackCapacity);

        documentContent = "";
        nextActionId = 1;
    }

    public void editDocument(String newText) {

        if (newText == null || newText.trim().isEmpty()) {
            System.out.println("Document cannot be empty!");
            return;
        }

        EditAction action = new EditAction(
            nextActionId++,
            documentContent,
            newText
        );

        actionStack.push(action);

        documentContent = newText;

        // Clear redo history after a new edit
        while (!redoStack.isEmpty()) {
            redoStack.pop();
        }
    }

    public void undoDocument() {

        if (actionStack.isEmpty()) {
            System.out.println("Nothing to undo!");
            return;
        }

        EditAction action = (EditAction) actionStack.pop();

        documentContent = action.getPreviousText();

        redoStack.push(action);
    }

    public void redoDocument() {

        if (redoStack.isEmpty()) {
            System.out.println("Nothing to redo!");
            return;
        }

        EditAction action = (EditAction) redoStack.pop();

        documentContent = action.getNewText();

        actionStack.push(action);
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

    public boolean canRedo() {
        return !redoStack.isEmpty();
    }
}
