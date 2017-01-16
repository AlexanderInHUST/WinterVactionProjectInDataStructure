package model;

import java.io.Serializable;

/**
 * Created by tangyifeng on 17/1/16.
 * Email: yifengtang_hust@outlook.com
 */
public class Word implements Serializable{

    private static final long serialVersionUID = 20170116;

    private String self;
    private int posByLines;
    private int posByPages;
    private int pos;

    @Override
    @SuppressWarnings("unchecked")
    public boolean equals(Object object) {
        boolean equals = true;
        Word obj = (Word) object;
        if(!getSelf().equals(obj.getSelf())) {
            equals = false;
        }
        return equals;
    }

    public String getSelf() {
        return self;
    }

    public void setSelf(String self) {
        this.self = self;
    }

    public int getPosByLines() {
        return posByLines;
    }

    public void setPosByLines(int posByLines) {
        this.posByLines = posByLines;
    }

    public int getPosByPages() {
        return posByPages;
    }

    public void setPosByPages(int posByPages) {
        this.posByPages = posByPages;
    }

    public int getPos() {
        return pos;
    }

    public void setPos(int pos) {
        this.pos = pos;
    }

}
