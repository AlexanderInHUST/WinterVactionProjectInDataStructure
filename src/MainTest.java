import baseDataStructure.MyLinkedList;
import model.Word;
import presenter.HashManager;

/**
 * Created by tangyifeng on 17/1/16.
 * Email: yifengtang_hust@outlook.com
 */
public class MainTest {

    public static void main(String args[]) {
//        TreeManager manager = TreeManager.getTreePresenter();
//        manager.initDSTable("/Users/tangyifeng/bible");
////        manager.loadDSTable("/Users/tangyifeng/data.saved");
//        System.out.println("Initial done.");
//        manager.insertDSTable("asd", 1000000);
//        System.out.println("Insert done.");
//        manager.searchDSTable("a", (MyLinkedList<Word> words) -> {
//            System.out.println(words.size());
//        });
//        System.out.println("Search done.");
//        manager.traverseDSTable((MyLinkedList<Word> words) -> {
//            System.out.println(words.size());
//        });
//        System.out.println("Traverse done.");
//        manager.getAllWordsDSTable((MyLinkedList<Word> words) -> {
//            System.out.println(words.size());
//        });
//        System.out.println("Get done.");
////        manager.saveDSTable("/Users/tangyifeng/data.saved");
//        System.out.println("Save done.");

        HashManager manager = HashManager.getHashManager();
//        manager.initHash("/Users/tangyifeng/bible");
        manager.loadHash("/Users/tangyifeng/data.saved");
        System.out.println("Initial done.");
        manager.insertHash("asd", 1000000);
        System.out.println("Insert done.");
        manager.searchHash("a", (MyLinkedList<Word> words) -> {
            System.out.println(words.size());
        });
        System.out.println("Search done.");
        manager.traverseHash((MyLinkedList<Word> words) -> {
            System.out.println(words.size());
        });
        System.out.println("Traverse done.");
        manager.getAllWordsHash((MyLinkedList<Word> words) -> {
            System.out.println(words.size());
        });
        System.out.println("Get done.");
//        manager.saveHash("/Users/tangyifeng/data.saved");
        System.out.println("Save done.");

    }
}
