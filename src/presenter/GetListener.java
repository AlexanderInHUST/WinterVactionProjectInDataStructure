package presenter;

import baseDataStructure.MyLinkedList;
import com.jgoodies.forms.factories.Borders;
import model.Word;
import view.MainView;
import view.MainViewFrame;
import view.SearchDialog;

import javax.swing.*;
import javax.swing.plaf.metal.MetalBorders;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

/**
 * Created by tangyifeng on 17/1/31.
 * Email: yifengtang_hust@outlook.com
 */
public class GetListener {

    private AddData dataAdder;
    private volatile int loadCount;
    private MainViewFrame mainViewFrame;

    private String searchWord;
    private int hashIndex = -1;
    private int treeIndex = -1;
    private boolean hashExist = false;
    private boolean treeExist = false;
    private String lastHashWord;
    private String lastTreeWord;

    public GetListener(MainViewFrame mainViewFrame) {
        this.mainViewFrame = mainViewFrame;
        dataAdder = new AddData(mainViewFrame);
    }

    public ActionListener getOpenButtonListener() {
        return (ActionEvent e) -> {
            JFileChooser chooser = new JFileChooser();
            chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
            chooser.showOpenDialog(new JPanel());
            File file = chooser.getSelectedFile();
            if (file != null) {
                if (file.getName().contains("txt")) {
                    changeBorder("文件正在被处理中，请稍后……");
                    new Thread(() -> {
                        dataAdder.getHashManager().initHash(file.getAbsolutePath(), hashLoadListener);
                        dataAdder.getTreeManager().initDSTable(file.getAbsolutePath(), treeLoadListener);
                    }).start();
                } else {
                    JOptionPane.showMessageDialog(null, "请选择txt文件！",
                            "错误", JOptionPane.WARNING_MESSAGE);
                }
            }
        };
    }

    public ActionListener getFileSaveListener() {
        return (ActionEvent e) -> {
            JFileChooser chooser = new JFileChooser();
            chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
            chooser.showSaveDialog(new JPanel());
            File file = chooser.getSelectedFile();
            if(dataAdder.getTreeManager().isInitial() && dataAdder.getTreeManager().isInitial()) {
                changeBorder("数据正在保存中，请稍后……");
                new Thread(() -> {
                    dataAdder.getHashManager().saveHash(file.getAbsolutePath(), hashSaveListener);
                    dataAdder.getTreeManager().saveDSTable(file.getAbsolutePath(), treeSaveListener);
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
                changeBorder("数据正在加载中，请稍后……");
                new Thread(() -> {
                    dataAdder.getHashManager().loadHash(fileAddress.toString() + "saved.hash", hashLoadListener);
                    dataAdder.getTreeManager().loadDSTable(fileAddress.toString() + "saved.tree", treeLoadListener);
                }).start();
            } else {
                JOptionPane.showMessageDialog(null, "请选择正确的文件！",
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
                loadCount = 0;
                dataAdder.loadInfo();
                changeBorder("欢迎使用本词频统计软件");
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
            if(++loadCount == 2) {
                loadCount = 0;
                changeBorder("欢迎使用本词频统计软件");
            }
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
                loadCount = 0;
                dataAdder.loadInfo();
                changeBorder("欢迎使用本词频统计软件");
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
            if(++loadCount == 2) {
                loadCount = 0;
                changeBorder("欢迎使用本词频统计软件");
            }
        }

        @Override
        public void onFailure() {
            JOptionPane.showMessageDialog(null, "字典树保存失败！",
                    "错误", JOptionPane.WARNING_MESSAGE);
        }
    };

    @SuppressWarnings("unchecked")
    public ActionListener getTreeVocaListListener() {
        return (ActionEvent e) -> {
            if(dataAdder.getTreeManager().isInitial() && dataAdder.getTreeManager().isInitial()) {
                dataAdder.getTreeManager().traverseDSTable((MyLinkedList<Word> words) -> {
                    DefaultListModel<String> listModel = new DefaultListModel<>();
                    for (Word word : words) {
                        listModel.addElement(word.getSelf() + "出现在" + word.getPosByPages() + "页第" + word.getPosByLines() + "行");
                    }
                    mainViewFrame.getTreeList().setModel(listModel);
                    treeExist = false;
                    treeIndex = -1;
                });
            } else {
                JOptionPane.showMessageDialog(null, "请先加载程序！",
                        "错误", JOptionPane.WARNING_MESSAGE);
            }
        };
    }

    @SuppressWarnings("unchecked")
    public ActionListener getTreeWordListListener() {
        return (ActionEvent e) -> {
            if(dataAdder.getTreeManager().isInitial() && dataAdder.getTreeManager().isInitial()) {
                dataAdder.getTreeManager().getAllWordsDSTable((MyLinkedList<Word> words) -> {
                    DefaultListModel<String> listModel = new DefaultListModel<>();
                    for (Word word : words) {
                        listModel.addElement(word.getSelf() + "出现在" + word.getPosByPages() + "页第" + word.getPosByLines() + "行");
                    }
                    mainViewFrame.getTreeList().setModel(listModel);
                });
                treeExist = false;
                treeIndex = -1;
            } else {
                JOptionPane.showMessageDialog(null, "请先加载程序！",
                        "错误", JOptionPane.WARNING_MESSAGE);
            }
        };
    }

    @SuppressWarnings("unchecked")
    public ActionListener getHashVocaListListener() {
        return (ActionEvent e) -> {
            if(dataAdder.getTreeManager().isInitial() && dataAdder.getTreeManager().isInitial()) {
                dataAdder.getHashManager().traverseHash((MyLinkedList<Word> words) -> {
                    DefaultListModel<String> listModel = new DefaultListModel<>();
                    for (Word word : words) {
                        listModel.addElement(word.getSelf() + "出现在" + word.getPosByPages() + "页第" + word.getPosByLines() + "行");
                    }
                    mainViewFrame.getHashList().setModel(listModel);
                });
                hashExist = false;
                hashIndex = -1;
            } else {
                JOptionPane.showMessageDialog(null, "请先加载程序！",
                        "错误", JOptionPane.WARNING_MESSAGE);
            }
        };
    }

    @SuppressWarnings("unchecked")
    public ActionListener getHashWordListListener() {
        return (ActionEvent e) -> {
            if(dataAdder.getTreeManager().isInitial() && dataAdder.getTreeManager().isInitial()) {
                dataAdder.getHashManager().getAllWordsHash((MyLinkedList<Word> words) -> {
                    DefaultListModel<String> listModel = new DefaultListModel<>();
                    for (Word word : words) {
                        listModel.addElement(word.getSelf() + "出现在" + word.getPosByPages() + "页第" + word.getPosByLines() + "行");
                    }
                    mainViewFrame.getHashList().setModel(listModel);
                });
                hashExist = false;
                hashIndex = -1;
            } else {
                JOptionPane.showMessageDialog(null, "请先加载程序！",
                        "错误", JOptionPane.WARNING_MESSAGE);
            }
        };
    }

    @SuppressWarnings("unchecked")
    public ActionListener getHashSearchListener() {
        return (ActionEvent e) -> {
            if(dataAdder.getTreeManager().isInitial() && dataAdder.getTreeManager().isInitial()) {
                SearchDialog searchDialog = new SearchDialog(mainViewFrame);
                searchDialog.getDialogPane().removePropertyChangeListener(searchDialog.getDialogPane().getPropertyChangeListeners()[0]);
                searchDialog.getDialogPane().setBorder(Borders.DIALOG);
                searchDialog.setVisible(true);
                searchDialog.getOkButton().addActionListener((ActionEvent event) -> {
                    searchWord = searchDialog.getSearchEdit().getText();
                    try {
                        dataAdder.getHashManager().searchHash(searchWord, (MyLinkedList<Word> words) -> {
                            DefaultListModel<String> listModel = new DefaultListModel<>();
                            for (Word word : words) {
                                listModel.addElement(word.getSelf() + "出现在" + word.getPosByPages() + "页第" + word.getPosByLines() + "行");
                            }
                            mainViewFrame.getHashList().setModel(listModel);
                            searchDialog.dispose();
                        });
                    } catch (NullPointerException exc) {
                        JOptionPane.showMessageDialog(null, "没有搜索到该单词！",
                                "错误", JOptionPane.WARNING_MESSAGE);
                    }
                });
                searchDialog.getCancelButton().addActionListener((ActionEvent event) -> {
                    searchDialog.dispose();
                });
                hashExist = false;
                hashIndex = -1;
            } else {
                JOptionPane.showMessageDialog(null, "请先加载程序！",
                        "错误", JOptionPane.WARNING_MESSAGE);
            }
        };
    }

    @SuppressWarnings("unchecked")
    public ActionListener getTreeSearchListener() {
        return (ActionEvent e) -> {
            if(dataAdder.getTreeManager().isInitial() && dataAdder.getTreeManager().isInitial()) {
                SearchDialog searchDialog = new SearchDialog(mainViewFrame);
                searchDialog.getDialogPane().removePropertyChangeListener(searchDialog.getDialogPane().getPropertyChangeListeners()[0]);
                searchDialog.getDialogPane().setBorder(Borders.DIALOG);
                searchDialog.setVisible(true);
                searchDialog.getOkButton().addActionListener((ActionEvent event) -> {
                    searchWord = searchDialog.getSearchEdit().getText();
                    try {
                        dataAdder.getTreeManager().searchDSTable(searchWord, (MyLinkedList<Word> words) -> {
                            DefaultListModel<String> listModel = new DefaultListModel<>();
                            for (Word word : words) {
                                listModel.addElement(word.getSelf() + "出现在" + word.getPosByPages() + "页第" + word.getPosByLines() + "行");
                            }
                            mainViewFrame.getTreeList().setModel(listModel);
                        });
                        searchDialog.dispose();
                    } catch (NullPointerException exc) {
                        JOptionPane.showMessageDialog(null, "没有搜索到该单词！",
                                "错误", JOptionPane.WARNING_MESSAGE);
                    }
                });
                searchDialog.getCancelButton().addActionListener((ActionEvent event) -> {
                    searchDialog.dispose();
                });
                treeExist = false;
                treeIndex = -1;
            } else {
                JOptionPane.showMessageDialog(null, "请先加载程序！",
                        "错误", JOptionPane.WARNING_MESSAGE);
            }
        };
    }

    @SuppressWarnings("unchecked")
    public ActionListener getHashLookUpListener() {
        return (ActionEvent e) -> {
            if(dataAdder.getTreeManager().isInitial() && dataAdder.getTreeManager().isInitial()) {
                String lookUpWord = mainViewFrame.getHashLookUpEdit().getText();
                if(lookUpWord.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "请输入想要查看的单词！",
                            "错误", JOptionPane.WARNING_MESSAGE);
                } else {
                    ListModel<String> listModel = mainViewFrame.getHashList().getModel();
                    if(lastHashWord != null) {
                        if(!lastHashWord.equals(lookUpWord)) {
                            hashIndex = -1;
                            hashExist = false;
                        }
                    }
                    lastHashWord = lookUpWord;
                    while(true) {
                        if(hashIndex == listModel.getSize() - 1) {
                            if(!hashExist) {
                                JOptionPane.showMessageDialog(null, "没有该单词！",
                                        "错误", JOptionPane.WARNING_MESSAGE);
                                break;
                            }
                            hashIndex = -1;
                        }
                        hashIndex++;
                        if(listModel.getElementAt(hashIndex).split("[^\\x00-\\xff]")[0].equals(lookUpWord)) {
                            mainViewFrame.getHashList().setSelectedIndex(hashIndex);
                            mainViewFrame.getHashList().ensureIndexIsVisible(hashIndex);
                            hashExist = true;
                            break;
                        }
                    }
                }
            } else {
                JOptionPane.showMessageDialog(null, "请先加载程序！",
                        "错误", JOptionPane.WARNING_MESSAGE);
            }
        };
    }

    @SuppressWarnings("unchecked")
    public ActionListener getTreeLookUpListener() {
        return (ActionEvent e) -> {
            if(dataAdder.getTreeManager().isInitial() && dataAdder.getTreeManager().isInitial()) {
                String lookUpWord = mainViewFrame.getTreeLookUpEdit().getText();
                if(lookUpWord.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "请输入想要查看的单词！",
                            "错误", JOptionPane.WARNING_MESSAGE);
                } else {
                    ListModel<String> listModel = mainViewFrame.getTreeList().getModel();
                    if(lastTreeWord != null) {
                        if(!lastTreeWord.equals(lookUpWord)) {
                            treeIndex = -1;
                            treeExist = false;
                        }
                    }
                    lastTreeWord = lookUpWord;
                    while(true) {
                        if(treeIndex == listModel.getSize() - 1) {
                            if(!treeExist) {
                                JOptionPane.showMessageDialog(null, "没有该单词！",
                                        "错误", JOptionPane.WARNING_MESSAGE);
                                break;
                            }
                            treeIndex = -1;
                        }
                        treeIndex++;
                        if(listModel.getElementAt(treeIndex).split("[^\\x00-\\xff]")[0].equals(lookUpWord)) {
                            mainViewFrame.getTreeList().setSelectedIndex(treeIndex);
                            mainViewFrame.getTreeList().ensureIndexIsVisible(treeIndex);
                            treeExist = true;
                            break;
                        }
                    }
                }
            } else {
                JOptionPane.showMessageDialog(null, "请先加载程序！",
                        "错误", JOptionPane.WARNING_MESSAGE);
            }
        };
    }

    public void changeBorder(String title) {
        if(mainViewFrame.getPanel3().getPropertyChangeListeners().length == 5) {
            mainViewFrame.getPanel3().removePropertyChangeListener(mainViewFrame.getPanel3().getPropertyChangeListeners()[0]);
        }
        mainViewFrame.getPanel3().setBorder(null);
        mainViewFrame.getPanel3().setBorder(new javax.swing.border.CompoundBorder(
                new javax.swing.border.TitledBorder(new javax.swing.border.EmptyBorder(0, 0, 0, 0),
                        title, javax.swing.border.TitledBorder.CENTER,
                        javax.swing.border.TitledBorder.BOTTOM, new java.awt.Font("Dialog", Font.BOLD, 12),
                        Color.black), mainViewFrame.getPanel3().getBorder()));

        mainViewFrame.getPanel4().setBorder(null);
        mainViewFrame.getPanel4().setBorder(new javax.swing.border.CompoundBorder(
                new javax.swing.border.TitledBorder(new javax.swing.border.EmptyBorder(0, 0, 0, 0),
                        title, javax.swing.border.TitledBorder.CENTER,
                        javax.swing.border.TitledBorder.BOTTOM, new java.awt.Font("Dialog", Font.BOLD, 12),
                        Color.black), mainViewFrame.getPanel4().getBorder()));
    }

}
