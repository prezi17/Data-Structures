package A2;

import java.util.Stack;

public class AugStack < E extends Comparable < E >> {

 private Stack < E > main;
 private Stack < E > minValueStack;

 /**
  * Constructor to initialize the fields
  */
 public AugStack() {

  this.main = new Stack < E > ();
  this.minValueStack = new Stack < E > ();
 }

 /**
  * adds value to the top of stack and returns nothing
  */
 public void push(E value) {

  if (this.main.isEmpty() == true) {
   this.main.push(value);
   this.minValueStack.push(value);
  } else {
   this.main.push(value);

   E element = this.minValueStack.peek();

   if (value.compareTo(element) <= 0) {
    this.minValueStack.push(value);
   }

  }

 }

 /**
  * @returns the popped value
  * if the value being popped is on the top of  minvalue stack;
  *  then that value is popped out from main and minValueStack both. 
  */
 public E pop() {
  if (this.main.isEmpty()) {
   return null;
  } else {
   E element = this.main.pop();

   if (element.equals(this.minValueStack.peek())) {
    minValueStack.pop();
   }
   return element;

  }
 }

 /**
  * @return the minimum value of the stack
  */
 public E getMin() {

  if (this.minValueStack.isEmpty()) {
   return null;
  } else {

   return minValueStack.peek();

  }

 }

 /**
  * @return the top value without removing it from the stack.
  */
 public E top() {

  if (this.main.isEmpty()) {
   return null;
  }
  E top = main.pop();
  main.push(top);
  return top;
 }


 /*
  *  main function to test stack functions.
  */

 public static void main(String[] args) {

  AugStack < Integer > A1 = new AugStack < Integer > ();

  A1.push(6);
  A1.push(10);
  A1.push(15);
  A1.push(26);
  System.out.println("Top = " + A1.top());
  System.out.println("Min = " + A1.getMin());

  A1.push(1);
  A1.push(4);
  A1.push(6);
  A1.push(13);
  A1.pop();
  A1.pop();
  A1.pop();
  A1.pop();

  System.out.println("Top = " + A1.top());
  System.out.println("Min = " + A1.getMin());


  A1.push(3);
  A1.push(35);

  System.out.println("Top = " + A1.top());
  System.out.println("Min = " + A1.getMin());
 }
}