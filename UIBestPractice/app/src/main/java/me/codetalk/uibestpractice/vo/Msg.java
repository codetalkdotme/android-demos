package me.codetalk.uibestpractice.vo;

/**
 * Created by Administrator on 2017/12/14.
 */

public class Msg {

    public static final int TYPE_RECV = 1;
    public static final int TYPE_SEND = 2;

    private String content;
    private int type;

    public Msg(String content, int type) {
        this.content = content;
        this.type = type;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
