package presenter;

import baseDataStructure.MyLinkedList;
import model.Word;
import presenter.HashManager;
import presenter.TreeManager;
import view.MainView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.lang.reflect.Method;

/**
 * Created by tangyifeng on 17/1/19.
 * Email: yifengtang_hust@outlook.com
 */
public class ListenerGetter {

    private HashManager hashManager;
    private TreeManager treeManager;
    private MainView mainView;
    private CardLayout layout;

    private String maxWord;
    private int maxCount;

    private volatile int loadCount = 0;

    public ListenerGetter(HashManager hashManager, TreeManager treeManager, MainView mainView) {
        this.hashManager = hashManager;
        this.treeManager = treeManager;
        this.mainView = mainView;
        this.layout = (CardLayout) mainView.getBaseFrame().getLayout();
    }

    public ActionListener getFileOpenListener() {
        return (ActionEvent e) -> {
            JFileChooser chooser = new JFileChooser();
            chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
            chooser.showOpenDialog(new JPanel());
            File file = chooser.getSelectedFile();
            if(file.getName().contains("txt")) {
                new Thread(() -> {
                    hashManager.initHash(file.getAbsolutePath(), hashLoadListener);
                    treeManager.initDSTable(file.getAbsolutePath(), treeLoadListener);
                    loadListInfo();
                }).start();
            } else {
                JOptionPane.showMessageDialog(null, "请选择txt文件！",
                        "错误", JOptionPane.WARNING_MESSAGE);
            }
        };
    }

    public ActionListener getFileSearchListener() {
        return (ActionEvent e) -> {
            if(hashManager.isInitial() && treeManager.isInitial()) {
                layout.show(mainView.getBaseFrame(), "SearchCard");
            } else {
                JOptionPane.showMessageDialog(null, "请先加载程序！",
                        "错误", JOptionPane.WARNING_MESSAGE);
            }
        };
    }

    public ActionListener getFileSaveListener() {
        return (ActionEvent e) -> {
            JFileChooser chooser = new JFileChooser();
            chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
            chooser.showSaveDialog(new JPanel());
            File file = chooser.getSelectedFile();
            if(hashManager.isInitial() && treeManager.isInitial()) {
                new Thread(() -> {
                    hashManager.saveHash(file.getAbsolutePath(), hashSaveListener);
                    treeManager.saveDSTable(file.getAbsolutePath(), treeSaveListener);
                }).start();
            } else {
                JOptionPane.showMessageDialog(null, "请先加载程序！",
                        "错误", JOptionPane.WARNING_MESSAGE);
            }
        };
    }

    public ActionListener getFileLoadListener() {
        return (ActionEvent e) -> {
            JFileChooser chooser = new JFileChooser();
            chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
            chooser.showOpenDialog(new JPanel());
            File file = chooser.getSelectedFile();
            if(file.getName().contains("tree") || file.getName().contains("hash")) {
                StringBuilder fileAddress = new StringBuilder();
                String[] dirs = file.getAbsolutePath().split("/");
                for(int i = 0; i < dirs.length - 1; i++) {
                    if(!dirs[i].isEmpty())
                        fileAddress.append("/").append(dirs[i]);
                }
                fileAddress.append("/");
                String[] fileName = dirs[dirs.length - 1].split("\\.");
                for(int i = 0; i < fileName.length - 2; i++) {
                    if(!fileName[i].isEmpty())
                        fileAddress.append(fileName[i]).append(".");
                }
                new Thread(() -> {
                    hashManager.loadHash(fileAddress.toString() + "saved.hash", hashLoadListener);
                    treeManager.loadDSTable(fileAddress.toString() + "saved.tree", treeLoadListener);
                }).start();
            } else {
                JOptionPane.showMessageDialog(null, "请先加载程序！",
                        "错误", JOptionPane.WARNING_MESSAGE);
            }
        };
    }

    public ActionListener getFileExitListener() {
        return (ActionEvent e) -> {
            int reply = JOptionPane.showConfirmDialog(null, "是否真的要退出", "退出", JOptionPane.YES_NO_OPTION);
            if (reply == JOptionPane.YES_OPTION) {
                System.exit(0);
            }
        };
    }


    private HashManager.OnLoadCompleteListener hashLoadListener = new HashManager.OnLoadCompleteListener() {
        @Override
        public void onSuccess() {
            JOptionPane.showMessageDialog(null, "哈希表加载成功！",
                    "提示", JOptionPane.INFORMATION_MESSAGE);
            if(++loadCount == 2) {
                layout.show(mainView.getBaseFrame(), "ListCard");
                loadCount = 0;
            }
        }

        @Override
        public void onFailure() {
            JOptionPane.showMessageDialog(null, "哈希表加载失败！",
                    "错误", JOptionPane.WARNING_MESSAGE);
            loadCount = 0;
        }
    };

    private HashManager.OnSaveCompleteListener hashSaveListener = new HashManager.OnSaveCompleteListener() {
        @Override
        public void onSuccess() {
            JOptionPane.showMessageDialog(null, "哈希表保存成功！",
                    "提示", JOptionPane.INFORMATION_MESSAGE);
        }

        @Override
        public void onFailure() {
            JOptionPane.showMessageDialog(null, "哈希表保存失败！",
                    "错误", JOptionPane.WARNING_MESSAGE);
        }
    };

    private TreeManager.OnLoadCompleteListener treeLoadListener = new TreeManager.OnLoadCompleteListener() {
        @Override
        public void onSuccess() {
            JOptionPane.showMessageDialog(null, "字典树加载成功！",
                    "提示", JOptionPane.INFORMATION_MESSAGE);
            if(++loadCount == 2) {
                layout.show(mainView.getBaseFrame(), "ListCard");
                loadCount = 0;
                loadListInfo();
            }
        }

        @Override
        public void onFailure() {
            JOptionPane.showMessageDialog(null, "字典树加载失败！",
                    "错误", JOptionPane.WARNING_MESSAGE);
            loadCount = 0;
        }
    };

    private TreeManager.OnSaveCompleteListener treeSaveListener = new TreeManager.OnSaveCompleteListener() {
        @Override
        public void onSuccess() {
            JOptionPane.showMessageDialog(null, "字典树保存成功！",
                    "提示", JOptionPane.INFORMATION_MESSAGE);
        }

        @Override
        public void onFailure() {
            JOptionPane.showMessageDialog(null, "字典树保存失败！",
                    "错误", JOptionPane.WARNING_MESSAGE);
        }
    };

    private void loadListInfo() {
        hashManager.getAllWordsHash((MyLinkedList<Word> words) -> {
            mainView.getHashTotalNum().setText("共" + words.size() + "词");
        });
        hashManager.traverseHash((MyLinkedList<Word> words) -> {
            mainView.getHashKindsNum().setText("共" + words.size() + "词");
        });
        hashManager.traverseHash((MyLinkedList<Word> words) -> {
            maxWord = "";
            maxCount = 0;
            for(Word word : words) {
                hashManager.searchHash(word.getSelf(), (MyLinkedList<Word> searchList) -> {
                    if(searchList.size() > maxCount) {
                        maxWord = word.getSelf();
                        maxCount = searchList.size();
                    }
                });
            }
            mainView.getHashMostWords().setText(maxWord + "共" + maxCount + "次");
        });
        hashManager.getAllWordsHash((MyLinkedList<Word> searchList) -> {
            mainView.getHashFirstWord().setText(searchList.get(0).getSelf());
            mainView.getHashLastWord().setText(searchList.get(searchList.size() - 1).getSelf());
        });

        treeManager.getAllWordsDSTable((MyLinkedList<Word> words) -> {
            mainView.getTreeTotalNum().setText("共" + words.size() + "词");
        });
        treeManager.traverseDSTable((MyLinkedList<Word> words) -> {
            mainView.getTreeKindsNum().setText("共" + words.size() + "词");
        });
        treeManager.traverseDSTable((MyLinkedList<Word> words) -> {
            maxWord = "";
            maxCount = 0;
            for(Word word : words) {
                treeManager.searchDSTable(word.getSelf(), (MyLinkedList<Word> searchList) -> {
                    if(searchList.size() > maxCount) {
                        maxWord = word.getSelf();
                        maxCount = searchList.size();
                    }
                });
            }
            mainView.getTreeMostWords().setText(maxWord + "共" + maxCount + "次");
        });
        treeManager.getAllWordsDSTable((MyLinkedList<Word> searchList) -> {
            mainView.getTreeFirstWord().setText(searchList.get(0).getSelf());
            mainView.getTreeLastWord().setText(searchList.get(searchList.size() - 1).getSelf());
        });
    }
}
