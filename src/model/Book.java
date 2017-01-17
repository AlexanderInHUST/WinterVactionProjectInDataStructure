package model;

import baseDataStructure.MyLinkedList;
import org.omg.CORBA.portable.InputStream;

import java.io.*;

/**
 * Created by tangyifeng on 17/1/16.
 * Email: yifengtang_hust@outlook.com
 */
public class Book implements Serializable{

    private static final long serialVersionUID = 20170116L;

    private static final int NO_CONTENTS = -1;
    private static final int DEFAULT_MAX_WORDS_PER_LINE = 5;
    private static final int DEFAULT_MAX_LINES_PER_PAGE = 5;

    private String contents;
    private MyLinkedList<Word> words;
    private int maxWordsPerLine;
    private int maxLinesPerPage;

    public static Book getBook(File file) {
        Book book = new Book();
        StringBuilder builder = new StringBuilder();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line;
            while((line = reader.readLine()) != null && !line.isEmpty()) {
                builder.append(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        book.contents = builder.toString();
        book.adaptStringToWordList();
        return book;
    }

    public static Book getBook(String contents) {
        Book book = new Book();
        book.contents = contents;
        book.adaptStringToWordList();
        return book;
    }

    public static Book getBook() {
        return new Book();
    }

    private Book() {
        words = new MyLinkedList<>();
        maxWordsPerLine = DEFAULT_MAX_WORDS_PER_LINE;
        maxLinesPerPage = DEFAULT_MAX_LINES_PER_PAGE;
    }

    private int adaptStringToWordList() {
        if(contents == null || contents.isEmpty())
            return NO_CONTENTS;
        String[] allWords = contents.split("[ .,?\"\n\t()\\-'!0-9:;]");
        for(int i = 0, j = 0; i < allWords.length; i++) {
            String s = allWords[i].trim();
            if(!s.isEmpty()) {
                Word word = new Word();
                word.setSelf(s.toLowerCase());
                word.setPosByLines(j / maxWordsPerLine);
                word.setPosByPages(word.getPosByLines() / maxLinesPerPage);
                word.setPos(j);
                words.add(word);
                j++;
            }
        }
        return words.size();
    }

    public String getContents() {
        return contents;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }

    public MyLinkedList<Word> getWords() {
        return words;
    }

    public void setWords(MyLinkedList<Word> words) {
        this.words = words;
    }

    public int getMaxWordsPerLine() {
        return maxWordsPerLine;
    }

    public void setMaxWordsPerLine(int maxWordsPerLine) {
        this.maxWordsPerLine = maxWordsPerLine;
    }

    public int getMaxLinesPerPage() {
        return maxLinesPerPage;
    }

    public void setMaxLinesPerPage(int maxLinesPerPage) {
        this.maxLinesPerPage = maxLinesPerPage;
    }

}
