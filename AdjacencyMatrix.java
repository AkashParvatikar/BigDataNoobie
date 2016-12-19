import java.util.*;
import java.util.Random;
import java.util.Scanner;
//class creating adjacency list
public class AdjacencyMatrix {
    int s=0;
    Random random;
    Node[] f;
    
    AdjacencyMatrix(int s) {
        this.s=s;
        random=new Random();
        f=new Node[s];
        f=generateMatrix(f);
    }
    public Node[] generateMatrix(Node[] fList) {
        Node[] back=new Node[fList.length];
        for(int i=0;i<fList.length;i++) {
            fList[i]=new Node(i,0,null);
            back[i]=fList[i];
        }
        for(int i=0;i<fList.length;i++)
            for(int j=fList.length-1;j>=i;j--) {
                if(i==j)
                    continue;
                else {
                    int value=random.nextInt(10)+1;
                    Node node1=new Node(j,value,null);
                    Node node2=new Node(i,value,null);
                    back[i].setNext(node1);
                    back[j].setNext(node2);
                    back[i]=node1;
                    back[j]=node2;
                }
            }
        return fList;
    }
    public void printMatrixFloyd() {
        for(int i=0;i<f.length;i++) {
            Node temp=f[i];
            while(temp!=null) {
                System.out.println(temp.getVertex()+","+temp.getWeight()+" ");
                temp=temp.getNext();
            }
            System.out.println();
        }
    }
}