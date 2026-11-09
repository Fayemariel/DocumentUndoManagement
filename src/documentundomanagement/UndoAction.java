package documentundomanagement;

// UndoAction inherits the properties of ActionRecord
public class UndoAction extends ActionRecord {

    // Stores the ID of the edit that was undone
    private int undoneActionId;

    // Constructor for creating an UndoAction record
    public UndoAction(int actionId, int undoneActionId) {

        // Set the action type and description using the parent class
        super(actionId, "UNDO", "Previous edit was undone");

        // Store the ID of the original edit
        this.undoneActionId = undoneActionId;
    }

    // Returns the ID of the undone edit
    public int getUndoneActionId() {
        return undoneActionId;
    }
}