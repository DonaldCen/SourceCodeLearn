package com.learn.donald.algorithm.array;

import java.util.Arrays;

/**
 * @Author: DonaldCen
 * @Date: 2021/11/9 17:13
 * @Desc: 模拟实现动态数组
 */
public class DynamicArray {

    private Object[] DEFAULT_EMPTY_ARRAY = new Object[]{};

    private static final int DEFAULT_CAPACITY = 10;
    private static final int MAX_ARRAY_SIZE = Integer.MAX_VALUE - 8;

    private Object[] array;

    private int size;

    public DynamicArray(int initialCapacity) {
        if (initialCapacity > 0) {
            this.array = new Object[initialCapacity];
        } else if (initialCapacity == 0) {
            this.array = DEFAULT_EMPTY_ARRAY;
        } else {
            throw new IllegalArgumentException("Illegal Capacity:" + initialCapacity);
        }
    }

    public DynamicArray() {
        this.array = DEFAULT_EMPTY_ARRAY;
    }

    public int getArraySize() {
        return size;
    }

    public void ensureCapacity(int minCapacity) {
        int minExpand = (array != DEFAULT_EMPTY_ARRAY)
                // any size if not default element table
                ? 0
                // larger than default for default empty table. It's already
                // supposed to be at default size.
                : DEFAULT_CAPACITY;

        if (minCapacity > minExpand) {
            ensureExplicitCapacity(minCapacity);
        }
    }

    private void ensureCapacityInternal(int minCapacity) {
        if (array == DEFAULT_EMPTY_ARRAY) {
            minCapacity = Math.max(DEFAULT_CAPACITY, minCapacity);
        }

        ensureExplicitCapacity(minCapacity);
    }

    private void ensureExplicitCapacity(int minCapacity) {
        if (minCapacity - array.length > 0) {
            grow(minCapacity);
        }
    }

    private void grow(int minCapacity) {
        int oldCapacity = array.length;
        int newCapacity = oldCapacity + (oldCapacity >> 1);
        if (newCapacity - minCapacity < 0) {
            newCapacity = minCapacity;
        }
        if (newCapacity - MAX_ARRAY_SIZE > 0) {
            newCapacity = hugeCapacity(minCapacity);
        }
        array = Arrays.copyOf(array, newCapacity);
    }

    private static int hugeCapacity(int minCapacity) {
        if (minCapacity < 0) // overflow
            throw new OutOfMemoryError();
        return (minCapacity > MAX_ARRAY_SIZE) ?
                Integer.MAX_VALUE :
                MAX_ARRAY_SIZE;
    }

    public boolean add(String a){
        ensureCapacityInternal(size + 1);
        array[size++] = a;
        return true;
    }

    public String get(int index){
        rangeCheck(index);
        return elementData(index);
    }

    public String remove(int index){
        rangeCheck(index);

        String data = elementData(index);

        int numMoved = size - index - 1;
        if (numMoved > 0){
            System.arraycopy(array, index+1, array, index,
                    numMoved);
        }
        array[--size] = null;

        return data;
    }

    private String elementData(int index){
        return (String) this.array[index];
    }

    private void rangeCheck(int index) {
        if (index >= size)
            throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
    }

    private String outOfBoundsMsg(int index) {
        return "Index: "+index+", Size: "+size;
    }
}
