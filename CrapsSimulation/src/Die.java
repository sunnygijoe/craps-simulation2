
public class Die
{
	private int lastRoll;
	private boolean predictible = false;
	private int[] rolls;
	private int index_of_next_roll;

	public Die()
	{
		CrapsGame.println("Die() constructor called.");
		this.roll();
	}

	public Die(int firstValue) // overloaded constructor: different signature
	{
		CrapsGame.println("Die(int) constructor called.");
		setLastRoll(firstValue);
	}
	
	public Die(int[] predictable_rolls)
	{
		if(predictable_rolls == null)
		{
			throw new RuntimeException("null initializing int array");
		}
		this.predictible = true;
		this.rolls = predictable_rolls;
		this.index_of_next_roll = 0;
		
	}

	public int getLastRoll() // getter or accessor method
	{
		return this.lastRoll;
	}

	// protected => visible to subclasses and same-package classes
	protected void setLastRoll(int lastRoll) // setter or mutator method
	{
		this.lastRoll = lastRoll;
	}

	public void roll() // note how this changes Die's state, but doesn't return
						// anything
	{
		if(!predictible)
			setLastRoll((int) (Math.random() * 6 + 1));
		else
		{
			setLastRoll(this.rolls[index_of_next_roll]);
			index_of_next_roll++;
			if(index_of_next_roll >= this.rolls.length)
			{
				index_of_next_roll = 0;
			}
		}
	}

	// try changing visibility of toString to protected...
	@Override
	public String toString() // this OVERRIDES the default Object.toString()
	{
		return "A Die object with roll " + this.getLastRoll();

		// add the following to the end of the above line:
		// + " " + super.toString()
	}

	public String toString(int msg) // Overloading... but NOT overriding!
	{
		return msg + this.toString();
	}
	
	public static String testStatic()
	{
		return "Die.testStatic()";
	}
}
