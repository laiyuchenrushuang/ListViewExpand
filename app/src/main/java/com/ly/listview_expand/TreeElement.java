package com.ly.listview_expand;

import java.util.ArrayList;
/**
 * 元素 可根据需要添加新的属性
 */
public class TreeElement {
    /**
     * 各个元素的层级标识
     */
    private int parentLevel;
    /**
     * 节点显示标题
     */
    private String noteName;
    /**
     * 子节点元素集合
     */
    private ArrayList<TreeElement> dataList = new ArrayList<TreeElement>();
    /**
     * 是否已扩展
     */
    private boolean isExpandAble;
    /**
     * 是否有子节点元素
     */
    private boolean isHasChild;
    /**
     * 当前节点位置
     */
    private int position;

    /**
     *
     * @param parentLevel 各个元素的层级标识
     * @param noteName 节点显示标题
     * @param dataList 子节点元素集合
     * @param isExpandAble 是否已扩展
     * @param isHasChild 是否有子节点元素
     * @param position 当前节点位置
     */

    public TreeElement(int parentLevel, String noteName,
                       ArrayList<TreeElement> dataList, boolean isExpandAble,
                       boolean isHasChild, int position) {
        super();
        this.parentLevel = parentLevel;
        this.noteName = noteName;
        this.dataList = dataList;
        this.isExpandAble = isExpandAble;
        this.isHasChild = isHasChild;
        this.position = position;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public boolean isHasChild() {
        return isHasChild;
    }

    public void setHasChild(boolean isHasChild) {
        this.isHasChild = isHasChild;
    }



    public int getParentLevel() {
        return parentLevel;
    }

    public void setParentLevel(int parentLevel) {
        this.parentLevel = parentLevel;
    }

    public String getNoteName() {
        return noteName;
    }

    public void setNoteName(String noteName) {
        this.noteName = noteName;
    }


    public ArrayList<TreeElement> getDataList() {
        return dataList;
    }

    public void setDataList(ArrayList<TreeElement> dataList) {
        this.dataList = dataList;
    }

    public boolean isExpandAble() {
        return isExpandAble;
    }

    public void setExpandAble(boolean isExpandAble) {
        this.isExpandAble = isExpandAble;
    }



}

