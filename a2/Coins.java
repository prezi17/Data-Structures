package A2;


	import java.util.Scanner;

	class Coins{
		
	/*
	 * @returns the different number of ways the coin can be changed.
	 * the recursive method to calculate  ways.
	 * it calls the wayshelper which checks how many quaters/nickel/dime/penny is there 
	 * 
	 */
		static void ways(int amount) {
			waysHelper(amount, 0, 0, 0, 0, 0);
		}

		/*
		 *  prints it while checking the plurals/singular noun depending on the number of coins.
		 *  in its recursive function it starts from the conditioncheck at step 0 and then add 1 to quater
		 *   and keep on repeating the step untill unless the amount is either 0 or goes less than 0
		 *    and at that point it moves to the next conditioncheckstep 1 provided amount became negative in the previous step.
		 *     and then again repeats the same step  with rest of the coins and condition check increases by 1 at every coin change.
		 */
		static void waysHelper(int amount,int quarter, int dime, int nickel, int pennies, int conditionCheck) {
			if (amount == 0) {
				if (quarter > 0) {
					if (quarter == 1)
						System.out.print(quarter + " quarter ");
					else
						System.out.print(quarter + " quarters ");
				}
				if (dime > 0) {
					if (dime == 1)
						System.out.print(dime + " dime ");
					else
						System.out.print(dime + " dimes ");
				}
				if (nickel > 0) {
					if (nickel == 1)
						System.out.print(nickel + " nickel ");
					else
						System.out.print(nickel + " nickels ");
				}
				if (pennies > 0) {
					if (pennies == 1)
						System.out.print(pennies + " penny ");
					else
						System.out.print(pennies + " pennies ");
				}
				System.out.println();
			} else if (amount > 0) {
				if (conditionCheck == 0) {
					waysHelper(amount - 25, quarter + 1, dime , nickel, pennies, conditionCheck);
					conditionCheck = 1;
				}
				if (conditionCheck == 1) {
					waysHelper(amount - 10, quarter, dime + 1, nickel, pennies, conditionCheck);
					conditionCheck = 2;
				}
				if (conditionCheck == 2) {
					waysHelper(amount - 5,quarter, dime, nickel + 1, pennies, conditionCheck);
					conditionCheck = 3;
				}
				if (conditionCheck == 3) {
					waysHelper(amount - 1, quarter, dime, nickel, pennies + 1, conditionCheck);
					conditionCheck = 4;
				}
			}
		}
		public static void main(String args[]) {
			Scanner readValue = new Scanner(System.in);
			int val;
			System.out.println("enter an amount in cents:\n");
			val = readValue.nextInt();
			System.out.println("This amount can be changed in the following ways:");
			ways(val);
		}
	}
