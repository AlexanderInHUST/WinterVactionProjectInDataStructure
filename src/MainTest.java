import baseDataStructure.MyLinkedList;
import model.Word;
import presenter.TreeManager;

import java.sql.Time;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;
import java.util.concurrent.TimeUnit;

/**
 * Created by tangyifeng on 17/1/16.
 * Email: yifengtang_hust@outlook.com
 */
public class MainTest {

    public static void main(String args[]) {
        TreeManager manager = TreeManager.getTreePresenter();
        manager.initDSTable("/Users/tangyifeng/bible");
//        manager.loadDSTable("/Users/tangyifeng/data.saved");
        System.out.println("Initial done.");
        manager.insertDSTable("asd", 1000000);
        System.out.println("Insert done.");
        manager.searchDSTable("a", (MyLinkedList<Word> words) -> {
            System.out.println(words.size());
        });
        System.out.println("Search done.");
        manager.traverseDSTable((MyLinkedList<Word> words) -> {
            System.out.println(words.size());
        });
        System.out.println("Traverse done.");
        manager.getAllWordsDSTable((MyLinkedList<Word> words) -> {
            System.out.println(words.size());
        });
        System.out.println("Get done.");
//        manager.saveDSTable("/Users/tangyifeng/data.saved");
        System.out.println("Save done.");
    }
}
