package me.codetalk.restjsontest.vo;

/**
 * Created by Administrator on 2017/12/15.
 */

public class MetaVO {

    public static final int TYPE_CAT = 1;    // 分类
    public static final int TYPE_TAG = 2;    // 标签
    public static final int TYPE_GROUP = 3;  // 人群

    private int type;
    private String no;
    private String text;

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
