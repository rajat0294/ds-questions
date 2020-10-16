package linkedlist;


// This file is initialized with a code version of this
// question's sample test case. Feel free to add, edit,
// or remove test cases in this file as you see fit!

import java.util.*;

class ProgramTest {

    public static void main(String[] args) {
        TestCase1();
    }
    private static List<Integer> getNodeValuesHeadToTail(Program.DoublyLinkedList linkedList) {
        List<Integer> values = new ArrayList<Integer>();
        Program.Node node = linkedList.head;
        while (node != null) {
            values.add(node.value);
            node = node.next;
        }
        return values;
    }

    private static List<Integer> getNodeValuesTailToHead(Program.DoublyLinkedList linkedList) {
        List<Integer> values = new ArrayList<Integer>();
        Program.Node node = linkedList.tail;
        while (node != null) {
            values.add(node.value);
            node = node.prev;
        }
        return values;
    }

    private static void bindNodes(Program.Node nodeOne, Program.Node nodeTwo) {
        nodeOne.next = nodeTwo;
        nodeTwo.prev = nodeOne;
    }

    private static boolean compare(List<Integer> array1, int[] array2) {
        if (array1.size() != array2.length) {
            return false;
        }
        for (int i = 0; i < array1.size(); i++) {
            if (array1.get(i) != array2[i]) {
                return false;
            }
        }
        return true;
    }

    public static void TestCase1() {
        Program.DoublyLinkedList linkedList = new Program.DoublyLinkedList();
        Program.Node one = new Program.Node(1);
        Program.Node two = new Program.Node(2);
        Program.Node three = new Program.Node(3);
        Program.Node three2 = new Program.Node(3);
        Program.Node three3 = new Program.Node(3);
        Program.Node four = new Program.Node(4);
        Program.Node five = new Program.Node(5);
        Program.Node six = new Program.Node(6);
        bindNodes(one, two);
        bindNodes(two, three);
        bindNodes(three, four);
        bindNodes(four, five);
        linkedList.head = one;
        linkedList.tail = five;

        linkedList.setHead(four);
        //Utils.assertTrue(compare(getNodeValuesHeadToTail(linkedList), new int[] {4, 1, 2, 3, 5}));
        //Utils.assertTrue(compare(getNodeValuesTailToHead(linkedList), new int[] {5, 3, 2, 1, 4}));

        linkedList.setTail(six);
        //Utils.assertTrue(compare(getNodeValuesHeadToTail(linkedList), new int[] {4, 1, 2, 3, 5, 6}));
        //Utils.assertTrue(compare(getNodeValuesTailToHead(linkedList), new int[] {6, 5, 3, 2, 1, 4}));

        linkedList.insertBefore(six, three);
        //Utils.assertTrue(compare(getNodeValuesHeadToTail(linkedList), new int[] {4, 1, 2, 5, 3, 6}));
        //Utils.assertTrue(compare(getNodeValuesTailToHead(linkedList), new int[] {6, 3, 5, 2, 1, 4}));

        linkedList.insertAfter(six, three2);
        //Utils.assertTrue(compare(getNodeValuesHeadToTail(linkedList), new int[] {4, 1, 2, 5, 3, 6, 3}));
        //Utils.assertTrue(compare(getNodeValuesTailToHead(linkedList), new int[] {3, 6, 3, 5, 2, 1, 4}));

        linkedList.insertAtPosition(1, three3);
        //Utils.assertTrue(compare(getNodeValuesHeadToTail(linkedList), new int[] {3, 4, 1, 2, 5, 3, 6, 3}));
        //Utils.assertTrue(compare(getNodeValuesTailToHead(linkedList), new int[] {3, 6, 3, 5, 2, 1, 4, 3}));

        linkedList.removeNodesWithValue(3);
        //Utils.assertTrue(compare(getNodeValuesHeadToTail(linkedList), new int[] {4, 1, 2, 5, 6}));
        //Utils.assertTrue(compare(getNodeValuesTailToHead(linkedList), new int[] {6, 5, 2, 1, 4}));

        linkedList.remove(two);
        //Utils.assertTrue(compare(getNodeValuesHeadToTail(linkedList), new int[] {4, 1, 5, 6}));
        //Utils.assertTrue(compare(getNodeValuesTailToHead(linkedList), new int[] {6, 5, 1, 4}));

        //Utils.assertTrue(linkedList.containsNodeWithValue(5));
        printLinkedList(linkedList);
        System.out.println(linkedList);
    }

    private static void printLinkedList(Program.DoublyLinkedList linkedList) {
        Program.Node node=linkedList.head;
        while (node!=null)
        {
            System.out.println(node.value);
            node=node.next;
        }
    }
}
