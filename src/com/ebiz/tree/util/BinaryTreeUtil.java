/**
 * Copyright ®2017 Ebiz-Interactive<br/>
 * Package:  com.ebiz.tree.util<br/>
 * FileName: BinaryTreeUtil.java<br/>
 * Description: Ebiz-Unisys<br/>
 */
package com.ebiz.tree.util;

import java.util.ArrayList;
import java.util.List;

import com.ebiz.tree.entity.BinaryTreeNode;

/**
 * 二叉树工具
 *
 * @author cao.qifa 
 * @date 2017年11月27日 
 * @version 1.0
 */
public class BinaryTreeUtil {
    
    /**
     * 前序遍历
     * 针对给定节点，先自身，然后遍历左子节点，最后遍历又子节点，并且对每个子节点同样方式遍历
     *
     * @param tree
     * @return
     * @date 2017年11月27日 
     */
    public static List<Object> preOrder(BinaryTreeNode treeNode){
        List<Object> nodeValueLst = new ArrayList<>();
        if(treeNode != null) {
            nodeValueLst.add(treeNode.getValue());
            preOrder(treeNode.getLeftChild());
            preOrder(treeNode.getRightChild());
        }
        return nodeValueLst;
    }
    /**
     * 中序遍历
     * 先遍历最左子树的最左叶子节点，然后自身，最后后以同样方式遍历右子节点
     *
     * @param treeNode
     * @return
     * @date 2017年11月27日 
     */
    public static List<Object> inOrder(BinaryTreeNode treeNode){
        List<Object> nodeValueLst = new ArrayList<>();
        if(treeNode != null) {
            preOrder(treeNode.getLeftChild());
            nodeValueLst.add(treeNode.getValue());
            preOrder(treeNode.getRightChild());
        }
        return nodeValueLst;
    }
    /**
     * 后续遍历
     * 先做子节点，然后右子节点，最后自身
     *
     * @param treeNode
     * @return
     * @date 2017年11月27日 
     */
    public static List<Object> postOrder(BinaryTreeNode treeNode){
        List<Object> nodeValueLst = new ArrayList<>();
        if(treeNode != null) {
            preOrder(treeNode.getLeftChild());
            preOrder(treeNode.getRightChild());
            nodeValueLst.add(treeNode.getValue());
        }
        return nodeValueLst;
    }
}
