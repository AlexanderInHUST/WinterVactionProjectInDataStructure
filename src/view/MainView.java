package view;

import presenter.HashManager;
import presenter.TreeManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Method;

/**
 * Created by tangyifeng on 17/1/19.
 * Email: yifengtang_hust@outlook.com
 */
public class MainView {

    private JPanel baseFrame;
    private JPanel backgroundFrame;
    private JLabel background;
    private JPanel listFrame;
    private JPanel searchFrame;
    private JTextArea hashTableTextArea;
    private JTextArea trieTreeTextArea;
    private JTextArea hashTotalNumTitle;
    private JTextArea hashTotalNum;
    private JTextArea hashKindsNumTitle;
    private JTextArea hashKindsNum;
    private JTextArea hashMostWordsTitle;
    private JTextArea hashMostWords;
    private JTextArea hashFirstWordTitle;
    private JTextArea hashFirstWord;
    private JTextArea hashLastWord;
    private JTextArea hashLastWordTitle;
    private JTextArea treeTotalNumTitle;
    private JTextArea treeTotalNum;
    private JTextArea treeKindsNumTitle;
    private JTextArea treeKindsNum;
    private JTextArea treeMostWordsTitle;
    private JTextArea treeMostWords;
    private JTextArea treeFirstWordTitle;
    private JTextArea treeFirstWord;
    private JTextArea treeLastWordTitle;
    private JTextArea treeLastWord;
    private JTextArea hashSearchTitle;
    private JList hashTableList;
    private JEditorPane hashSearchEditBox;
    private JButton hashSearchButton;
    private JButton hashKindListButton;
    private JButton hashWordListButton;
    private JTextArea treeSearchTitle;
    private JList treeList;
    private JEditorPane treeEditBox;
    private JButton treeSearchButton;
    private JButton treeKindListButton;
    private JButton treeWordListButton;
    private JButton backButton;
    private JMenuBar baseMenu;
    private MainMenu menu;

    public MainView() {
        System.out.println("MainView " + this);
        menu = new MainMenu();
        baseMenu = menu.getMainMenuBar(HashManager.getHashManager(), TreeManager.getTreePresenter(), this);

    }

    public static void main(String[] args) {
        MainView mainView = new MainView();

        JFrame frame = new JFrame("数据结构课设");
        frame.setSize(new Dimension(640, 540));
        frame.setContentPane(mainView.baseFrame);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setJMenuBar(mainView.baseMenu);
        frame.pack();
        frame.setVisible(true);
    }

    public JPanel getBaseFrame() {
        return baseFrame;
    }

    public JPanel getBackgroundFrame() {
        return backgroundFrame;
    }

    public JLabel getBackground() {
        return background;
    }

    public JPanel getListFrame() {
        return listFrame;
    }

    public JPanel getSearchFrame() {
        return searchFrame;
    }

    public JTextArea getHashTableTextArea() {
        return hashTableTextArea;
    }

    public JTextArea getTrieTreeTextArea() {
        return trieTreeTextArea;
    }

    public JTextArea getHashTotalNumTitle() {
        return hashTotalNumTitle;
    }

    public JTextArea getHashTotalNum() {
        return hashTotalNum;
    }

    public JTextArea getHashKindsNumTitle() {
        return hashKindsNumTitle;
    }

    public JTextArea getHashKindsNum() {
        return hashKindsNum;
    }

    public JTextArea getHashMostWordsTitle() {
        return hashMostWordsTitle;
    }

    public JTextArea getHashMostWords() {
        return hashMostWords;
    }

    public JTextArea getHashFirstWordTitle() {
        return hashFirstWordTitle;
    }

    public JTextArea getHashFirstWord() {
        return hashFirstWord;
    }

    public JTextArea getHashLastWord() {
        return hashLastWord;
    }

    public JTextArea getHashLastWordTitle() {
        return hashLastWordTitle;
    }

    public JTextArea getTreeTotalNumTitle() {
        return treeTotalNumTitle;
    }

    public JTextArea getTreeTotalNum() {
        return treeTotalNum;
    }

    public JTextArea getTreeKindsNumTitle() {
        return treeKindsNumTitle;
    }

    public JTextArea getTreeKindsNum() {
        return treeKindsNum;
    }

    public JTextArea getTreeMostWordsTitle() {
        return treeMostWordsTitle;
    }

    public JTextArea getTreeMostWords() {
        return treeMostWords;
    }

    public JTextArea getTreeFirstWordTitle() {
        return treeFirstWordTitle;
    }

    public JTextArea getTreeFirstWord() {
        return treeFirstWord;
    }

    public JTextArea getTreeLastWordTitle() {
        return treeLastWordTitle;
    }

    public JTextArea getTreeLastWord() {
        return treeLastWord;
    }

    public JTextArea getHashSearchTitle() {
        return hashSearchTitle;
    }

    public JList getHashTableList() {
        return hashTableList;
    }

    public JEditorPane getHashSearchEditBox() {
        return hashSearchEditBox;
    }

    public JButton getHashSearchButton() {
        return hashSearchButton;
    }

    public JButton getHashKindListButton() {
        return hashKindListButton;
    }

    public JButton getHashWordListButton() {
        return hashWordListButton;
    }

    public JTextArea getTreeSearchTitle() {
        return treeSearchTitle;
    }

    public JList getTreeList() {
        return treeList;
    }

    public JEditorPane getTreeEditBox() {
        return treeEditBox;
    }

    public JButton getTreeSearchButton() {
        return treeSearchButton;
    }

    public JButton getTreeKindListButton() {
        return treeKindListButton;
    }

    public JButton getTreeWordListButton() {
        return treeWordListButton;
    }

    public JButton getBackButton() {
        return backButton;
    }

    public JMenuBar getBaseMenu() {
        return baseMenu;
    }

    public MainMenu getMenu() {
        return menu;
    }
}
