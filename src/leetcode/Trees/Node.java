package leetcode.Trees;

public class Node {
    Node next = null;

    

    public void appendToTail(int val) {
        Node end = new Node();
        Node n = this;
        while(n.next != null){
            n = n.next;
        }
        n.next = end;
    }
    

}
