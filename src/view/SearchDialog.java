/*
 * Created by JFormDesigner on Tue Jan 31 18:51:52 CST 2017
 */

package view;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import com.jgoodies.forms.factories.*;
import com.jgoodies.forms.layout.*;

/**
 * @author Alex Tang
 */
public class SearchDialog extends JDialog {
    public SearchDialog(Frame owner) {
        super(owner);
        initComponents();
    }

    public SearchDialog(Dialog owner) {
        super(owner);
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Alex Tang
        dialogPane = new JPanel();
        contentPanel = new JPanel();
        textPane1 = new JTextPane();
        searchEdit = new JTextField();
        buttonBar = new JPanel();
        okButton = new JButton();
        cancelButton = new JButton();

        //======== this ========
        setTitle("\u641c\u7d22\u5355\u8bcd");
        setResizable(false);
        Container contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());

        //======== dialogPane ========
        {
            dialogPane.setBorder(Borders.DIALOG);
            dialogPane.setBackground(new Color(235, 235, 235));

            // JFormDesigner evaluation mark
            dialogPane.setBorder(new javax.swing.border.CompoundBorder(
                new javax.swing.border.TitledBorder(new javax.swing.border.EmptyBorder(0, 0, 0, 0),
                    "JFormDesigner Evaluation", javax.swing.border.TitledBorder.CENTER,
                    javax.swing.border.TitledBorder.BOTTOM, new java.awt.Font("Dialog", java.awt.Font.BOLD, 12),
                    java.awt.Color.red), dialogPane.getBorder())); dialogPane.addPropertyChangeListener(new java.beans.PropertyChangeListener(){public void propertyChange(java.beans.PropertyChangeEvent e){if("border".equals(e.getPropertyName()))throw new RuntimeException();}});

            dialogPane.setLayout(new BorderLayout());

            //======== contentPanel ========
            {
                contentPanel.setBackground(new Color(235, 235, 235));
                contentPanel.setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));
                contentPanel.setLayout(new FormLayout(
                    "184dlu",
                    "default, 6dlu, default"));

                //---- textPane1 ----
                textPane1.setText("\u8bf7\u8f93\u5165\u60f3\u8981\u641c\u7d22\u7684\u5355\u8bcd");
                textPane1.setBackground(new Color(235, 235, 235));
                textPane1.setFocusable(false);
                textPane1.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
                textPane1.setDragEnabled(false);
                textPane1.setFocusCycleRoot(false);
                textPane1.setRequestFocusEnabled(false);
                contentPanel.add(textPane1, CC.xy(1, 1));
                contentPanel.add(searchEdit, CC.xy(1, 3));
            }
            dialogPane.add(contentPanel, BorderLayout.CENTER);

            //======== buttonBar ========
            {
                buttonBar.setBorder(Borders.createEmptyBorder("4dlu, 0dlu, 0dlu, 0dlu"));
                buttonBar.setBackground(new Color(235, 235, 235));
                buttonBar.setLayout(new FormLayout(
                    "$glue, $button, $rgap, $button",
                    "pref"));

                //---- okButton ----
                okButton.setText("\u641c\u7d22");
                okButton.setBackground(new Color(235, 235, 235));
                buttonBar.add(okButton, CC.xy(2, 1));

                //---- cancelButton ----
                cancelButton.setText("\u53d6\u6d88");
                cancelButton.setBackground(new Color(235, 235, 235));
                buttonBar.add(cancelButton, CC.xy(4, 1));
            }
            dialogPane.add(buttonBar, BorderLayout.SOUTH);
        }
        contentPane.add(dialogPane, BorderLayout.CENTER);
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Alex Tang
    private JPanel dialogPane;
    private JPanel contentPanel;
    private JTextPane textPane1;
    private JTextField searchEdit;
    private JPanel buttonBar;
    private JButton okButton;
    private JButton cancelButton;
    // JFormDesigner - End of variables declaration  //GEN-END:variables


    public JPanel getDialogPane() {
        return dialogPane;
    }

    public JPanel getContentPanel() {
        return contentPanel;
    }

    public JTextPane getTextPane1() {
        return textPane1;
    }

    public JTextField getSearchEdit() {
        return searchEdit;
    }

    public JPanel getButtonBar() {
        return buttonBar;
    }

    public JButton getOkButton() {
        return okButton;
    }

    public JButton getCancelButton() {
        return cancelButton;
    }
}
