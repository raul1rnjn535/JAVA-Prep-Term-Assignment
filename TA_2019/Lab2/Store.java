import java.util.HashMap; 
import java.util.Map; 

public class Store{
	private Biller biller;
	private Utility utility;

	public Store(float perishableLimit, float perishablePackingRate, 
		float nonPerishableLimit, float nonPerishablePackingRate){
		this.biller=new Biller(perishableLimit,perishablePackingRate,
			nonPerishableLimit,nonPerishablePackingRate);
		this.utility=new Utility();
	}

	public void addItemToStore(String name, float unitPrice, float unitQuantity, int category){
		if(category==1){
			Perishables perishable=new Perishables(name,unitPrice,unitQuantity,category);
			this.utility.addItem(name,perishable);
		}

		else{
			NonPerishables nonperishable=new NonPerishables(name,unitPrice,unitQuantity,category);
			this.utility.addItem(name,nonperishable);
		}
		return ;
	}

	public float billItems(Cart cart){
		HashMap<String,Item> lstStoreItems=utility.getItemList();
		return this.biller.getBill(cart, lstStoreItems);
	}


}