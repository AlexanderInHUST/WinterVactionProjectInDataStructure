package presenter;

import baseDataStructure.MyLinkedList;
import com.sun.istack.internal.Nullable;
import model.Book;
import model.TrieTree;
import model.Word;

import javax.swing.*;
import java.io.*;

/**
 * Created by tangyifeng on 17/1/16.
 * Email: yifengtang_hust@outlook.com
 */
public class TreeManager{

    private TrieTree root;
    private Book book;
    private static TreeManager manager;

    private boolean isInit = false;

    public interface OnSaveCompleteListener {
        public void onSuccess();
        public void onFailure();
    }

    public interface OnLoadCompleteListener {
        public void onSuccess();
        public void onFailure();
    }

    public interface OnTraverseListener {
        public void onTraverse(MyLinkedList<Word> words);
    }

    public interface OnSearchListener {
        public void onSearch(MyLinkedList<Word> words);
    }

    private TreeManager() {
    }

    public boolean isInitial() {
        return isInit;
    }

    public static TreeManager getTreePresenter() {
        if(manager == null)
            manager = new TreeManager();
        return manager;
    }

    public void initDSTable(String fileAddress, OnLoadCompleteListener onLoadCompleteListener) {
        File bookFile = new File(fileAddress);
        if (bookFile.exists()) {
            book = Book.getBook(bookFile);
        } else {
            book = Book.getBook(fileAddress);
        }
        root = TrieTree.initialTireTree();
        for (Word word : book.getWords()) {
            root.addWord(word);
        }
        isInit = true;
        SwingUtilities.invokeLater(onLoadCompleteListener::onSuccess);
        System.out.println("Trie tree has been initial successfully!");
    }

    public boolean destroyTable() {
        if (root == null) {
            return false;
        }
        root.destroyTireTree();
        book = null;
        isInit = false;
        return true;
    }

    public boolean searchDSTable(String word, OnSearchListener searchListener) throws NullPointerException{
        if (root == null)
            return false;
        Word searchWord = new Word();
        searchWord.setSelf(word);
        MyLinkedList<Word> words = root.searchWord(searchWord);
        searchListener.onSearch(words);
        return true;
    }

    public boolean insertDSTable(String word, int pos) {
        if (root == null)
            return false;
        Word insertWord = new Word();
        insertWord.setPos(pos);
        insertWord.setPosByLines(pos / book.getMaxWordsPerLine());
        insertWord.setPosByPages(insertWord.getPosByLines() / book.getMaxLinesPerPage());
        insertWord.setSelf(word);
        root.addWord(insertWord);
        return true;
    }

    public boolean insertDSTable(String word, int posInLine, int posByLines, int posByPage) {
        if (root == null)
            return false;
        Word insertWord = new Word();
        insertWord.setSelf(word);
        insertWord.setPos((posByLines - 1) * book.getMaxWordsPerLine() + posInLine);
        insertWord.setPosByLines(posByLines);
        insertWord.setPosByPages(posByPage);
        root.addWord(insertWord);
        return true;
    }

    public boolean deleteDSTable(String word) {
        if (root == null)
            return false;
        Word deleteWord = new Word();
        deleteWord.setSelf(word);
        root.deleteWord(deleteWord);
        return true;
    }

    public boolean traverseDSTable(OnTraverseListener traverseListener) {
        if (root == null)
            return false;
        MyLinkedList<Word> words = root.traverseTrieTree();
        traverseListener.onTraverse(words);
        return true;
    }

    public boolean getAllWordsDSTable(OnTraverseListener traverseListener) {
        if (root == null)
            return false;
        MyLinkedList<Word> words = book.getWords();
        traverseListener.onTraverse(words);
        return true;
    }

    public boolean saveDSTable(@Nullable String saveAddress, OnSaveCompleteListener onSaveCompleteListener) {
        try {
            String address = (saveAddress == null) ? "data.saved.tree" : saveAddress + ".saved.tree";
            ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(address));
            outputStream.writeObject(root);
            outputStream.writeObject(book);
            outputStream.flush();
            outputStream.close();
            SwingUtilities.invokeLater(onSaveCompleteListener::onSuccess);
        } catch (IOException e) {
            SwingUtilities.invokeLater(onSaveCompleteListener::onFailure);
            e.printStackTrace();
            return false;
        }
        System.out.println("Trie tree has been save successfully!");
        return true;
    }

    public boolean loadDSTable(@Nullable String saveAddress, OnLoadCompleteListener onLoadCompleteListener) {
        try{
            String address = (saveAddress == null) ? "data.saved.tree" : saveAddress;
            ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(address));
            root = TrieTree.initialTireTree();
            book = Book.getBook();
            root = (TrieTree) inputStream.readObject();
            book = (Book) inputStream.readObject();
            inputStream.close();
            isInit = true;
            SwingUtilities.invokeLater(onLoadCompleteListener::onSuccess);
        } catch (IOException | ClassNotFoundException e) {
            SwingUtilities.invokeLater(onLoadCompleteListener::onFailure);
            e.printStackTrace();
            return false;
        }
        System.out.println("Trie tree has been load successfully!");
        return true;
    }
}
