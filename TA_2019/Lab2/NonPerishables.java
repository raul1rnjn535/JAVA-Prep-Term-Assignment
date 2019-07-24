public class NonPerishables extends Item{
	
	float volume;

	public NonPerishables(String name, float unitPrice, float unitQuantity, int category){
		super(name, unitPrice, unitQuantity, category);
		this.volume=0f;
	}

	public NonPerishables(String name, float unitPrice, float unitQuantity, int category, float volume){
		super(name, unitPrice, unitQuantity, category);
		this.volume=volume;
	}

	public void setVolume(float volume){
		this.volume=volume;
	}

	public float getVolume(){
		return this.volume;
	}
}