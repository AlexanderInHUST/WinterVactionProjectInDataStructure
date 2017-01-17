package model;

import baseDataStructure.MyHashTable;
import baseDataStructure.MyLinkedList;

import java.io.Serializable;

/**
 * Created by tangyifeng on 17/1/16.
 * Email: yifengtang_hust@outlook.com
 */
public class HashTable implements Serializable {

    private static final long serialVersionUID = 20170116L;

    private MyHashTable<String, MyLinkedList<Word>> hashTable;

    private HashTable() {
        hashTable = new MyHashTable<>();
    }

    public static HashTable initialHashTable() {
        return new HashTable();
    }

    public void addWord(Word word) {
        MyLinkedList<Word> data = hashTable.get(word.getSelf());
        if(data == null) {
            data = new MyLinkedList<>();
        }
        data.add(word);
        hashTable.set(word.getSelf(), data);
    }

    public MyLinkedList<Word> searchWord(Word word) {
        return hashTable.get(word.getSelf());
    }

    public boolean deleteWord(Word word) {
        return hashTable.remove(word.getSelf()) == null;
    }

    public MyLinkedList<Word> traverseHashTable() {
        MyLinkedList<Word> words = new MyLinkedList<>();
        for(MyLinkedList<Word> list : hashTable.getAll()) {
            for(Word word : list) {
                words.add(word);
            }
        }
        return words;
    }

    public MyHashTable<String, MyLinkedList<Word>> getHashTable() {
        return hashTable;
    }

    public void setHashTable(MyHashTable<String, MyLinkedList<Word>> hashTable) {
        this.hashTable = hashTable;
    }
 }
