import java.util.HashMap; 
import java.util.Map; 

public class Utility{
	HashMap<String,Item> map;

	public Utility(){
		map=new HashMap<String,Item>();
	}

	public void addItem(String itemName, Item item){
		this.map.put(itemName, item);
		return;
	}

	public Item getItem(String itemName){
		return this.map.get(itemName);
	}

	public HashMap<String,Item> getItemList(){
		return this.map;
	}
}