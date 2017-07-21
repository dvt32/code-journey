package beans;

public class Stock {
	private String name;
	private int quantity;
	private int id;
	
	public Stock() { }
	
	public Stock(String name, int quantity, int id) {
		this.name = name;
		this.quantity = quantity;
		this.id = id;
	}
	
	public String getName() { return name; }
	public void setName(String name) { this.name = name; }
	
	public int getQuantity() { return quantity; }
	public void setQuantity(int quantity) { this.quantity = quantity; }
	
	public int getId() { return id; }
	public void setId(int id) { this.id = id; }
	
	@Override
	public String toString()
	{
		return "[id: " +  id + ", name: " + name + ", quantity: " + quantity +"]";
	}
}
