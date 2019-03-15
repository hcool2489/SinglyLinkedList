public class SinglyLinkedList {

    private static class Node {

        private int data;
        private Node nextNode;

        public int getData() {
            return data;
        }

        public Node getNextNode() {
            return nextNode;
        }

        public void setData(int data) {
            this.data = data;
        }

        public void setNextNode(Node nextNode) {
            this.nextNode = nextNode;
        }

        public Node(int data, Node nextNode) {
            this.data = data;
            this.nextNode = nextNode;
        }
    }

    private Node head = null;
    private int size = 0;

    public static void main(String[] args) {
        SinglyLinkedList linkedList = new SinglyLinkedList();

        System.out.println("Printing the list first time:");
        System.out.println(linkedList);

        System.out.println("Inserting 5 values in the linked list");
        for (int i = 0; i < 5; i++) {
            linkedList.insert(i);
            System.out.println(linkedList);
        }

        int randomNumber = (int) (Math.random() * 10);

        int deleted = linkedList.remove(randomNumber);

        if (deleted == -1) {
            System.out.println(randomNumber + " was not found in the linked list.");
        } else {
            System.out.println(deleted + " was deleted.");
        }

        System.out.println(linkedList);
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();

        result.append("[");

        Node temp = this.head;

        while (temp != null) {
            result.append(temp.getData());

            if (temp.getNextNode() != null) {
                result.append(" --> ");
            }

            temp = temp.getNextNode();
        }

        result.append("]");
        return result.toString();
    }

    private void insertHead(int data) {
        this.head = new Node(data, this.head);
        size++;
    }

    private void insertAfter(int data, Node node) {
        node.setNextNode(new Node(data, node.getNextNode()));
        size++;
    }

    public void insert(int data) {
        if (this.head == null) {
            insertHead(data);
        } else {
            Node temp = this.head;

            while (temp.getNextNode() != null) {
                temp = temp.getNextNode();
            }
            insertAfter(data, temp);
        }
    }

    private int deleteHead() {
        int response = -1;

        if (this.head != null) {

            response = this.head.getData();

            Node temp = this.head;

            this.head = temp.getNextNode();
        }

        size--;
        return response;
    }

    private int deleteAfter(Node node) {
        int response = -1;

        Node temp = node.getNextNode();

        if (temp != null) {
            response = temp.getData();
            node.setNextNode(temp.getNextNode());
        }

        size--;
        return response;
    }

    public int remove(int data) {
        int response = -1;

        if (this.head.data == data) {
            response = deleteHead();
        } else {
            Node temp = this.head;
            while (temp != null) {
                if (temp.getNextNode().getData() == data) {
                    response = deleteAfter(temp);
                    break;
                }
                temp = temp.getNextNode();
            }
        }
        return response;
    }

}