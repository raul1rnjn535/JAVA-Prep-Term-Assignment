import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class StoreOutlet{
	public static void main(String[] args){
		Store store = new Store(5,5,4,2);
		store.addItemToStore("Banana",35,1,1);
		store.addItemToStore("Carrots",60,1,1);
		store.addItemToStore("Potato",70,1,1);
		store.addItemToStore("Grapes",120,1,1);
		store.addItemToStore("Butter",210,1,1);
		store.addItemToStore("Detergent",200,2.5f,2);
		store.addItemToStore("Soap",35,0.4f,2);
		store.addItemToStore("Notebook",40,0.2f,2);
		Cart cart = new Cart();
		Perishables grapes=new Perishables("Grapes",120,1,1,0.5f);	
		cart.addPerishableItemToCart(grapes);	 
		Perishables potato=new Perishables("Potato",70,1,1,3.0f);	
		cart.addPerishableItemToCart(potato);	 
		NonPerishables soap=new NonPerishables("Soap",35,1,2,5f);	
		cart.addNonPerishableItemToCart(soap);	 
		NonPerishables detergent=new NonPerishables("Detergent",200,1,2,2.0f);	
		cart.addNonPerishableItemToCart(detergent);	 
		Perishables butter=new Perishables("Butter",210,1,1,0.5f);	
		cart.addPerishableItemToCart(butter);	 
		Perishables carrots=new Perishables("Carrots",60,1,1,1.5f);	
		cart.addPerishableItemToCart(carrots);
		return;
	}
}