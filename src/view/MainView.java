package view;

import javax.swing.*;
import java.awt.*;

/**
 * Created by tangyifeng on 17/1/31.
 * Email: yifengtang_hust@outlook.com
 */
public class MainView {

    private JFrame baseFrame;
    private SearchDialog searchDialog;

    public MainView() {
        baseFrame = new MainViewFrame().getBaseFrame();
        searchDialog = new SearchDialog(baseFrame);
    }

    public static void main(String[] args) {
        MainView mainView = new MainView();
        mainView.baseFrame.setVisible(true);
    }

}
