/*
 * Created by JFormDesigner on Tue Jan 31 16:17:37 CST 2017
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
public class MainViewFrame extends JFrame {
    public MainViewFrame() {
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Alex Tang
        baseFrame = new JFrame();
        tabbedPane1 = new JTabbedPane();
        panel3 = new JPanel();
        scrollPane1 = new JScrollPane();
        treeList = new JList();
        panel2 = new JPanel();
        treeWordsNumText = new JTextPane();
        treeVacaNumText = new JTextPane();
        treeMostText = new JTextPane();
        treeFirstText = new JTextPane();
        treeLastText = new JTextPane();
        panel6 = new JPanel();
        treeShowWordsButton = new JButton();
        treeShowVacaButton = new JButton();
        treeSearchButton = new JButton();
        panel14 = new JPanel();
        treeLookUpEdit = new JTextField();
        treeLookUpButton = new JButton();
        panel4 = new JPanel();
        scrollPane2 = new JScrollPane();
        hashList = new JList();
        panel5 = new JPanel();
        hashWordsNumText = new JTextPane();
        hashVacaNumText = new JTextPane();
        hashMostText = new JTextPane();
        hashFirstText = new JTextPane();
        hashLastText = new JTextPane();
        panel7 = new JPanel();
        hashShowWordsButton = new JButton();
        hashShowVacaButton = new JButton();
        hashSearchButton = new JButton();
        panel15 = new JPanel();
        hashLookUpEdit = new JTextField();
        hashLookUpButton = new JButton();
        panel13 = new JPanel();
        panel16 = new JPanel();
        textPane5 = new JTextPane();
        openButton = new JButton();
        saveButton = new JButton();
        loadButton = new JButton();
        exitButton = new JButton();

        //======== baseFrame ========
        {
            baseFrame.setTitle("\u6570\u636e\u7ed3\u6784\u8bfe\u8bbe");
            baseFrame.setResizable(false);
            baseFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            Container baseFrameContentPane = baseFrame.getContentPane();
            baseFrameContentPane.setLayout(new FormLayout(
                "[247dlu,default]",
                "2*(default)"));

            //======== tabbedPane1 ========
            {
                tabbedPane1.setBackground(new Color(235, 235, 235));

                //======== panel3 ========
                {
                    panel3.setBackground(new Color(235, 235, 235));

                    // JFormDesigner evaluation mark
                    panel3.setBorder(new javax.swing.border.CompoundBorder(
                        new javax.swing.border.TitledBorder(new javax.swing.border.EmptyBorder(0, 0, 0, 0),
                            "JFormDesigner Evaluation", javax.swing.border.TitledBorder.CENTER,
                            javax.swing.border.TitledBorder.BOTTOM, new java.awt.Font("Dialog", java.awt.Font.BOLD, 12),
                            java.awt.Color.red), panel3.getBorder())); panel3.addPropertyChangeListener(new java.beans.PropertyChangeListener(){public void propertyChange(java.beans.PropertyChangeEvent e){if("border".equals(e.getPropertyName()))throw new RuntimeException();}});

                    panel3.setLayout(new FormLayout(
                        "[146dlu,default], $lcgap, 3dlu, $lcgap, [100dlu,default]",
                        "82dlu, $lgap, 46dlu, $lgap, 19dlu"));

                    //======== scrollPane1 ========
                    {
                        scrollPane1.setBackground(new Color(235, 235, 235));
                        scrollPane1.setViewportView(treeList);
                    }
                    panel3.add(scrollPane1, CC.xywh(1, 1, 1, 3));

                    //======== panel2 ========
                    {
                        panel2.setBorder(new CompoundBorder(
                            new TitledBorder("\u57fa\u672c\u4fe1\u606f"),
                            Borders.DLU2));
                        panel2.setBackground(new Color(235, 235, 235));
                        panel2.setLayout(new FormLayout(
                            "89dlu",
                            "4*(default, $lgap), default"));

                        //---- treeWordsNumText ----
                        treeWordsNumText.setText("\u603b\u8bcd\u6570\uff1a");
                        treeWordsNumText.setBackground(new Color(235, 235, 235));
                        treeWordsNumText.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
                        treeWordsNumText.setDragEnabled(false);
                        treeWordsNumText.setFocusable(false);
                        treeWordsNumText.setFocusCycleRoot(false);
                        treeWordsNumText.setRequestFocusEnabled(false);
                        panel2.add(treeWordsNumText, CC.xy(1, 1));

                        //---- treeVacaNumText ----
                        treeVacaNumText.setText("\u603b\u8bcd\u91cf\uff1a");
                        treeVacaNumText.setBackground(new Color(235, 235, 235));
                        treeVacaNumText.setRequestFocusEnabled(false);
                        treeVacaNumText.setFocusCycleRoot(false);
                        treeVacaNumText.setFocusable(false);
                        treeVacaNumText.setDragEnabled(false);
                        treeVacaNumText.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
                        panel2.add(treeVacaNumText, CC.xy(1, 3));

                        //---- treeMostText ----
                        treeMostText.setText("\u51fa\u73b0\u6700\u591a\u8bcd\uff1a");
                        treeMostText.setBackground(new Color(235, 235, 235));
                        treeMostText.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
                        treeMostText.setDragEnabled(false);
                        treeMostText.setFocusable(false);
                        treeMostText.setFocusCycleRoot(false);
                        treeMostText.setRequestFocusEnabled(false);
                        panel2.add(treeMostText, CC.xy(1, 5));

                        //---- treeFirstText ----
                        treeFirstText.setText("\u7b2c\u4e00\u4e2a\u8bcd\uff1a");
                        treeFirstText.setBackground(new Color(235, 235, 235));
                        treeFirstText.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
                        treeFirstText.setDragEnabled(false);
                        treeFirstText.setFocusable(false);
                        treeFirstText.setFocusCycleRoot(false);
                        treeFirstText.setRequestFocusEnabled(false);
                        panel2.add(treeFirstText, CC.xy(1, 7));

                        //---- treeLastText ----
                        treeLastText.setText("\u6700\u540e\u4e00\u4e2a\u8bcd\uff1a");
                        treeLastText.setBackground(new Color(235, 235, 235));
                        treeLastText.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
                        treeLastText.setDragEnabled(false);
                        treeLastText.setFocusable(false);
                        treeLastText.setFocusCycleRoot(false);
                        treeLastText.setRequestFocusEnabled(false);
                        panel2.add(treeLastText, CC.xy(1, 9));
                    }
                    panel3.add(panel2, CC.xy(5, 1));

                    //======== panel6 ========
                    {
                        panel6.setBorder(new CompoundBorder(
                            new TitledBorder("\u68c0\u7d22"),
                            Borders.DLU2));
                        panel6.setBackground(new Color(235, 235, 235));
                        panel6.setLayout(new FormLayout(
                            "115dlu",
                            "3*(default)"));

                        //---- treeShowWordsButton ----
                        treeShowWordsButton.setText("\u663e\u793a\u5168\u4e66\u6240\u6709\u5355\u8bcd");
                        treeShowWordsButton.setBackground(new Color(235, 235, 235));
                        panel6.add(treeShowWordsButton, CC.xy(1, 1));

                        //---- treeShowVacaButton ----
                        treeShowVacaButton.setText("\u663e\u793a\u5168\u4e66\u6240\u6709\u8bcd\u6c47");
                        treeShowVacaButton.setBackground(new Color(235, 235, 235));
                        panel6.add(treeShowVacaButton, CC.xy(1, 2));

                        //---- treeSearchButton ----
                        treeSearchButton.setText("\u641c\u7d22");
                        treeSearchButton.setBackground(new Color(235, 235, 235));
                        panel6.add(treeSearchButton, CC.xy(1, 3));
                    }
                    panel3.add(panel6, CC.xywh(5, 3, 1, 3));

                    //======== panel14 ========
                    {
                        panel14.setBackground(new Color(235, 235, 235));
                        panel14.setLayout(new FormLayout(
                            "120dlu, $lcgap, 30dlu",
                            "default"));
                        panel14.add(treeLookUpEdit, CC.xy(1, 1));

                        //---- treeLookUpButton ----
                        treeLookUpButton.setText("\u67e5\u627e");
                        treeLookUpButton.setBackground(new Color(235, 235, 235));
                        panel14.add(treeLookUpButton, CC.xy(3, 1));
                    }
                    panel3.add(panel14, CC.xy(1, 5));
                }
                tabbedPane1.addTab("\u5b57\u5178\u6811", panel3);

                //======== panel4 ========
                {
                    panel4.setBackground(new Color(235, 235, 235));
                    panel4.setLayout(new FormLayout(
                        "[143dlu,default], $lcgap, 3dlu, $lcgap, [100dlu,default]",
                        "82dlu, $lgap, 46dlu, $lgap, 19dlu"));

                    //======== scrollPane2 ========
                    {
                        scrollPane2.setBackground(new Color(235, 235, 235));
                        scrollPane2.setViewportView(hashList);
                    }
                    panel4.add(scrollPane2, CC.xywh(1, 1, 1, 3));

                    //======== panel5 ========
                    {
                        panel5.setBorder(new CompoundBorder(
                            new TitledBorder("\u57fa\u672c\u4fe1\u606f"),
                            Borders.DLU2));
                        panel5.setBackground(new Color(235, 235, 235));
                        panel5.setLayout(new FormLayout(
                            "89dlu",
                            "4*(default, $lgap), default"));

                        //---- hashWordsNumText ----
                        hashWordsNumText.setText("\u603b\u8bcd\u6570\uff1a");
                        hashWordsNumText.setBackground(new Color(235, 235, 235));
                        hashWordsNumText.setRequestFocusEnabled(false);
                        hashWordsNumText.setFocusable(false);
                        hashWordsNumText.setDragEnabled(false);
                        hashWordsNumText.setFocusCycleRoot(false);
                        hashWordsNumText.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
                        panel5.add(hashWordsNumText, CC.xy(1, 1));

                        //---- hashVacaNumText ----
                        hashVacaNumText.setText("\u603b\u8bcd\u91cf\uff1a");
                        hashVacaNumText.setBackground(new Color(235, 235, 235));
                        hashVacaNumText.setFocusable(false);
                        hashVacaNumText.setDragEnabled(false);
                        hashVacaNumText.setFocusCycleRoot(false);
                        hashVacaNumText.setRequestFocusEnabled(false);
                        hashVacaNumText.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
                        panel5.add(hashVacaNumText, CC.xy(1, 3));

                        //---- hashMostText ----
                        hashMostText.setText("\u51fa\u73b0\u6700\u591a\u8bcd\uff1a");
                        hashMostText.setBackground(new Color(235, 235, 235));
                        hashMostText.setFocusable(false);
                        hashMostText.setRequestFocusEnabled(false);
                        hashMostText.setFocusCycleRoot(false);
                        hashMostText.setDragEnabled(false);
                        hashMostText.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
                        panel5.add(hashMostText, CC.xy(1, 5));

                        //---- hashFirstText ----
                        hashFirstText.setText("\u7b2c\u4e00\u4e2a\u8bcd\uff1a");
                        hashFirstText.setBackground(new Color(235, 235, 235));
                        hashFirstText.setFocusable(false);
                        hashFirstText.setDragEnabled(false);
                        hashFirstText.setFocusCycleRoot(false);
                        hashFirstText.setRequestFocusEnabled(false);
                        hashFirstText.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
                        panel5.add(hashFirstText, CC.xy(1, 7));

                        //---- hashLastText ----
                        hashLastText.setText("\u6700\u540e\u4e00\u4e2a\u8bcd\uff1a");
                        hashLastText.setBackground(new Color(235, 235, 235));
                        hashLastText.setFocusable(false);
                        hashLastText.setRequestFocusEnabled(false);
                        hashLastText.setFocusCycleRoot(false);
                        hashLastText.setDragEnabled(false);
                        hashLastText.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
                        panel5.add(hashLastText, CC.xy(1, 9));
                    }
                    panel4.add(panel5, CC.xy(5, 1));

                    //======== panel7 ========
                    {
                        panel7.setBorder(new CompoundBorder(
                            new TitledBorder("\u68c0\u7d22"),
                            Borders.DLU2));
                        panel7.setBackground(new Color(235, 235, 235));
                        panel7.setLayout(new FormLayout(
                            "115dlu",
                            "3*(default)"));

                        //---- hashShowWordsButton ----
                        hashShowWordsButton.setText("\u663e\u793a\u5168\u4e66\u6240\u6709\u5355\u8bcd");
                        hashShowWordsButton.setBackground(new Color(235, 235, 235));
                        panel7.add(hashShowWordsButton, CC.xy(1, 1));

                        //---- hashShowVacaButton ----
                        hashShowVacaButton.setText("\u663e\u793a\u5168\u4e66\u6240\u6709\u8bcd\u6c47");
                        hashShowVacaButton.setBackground(new Color(235, 235, 235));
                        panel7.add(hashShowVacaButton, CC.xy(1, 2));

                        //---- hashSearchButton ----
                        hashSearchButton.setText("\u641c\u7d22");
                        hashSearchButton.setBackground(new Color(235, 235, 235));
                        panel7.add(hashSearchButton, CC.xy(1, 3));
                    }
                    panel4.add(panel7, CC.xywh(5, 3, 1, 3));

                    //======== panel15 ========
                    {
                        panel15.setBackground(new Color(235, 235, 235));
                        panel15.setLayout(new FormLayout(
                            "120dlu, $lcgap, 30dlu",
                            "default"));
                        panel15.add(hashLookUpEdit, CC.xy(1, 1));

                        //---- hashLookUpButton ----
                        hashLookUpButton.setText("\u67e5\u627e");
                        hashLookUpButton.setBackground(new Color(235, 235, 235));
                        panel15.add(hashLookUpButton, CC.xy(3, 1));
                    }
                    panel4.add(panel15, CC.xy(1, 5));
                }
                tabbedPane1.addTab("\u54c8\u5e0c\u8868", panel4);
            }
            baseFrameContentPane.add(tabbedPane1, CC.xy(1, 1));

            //======== panel13 ========
            {
                panel13.setBackground(new Color(235, 235, 235));
                panel13.setLayout(new FormLayout(
                    "128dlu, 4*($lcgap, default)",
                    "default"));

                //======== panel16 ========
                {
                    panel16.setBackground(new Color(235, 235, 235));
                    panel16.setLayout(new FormLayout(
                        "5dlu, default",
                        "default"));

                    //---- textPane5 ----
                    textPane5.setText("Made by AlexTang");
                    textPane5.setForeground(new Color(204, 204, 204));
                    textPane5.setBackground(new Color(235, 235, 235));
                    textPane5.setRequestFocusEnabled(false);
                    textPane5.setFocusCycleRoot(false);
                    textPane5.setFocusable(false);
                    textPane5.setDragEnabled(false);
                    textPane5.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
                    panel16.add(textPane5, CC.xy(2, 1));
                }
                panel13.add(panel16, CC.xy(1, 1));

                //---- openButton ----
                openButton.setText("\u6253\u5f00");
                openButton.setBackground(new Color(235, 235, 235));
                panel13.add(openButton, CC.xy(3, 1));

                //---- saveButton ----
                saveButton.setText("\u4fdd\u5b58");
                saveButton.setBackground(new Color(235, 235, 235));
                panel13.add(saveButton, CC.xy(5, 1));

                //---- loadButton ----
                loadButton.setText("\u52a0\u8f7d");
                loadButton.setBackground(new Color(235, 235, 235));
                panel13.add(loadButton, CC.xy(7, 1));

                //---- exitButton ----
                exitButton.setText("\u5173\u95ed");
                exitButton.setBackground(new Color(235, 235, 235));
                panel13.add(exitButton, CC.xy(9, 1));
            }
            baseFrameContentPane.add(panel13, CC.xy(1, 2));
            baseFrame.pack();
            baseFrame.setLocationRelativeTo(baseFrame.getOwner());
        }
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Alex Tang
    private JFrame baseFrame;
    private JTabbedPane tabbedPane1;
    private JPanel panel3;
    private JScrollPane scrollPane1;
    private JList treeList;
    private JPanel panel2;
    private JTextPane treeWordsNumText;
    private JTextPane treeVacaNumText;
    private JTextPane treeMostText;
    private JTextPane treeFirstText;
    private JTextPane treeLastText;
    private JPanel panel6;
    private JButton treeShowWordsButton;
    private JButton treeShowVacaButton;
    private JButton treeSearchButton;
    private JPanel panel14;
    private JTextField treeLookUpEdit;
    private JButton treeLookUpButton;
    private JPanel panel4;
    private JScrollPane scrollPane2;
    private JList hashList;
    private JPanel panel5;
    private JTextPane hashWordsNumText;
    private JTextPane hashVacaNumText;
    private JTextPane hashMostText;
    private JTextPane hashFirstText;
    private JTextPane hashLastText;
    private JPanel panel7;
    private JButton hashShowWordsButton;
    private JButton hashShowVacaButton;
    private JButton hashSearchButton;
    private JPanel panel15;
    private JTextField hashLookUpEdit;
    private JButton hashLookUpButton;
    private JPanel panel13;
    private JPanel panel16;
    private JTextPane textPane5;
    private JButton openButton;
    private JButton saveButton;
    private JButton loadButton;
    private JButton exitButton;
    // JFormDesigner - End of variables declaration  //GEN-END:variables


    public JFrame getBaseFrame() {
        return baseFrame;
    }

    public JTabbedPane getTabbedPane1() {
        return tabbedPane1;
    }

    public JPanel getPanel3() {
        return panel3;
    }

    public JScrollPane getScrollPane1() {
        return scrollPane1;
    }

    public JList getTreeList() {
        return treeList;
    }

    public JPanel getPanel2() {
        return panel2;
    }

    public JTextPane getTreeWordsNumText() {
        return treeWordsNumText;
    }

    public JTextPane getTreeVacaNumText() {
        return treeVacaNumText;
    }

    public JTextPane getTreeMostText() {
        return treeMostText;
    }

    public JTextPane getTreeFirstText() {
        return treeFirstText;
    }

    public JTextPane getTreeLastText() {
        return treeLastText;
    }

    public JPanel getPanel6() {
        return panel6;
    }

    public JButton getTreeShowWordsButton() {
        return treeShowWordsButton;
    }

    public JButton getTreeShowVacaButton() {
        return treeShowVacaButton;
    }

    public JButton getTreeSearchButton() {
        return treeSearchButton;
    }

    public JPanel getPanel14() {
        return panel14;
    }

    public JTextField getTreeLookUpEdit() {
        return treeLookUpEdit;
    }

    public JButton getTreeLookUpButton() {
        return treeLookUpButton;
    }

    public JPanel getPanel4() {
        return panel4;
    }

    public JScrollPane getScrollPane2() {
        return scrollPane2;
    }

    public JList getHashList() {
        return hashList;
    }

    public JPanel getPanel5() {
        return panel5;
    }

    public JTextPane getHashWordsNumText() {
        return hashWordsNumText;
    }

    public JTextPane getHashVacaNumText() {
        return hashVacaNumText;
    }

    public JTextPane getHashMostText() {
        return hashMostText;
    }

    public JTextPane getHashFirstText() {
        return hashFirstText;
    }

    public JTextPane getHashLastText() {
        return hashLastText;
    }

    public JPanel getPanel7() {
        return panel7;
    }

    public JButton getHashShowWordsButton() {
        return hashShowWordsButton;
    }

    public JButton getHashShowVacaButton() {
        return hashShowVacaButton;
    }

    public JButton getHashSearchButton() {
        return hashSearchButton;
    }

    public JPanel getPanel15() {
        return panel15;
    }

    public JTextField getHashLookUpEdit() {
        return hashLookUpEdit;
    }

    public JButton getHashLookUpButton() {
        return hashLookUpButton;
    }

    public JPanel getPanel13() {
        return panel13;
    }

    public JPanel getPanel16() {
        return panel16;
    }

    public JTextPane getTextPane5() {
        return textPane5;
    }

    public JButton getOpenButton() {
        return openButton;
    }

    public JButton getSaveButton() {
        return saveButton;
    }

    public JButton getLoadButton() {
        return loadButton;
    }

    public JButton getExitButton() {
        return exitButton;
    }
}
