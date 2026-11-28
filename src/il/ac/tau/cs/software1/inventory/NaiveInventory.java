package il.ac.tau.cs.software1.inventory;

/*
 * A simple array-based Inventory (Question 6).
 */
public class NaiveInventory implements Inventory {

	private static final int INITIAL_CAPACITY = 100;

	private Collectible [] collectibles;
	private int amount;

	public NaiveInventory() {
		this.collectibles = new Collectible[INITIAL_CAPACITY];
		this.amount = 0;
	}

	@Override
	public void collect(Collectible collectible) {
		// if the inventory is full - extend it to be twice as large
		if (this.amount == this.collectibles.length){
			Collectible [] extention = new Collectible[this.collectibles.length*2];
			for (int i = 0; i < this.collectibles.length; i++){
				extention[i] = this.collectibles[i];
			}
			this.collectibles = extention;
		}
		// if there is room for another collectable - collect it
		this.collectibles[this.amount] = collectible;
		this.amount++;
	}

	@Override
	public float getTotalWeight() {
		float totalWeight = 0;
		for (int i = 0; i < this.amount; i++){
			totalWeight += this.collectibles[i].getWeight();
		}
		return totalWeight;
	}

	@Override
	public int getCurrentCount() {
		return this.amount;
	}

	// Returns the array of Collectibles that is stored in the field of this class
	public Collectible[] getCollArr() {
		return this.collectibles;
	}
}
