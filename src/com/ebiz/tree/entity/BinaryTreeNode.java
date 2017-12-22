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
 * @param <E>
 */
public class BinaryTreeNode<E> {
    private E value;
    private BinaryTreeNode<E> leftChild;
    private BinaryTreeNode<E> rightChild;
    public BinaryTreeNode() {}
    public BinaryTreeNode(E value) {
        this.leftChild = null;
        this.rightChild = null;
        this.value = value;
    }
    
    /**
     * @return the value
     */
    public E getValue() {
        return value;
    }
    
    /**
     * @param value the value to set
     */
    public void setValue(E value) {
        this.value = value;
    }
    
    /**
     * @return the leftChild
     */
    public BinaryTreeNode<E> getLeftChild() {
        return leftChild;
    }
    
    /**
     * @param leftChild the leftChild to set
     */
    public void setLeftChild(BinaryTreeNode<E> leftChild) {
        this.leftChild = leftChild;
    }
    
    /**
     * @return the rightChild
     */
    public BinaryTreeNode<E> getRightChild() {
        return rightChild;
    }
    
    /**
     * @param rightChild the rightChild to set
     */
    public void setRightChild(BinaryTreeNode<E> rightChild) {
        this.rightChild = rightChild;
    }
    
}
