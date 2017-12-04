/**
 * Copyright ®2017 Ebiz-Interactive<br/>
 * Package:  com.ebiz.tree.util<br/>
 * FileName: BinaryTreeUtil.java<br/>
 * Description: Ebiz-Unisys<br/>
 */
package com.ebiz.tree.util;

import java.util.ArrayDeque;
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
     * @param <T>
     *
     * @param tree
     * @return
     * @date 2017年11月27日 
     */
    public static <T> List<T> preOrder(BinaryTreeNode<T> treeNode){
        List<T> nodeValueLst = new ArrayList<>();
        if(treeNode != null) {
            nodeValueLst.add(treeNode.getValue());
            nodeValueLst.addAll(preOrder(treeNode.getLeftChild()));
            nodeValueLst.addAll(preOrder(treeNode.getRightChild()));
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
    public static <T> List<T> inOrder(BinaryTreeNode<T> treeNode){
        List<T> nodeValueLst = new ArrayList<>();
        if(treeNode != null) {
            
            nodeValueLst.addAll(inOrder(treeNode.getLeftChild()));
            nodeValueLst.add(treeNode.getValue());
            nodeValueLst.addAll(inOrder(treeNode.getRightChild()));
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
    public static<T> List<T> postOrder(BinaryTreeNode<T> treeNode){
        List<T> nodeValueLst = new ArrayList<>();
        if(treeNode != null) {
            nodeValueLst.addAll(postOrder(treeNode.getLeftChild()));
            nodeValueLst.addAll(postOrder(treeNode.getRightChild()));
            nodeValueLst.add(treeNode.getValue());
        }
        return nodeValueLst;
    }
    
    
    /**
     * 广度优先遍历二叉树(借用双端队列ArrayDeque的队列性质)
     *
     * @param treeNode
     * @return
     * @date 2017年12月1日 
     */
    public static <T> List<T> levelOrder(BinaryTreeNode<T> treeNode){
        List<T> nodeValueLst = new ArrayList<>();
        if(treeNode != null) {
            ArrayDeque<BinaryTreeNode<T>> queue=new ArrayDeque<>();
            queue.add(treeNode);
            while(!queue.isEmpty()) {
                BinaryTreeNode<T> nd = queue.remove();
                nodeValueLst.add(nd.getValue());
                if(nd.getLeftChild() != null) {
                    queue.add(nd.getLeftChild());
                }
                if(nd.getRightChild() != null) {
                    queue.add(nd.getRightChild());
                }
            }
        }
        return nodeValueLst;
    }
    
    /**
     * 深度优先方式遍历二叉树（借用双端队列ArrayDeque的栈性质）
     *
     * @param treeNode
     * @return
     * @date 2017年12月4日 
     */
    public static <T> List<T> deptOrder(BinaryTreeNode<T> treeNode) {
        List<T> nodeValueLst = new ArrayList<>();
        if(treeNode != null) {
            ArrayDeque<BinaryTreeNode<T>> stack=new ArrayDeque<>();
            stack.push(treeNode);
            while(!stack.isEmpty()) {
                treeNode = stack.pop();
                nodeValueLst.add(treeNode.getValue());
                if(treeNode.getRightChild() != null) {
                    stack.push(treeNode.getRightChild());
                }
                if(treeNode.getLeftChild() != null) {
                    stack.push(treeNode.getLeftChild());
                }
            }
        }
        return nodeValueLst;
    }
    public static void main(String[] args) {
        BinaryTreeNode<String> parent = new BinaryTreeNode<>("1");
        BinaryTreeNode<String> lChild = new BinaryTreeNode<>("2");
        BinaryTreeNode<String> rChild = new BinaryTreeNode<>("3");
        BinaryTreeNode<String> llChild = new BinaryTreeNode<>("4");
        BinaryTreeNode<String> lrChild = new BinaryTreeNode<>("5");
        BinaryTreeNode<String> rlChild = new BinaryTreeNode<>("6");
        BinaryTreeNode<String> rrChild = new BinaryTreeNode<>("7");
        BinaryTreeNode<String> lllChild = new BinaryTreeNode<>("8");
        BinaryTreeNode<String> llrChild = new BinaryTreeNode<>("9");
        
        parent.setLeftChild(lChild);
        parent.setRightChild(rChild);
        lChild.setLeftChild(llChild);
        lChild.setRightChild(lrChild);
        llChild.setLeftChild(lllChild);
        llChild.setRightChild(llrChild);
        rChild.setLeftChild(rlChild);
        rChild.setRightChild(rrChild);
        System.out.println("广度优先遍历");
        System.out.println(levelOrder(parent));
        System.out.println("深度优先遍历");
        System.out.println(deptOrder(parent));
        System.out.println("前序遍历\n" + preOrder(parent));
        System.out.println("中序遍历\n" + inOrder(parent));
        System.out.println("后序遍历\n" + postOrder(parent));
        
        System.err.println("---------------------------");
        ArrayDeque<Integer> queue=new ArrayDeque<>();
        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);
        queue.add(5);
        queue.add(6);
        queue.add(7);
        queue.push(8);
        System.out.println(queue);
        System.out.println(queue.pop());
        System.out.println(queue);
        System.out.println("queue1--");
        ArrayDeque<Integer> queue1=new ArrayDeque<>();
        queue1.push(1);
        queue1.push(2);
        queue1.push(3);
        queue1.push(4);
        queue1.push(5);
        queue1.push(6);
        queue1.push(7);
        System.out.println(queue1);
        
        System.out.println(queue1.pop());
        System.out.println(queue1);
        
    }
}
