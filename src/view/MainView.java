package view;

import presenter.GetListener;

import javax.swing.*;
import java.awt.*;

/**
 * Created by tangyifeng on 17/1/31.
 * Email: yifengtang_hust@outlook.com
 */
public class MainView {

    private MainViewFrame mainViewFrame;
    private GetListener listenerGetter;

    public MainView() {
        mainViewFrame = new MainViewFrame();
        listenerGetter = new GetListener(mainViewFrame);
        mainViewFrame.getBaseFrame().setVisible(true);
        listenerGetter.changeBorder("欢迎使用本词频统计软件");
    }

    public static void main(String[] args) {
        MainView mainView = new MainView();

        mainView.mainViewFrame.getOpenButton().addActionListener(mainView.listenerGetter.getOpenButtonListener());
        mainView.mainViewFrame.getSaveButton().addActionListener(mainView.listenerGetter.getFileSaveListener());
        mainView.mainViewFrame.getLoadButton().addActionListener(mainView.listenerGetter.getFileLoadListener());
        mainView.mainViewFrame.getExitButton().addActionListener(mainView.listenerGetter.getFileExitListener());

        mainView.mainViewFrame.getHashShowWordsButton().addActionListener(mainView.listenerGetter.getHashWordListListener());
        mainView.mainViewFrame.getHashShowVacaButton().addActionListener(mainView.listenerGetter.getHashVocaListListener());
        mainView.mainViewFrame.getHashSearchButton().addActionListener(mainView.listenerGetter.getHashSearchListener());
        mainView.mainViewFrame.getHashLookUpButton().addActionListener(mainView.listenerGetter.getHashLookUpListener());

        mainView.mainViewFrame.getTreeShowWordsButton().addActionListener(mainView.listenerGetter.getTreeWordListListener());
        mainView.mainViewFrame.getTreeShowVacaButton().addActionListener(mainView.listenerGetter.getTreeVocaListListener());
        mainView.mainViewFrame.getTreeSearchButton().addActionListener(mainView.listenerGetter.getTreeSearchListener());
        mainView.mainViewFrame.getTreeLookUpButton().addActionListener(mainView.listenerGetter.getTreeLookUpListener());
    }
}
