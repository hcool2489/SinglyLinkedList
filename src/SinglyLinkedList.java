public class SinglyLinkedList {
    public class Node {
        private int data;
        private Node next;

        public int getData() {
            return data;
        }

        public void setData(int data) {
            this.data = data;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        public Node() {
            this.data = 0;
            this.next = null;
        }

        public Node(int data) {
            this.data = data;
            this.next = null;
        }

        public Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }
    }

    public static void main(String[] args) {
        SinglyLinkedList linkedList = new SinglyLinkedList();
        System.out.println(linkedList);
        linkedList.insert(42);
        System.out.println(linkedList);
    }

    private int size = 0;
    private Node head = null;

    @Override
    public String toString() {
        StringBuilder response = new StringBuilder();
        response.append("[");
        Node temp = this.head;
        while (temp!=null){
            response.append(temp.getData());
            if(temp.next!=null){
                response.append("=>");
            }
        }
        response.append("]");
        return response.toString();
    }
    private void insertHead(int data){
        /*Node newNode = new Node(data, this.head);
        this.head = newNode;*/
        this.head = new Node(data, this.head);
        size++;
    }
    private void insertAfter(int data, Node node){
        /*Node newNode = new Node(data, node.next);
        node.next = newNode;*/
        node.next = new Node(data, node.next);
        size++;
    }

    public void insert(int data) {
        if(head == null){
            insertHead(data);
        }
        else{
            Node temp = this.head;
            while(temp.next != null){
                temp = temp.next;
            }
            insertAfter(data, temp);
        }
    }
}