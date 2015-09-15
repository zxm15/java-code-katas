package Trees;
import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * Created by ZXM on 8/7/15.
 * This is a Java Program to implement Binary Heap. A binary heap is a heap data structure created using a binary tree. It can be seen as a binary tree with two additional constraints:
 i) The shape property: the tree is a complete binary tree; that is, all levels of the tree, except possibly the last one (deepest) are fully filled and if the last level of the tree is not complete, the nodes of that level are filled from left to right.
 ii) The heap property: each node is smaller than or equal to each of its children according to a comparison predicate defined for the data structure.
 Here binary heap is implemented using arrays.
 */

public class BinaryHeap<T extends Comparable<T>> {
    private static final int DEFAULT_CAPACITY = 10;
    protected T[] array;
    protected int size; //default the first element starts at index 1
    /**
     * Construct a new binary heap
     */
    public BinaryHeap () {
        array = (T[]) new Comparable[DEFAULT_CAPACITY];
        size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == array.length - 1;
    }

    public void add(T value) {
        //grow array if needed
        if (isFull()) {
            array = resize();
        }
        array[++size] = value;
        heapifyUp();
    }

    private void heapifyUp() {
        int index = size;
        while(hasParent(index)) {
            int parent = getParent(index);
            if (array[parent].compareTo(array[index]) > 0) {
                swap(parent, index);
            } else {
                break;
            }
            index = parent;
        }
    }

    /**
     * remove the min of the heap
     */
    public void remove() {
        if (isEmpty()) return;
        array[1] = array[size];
        size--;
        heapifyDown();
    }

    private void heapifyDown() {
        int index = 1;
        while (hasLeftChild(index)) {
            int smallerChild = getLeftChild(index);
            if (hasRightChild(index)) {
                int rightChild = getRightChild(index);
                if (array[smallerChild].compareTo(array[rightChild]) > 0) {
                    smallerChild = rightChild;
                }
            }
            if (array[index].compareTo(array[smallerChild]) >0) {
                swap(index, smallerChild);
            } else {
                break;
            }
            index = smallerChild;
        }
    }

    private boolean hasLeftChild(int index) {
        return 2 * index <= size;
    }

    private boolean hasRightChild(int index) {
        return 2 * index + 1 <= size;
    }

    private int getLeftChild(int index) {
        return 2 * index;
    }

    private int getRightChild(int index) {
        return 2 * index + 1;
    }

    private boolean hasParent(int index) {
        return index > 1;
    }

    private int getParent(int index) {
        return index / 2;
    }

    private void swap(int i, int j) {
        T temp = array[i];
        array[j] = array[i];
        array[i] = temp;
    }
    private T[] resize() {
//        T[] newArray = (T[]) new Comparable[2 * size];
//        System.arraycopy(array, 0, newArray, 0, array.length);
//        return newArray;
        return Arrays.copyOf(array, array.length * 2);
    }
}
