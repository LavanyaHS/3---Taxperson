package TaxPackage;
//class for items property.
public class Item{
	public char type;
	public String name;
	public double price;
	public int id;
	 
	 
	public Item(int id, char type,	String name, double price){
		this.type=type;
		this.name=name;
		this.price=price;
		this.id=id;
	}
}
