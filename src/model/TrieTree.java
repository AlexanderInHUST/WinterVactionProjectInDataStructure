package model;

import baseDataStructure.MyLinkedList;
import com.sun.istack.internal.Nullable;

import java.io.Serializable;
import java.util.LinkedList;

/**
 * Created by tangyifeng on 17/1/16.
 * Email: yifengtang_hust@outlook.com
 */
public class TrieTree implements Serializable {

    private static final long serialVersionUID = 20170116;

    private TrieTree[] children;
    private LinkedList<Word> wordList;

    private TrieTree() {
        wordList = new LinkedList<>();
    }

    public static TrieTree initialTireTree() {
        return new TrieTree();
    }

    public void destroyTireTree() {
        children = null;
        wordList = null;
    }

    public void addWord(Word word) {
        addWord(word, word.getSelf());
    }

    public boolean deleteWord(Word word) {
        return deleteWord(word, word.getSelf());
    }

    public LinkedList<Word> searchWord(Word word) {
        return searchWord(word, word.getSelf());
    }

    public LinkedList<Word> traverseTrieTree() {
        LinkedList<Word> allWords = new LinkedList<>();
        traverseTrieTree(allWords);
        return allWords;
    }

    @Nullable
    private void traverseTrieTree(LinkedList<Word> allWords) {
        if(wordList.size() != 0)
            allWords.add(wordList.get(0));
        if(children != null) {
            for (TrieTree child : children) {
                if(child != null)
                    child.traverseTrieTree(allWords);
            }
        }
    }

    @Nullable
    private LinkedList<Word> searchWord(Word word, String subWord) {
        if(wordList == null)
            return null;
        if(subWord.length() == 0) {
            if(wordList.contains(word)) {
                return wordList;
            }
            return null;
        } else {
            return children[subWord.charAt(0) - 'a'].searchWord(word, subWord.substring(1));
        }
    }

    private boolean deleteWord(Word word, String subWord) {
        if(subWord.length() == 0) {
            if(wordList == null || !wordList.contains(word))
                return false;
            wordList = new LinkedList<>();
            return true;
        } else {
            return children[subWord.charAt(0) - 'a'].deleteWord(word, subWord.substring(1));
        }
    }

    private void addWord(Word word, String subWord) {
        if(subWord.length() == 0) {
            wordList.add(word);
        } else {
            if(children == null)
                children = new TrieTree[26];
            if(children[subWord.charAt(0) - 'a'] == null)
                children[subWord.charAt(0) - 'a'] = new TrieTree();
            children[subWord.charAt(0) - 'a'].addWord(word, subWord.substring(1));
        }
    }

    public TrieTree[] getChildren() {
        return children;
    }

    public void setChildren(TrieTree[] children) {
        this.children = children;
    }

    public LinkedList<Word> getWordList() {
        return wordList;
    }

    public void setWordList(LinkedList<Word> wordList) {
        this.wordList = wordList;
    }
}
