package AlgoTasks.t04_FindMin.zadanie41;

public class MinStackImpl implements MinStack<Integer> {

    private class Node {
        Integer value;
        Integer currentMin;
        Node next;

        Node(Integer value, Integer currentMin, Node next) {
            this.value = value;
            this.currentMin = currentMin;
            this.next = next;
        }
    }

    private Node head;

    public MinStackImpl() {
        head = null;
    }

    @Override
    public void push(Integer value) {
        if (head == null) {
            head = new Node(value, value, null);
        } else {
            int newMin = Math.min(value, head.currentMin);
            head = new Node(value, newMin, head);
        }
    }

    @Override
    public Integer pop() {
        if (head == null) return null;
        Integer value = head.value;
        head = head.next;
        return value;
    }

    @Override
    public Integer top() {
        if (head == null) return null;
        return head.value;
    }

    @Override
    public Integer min() {
        if (head == null) return null;
        return head.currentMin;
    }
}