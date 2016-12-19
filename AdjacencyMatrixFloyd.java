import java.util.Scanner;
import java.lang.Math;
import java.util.Random;
//class to create adjacency list
public class AdjacencyMatrixFloyd {
    int s=0;
    Random random;
    FloydLinkedList[] f;
    
    AdjacencyMatrixFloyd(int s) {
        this.s=s;
        random=new Random();
        f=new FloydLinkedList[s];
        f=generateMatrixFloyd(f);
    }
    
    public FloydLinkedList[] generateMatrixFloyd(FloydLinkedList[] fList) {
        FloydLinkedList[] back=new FloydLinkedList[fList.length];
        for(int i=0;i<fList.length;i++) {
            fList[i]=new FloydLinkedList(i,0,null);
            back[i]=fList[i];
        }
        for(int i=0;i<fList.length;i++)
            for(int j=fList.length-1;j>=i;j--) {
                if(i==j)
                    continue;
                else {
                    int value=random.nextInt(9)+1;
                    FloydLinkedList node1=new FloydLinkedList(j,value,null);
                    FloydLinkedList node2=new FloydLinkedList(i,value,null);
                    back[i].setNext(node1);
                    back[j].setNext(node2);
                    back[i]=node1;
                    back[j]=node2;
                }
            }
        return fList;
    }
  /*  public void printMatrixFloyd() {
        for(int i=0;i<front.length;i++) {
            FloydLinkedList temp=front[i];
            while(temp!=null) {
                System.out.println(temp.getVertex()+"'"+temp.getWeight()+" ");
                temp=temp.getNext();
            }
            System.out.println();
        }
    } */
}