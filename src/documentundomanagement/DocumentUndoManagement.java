package documentundomanagement;

/**
 *
 * @author gamon
 */
public class DocumentUndoManagement {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       java.awt.EventQueue.invokeLater(new Runnable() {
    public void run() {
        new DocumentGUI().setVisible(true);
    }
});
    }
    

}