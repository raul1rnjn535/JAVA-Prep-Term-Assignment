public class Perishables extends Item{
	
	private float weight;

	public Perishables(String name, float unitPrice, float unitQuantity, int category){
		super(name, unitPrice, unitQuantity, category);
		this.weight=0f;
	}

	public Perishables(String name, float unitPrice, float unitQuantity, int category, float weight){
		super(name, unitPrice, unitQuantity, category);
		this.weight=weight;
	}

	public void setWeight(float weight){
		this.weight=weight;
	}

	public float getWeight(){
		return this.weight;
	}
}