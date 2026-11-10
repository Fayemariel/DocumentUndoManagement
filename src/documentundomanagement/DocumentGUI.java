
package documentundomanagement;

public class DocumentGUI extends javax.swing.JFrame {

    private DocumentManager documentManager;

    private static final java.util.logging.Logger logger =
            java.util.logging.Logger.getLogger(DocumentGUI.class.getName());

    public DocumentGUI() {
        initComponents();

        // Initialize the document manager
        documentManager = new DocumentManager(100);

        // Search placeholder
        jTextField1.setText("Enter keyword here...");

        jTextField1.addFocusListener(new java.awt.event.FocusAdapter() {
            @Override
            public void focusGained(java.awt.event.FocusEvent evt) {
                if (jTextField1.getText().equals("Enter keyword here...")) {
                    jTextField1.setText("");
                }
            }

            @Override
            public void focusLost(java.awt.event.FocusEvent evt) {
                if (jTextField1.getText().trim().isEmpty()) {
                    jTextField1.setText("Enter keyword here...");
                }
            }
        });

        // Document placeholder
        txtDocument.setText("Start typing your document here...");

        txtDocument.addFocusListener(new java.awt.event.FocusAdapter() {
            @Override
            public void focusGained(java.awt.event.FocusEvent evt) {
                if (txtDocument.getText().equals("Start typing your document here...")) {
                    txtDocument.setText("");
                }
            }

            @Override
            public void focusLost(java.awt.event.FocusEvent evt) {
                if (txtDocument.getText().trim().isEmpty()) {
                    txtDocument.setText("Start typing your document here...");
                }
            }
        });

        // Search button
        btnSearch.addActionListener(e -> searchHistory());

        // Clear History button
        btnClear.addActionListener(e -> {
            documentManager.clearHistory();
            txtHistory.setText("");
        });
    }

    private void searchHistory() {
        String keyword = jTextField1.getText().trim();

        if (keyword.isEmpty() || keyword.equals("Enter keyword here...")) {
            javax.swing.JOptionPane.showMessageDialog(
                    this, "Please enter a keyword.");
            return;
        }

        String results = documentManager.searchHistory(keyword);

        if (results.isEmpty()) {
            txtHistory.setText("No matching history found.");
        } else {
            txtHistory.setText(results);
        }
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

        pnlSidebar = new javax.swing.JPanel();
        lblSubtitle = new javax.swing.JLabel();
        lblTitle = new javax.swing.JLabel();
        pnlEditor = new javax.swing.JPanel();
        lblEditorTitle = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtDocument = new javax.swing.JTextArea();
        btnSave = new javax.swing.JButton();
        btnUndo = new javax.swing.JButton();
        pnlSearch = new javax.swing.JPanel();
        lblSearchtitle = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        btnSearch = new javax.swing.JButton();
        pnlHistory = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtHistory = new javax.swing.JTextArea();
        lblHistory = new javax.swing.JLabel();
        btnClear = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        pnlSidebar.setPreferredSize(new java.awt.Dimension(1000, 650));
        pnlSidebar.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblSubtitle.setFont(new java.awt.Font("Segoe UI", 1, 14));
        lblSubtitle.setForeground(new java.awt.Color(204, 204, 204));
        lblSubtitle.setText("DOCUMENT WORKSPACE");
        pnlSidebar.add(lblSubtitle,
                new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, -1, -1));

        lblTitle.setBackground(new java.awt.Color(35, 59, 82));
        lblTitle.setFont(new java.awt.Font("Segoe UI Symbol", 1, 24));
        lblTitle.setForeground(new java.awt.Color(255, 255, 255));
        lblTitle.setText("Document Undo Management");
        lblTitle.setOpaque(true);
        lblTitle.setPreferredSize(new java.awt.Dimension(1000, 650));
        pnlSidebar.add(lblTitle,
                new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 730, 116));

        // EDITOR PANEL
        pnlEditor.setBackground(new java.awt.Color(255, 255, 255));

        lblEditorTitle.setFont(new java.awt.Font("Times New Roman", 1, 14));
        lblEditorTitle.setForeground(new java.awt.Color(93, 91, 91));
        lblEditorTitle.setText("Document Editor");

        txtDocument.setBackground(new java.awt.Color(222, 222, 222));
        txtDocument.setColumns(20);
        txtDocument.setRows(5);
        jScrollPane1.setViewportView(txtDocument);

        btnSave.setBackground(new java.awt.Color(40, 60, 80));
        btnSave.setFont(new java.awt.Font("Segoe UI Semibold", 1, 14));
        btnSave.setForeground(new java.awt.Color(255, 255, 255));
        btnSave.setText("Save Edit");
        btnSave.addActionListener(this::btnSaveActionPerformed);

        btnUndo.setBackground(new java.awt.Color(195, 195, 195));
        btnUndo.setFont(new java.awt.Font("Segoe UI Semibold", 1, 14));
        btnUndo.setText("Undo");
        btnUndo.addActionListener(this::btnUndoActionPerformed);

        javax.swing.GroupLayout pnlEditorLayout =
                new javax.swing.GroupLayout(pnlEditor);

        pnlEditor.setLayout(pnlEditorLayout);

        pnlEditorLayout.setHorizontalGroup(
            pnlEditorLayout.createParallelGroup(
                    javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlEditorLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlEditorLayout.createParallelGroup(
                        javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1,
                            javax.swing.GroupLayout.PREFERRED_SIZE, 706,
                            javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnlEditorLayout.createParallelGroup(
                            javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(pnlEditorLayout.createSequentialGroup()
                            .addComponent(btnSave,
                                    javax.swing.GroupLayout.PREFERRED_SIZE, 337,
                                    javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(
                                    javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(btnUndo,
                                    javax.swing.GroupLayout.PREFERRED_SIZE, 363,
                                    javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(lblEditorTitle,
                                javax.swing.GroupLayout.PREFERRED_SIZE, 120,
                                javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(48, Short.MAX_VALUE))
        );

        pnlEditorLayout.setVerticalGroup(
            pnlEditorLayout.createParallelGroup(
                    javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlEditorLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblEditorTitle)
                .addPreferredGap(
                        javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1,
                        javax.swing.GroupLayout.PREFERRED_SIZE,
                        javax.swing.GroupLayout.DEFAULT_SIZE,
                        javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(
                        javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlEditorLayout.createParallelGroup(
                        javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnUndo)
                    .addComponent(btnSave))
                .addGap(0, 26, Short.MAX_VALUE))
        );

        // Add the editor panel ONCE
        pnlSidebar.add(pnlEditor,
                new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 140, 760, 180));

        // SEARCH PANEL
        pnlSearch.setBackground(new java.awt.Color(255, 255, 255));

        lblSearchtitle.setFont(new java.awt.Font("Times New Roman", 1, 14));
        lblSearchtitle.setForeground(new java.awt.Color(93, 91, 91));
        lblSearchtitle.setText("Search Edit History");

        jTextField1.setBackground(new java.awt.Color(222, 222, 222));
        jTextField1.setText("Enter keyword...");
        jTextField1.addActionListener(this::jTextField1ActionPerformed);

        btnSearch.setBackground(new java.awt.Color(40, 60, 80));
        btnSearch.setForeground(new java.awt.Color(255, 255, 255));
        btnSearch.setText("Search");

        javax.swing.GroupLayout pnlSearchLayout =
                new javax.swing.GroupLayout(pnlSearch);

        pnlSearch.setLayout(pnlSearchLayout);

        pnlSearchLayout.setHorizontalGroup(
            pnlSearchLayout.createParallelGroup(
                    javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSearchLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(pnlSearchLayout.createParallelGroup(
                        javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblSearchtitle,
                            javax.swing.GroupLayout.PREFERRED_SIZE, 123,
                            javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnlSearchLayout.createSequentialGroup()
                        .addComponent(jTextField1,
                                javax.swing.GroupLayout.PREFERRED_SIZE, 596,
                                javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(
                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSearch,
                                javax.swing.GroupLayout.PREFERRED_SIZE, 108,
                                javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(
                        javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnlSearchLayout.setVerticalGroup(
            pnlSearchLayout.createParallelGroup(
                    javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSearchLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblSearchtitle)
                .addPreferredGap(
                        javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlSearchLayout.createParallelGroup(
                        javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnSearch,
                            javax.swing.GroupLayout.DEFAULT_SIZE, 34,
                            Short.MAX_VALUE)
                    .addComponent(jTextField1))
                .addContainerGap(38, Short.MAX_VALUE))
        );

        pnlSidebar.add(pnlSearch,
                new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 340, 730, -1));

        // HISTORY PANEL
        pnlHistory.setBackground(new java.awt.Color(255, 255, 255));

        txtHistory.setBackground(new java.awt.Color(222, 222, 222));
        txtHistory.setColumns(20);
        txtHistory.setRows(5);
        txtHistory.setEditable(false);
        jScrollPane2.setViewportView(txtHistory);

        lblHistory.setFont(new java.awt.Font("Times New Roman", 1, 14));
        lblHistory.setForeground(new java.awt.Color(93, 91, 91));
        lblHistory.setText("Action History");

        btnClear.setBackground(new java.awt.Color(40, 60, 80));
        btnClear.setForeground(new java.awt.Color(255, 255, 255));
        btnClear.setText("Clear");

        javax.swing.GroupLayout pnlHistoryLayout =
                new javax.swing.GroupLayout(pnlHistory);

        pnlHistory.setLayout(pnlHistoryLayout);

        pnlHistoryLayout.setHorizontalGroup(
            pnlHistoryLayout.createParallelGroup(
                    javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlHistoryLayout.createSequentialGroup()
                .addComponent(jScrollPane2,
                        javax.swing.GroupLayout.PREFERRED_SIZE, 601,
                        javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(
                        javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnClear,
                        javax.swing.GroupLayout.DEFAULT_SIZE, 117,
                        Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(pnlHistoryLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(lblHistory)
                .addContainerGap(
                        javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnlHistoryLayout.setVerticalGroup(
            pnlHistoryLayout.createParallelGroup(
                    javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
                    pnlHistoryLayout.createSequentialGroup()
                .addContainerGap(13, Short.MAX_VALUE)
                .addComponent(lblHistory)
                .addPreferredGap(
                        javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlHistoryLayout.createParallelGroup(
                        javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlHistoryLayout.createSequentialGroup()
                        .addComponent(jScrollPane2,
                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(19, 19, 19))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
                            pnlHistoryLayout.createSequentialGroup()
                        .addComponent(btnClear,
                                javax.swing.GroupLayout.PREFERRED_SIZE, 40,
                                javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(46, 46, 46))))
        );

        pnlSidebar.add(pnlHistory,
                new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 450, 730, -1));

        // MAIN FRAME LAYOUT
        javax.swing.GroupLayout layout =
                new javax.swing.GroupLayout(getContentPane());

        getContentPane().setLayout(layout);

        layout.setHorizontalGroup(
            layout.createParallelGroup(
                    javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(
                        javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(pnlSidebar,
                        javax.swing.GroupLayout.PREFERRED_SIZE, 729,
                        javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        layout.setVerticalGroup(
            layout.createParallelGroup(
                    javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlSidebar,
                        javax.swing.GroupLayout.PREFERRED_SIZE, 599,
                        javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(
                        javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {
        searchHistory();
    }

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {

        String text = txtDocument.getText();

        if (text.trim().isEmpty()
                || text.equals("Start typing your document here...")) {
            javax.swing.JOptionPane.showMessageDialog(
                    this, "Please enter some document text.");
            return;
        }

        documentManager.editDocument(text);
        txtHistory.setText(documentManager.getHistory());

        javax.swing.JOptionPane.showMessageDialog(
                this, "Your edit has been saved.");
    }

    private void btnUndoActionPerformed(java.awt.event.ActionEvent evt) {

        String previousText = documentManager.undo();

        if (previousText == null) {
            javax.swing.JOptionPane.showMessageDialog(
                    this, "There is nothing to undo.");
        } else {
            txtDocument.setText(previousText);
            txtHistory.setText(documentManager.getHistory());
        }
    }

    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info
                    : javax.swing.UIManager.getInstalledLookAndFeels()) {

                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ReflectiveOperationException
                | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(() ->
                new DocumentGUI().setVisible(true));
    }

    // Variables declaration
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnSearch;
    private javax.swing.JButton btnUndo;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JLabel lblEditorTitle;
    private javax.swing.JLabel lblHistory;
    private javax.swing.JLabel lblSearchtitle;
    private javax.swing.JLabel lblSubtitle;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JPanel pnlEditor;
    private javax.swing.JPanel pnlHistory;
    private javax.swing.JPanel pnlSearch;
    private javax.swing.JPanel pnlSidebar;
    private javax.swing.JTextArea txtDocument;
    private javax.swing.JTextArea txtHistory;
    // End of variables declaration
}
