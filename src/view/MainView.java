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
        frame.setSize(new Dimension(960, 540));
        frame.setContentPane(mainView.baseFrame);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setJMenuBar(mainView.baseMenu);
        frame.pack();
        frame.setVisible(true);
    }

    public JPanel getBaseFrame() {
        return baseFrame;
    }

    public void setBaseFrame(JPanel baseFrame) {
        this.baseFrame = baseFrame;
    }

    public JPanel getBackgroundFrame() {
        return backgroundFrame;
    }

    public void setBackgroundFrame(JPanel backgroundFrame) {
        this.backgroundFrame = backgroundFrame;
    }

    public JLabel getBackground() {
        return background;
    }

    public void setBackground(JLabel background) {
        this.background = background;
    }

    public JPanel getListFrame() {
        return listFrame;
    }

    public void setListFrame(JPanel listFrame) {
        this.listFrame = listFrame;
    }

    public JPanel getSearchFrame() {
        return searchFrame;
    }

    public void setSearchFrame(JPanel searchFrame) {
        this.searchFrame = searchFrame;
    }

    public JMenuBar getBaseMenu() {
        return baseMenu;
    }

    public void setBaseMenu(JMenuBar baseMenu) {
        this.baseMenu = baseMenu;
    }

    public JTextArea getHashTableTextArea() {
        return hashTableTextArea;
    }

    public void setHashTableTextArea(JTextArea hashTableTextArea) {
        this.hashTableTextArea = hashTableTextArea;
    }

    public JTextArea getTrieTreeTextArea() {
        return trieTreeTextArea;
    }

    public void setTrieTreeTextArea(JTextArea trieTreeTextArea) {
        this.trieTreeTextArea = trieTreeTextArea;
    }

    public JTextArea getHashTotalNumTitle() {
        return hashTotalNumTitle;
    }

    public void setHashTotalNumTitle(JTextArea hashTotalNumTitle) {
        this.hashTotalNumTitle = hashTotalNumTitle;
    }

    public JTextArea getHashTotalNum() {
        return hashTotalNum;
    }

    public void setHashTotalNum(JTextArea hashTotalNum) {
        this.hashTotalNum = hashTotalNum;
    }

    public JTextArea getHashKindsNumTitle() {
        return hashKindsNumTitle;
    }

    public void setHashKindsNumTitle(JTextArea hashKindsNumTitle) {
        this.hashKindsNumTitle = hashKindsNumTitle;
    }

    public JTextArea getHashKindsNum() {
        return hashKindsNum;
    }

    public void setHashKindsNum(JTextArea hashKindsNum) {
        this.hashKindsNum = hashKindsNum;
    }

    public JTextArea getHashMostWordsTitle() {
        return hashMostWordsTitle;
    }

    public void setHashMostWordsTitle(JTextArea hashMostWordsTitle) {
        this.hashMostWordsTitle = hashMostWordsTitle;
    }

    public JTextArea getHashMostWords() {
        return hashMostWords;
    }

    public void setHashMostWords(JTextArea hashMostWords) {
        this.hashMostWords = hashMostWords;
    }

    public JTextArea getHashFirstWordTitle() {
        return hashFirstWordTitle;
    }

    public void setHashFirstWordTitle(JTextArea hashFirstWordTitle) {
        this.hashFirstWordTitle = hashFirstWordTitle;
    }

    public JTextArea getHashFirstWord() {
        return hashFirstWord;
    }

    public void setHashFirstWord(JTextArea hashFirstWord) {
        this.hashFirstWord = hashFirstWord;
    }

    public JTextArea getHashLastWord() {
        return hashLastWord;
    }

    public void setHashLastWord(JTextArea hashLastWord) {
        this.hashLastWord = hashLastWord;
    }

    public JTextArea getHashLastWordTitle() {
        return hashLastWordTitle;
    }

    public void setHashLastWordTitle(JTextArea hashLastWordTitle) {
        this.hashLastWordTitle = hashLastWordTitle;
    }

    public JTextArea getTreeTotalNumTitle() {
        return treeTotalNumTitle;
    }

    public void setTreeTotalNumTitle(JTextArea treeTotalNumTitle) {
        this.treeTotalNumTitle = treeTotalNumTitle;
    }

    public JTextArea getTreeTotalNum() {
        return treeTotalNum;
    }

    public void setTreeTotalNum(JTextArea treeTotalNum) {
        this.treeTotalNum = treeTotalNum;
    }

    public JTextArea getTreeKindsNumTitle() {
        return treeKindsNumTitle;
    }

    public void setTreeKindsNumTitle(JTextArea treeKindsNumTitle) {
        this.treeKindsNumTitle = treeKindsNumTitle;
    }

    public JTextArea getTreeKindsNum() {
        return treeKindsNum;
    }

    public void setTreeKindsNum(JTextArea treeKindsNum) {
        this.treeKindsNum = treeKindsNum;
    }

    public JTextArea getTreeMostWordsTitle() {
        return treeMostWordsTitle;
    }

    public void setTreeMostWordsTitle(JTextArea treeMostWordsTitle) {
        this.treeMostWordsTitle = treeMostWordsTitle;
    }

    public JTextArea getTreeMostWords() {
        return treeMostWords;
    }

    public void setTreeMostWords(JTextArea treeMostWords) {
        this.treeMostWords = treeMostWords;
    }

    public JTextArea getTreeFirstWordTitle() {
        return treeFirstWordTitle;
    }

    public void setTreeFirstWordTitle(JTextArea treeFirstWordTitle) {
        this.treeFirstWordTitle = treeFirstWordTitle;
    }

    public JTextArea getTreeFirstWord() {
        return treeFirstWord;
    }

    public void setTreeFirstWord(JTextArea treeFirstWord) {
        this.treeFirstWord = treeFirstWord;
    }

    public JTextArea getTreeLastWordTitle() {
        return treeLastWordTitle;
    }

    public void setTreeLastWordTitle(JTextArea treeLastWordTitle) {
        this.treeLastWordTitle = treeLastWordTitle;
    }

    public JTextArea getTreeLastWord() {
        return treeLastWord;
    }

    public void setTreeLastWord(JTextArea treeLastWord) {
        this.treeLastWord = treeLastWord;
    }

    public MainMenu getMenu() {
        return menu;
    }

    public void setMenu(MainMenu menu) {
        this.menu = menu;
    }
}
