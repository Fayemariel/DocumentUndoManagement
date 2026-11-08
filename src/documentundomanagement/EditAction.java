package documentundomanagement;

public class EditAction extends ActionRecord {

    private String editedText;

    public EditAction(int actionId, String editedText) {
        super(actionId, "EDIT", "Document was edited");
        this.editedText = editedText;
        
    }
    
    public String getEditedText() {
    return editedText;
}

    }

