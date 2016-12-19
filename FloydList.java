import java.util.Scanner;
import java.lang.Math;

public class FloydList {

    public static void main(String[] args) {
        //initilaize graph size with values=100,1000,2000,3000
        //4000,5000 and 6000
        int s= 100;
        // calculate time stamp
        long startTime = System.currentTimeMillis();
        //create the adjacency list
        AdjacencyMatrixFloyd matrix = new AdjacencyMatrixFloyd(s);

        long endTime = System.currentTimeMillis();
        System.out.println("Time to create adjacency matrix is: " + (endTime - startTime) / 1000.00 + " seconds");

        //matrix.printMatrixFloyd();
        floyd(matrix.f);
       // matrix.printMatrixFloyd();
        long endTime2 = System.currentTimeMillis();
        System.out.println("Time to generate input and compute shortest path: " + (endTime2 - startTime) / 1000.00 + "seconds");
        System.out.println(("Total time: " + (((endTime - startTime) / 1000.00) + ((endTime2 - startTime) / 1000.00)) + "seconds"));
    }

    public static void floyd(FloydLinkedList[] f) {
        int n = f.length;
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {

                FloydLinkedList kHead = f[k];
                FloydLinkedList iHead = f[i];

                FloydLinkedList kNode = iHead;
                while (kNode != null) {
                    if (kNode.getVertex() == k) {
                        break;
                    }
                    kNode = kNode.getNext();
                }
                //for each node check the new path with known shortest value
                FloydLinkedList id1 = f[i].getNext();
                if (kNode != null) {
                    while (id1 != null) {
                        FloydLinkedList temp = f[id1.getVertex()];
                        while (temp != null) {
                            if (temp.getVertex() == k) {
                                break;
                            }
                            temp = temp.getNext();
                        }
                        if (temp != null) {
                            if (temp.getWeight() + id1.getWeight() < kNode.getWeight()) {
                                kNode.setWeight(temp.getWeight() + id1.getWeight());
                            }
                        }
                        id1 = id1.getNext();
                    }
                }
            }
        }
    }
}