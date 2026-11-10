package documentundomanagement;

public class DocumentManager {

    // Singly Linked List for Undo
    private static class UndoNode {
        String text;
        UndoNode next;

        UndoNode(String text) {
            this.text = text;
        }
    }

    // Singly Linked List for Action History
    private static class HistoryNode {
        String action;
        HistoryNode next;

        HistoryNode(String action) {
            this.action = action;
        }
    }

    private UndoNode undoTop;
    private HistoryNode historyHead;
    private HistoryNode historyTail;

    private String currentDocument = "";
    private int undoCount = 0;
    private final int capacity;

    public DocumentManager(int capacity) {
        this.capacity = Math.max(1, capacity);
    }

    // Save a new document edit
    public void editDocument(String newText) {

        if (undoCount == capacity) {
            removeOldestUndo();
        }

        UndoNode node = new UndoNode(currentDocument);
        node.next = undoTop;
        undoTop = node;
        undoCount++;

        currentDocument = newText;

        addHistory("EDIT - Document was edited: " + newText);
    }

    // Undo the most recent edit
    public String undo() {

        if (undoTop == null) {
            return null;
        }

        currentDocument = undoTop.text;
        undoTop = undoTop.next;
        undoCount--;

        addHistory("UNDO - Previous document restored");

        return currentDocument;
    }

    // Remove the oldest undo entry when capacity is reached
    private void removeOldestUndo() {

        if (undoTop == null) {
            return;
        }

        if (undoTop.next == null) {
            undoTop = null;
            undoCount = 0;
            return;
        }

        UndoNode current = undoTop;

        while (current.next.next != null) {
            current = current.next;
        }

        current.next = null;
        undoCount--;
    }

    // Add an action to the history linked list
    private void addHistory(String action) {

        HistoryNode node = new HistoryNode(action);

        if (historyHead == null) {
            historyHead = node;
            historyTail = node;
        } else {
            historyTail.next = node;
            historyTail = node;
        }
    }

    // Display all history
    public String getHistory() {

        StringBuilder result = new StringBuilder();
        HistoryNode current = historyHead;

        while (current != null) {
            result.append(current.action).append("\n");
            current = current.next;
        }

        return result.toString();
    }

    // Search the action history
    public String searchHistory(String keyword) {

        StringBuilder result = new StringBuilder();
        HistoryNode current = historyHead;

        while (current != null) {

            if (current.action.toLowerCase()
                    .contains(keyword.toLowerCase())) {

                result.append(current.action).append("\n");
            }

            current = current.next;
        }

        return result.toString();
    }

    // Clear action history
    public void clearHistory() {
        historyHead = null;
        historyTail = null;
    }

    public String getCurrentDocument() {
        return currentDocument;
    }
}