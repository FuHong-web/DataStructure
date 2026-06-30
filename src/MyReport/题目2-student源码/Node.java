package MyReport.student;

/**
 * @author: Yan Tong xue
 * @Created:2026/6/28 10:28
 * @desc:
 */
public class Node {
    private Student data;
    private Node prev;
    private Node next;

    public Node() {
        this.data = new Student();
        this.prev = null;
        this.next = null;
    }

    public Node(Student data) {
        this.data = data;
        this.prev = null;
        this.next = null;
    }

    public Student getData() { return data; }
    public void setData(Student data) { this.data = data; }

    public Node getPrev() { return prev; }
    public void setPrev(Node prev) { this.prev = prev; }

    public Node getNext() { return next; }
    public void setNext(Node next) { this.next = next; }
}