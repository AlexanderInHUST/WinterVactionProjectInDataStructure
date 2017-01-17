package baseDataStructure;

import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created by tangyifeng on 17/1/16.
 * Email: yifengtang_hust@outlook.com
 */
public class MyLinkedList<T> implements Iterable<T>, Serializable{

    private static final long serialVersionUID = 20170116L;

    private transient MyLinkedNode head;
    private transient MyLinkedNode tail;
    private transient int size;

    public MyLinkedList(){
        head = new MyLinkedNode();
        tail = head;
        size = 0;
    }

    public void add(T object) {
        MyLinkedNode q = new MyLinkedNode(object);
        tail.next = q;
        tail = q;
        size++;
    }

    public boolean contains(T object) {
        MyLinkedNode p = head;
        while(p.next != null) {
            p = p.next;
            if(p.data.equals(object)) {
                return true;
            }
        }
        return false;
    }

    public T get(int pos) {
        MyLinkedNode p = head;
        int count = 0;
        while(p.next != null) {
            p = p.next;
            if(count++ == pos) {
                return p.data;
            }
        }
        return null;
    }

    public int size() {
        return size;
    }

    @Override
    public Iterator<T> iterator() {
        return new MyLinkedIterator();
    }

    // java.io.Serializable的写入函数
    // 将LinkedList的“容量，所有的元素值”都写入到输出流中
    private void writeObject(ObjectOutputStream s)
            throws java.io.IOException {
        // Write out any hidden serialization magic
        s.defaultWriteObject();

        // 写入“容量”
        s.writeInt(size);

        // 将链表中所有节点的数据都写入到输出流中
        if(size != 0) {
            for (MyLinkedNode e = head.next; e != null; e = e.next)
                s.writeObject(e.data);
        }
    }

    // java.io.Serializable的读取函数：根据写入方式反向读出
    // 先将LinkedList的“容量”读出，然后将“所有的元素值”读出

    private void readObject(java.io.ObjectInputStream s)
            throws java.io.IOException, ClassNotFoundException {
        // Read in any hidden serialization magic
        s.defaultReadObject();

        // 从输入流中读取“容量”
        int size = s.readInt();

        // 新建链表表头节点
        head = new MyLinkedNode();
        tail = head;

        // 从输入流中将“所有的元素值”并逐个添加到链表中
        if(size != 0) {
            for (int i = 0; i < size; i++)
                add((T) s.readObject());
        }
    }

    private class MyLinkedNode{
        T data;
        MyLinkedNode next;
        private MyLinkedNode() {}
        private MyLinkedNode(T data) {
            this.data = data;
        }
    }

    private class MyLinkedIterator implements Iterator<T> {

        private MyLinkedNode current = head;

        @Override
        public boolean hasNext() {
            return current != tail;
        }

        @Override
        public T next() {
            if(!hasNext()) {
                throw new NoSuchElementException();
            }
            current = current.next;
            return current.data;
        }
    }

}
