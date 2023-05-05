package com.lpc.leetcode;

/**
 * 设计循环双端队列
 *
 * @author byu_rself
 * @date 2023/5/5 11:21
 */
public class P641 {

    int[] data;
    int size, head, tail;

    public P641(int k) {
        data = new int[k];
        size = 0;
        head = 0;
        tail = k - 1;
    }

    public boolean insertFront(int value) {
        if (isFull()) return false;
        head = head == 0 ? data.length - 1 : head - 1; // 头指针左移
        data[head] = value;
        ++size;
        return true;
    }

    public boolean insertLast(int value) {
        if (isFull()) return false;
        tail = tail == data.length - 1 ? 0 : tail + 1; // 尾指针右移
        data[tail] = value;
        ++size;
        return true;
    }

    public boolean deleteFront() {
        if (isEmpty()) return false;
        head = head == data.length - 1 ? 0 : head + 1; // 头指针右移
        --size;
        return true;
    }

    public boolean deleteLast() {
        if (isEmpty()) return false;
        tail = tail == 0 ? data.length - 1 : tail - 1; // 尾指针左移
        --size;
        return true;
    }

    public int getFront() {
        return isEmpty() ? -1 : data[head];
    }

    public int getRear() {
        return isEmpty() ? -1 : data[tail];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == data.length;
    }

/*    int[] data;
    int front, rear;
    int maxSize;

    public P641(int k) {
        maxSize = k + 1;
        data = new int[maxSize];
        front = rear = 0;
    }

    public boolean insertFront(int value) {
        if (isFull()) return false;
        front = (front - 1 + maxSize) % maxSize;
        data[front] = value;
        return true;
    }

    public boolean insertLast(int value) {
        if (isFull()) return false;
        data[rear] = value;
        rear = (rear + 1) % maxSize;
        return true;
    }

    public boolean deleteFront() {
        if (isEmpty()) return false;
        front = (front + 1) % maxSize;
        return true;
    }

    public boolean deleteLast() {
        if (isEmpty()) return false;
        rear = (rear - 1 + maxSize) % maxSize;
        return true;
    }

    public int getFront() {
        return isEmpty() ? -1 : data[front];
    }

    public int getRear() {
        return isEmpty() ? -1 : data[(rear - 1 + maxSize) % maxSize];
    }

    public boolean isEmpty() {
        return front == rear;
    }

    public boolean isFull() {
        return (rear + 1) % maxSize == front;
    }*/
}
