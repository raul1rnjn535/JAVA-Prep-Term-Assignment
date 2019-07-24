import java.util.ArrayList; 
import java.util.List; 

public class Packer{
	private float perishableLimit;
	private float perishablePackingRate;
	private float nonPerishableLimit;
	private float nonPerishablePackingRate;

	public Packer(float perishableLimit, float perishablePackingRate, 
		float nonPerishableLimit, float nonPerishablePackingRate){
		this.perishableLimit=perishableLimit;
		this.perishablePackingRate=perishablePackingRate;
		this.nonPerishableLimit=nonPerishableLimit;
		this.nonPerishablePackingRate=nonPerishablePackingRate;
	}

	public void setPerishableLimit(float perishableLimit){
		this.perishableLimit=perishableLimit;
	}

	public float getPerishableLimit(){
		return this.perishableLimit;
	}
	
	public void setPerishablePackingRate(float perishablePackingRate){
		this.perishablePackingRate=perishablePackingRate;
	}

	public float getPerishablePackingRate(){
		return this.perishablePackingRate;
	}
	
	public void setNonPerishableLimit(float nonPerishableLimit){
		this.nonPerishableLimit=nonPerishableLimit;
	}

	public float getNonPerishableLimit(){
		return this.nonPerishableLimit;
	}

	public void setNonPerishablePackingRate(float nonPerishablePackingRate){
		this.nonPerishablePackingRate=nonPerishablePackingRate;
	}

	public float getNonPerishablePackingRate(){
		return this.nonPerishablePackingRate;
	}

	public float getShippingCharges(ArrayList<Item> lstItems){
		float totalWeight=0,totalVolume=0;
		for(Item item : lstItems){
			if(item.getCategory()==1){
				Perishables perishable = (Perishables)item;
				totalWeight+=(perishable.getWeight()*perishable.getUnitQuantity());
			}
			else{
				NonPerishables nonperishable = (NonPerishables)item;
				totalVolume+=(nonperishable.getVolume()*nonperishable.getUnitQuantity());
			}
		}
		float chargeableweight=totalWeight>this.perishableLimit?totalWeight-this.perishableLimit:0;
		float chargeablevolume=totalVolume>this.nonPerishableLimit?totalVolume-this.nonPerishableLimit:0;
		return (chargeablevolume*nonPerishablePackingRate+chargeableweight*perishablePackingRate);
	}

}