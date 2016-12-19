import java.util.Scanner;
import java.util.*;
import java.lang.Math;
import java.io.*;
//created node class acting like a linked list data structure
public class Node {
    int vertex;
    int weight;
    Node next;
    
    public Node(int vertex, int weight, Node next) {
        super();
        this.vertex=vertex;
        this.weight=weight;
        this.next=next;
    }
    
    public int getVertex() {
        return vertex;
    }
    
    public int getWeight() {
        return weight;
    }
    
    public void setWeight(int weight) {
        this.weight=weight;
    }
    
    public Node getNext() {
        return next;
    }
    
    public void setNext(Node next) {
        this.next=next;
    }
}
