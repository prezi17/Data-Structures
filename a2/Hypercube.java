package A2;



import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Hypercube {
 private Stack < Corner > walk;
 private int numOfDimentions;

 public Hypercube(int n) throws Exception {
  if (n < 0) {
   throw new Exception("Please enter a positive integer");
  } else {
   this.numOfDimentions = n;
   this.walk = new Stack < Corner > ();
  }
 }

 /**
  * nested class corner 
  * @return the coordinates in form of a string
  */

 public static class Corner {
  private String coordinates;

  public Corner() {
   this.coordinates = new String("");
  }
 }

 /**
  *
  * recursive function to take a walk on an n-dimensional hypercube
  */
 public void recursiveWalk() {
  int len = numOfDimentions;
  Corner createCorner = new Corner();
  recursiveWalk(createCorner.coordinates, len);
 }

 public static void reverseRecursiveWalk(String coordinates, int n) {
  if (n == 0) {
   System.out.println(coordinates);
  } else {
   recursiveWalk(coordinates + "1", n - 1);
   reverseRecursiveWalk(coordinates + "0", n - 1);
  }
 }

 // append order n binary numbers to end of prefix string, and print it to the screen 
 public static void recursiveWalk(String coordinates, int n) {
  if (n == 0) {
   System.out.println(coordinates);
  } else {
   recursiveWalk(coordinates + "0", n - 1);
   reverseRecursiveWalk(coordinates + "1", n - 1);
  }
 }


 /**
  *
  * function for the iterative walk on a hypercube of n dimmention using array dequeue as asked by professor.
  */
public void iterativeWalk()
{
  int len = this.numOfDimentions;
  iterativeWalkHelper(this, len);
  for(Corner c : this.walk) {
  System.out.println(c.coordinates);
}
}
 private static void iterativeWalkHelper(Hypercube h, int n)
 {
 Queue<Integer> Cornerqueue = new LinkedList<Integer>();
        int num = 0;
        Cornerqueue.add(0);
        for (int i = 0; i < n; i++)
        {
            int size = Cornerqueue.size();
 for (int j = size - 1; j >= 0; j--)
 {
    int k = -1;
    if(k != j)
    {
        Iterator<Integer> it = Cornerqueue.iterator();
        for(; k!= j; k++) {
            num = it.next();
        }
    }
    Cornerqueue.add(num + size); 
 }
 }
 for(int cor : Cornerqueue)
 {
    Corner c = new Corner();
    c.coordinates = "";
            for(int k = 0; k < n; k++) {
                c.coordinates = c.coordinates + "0";
            }
            Corner newCorner = new Corner();
            newCorner.coordinates = (c.coordinates + Integer.toBinaryString(cor)).substring(Integer.toBinaryString(cor).length());
            h.walk.push(newCorner);
 }
 }

 public static void main(String[] args) throws Exception {
  Hypercube hype1 = new Hypercube(3);
  long startTime1=System.currentTimeMillis();
  System.out.println("Iterative walk on 3D cube is :  \n" );
  //+ hype1.iterativeWalkHelper());
  hype1.iterativeWalk();
  long endTime1= System.currentTimeMillis();
  long Elapsed1 = endTime1-startTime1;
  System.out.println("\n iterative  walk on 3D cube time elAPSED IS..:"  + Elapsed1);
  System.out.println("\n recursive walk on 3D cube:");
  long startTime=System.currentTimeMillis();
  hype1.recursiveWalk();
  long endTime= System.currentTimeMillis();
  long Elapsed = endTime-startTime;
  System.out.println("\n recursive walk on 3D cube time elAPSED IS..:"  + Elapsed);

  
  Hypercube hype2 = new Hypercube(4);
 System.out.println("\n Iterative walk on 4D cube:" ); 
  hype2.iterativeWalk();
  System.out.println("\n recursive walk on 4D cube:");
  hype2.recursiveWalk();

  Hypercube hype3 = new Hypercube(5);
  //System.out.println("Iterative walk on 5D cube:" + hype3.iterativeWalkHelper());
  System.out.println("\n recursive walk on5D cube:");
  hype2.recursiveWalk();
 }

}