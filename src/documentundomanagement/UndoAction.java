/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package documentundomanagement;

/**
 *
 * @author gamon
 */
public class UndoAction extends ActionRecord {
    
        private int undoneActionId;
        
        public UndoAction(int actionId, int undoneActionId) {
            super(actionId, "UNDO", "Previous edit was undone");
            this.undoneActionId = undoneActionId;
}
        public int getUndoneActionId() {
            return undoneActionId;
}
        

    

    
}
