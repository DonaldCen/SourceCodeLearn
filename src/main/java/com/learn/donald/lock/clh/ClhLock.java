package com.learn.donald.lock.clh;

import lombok.Data;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * @Author: DonaldCen
 * @Date: 2021/9/28 11:30
 * @Desc:
 */
public class ClhLock implements Lock {

    private static ThreadLocal<Node> curNodeLocal = new ThreadLocal<>();

    private AtomicReference<Node> tail = new AtomicReference<>(null);

    public ClhLock(){
        tail.getAndSet(Node.EMPTY);
    }

    @Override
    public void lock() {
        Node curNode = new Node(true,null);
        Node preNode = tail.get();
        while (!tail.compareAndSet(preNode,curNode)){
            preNode = tail.get();
        }
        curNode.setPrevNode(preNode);
        while (curNode.getPrevNode().isLocked()){
            Thread.yield();
        }
        curNodeLocal.set(curNode);
    }

    @Override
    public void lockInterruptibly() throws InterruptedException {

    }

    @Override
    public boolean tryLock() {
        return true;
    }

    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return true;
    }

    @Override
    public void unlock() {
        Node curNode = curNodeLocal.get();
        curNode.setLocked(false);
        curNode.setPrevNode(null);
        curNodeLocal.set(null);
    }

    @Override
    public Condition newCondition() {
        return null;
    }

    @Data
    static class Node {
        public Node(boolean locked,Node prevNode){
            this.locked = locked;
            this.prevNode = prevNode;
        }
        volatile boolean locked;

        Node prevNode;

        public static final Node EMPTY = new Node(false,null);
    }
}
