import java.util.ArrayList; 
import java.util.List;
import java.util.HashMap; 
import java.util.Map;  

public class Biller{
	private Packer packer;

	public Biller(float perishableLimit, float perishablePackingRate, 
		float nonPerishableLimit, float nonPerishablePackingRate){
		this.packer=new Packer(perishableLimit,perishablePackingRate,
			nonPerishableLimit,nonPerishablePackingRate);
	}

	public float getBill(Cart cart, HashMap<String,Item> lstStoreItems){
		ArrayList<Item> lstCartItems = cart.getCartItems();
		float shippingCharges=this.packer.getShippingCharges(lstCartItems);
		float totalBill=0;
		for(Item item : lstCartItems){
			if(item.getCategory()==1){
				Perishables perishable=(Perishables)lstStoreItems.get(item.getName());
				System.out.println(perishable.getUnitPrice()+" "+perishable.getWeight()+" "+perishable.getUnitQuantity());
				totalBill+=(perishable.getUnitPrice()*perishable.getWeight()*perishable.getUnitQuantity());
			}else{
				NonPerishables nonperishable = (NonPerishables)lstStoreItems.get(item.getName());
				System.out.println(nonperishable.getUnitPrice()+" "+nonperishable.getVolume()+" "+nonperishable.getUnitQuantity());
				totalBill+=(nonperishable.getUnitPrice()*nonperishable.getVolume()*nonperishable.getUnitQuantity());
			}
		}
		return totalBill+shippingCharges;
	}

}