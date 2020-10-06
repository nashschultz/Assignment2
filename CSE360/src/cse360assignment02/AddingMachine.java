package cse360assignment02;

public class AddingMachine {
  private int total; // private total variable
  private int[] transactions;
  
  public AddingMachine () { // constructor for AddingMachine
    total = 0;  // not needed - included for clarity
    transactions = new int[0]; // initializes empty array
  }
  
  public int getTotal () { // returns total - accesses private variable
    return total;
  }
  
  public void add (int value) { // adds to total
	  transactions = addToArray(transactions, value); // adds to array
	  total += value; // subtracts
  }

  public void subtract (int value) { // subtracts from total
	  transactions = addToArray(transactions, -value); // adds to array
	  total -= value; // subtracts
  }
  
  private int[] addToArray(int[] array, int value) { // accessory function to add to the array
	  int[] newArray = new int[array.length + 1];
	  for(int i=0; i < array.length; i++) {
		  newArray[i] = array[i]; // moves existing over to new array
	  }
	  newArray[array.length] = value; // adds new value at end
	  return newArray; // returns it 
  }

  public String toString () { // prints all previous transactions
	  String transHistory = ""; // sets up string
	  for(int i=0; i < transactions.length; i++) { // iterates through array
		  if(transactions[i] < 0) {
			  transHistory += " - " + (Math.abs(transactions[i]));
		  } else {
			  if(i == 0) { // doesn't include + if first position
				  transHistory += transactions[i];
			  } else {
				  transHistory += " + " + transactions[i];
			  }
		  }
	  }
	  return transHistory.trim(); // returns with no spaces on end
  }

  public void clear() { // clears transactions 
	  transactions = new int[0];
  }
}