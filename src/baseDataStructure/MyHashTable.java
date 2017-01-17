package baseDataStructure;

import java.io.*;
import java.lang.reflect.Array;

/**
 * Created by tangyifeng on 17/1/17.
 * Email: yifengtang_hust@outlook.com
 */
public class MyHashTable<K, V> implements Serializable {

    private static final long serialVersionUID = 20170116L;
    private static final int DEFAULT_SIZE = 20;
    private static final int HASH_SEED = 20170117;

    private transient HashEntry[] table;
    private transient int size;
    private transient int length;
    private transient int count;
    private transient int numOfWord;

    @SuppressWarnings("unchecked")
    public MyHashTable() {
        size = DEFAULT_SIZE;
        length = (int) Math.pow(2, size) - 1;
        table = (HashEntry[]) Array.newInstance(HashEntry.class, length);// WOW! UNBELIEVABLE!
        count = 0;
        numOfWord = 0;
    }

    public V get(K k) {
        HashEntry entry = find(k);
        return (entry == null) ? null : entry.value;
    }

    public void set(K k, V v) {
        HashEntry entry = find(k);
        if(entry == null) {
            add(k, v);
            numOfWord ++;
        } else {
            entry.value = v;
        }
    }

    public V remove(K k) {
        int pos = indexFor(hash(k), length);
        if(table[pos] == null)
            return null;
        HashEntry p = table[pos];
        while(p.next != null) {
            HashEntry front = p;
            p = p.next;
            if(p.key.equals(k)) {
                V value = p.value;
                front.next = p.next;
                count--;
                return value;
            }
        }
        return null;
    }

    private HashEntry find(K k) {
        int pos = indexFor(hash(k), length);
        if(table[pos] == null)
            return null;
        HashEntry p = table[pos];
        while(p.next != null) {
            p = p.next;
            if(p.key.equals(k)) {
                return p;
            }
        }
        return null;
    }

    public MyLinkedList<V> getAll() {
        MyLinkedList<V> all = new MyLinkedList<V>();
        for(int i = 0; i < table.length; i++) {
            if(table[i] != null) {
                HashEntry entry = table[i];
                while(entry.next != null) {
                    entry = entry.next;
                    all.add(entry.value);
                }
            }
        }
        return all;
    }

    private void add(K k, V v) {
        int pos = indexFor(hash(k), length);
        if(table[pos] == null) {
            table[pos] = new HashEntry(null, null);
            count++;
        }
        HashEntry p = table[pos];
        p.length ++;
        while(p.next != null) {
            p = p.next;
        }
        p.next = new HashEntry(k, v);
    }

    private int hash(K k) {
        int h = HASH_SEED ^ k.hashCode();
        h ^= (h >>> 20) ^ (h >>> 12);
        return h ^ (h >>> 6) ^ (h >>> 4);
    }

    private static int indexFor(int h, int length) {
        return h & length;
    }

    // java.io.Serializable的写入函数
    // 将LinkedList的“容量，所有的元素值”都写入到输出流中
    private void writeObject(ObjectOutputStream s)
            throws java.io.IOException {
        // Write out any hidden serialization magic
        s.defaultWriteObject();

        // 写入“容量”
        s.writeInt(size);
        s.writeInt(count);
        s.writeInt(numOfWord);

        // 将链表中所有节点的数据都写入到输出流中
        for(int i = 0; i < table.length; i++) {
            if(table[i] != null) {
                HashEntry p = table[i];
                s.writeInt(i);
                s.writeInt(p.length);
                while(p.next != null) {
                    p = p.next;
                    s.writeObject(p.key);
                    s.writeObject(p.value);
                }
            }
        }
    }

    // java.io.Serializable的读取函数：根据写入方式反向读出
    // 先将LinkedList的“容量”读出，然后将“所有的元素值”读出
    @SuppressWarnings("unchecked")
    private void readObject(java.io.ObjectInputStream s)
            throws java.io.IOException, ClassNotFoundException {
        // Read in any hidden serialization magic
        s.defaultReadObject();

        // 从输入流中读取“容量”
        size = s.readInt();
        count = s.readInt();
        numOfWord = s.readInt();

        length = (int) Math.pow(2, size) - 1;

        // 新建链表表头节点
        table = (HashEntry[]) Array.newInstance(HashEntry.class, length);
        // 从输入流中将“所有的元素值”并逐个添加到链表中
        for(int i = 0; i < count; i++) {
            int pos = s.readInt();
            int length = s.readInt();
            table[pos] = new HashEntry(null, null);
            table[pos].length = length;
            HashEntry p = table[pos];
            for(int j = 0; j < length; j++) {
                HashEntry q = new HashEntry((K) s.readObject(), (V) s.readObject());
                p.next = q;
                p = q;
            }
        }
    }

    private class HashEntry {
        final K key;
        V value;
        HashEntry next;
        int length;
        private HashEntry(K key, V value) {
            this.key = key;
            this.value = value;
            length = 0;
            next = null;
        }
    }
}
