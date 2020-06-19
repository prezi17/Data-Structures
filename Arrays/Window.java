/**********************************************************
 * EECS2011ON: Fundamentals of Data Structures,  Winter 2020
 * Assignment 1, Problem 2: ArrayLongestPlateau.java
 * Student Name:   Rajwinder kaur Rajwinder kaur
 * Student EECS account:  rkaur3	
 * Student ID number:  216907602
 **********************************************************/

package A1;

public class Window {
	
	protected double left;
	protected double right;
	protected double top;
	protected double bottom;

	public Window() throws InvalidWindowException {
		this(0, 0, 0, 0);
	}

	public Window(double Left, double Right, double Bottom, double Top) throws InvalidWindowException {
		if ((Right <= Left)|| (Top <= Bottom) ) {
			throw new InvalidWindowException("ERROR:  check your values..!!  Rules to be followed: Right> left  && top > Bottom ");

		}
			this.left =Left; // x Coordinate
			this.right = Right; // x Coordinate
			this.bottom = Bottom; // Y Coordinate
			this.top = Top;  	// Y Coordinate
	}

	public Window(Window w) throws InvalidWindowException {
		this(w.left, w.right, w.bottom, w.top);
	}

	/**
	 * @return the left
	 */
	public double getLeft() {
		return this.left;
	}

	/**
	 * @param left the left to set
	 * @throws InvalidWindowException
	 */
	public void setLeft(double left) throws InvalidWindowException {

		if (left >= this.right) {
			throw new InvalidWindowException("ERROR: Left value must be smaller thsn right");
		}
		this.left = left;
	}

	/**
	 * @return the right
	 */
	public double getRight() {
		return this.right;
	}

	/**
	 * @param right the right to set
	 * @throws InvalidWindowException
	 */
	public void setRight(double right) throws InvalidWindowException {

		if (right <= this.left) {
			throw new InvalidWindowException("ERROR:   Right value must be greater than left");
		}
		this.right = right;
	}

	/**
	 * @return the bottom
	 */
	public double getBottom() {
		return this.bottom;
	}

	/**
	 * @param bottom the bottom to set
	 * @throws InvalidWindowException
	 */
	public void setBottom(double bottom) throws InvalidWindowException {

		if (bottom >= this.top) {
			throw new InvalidWindowException("ERROR: Bottom value must be smaller than top");
		}
		this.bottom = bottom;
	}

	/**
	 * @return the top
	 */
	public double getTop() {
		return this.top;
	}

	/**
	 * @param top the top to set
	 * @throws InvalidWindowException
	 */
	public void setTop(double top) throws InvalidWindowException {

		if (top <= this.bottom) {
			throw new InvalidWindowException(" ERROR:  Top value must be greater than bottom value ");
		}
		this.top = top;
	}

	/**
	 * @return true if and only if the instance window encloses the argument window  w.
	 *        
	 */
	public Boolean encloses(Window w) {

		if (this.top >= w.top && this.bottom <= w.bottom && this.left <= w.left && this.right >= w.right)
			return true;
		else
			return false;

	}

	/**
	 * @return true if and only if the instance window overlaps the argument window
	 *         w.
	 */
	public Boolean overlaps(Window w) {

		if (this.top <= w.bottom) {
			return false;
		} else if (this.left >= w.right) {
			return false;
		} else if (this.right <= w.left) {
			return false;
		} else if (this.bottom >= w.top) {
			return false;
		}
		return true;
	}

	/**
	 * @return the number of (unordered) overlapping pairs of windows in the input
	 *         array windows.
	 *  
	 *   SO ,INSIDE THE NESTED LOOPS IT COMPARES EVERY SINGLE WINDOW WIT OTHER WINDOWS  AND RECORDS THE VALUE
	 *         
	 */
	public static int overlapCount(Window[] windows) {

		int overlapcount = 0;
		for (int i = 0; i < windows.length; i++) {
			for (int j = i + 1; j < windows.length; j++)
				if (windows[i].overlaps(windows[j])) {
					overlapcount++;
				}
		}
		return overlapcount;
	}

	/**
	 *
	 * @return returns the number of (ordered) enclosing pairs of windows in the
	 *         input array windows.
	 *
	 */
	public static int enclosureCount(Window[] windows) {

		int enclosurecount = 0;
		for (int i = 0; i < windows.length; i++) {
			for (int j = i + 1; j < windows.length; j++) {
				if (windows[i].encloses(windows[j]) || windows[j].encloses(windows[i])) {
					enclosurecount++;
				}
			}
		}
		return enclosurecount;
	}

//main() method runs some interesting test cases of the above methods.
	/**
	 * @param args
	 */
	public static void main(String[] args) throws InvalidWindowException {

 Window w1 = new Window(2, 4, 3,4); // L, R, T ,B
 Window w2 = new Window(5, 8, 2, 5);
 Window w3 = new Window(4, 7, 3, 4);
 Window w4 = new Window(7, 9, 5, 10);
 Window w5 = new Window(10, 15, 15, 18);
 Window w6 = new Window(20, 25, 2, 4);
 Window w7 = new Window(5, 10, 3, 5);
 Window w8 = new Window(5, 7, 2, 4);

 Window windows[] = { w1, w2, w3,w4,w5,w6,w7,w8 };

		System.out.println(" Result of the program is as follows:     \n");

		System.out.println("The number of (unordered) overlapping pairs of windows: " + Window.overlapCount(windows));
		System.out.println("The number of (ordered) enclosing pairs of windows: " + Window.enclosureCount(windows));
	}
	

}

