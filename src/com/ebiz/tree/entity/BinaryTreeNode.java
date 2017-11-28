/**
 * Copyright ®2017 Ebiz-Interactive<br/>
 * Package:  com.ebiz.tree<br/>
 * FileName: BinaryTree.java<br/>
 * Description: Ebiz-Unisys<br/>
 */
package com.ebiz.tree.entity;


/**
 * 【类或接口功能描述】
 *
 * @author cao.qifa 
 * @date 2017年11月27日 
 * @version 1.0
 */
public class BinaryTreeNode {
    private Object value;
    private BinaryTreeNode leftChild;
    private BinaryTreeNode rightChild;
    public BinaryTreeNode() {}
    public BinaryTreeNode(Object value) {
        this.leftChild = null;
        this.rightChild = null;
        this.value = value;
    }
    
    /**
     * @return the value
     */
    public Object getValue() {
        return value;
    }
    
    /**
     * @param value the value to set
     */
    public void setValue(Object value) {
        this.value = value;
    }
    
    /**
     * @return the leftChild
     */
    public BinaryTreeNode getLeftChild() {
        return leftChild;
    }
    
    /**
     * @param leftChild the leftChild to set
     */
    public void setLeftChild(BinaryTreeNode leftChild) {
        this.leftChild = leftChild;
    }
    
    /**
     * @return the rightChild
     */
    public BinaryTreeNode getRightChild() {
        return rightChild;
    }
    
    /**
     * @param rightChild the rightChild to set
     */
    public void setRightChild(BinaryTreeNode rightChild) {
        this.rightChild = rightChild;
    }
    
}
