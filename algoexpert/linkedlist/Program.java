package linkedlist;
import java.util.*;

// Feel free to add new properties and methods to the class.
class Program {
    static class DoublyLinkedList {
        public Node head;
        public Node tail;

        public void setHead(Node node) {
            // Write your code here.
            if(head == null){
                head=node;
                tail=node;
                return;
            }
            insertBefore(head,node);
        }

        public void setTail(Node node) {
            // Write your code here.
            if(tail==null){
                setHead(node);
                return;
            }
            insertAfter(tail,node);
        }

        public void insertBefore(Node node, Node nodeToInsert) {
            // Write your code here.
            if(nodeToInsert == head && nodeToInsert==tail) return;
            remove(nodeToInsert);
            nodeToInsert.prev=node.prev;
            nodeToInsert.next=node;
            if(node.prev==null){
                head=nodeToInsert;
            }else{
                node.prev.next=nodeToInsert;
            }
            node.prev=nodeToInsert;
        }

        public void insertAfter(Node node, Node nodeToInsert) {
            // Write your code here.
            if(nodeToInsert==tail) return;
            remove(nodeToInsert);
            nodeToInsert.prev=node;
            nodeToInsert.next=node.next;
            if(node.next==null){
                tail=nodeToInsert;
            }else{
                node.next.prev=nodeToInsert;
            }
            node.next=nodeToInsert;
        }

        public void insertAtPosition(int position, Node nodeToInsert) {
            // Write your code here.
            if(position==1){
                setHead(nodeToInsert);
                return;
            }

            Node node=head;
            int currentPosition=1;

            while(node!=null && currentPosition++ !=position) node =node.next;
            if(node!=null){
                insertBefore(node,nodeToInsert);
            }else{
                setTail(nodeToInsert);
            }
        }

        public void removeNodesWithValue(int value) {
            // Write your code here.
            Node curr=head;
            while(curr!=null){
                Node nodeToRemove=curr;
                curr=curr.next;
                if(nodeToRemove.value==value){
                    remove(nodeToRemove);
                }
            }
        }

        public void remove(Node node) {
            // Write your code here.
            if(node==head) head=head.next;
            if(node==tail) tail=tail.prev;
            if(node.prev!=null){
                node.prev.next=node.next;
            }
            if(node.next!=null){
                node.next.prev=node.prev;
            }
            node.prev=null;
            node.next=null;
        }

        public boolean containsNodeWithValue(int value) {
            // Write your code here.
            Node curr=head;
            while(curr!=null){
                if(curr.value==value){
                    return true;
                }
            }
            return false;
        }
    }

    // Do not edit the class below.
    static class Node {
        public int value;
        public Node prev;
        public Node next;

        public Node(int value) {
            this.value = value;
        }
    }
}