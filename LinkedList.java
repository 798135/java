/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author chandupavan
 */
public class LinkedList {
    Node head;
    static class Node {
        int data;
        Node next;
  
        Node(int d) {
            data = d;
            next = null;
        }
    }
    public static LinkedList deleteAtPos(LinkedList ls, int pos) {
        if(pos < 1)
            System.out.println("Invalid position specified " + pos);
        Node curNode = ls.head;
        //Node prevNode = null;
        
        if(pos == 1) {
            ls.head = curNode.next;
            return ls;
        }
        while(pos-- != 0) {
            if(pos == 1) {
                curNode.next = curNode.next.next;
            }
            //prevNode = curNode;
            curNode = curNode.next;
        }
        return ls;
    }
    public static LinkedList deleteElement(LinkedList ls, int d) {
        Node curNode = ls.head;
        Node prevNode = null;
        if(curNode != null && curNode.data == d) {
            ls.head = curNode.next;
            return ls;
        }
        while(curNode != null && curNode.data != d) {
            prevNode = curNode;
            curNode = curNode.next;
        }
        if (curNode != null) {
            prevNode.next = curNode.next;
        }
        if(curNode == null) {
            System.out.println("Could not find element");
        }
        return ls;
    }
    public static LinkedList insertAtPos(LinkedList ls, int pos, int d) {
        Node new_node = new Node(d);
        
        if(pos < 1) {
            System.out.println("Invalid postion " + pos);
        }
        if(pos == 1) {
            new_node.next = ls.head;
            ls.head = new_node;
        }
        else {
            Node curNode = ls.head;
            while(pos-- != 0) {
                if(pos == 1) {
                    new_node.next = curNode.next;
                    curNode.next = new_node;
                }
                curNode = curNode.next;
            }
        }
        return ls;
    }
    public static LinkedList insertFront(LinkedList ls, int d) {
        Node new_node = new Node(d);
        //Node last = ls.head;
        new_node.next = null;
        if(ls.head == null) {
            ls.head = new_node;
        }
        else {
            new_node.next = ls.head;
            ls.head = new_node;
        }
        return ls;
    }
    public static LinkedList insert(LinkedList ls, int d) {
        Node n = new Node(d);
        n.next = null;
        if (ls.head == null) {
            ls.head = n;
        }
        else {
            Node l = ls.head;
            while (l.next != null) {
                l = l.next;
            }
            l.next = n;
        }
        return ls;
    }
    
    public static void printList(LinkedList list) 
    { 
        Node currNode = list.head; 
        System.out.print("LinkedList: "); 
  
        // Traverse through the LinkedList 
        while (currNode != null) { 
            // Print the data at current node
            if(currNode.next != null) {
                System.out.print(currNode.data + "->"); 
            }
            else {
                System.out.print(currNode.data);
            }
            // Go to next node 
            currNode = currNode.next; 
        } 
    }
    public static void main(String[] args) {
        LinkedList ls = new LinkedList();
        ls = insert(ls, 2);
        ls = insert(ls, 3);
        ls = insert(ls, 4);
        ls = insertFront(ls, 5);
        ls = insertFront(ls, 6);
        ls = insert(ls, 7);
        ls = insertAtPos(ls, 3, 8);
        ls = insertAtPos(ls, 0, 9);
        ls = insertAtPos(ls, 4, 9);
        ls = deleteElement(ls, 8);
        ls = deleteElement(ls, 10);
        ls = deleteAtPos(ls, 4);
        printList(ls);
        
    }
}
