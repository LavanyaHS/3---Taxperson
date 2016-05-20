package TaxPackage;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Iterator;

/*
*@author Lavanya
*This class asks user to select an item code ,calculates tax and prints total cost of the item.
*/
public class TaxPerson {

 
	public static void main(String[] args) {
		Scanner s1 = new Scanner(System.in);
		 int itemid;
		ArrayList<Item> items = new ArrayList<Item>();
		//displays items. 
		addandDisplayItems(items);
	 

	System.out.println("\n-----------------------------");
	System.out.println("Please enter the Item_id to calculate Total Cost:");
	System.out.println("-----------------------------");
	
	try {
		itemid = s1.nextInt();
		// find the the item-id is available or not
		if (!findItem(items, itemid)) {
			System.err.println("Sorry no record found");
		}

	}

	catch (NumberFormatException e) {
		System.err.println("Please enter valid item code " + e.getMessage());
	} catch (Exception e) {
		System.err.println("Please enter valid item code " + e.getMessage());
	} finally {
		if (s1 != null) {
			s1.close();
		}
	}
}

	/*
	 Finds item _id in the list.
	 calls calculateTax method.
	 returns true if item_id is found and false if not
	 @param arraylist items 
	  @param int itemTid  
	  @return boolean true/false
	 */

	public static boolean findItem(ArrayList<Item> items, int itemId) {
		boolean itemFlag = false;
		double total_cost;
		Iterator<Item> itr = items.iterator();
		while (itr.hasNext()) {

			Item it = (Item) itr.next();
			if (it.id == itemId) {
			total_cost=	calculateTax(it.name, it.price, it.type);
				 System.out.println();
				 System.out.format("%s%15s ",   it.name, total_cost + "Cents");
				itemFlag = true;
			}

		}

		return itemFlag;
	}
	/*
	  creates item type objects
	  add items in list. 
	  iterates through the list and print the items 
	  @param  arryalist items
	 */

	public static void addandDisplayItems(ArrayList<Item> items) {
		Item item1 = new Item(1,'N', "Internet",100);
		Item item2 = new Item(2,'N', "Television", 500);
		Item item3 = new Item(3,'N', "Car", 1500);
		Item item4 = new Item(4,'N', "Phone", 400);
		Item item5 = new Item(5,'L', "spa", 1000);
		Item item6 = new Item(6,'L', "Foriegn Trip", 4000);
		Item item7 = new Item(7,'L', "daimond", 2500);
		Item item8 = new Item(8,'L', "Yacht", 3000); 
				
		items.add(item1);
		items.add(item2);
		items.add(item3);
		items.add(item4);
		items.add(item5);
		items.add(item6);
		items.add(item7);
		items.add(item8);
		
		System.out.println ("\n-----------------------------");
	    System.out.println ("Please enter the Item_id to calculate Total Cost:");
	    System.out.println ("-----------------------------");
	 
	    System.out.format("%s%15s%17s","Item Id",   "Item", "Total Cost");
	    Iterator<Item> itr=items.iterator();  
		  //traversing elements of ArrayList object  
		  while(itr.hasNext()){  
		    Item it=(Item)itr.next(); 
		    System.out.println();
		    System.out.format("%s%15s%17s",it.id,it.name, it.price);
		    	 }
		  
	
		
	}

	/*
	  Calculates tax based on price and type(luxurious(L) or Necessity(N) ). 
	  for Basic Necessity tax is 1% and 9% if is luxurious item.
	  @return type double -total_cost
	 @param String name of the item
	  @param  double price of the item
	  @param char type of the item(L / N)
	  @return total_cost on the given item
       prints the calculated tax on console
	 */

	public static double calculateTax(String name, double price, char type) {
		// TODO Auto-generated method stub
		System.out.println ("\n-----------------------------");
	    System.out.println ("Items with Total Cost:");
	    System.out.println ("-----------------------------");
	 
	    System.out.format("%s%15s ",   "Item", "Total Cost");
		double total_cost =0;
		if (type=='N'){
			 total_cost = price +(price*1/100);
			//System.out.println();
			//System.out.format("%s%15s ",     name, total_cost + "Cents");
			// return total_cost;
		}
		else if (type=='L'){
			 total_cost = price +(price*9/100);
				//System.out.println();
				//System.out.format("%s%15s ",    name, total_cost + "Cents");
				//return total_cost;
		}
		return total_cost;
		
			}
		
}

