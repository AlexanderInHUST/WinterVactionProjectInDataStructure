package view;

import presenter.HashManager;
import presenter.ListenerGetter;
import presenter.TreeManager;

import javax.swing.*;
import java.awt.event.*;

/**
 * Created by tangyifeng on 17/1/19.
 * Email: yifengtang_hust@outlook.com
 */
public class MainMenu {

    private JMenuBar mainMenuBar;
    private JMenu file;
    private JMenu about;
    private JMenuItem fileOpen;
    private JMenuItem fileSave;
    private JMenuItem fileLoad;
    private JMenuItem fileExit;
    private JMenuItem aboutAbout;

    private ListenerGetter listenerGetter;
    private HashManager hashManager;
    private TreeManager treeManager;

    public JMenuBar getMainMenuBar(HashManager hashManager, TreeManager treeManager) {
        listenerGetter = new ListenerGetter(hashManager, treeManager);
        initialMainMenuBar();
        setHashManager(hashManager);
        setTreeManager(treeManager);
        return mainMenuBar;
    }

    private void initialMainMenuBar() {
        mainMenuBar = new JMenuBar();
        file = new JMenu("文件");
        about = new JMenu("关于");

        mainMenuBar.add(file);
        mainMenuBar.add(about);

        fileOpen = new JMenuItem("打开");
        fileOpen.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, ActionEvent.CTRL_MASK));
        fileOpen.addActionListener(listenerGetter.getFileOpenListener());

        fileSave = new JMenuItem("保存");
        fileSave.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK));
        fileSave.addActionListener(listenerGetter.getFileSaveListener());

        fileLoad = new JMenuItem("加载");
        fileLoad.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_L, ActionEvent.CTRL_MASK));
        fileLoad.addActionListener(listenerGetter.getFileLoadListener());

        fileExit = new JMenuItem("关闭");
        fileExit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, ActionEvent.CTRL_MASK));
        fileExit.addActionListener(listenerGetter.getFileExitListener());

        aboutAbout = new JMenuItem("关于");
        aboutAbout.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q, ActionEvent.CTRL_MASK));

        file.add(fileOpen);
        file.add(fileSave);
        file.add(fileLoad);
        file.add(fileExit);
        about.add(aboutAbout);
    }

    public HashManager getHashManager() {
        return hashManager;
    }

    public void setHashManager(HashManager hashManager) {
        this.hashManager = hashManager;
    }

    public TreeManager getTreeManager() {
        return treeManager;
    }

    public void setTreeManager(TreeManager treeManager) {
        this.treeManager = treeManager;
    }

}
