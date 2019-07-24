import java.util.ArrayList; 
import java.util.List; 

public class Cart{
	
	private ArrayList<Item> lstCartItems;

	public Cart(){
		this.lstCartItems=new ArrayList<Item>();
		return;
	}

	public void addPerishableItemToCart(Perishables item){
		this.lstCartItems.add(item);
		return;
	}

	public void addNonPerishableItemToCart(NonPerishables item){
		this.lstCartItems.add(item);
		return;
	}

	public ArrayList<Item> getCartItems(){
		return this.lstCartItems;
	}

	public Item removeItemFromCart(String itemName){
		for(Item item : this.lstCartItems){
			if(item.getName().equals(itemName)){
				this.lstCartItems.remove(item);
				return item;
			}
		}
		return null;
	}
}