
package documentundomanagement;

public class EditAction extends ActionRecord {

    private String previousText;
    private String newText;

    public EditAction(int actionId, String previousText, String newText) {

        super(actionId, "EDIT", "Document was edited");

        this.previousText = previousText;
        this.newText = newText;
    }

    public String getPreviousText() {
        return previousText;
    }

    public String getNewText() {
        return newText;
    }
}
