package presenter;

import baseDataStructure.MyLinkedList;
import model.Word;
import view.MainViewFrame;

/**
 * Created by tangyifeng on 17/1/31.
 * Email: yifengtang_hust@outlook.com
 */
public class AddData {

    private HashManager hashManager;
    private TreeManager treeManager;
    private MainViewFrame mainViewFrame;

    private String maxWord;
    private int maxCount;

    public AddData(MainViewFrame MainViewFrame) {
        this.mainViewFrame = MainViewFrame;
        hashManager = HashManager.getHashManager();
        treeManager = TreeManager.getTreePresenter();

    }

    public synchronized void loadInfo() {
        getTreeWordsNum();
        getTreeVocaNum();
        getTreeMostNum();
        getTreeFirstAndLast();

        getHashWordsNum();
        getHashVocaNum();
        getHashMostNum();
        getHashFirstAndLast();
    }

    private void getTreeWordsNum() {
        treeManager.getAllWordsDSTable((MyLinkedList<Word> words) -> {
            String result = "总词数：";
            mainViewFrame.getTreeWordsNumText().setText(result + words.size());
        });
    }

    private void getHashWordsNum() {
        hashManager.getAllWordsHash((MyLinkedList<Word> words) -> {
            String result = "总词数：";
            mainViewFrame.getHashWordsNumText().setText(result + words.size());
        });
    }

    private void getTreeVocaNum() {
        treeManager.traverseDSTable((MyLinkedList<Word> words) -> {
            String result = "总词量：";
            mainViewFrame.getTreeVacaNumText().setText(result + words.size());
        });
    }

    private void getHashVocaNum() {
        hashManager.traverseHash((MyLinkedList<Word> words) -> {
            String result = "总词量：";
            mainViewFrame.getHashVacaNumText().setText(result + words.size());
        });
    }

    private void getTreeMostNum() {
        String result = "出现最多词：";
        treeManager.traverseDSTable((MyLinkedList<Word> words) -> {
            maxWord = "";
            maxCount = 0;
            for (Word word : words) {
                treeManager.searchDSTable(word.getSelf(), (MyLinkedList<Word> searchList) -> {
                    if (searchList.size() > maxCount) {
                        maxWord = word.getSelf();
                        maxCount = searchList.size();
                    }
                });
            }
            mainViewFrame.getTreeMostText().setText(result + maxWord + "共" + maxCount + "次");
        });
    }

    private void getHashMostNum() {
        String result = "出现最多词：";
        hashManager.traverseHash((MyLinkedList<Word> words) -> {
            maxWord = "";
            maxCount = 0;
            for (Word word : words) {
                hashManager.searchHash(word.getSelf(), (MyLinkedList<Word> searchList) -> {
                    if (searchList.size() > maxCount) {
                        maxWord = word.getSelf();
                        maxCount = searchList.size();
                    }
                });
            }
            mainViewFrame.getHashMostText().setText(result + maxWord + "共" + maxCount + "次");
        });
    }

    private void getTreeFirstAndLast() {
        String resultFirst = "第一个词：";
        String resultLast = "最后一个词：";
        treeManager.getAllWordsDSTable((MyLinkedList<Word> searchList) -> {
            mainViewFrame.getTreeFirstText().setText(resultFirst + searchList.get(0).getSelf());
            mainViewFrame.getTreeLastText().setText(resultLast + searchList.get(searchList.size() - 1).getSelf());
        });
    }

    private void getHashFirstAndLast() {
        String resultFirst = "第一个词：";
        String resultLast = "最后一个词：";
        hashManager.getAllWordsHash((MyLinkedList<Word> searchList) -> {
            mainViewFrame.getHashFirstText().setText(resultFirst + searchList.get(0).getSelf());
            mainViewFrame.getHashLastText().setText(resultLast + searchList.get(searchList.size() - 1).getSelf());
        });
    }

    public HashManager getHashManager() {
        return hashManager;
    }

    public TreeManager getTreeManager() {
        return treeManager;
    }
}
