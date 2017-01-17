package presenter;

import baseDataStructure.MyLinkedList;
import com.sun.istack.internal.Nullable;
import model.Book;
import model.HashTable;
import model.Word;

import java.io.*;

/**
 * Created by tangyifeng on 17/1/17.
 * Email: yifengtang_hust@outlook.com
 */
public class HashManager {

    private HashTable table;
    private static HashManager manager;
    private Book book;

    public interface OnTraverseListener {
        public void onTraverse(MyLinkedList<Word> words);
    }

    public interface OnSearchListener {
        public void onSearch(MyLinkedList<Word> words);
    }

    private HashManager() {}

    public static HashManager getHashManager() {
        manager = new HashManager();
        return manager;
    }

    public void initHash(String fileAddress) {
        File bookFile = new File(fileAddress);
        if (bookFile.exists()) {
            book = Book.getBook(bookFile);
        } else {
            book = Book.getBook(fileAddress);
        }
        table = HashTable.initialHashTable();
        for(Word word : book.getWords()) {
            table.addWord(word);
        }
        System.out.println("Hash has been initial successfully!");
    }

    public boolean destroyHash() {
        if(table == null) {
            return false;
        }
        table = null;
        return true;
    }

    public boolean searchHash(String word, OnSearchListener listener) {
        if(table == null) {
            return false;
        }
        Word searchWord = new Word();
        searchWord.setSelf(word);
        MyLinkedList<Word> words = table.searchWord(searchWord);
        listener.onSearch(words);
        return true;
    }

    public boolean insertHash(String word, int pos) {
        if (table == null)
            return false;
        Word insertWord = new Word();
        insertWord.setPos(pos);
        insertWord.setPosByLines(pos / book.getMaxWordsPerLine());
        insertWord.setPosByPages(insertWord.getPosByLines() / book.getMaxLinesPerPage());
        insertWord.setSelf(word);
        table.addWord(insertWord);
        return true;
    }

    public boolean insertHash(String word, int posInLine, int posByLines, int posByPage) {
        if (table == null)
            return false;
        Word insertWord = new Word();
        insertWord.setSelf(word);
        insertWord.setPos((posByLines - 1) * book.getMaxWordsPerLine() + posInLine);
        insertWord.setPosByLines(posByLines);
        insertWord.setPosByPages(posByPage);
        table.addWord(insertWord);
        return true;
    }

    public boolean deleteHash(String word) {
        if (table == null)
            return false;
        Word deleteWord = new Word();
        deleteWord.setSelf(word);
        table.deleteWord(deleteWord);
        return true;
    }

    public boolean traverseHash(OnTraverseListener listener) {
        if(table == null) {
            return false;
        }
        MyLinkedList<Word> words = table.traverseHashTable();
        listener.onTraverse(words);
        return true;
    }

    public boolean saveHash(@Nullable String saveAddress) {
        try {
            String address = (saveAddress == null) ? "data.saved" : saveAddress;
            ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(address));
            outputStream.writeObject(table);
            outputStream.writeObject(book);
            outputStream.flush();
            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public boolean loadHash(@Nullable String saveAddress) {
        try{
            String address = (saveAddress == null) ? "data.saved" : saveAddress;
            ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(address));
            table = HashTable.initialHashTable();
            book = Book.getBook();
            table = (HashTable) inputStream.readObject();
            book = (Book) inputStream.readObject();
            inputStream.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return false;
        }
        System.out.println("Hash has been load successfully!");
        return true;
    }
}
