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
    private JTextArea textArea1;
    private JButton button1;
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

    public JButton getButton1() {
        return button1;
    }

    public void setButton1(JButton button1) {
        this.button1 = button1;
    }

    public JMenuBar getBaseMenu() {
        return baseMenu;
    }

    public void setBaseMenu(JMenuBar baseMenu) {
        this.baseMenu = baseMenu;
    }
}
