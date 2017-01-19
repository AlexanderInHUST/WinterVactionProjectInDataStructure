package view;

import presenter.HashManager;
import presenter.TreeManager;

import javax.swing.*;
import java.awt.*;

/**
 * Created by tangyifeng on 17/1/19.
 * Email: yifengtang_hust@outlook.com
 */
public class MainView {

    private JPanel baseFrame;
    private JLabel background;
    private JMenuBar baseMenu;

    public static void main(String[] args) {
        MainView mainView = new MainView();
        MainMenu menu = new MainMenu();
        mainView.baseMenu = menu.getMainMenuBar(HashManager.getHashManager(), TreeManager.getTreePresenter());

        JFrame frame = new JFrame("数据结构课设");
        frame.setContentPane(new MainView().baseFrame);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setJMenuBar(mainView.baseMenu);
        frame.pack();
        frame.setVisible(true);
    }

}
