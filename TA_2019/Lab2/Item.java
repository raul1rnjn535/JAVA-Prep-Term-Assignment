public abstract class Item{
	
	public String name;
	public float unitPrice;
	public float unitQuantity;
	public int category;
	
	public Item(String name, float unitPrice, float unitQuantity, int category){
		this.name=name;
		this.unitPrice=unitPrice;
		this.unitQuantity=unitQuantity;
		this.category=category;
	}

	public void setName(String name){
		this.name=name;
	}

	public String getName(){
		return this.name;
	}

	public void setUnitPrice(float unitPrice){
		this.unitPrice=unitPrice;
	}

	public float getUnitPrice(){
		return this.unitPrice;
	}

	public void setUnitQuantity(float unitQuantity){
		this.unitQuantity=unitQuantity;
	}

	public float getUnitQuantity(){
		return this.unitQuantity;
	}

	public void setCategory(int category){
		this.category=category;
	}

	public int getCategory(){
		return this.category;
	}

}