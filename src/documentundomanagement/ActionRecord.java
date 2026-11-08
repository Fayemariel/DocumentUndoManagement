package documentundomanagement;

public class ActionRecord {

    private int actionId;
    private String actionType;
    private String description;

    public ActionRecord(int actionId, String actionType, String description) {
        this.actionId = actionId;
        this.actionType = actionType;
        this.description = description;
    }

    public int getActionId() {
        return actionId;
    }

    public String getActionType() {
        return actionType;
    }

    public String getDescription() {
        return description;
    }
}