package AlgoTasks.t04_FindMin.zadanie42;

import java.util.ArrayList;
import java.util.List;

public class PriorityQueueImpl implements PriorityQueue<Integer> {

    private class Node {
        Integer value;
        long id;

        Node(Integer value, long id) {
            this.value = value;
            this.id = id;
        }
    }

    private List<Node> heap = new ArrayList<>();
    private long[] position = new long[100005];
    private long operationCounter = 0;
    private long lastDequeuedId = -1;

    public PriorityQueueImpl() {
        for (int i = 0; i < position.length; i++) {
            position[i] = -1;
        }
    }

    @Override
    public void enqueue(Integer value) {
        operationCounter++;
        Node newNode = new Node(value, operationCounter);

        heap.add(newNode);
        position[(int) newNode.id] = heap.size() - 1;

        siftUp(heap.size() - 1);
    }

    @Override
    public Integer dequeueMax() {
        if (heap.isEmpty()) {
            return null;
        }

        Node maxNode = heap.get(0);
        lastDequeuedId = maxNode.id;
        position[(int) maxNode.id] = -1;

        Node lastNode = heap.remove(heap.size() - 1);

        if (!heap.isEmpty()) {
            heap.set(0, lastNode);
            position[(int) lastNode.id] = 0;
            siftDown(0);
        }

        return maxNode.value;
    }

    @Override
    public void increment(long operation, Integer addition) {
        if (operation < 1 || operation >= position.length || position[(int) operation] == -1) {
            return;
        }

        int index = (int) position[(int) operation];
        Node node = heap.get(index);
        node.value += addition;

        siftUp(index);
    }

    public long getLastDequeuedId() {
        return lastDequeuedId;
    }

    private void siftUp(int index) {
        while (index > 0) {
            int parentIndex = (index - 1) / 2;
            if (heap.get(parentIndex).value < heap.get(index).value) {
                swap(parentIndex, index);
                index = parentIndex;
            } else {
                break;
            }
        }
    }

    private void siftDown(int index) {
        int size = heap.size();
        while (true) {
            int leftChild = 2 * index + 1;
            int rightChild = 2 * index + 2;
            int largest = index;

            if (leftChild < size && heap.get(leftChild).value > heap.get(largest).value) {
                largest = leftChild;
            }
            if (rightChild < size && heap.get(rightChild).value > heap.get(largest).value) {
                largest = rightChild;
            }

            if (largest != index) {
                swap(largest, index);
                index = largest;
            } else {
                break;
            }
        }
    }

    private void swap(int i, int j) {
        Node temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);

        position[(int) temp.id] = j;
        position[(int) heap.get(i).id] = i;
    }
}