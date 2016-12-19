import java.util.Scanner;
import java.lang.Math;
import java.io.*;
//create a node class acting as linked list data structure
public class FloydLinkedList {
    int vertex;
    int weight;
    FloydLinkedList next;
    
    public FloydLinkedList(int vertex, int weight, FloydLinkedList next) {
        super();
        this.vertex=vertex;
        this.weight=weight;
        this.next=next;
    }
    public int getVertex() {
        return this.vertex;
    }
    
    public void setVertex(int vertex) {
        this.vertex=vertex;
    }
    public int getWeight() {
        return this.weight;
    }
    
    public void setWeight(int weight) {
        this.weight=weight;
    }
    
    public FloydLinkedList getNext() {
        return this.next;
    }
    
    public void setNext(FloydLinkedList next) {
        this.next=next;
    }
}
