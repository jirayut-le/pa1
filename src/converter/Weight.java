package converter;
/**
 * A definition of common units of Weight.
 * @author Jirayut Leeupathumvong 5801546617
 *
 */
public enum Weight implements Unit{
	
	/**
	 * Define the members of the enumeration
	 * The attributes are :
	 * name = a string name for this unit,
	 * value = multiplier to convert to gram.
	 */
	GRAM( "Gram" , 1),
	KILOGRAM("Kilogram" , 1/0.001),
	MILLIGRAM( "Milligram" , 1/1000.0),
	MICROGRAM( "Microgram" , 1/Math.pow(10, 6)),
	POUND( "Pound" , 1/0.00220462),
	USTON( "US ton", 1/(1.1023*Math.pow(10, -6))),
	STONE( "Stone" , 1/0.000157473),
	OUNCE( "Ounce" , 1/0.035274),
	IMPERIALTON( "Imperial ton" , 1/(9.8421*Math.pow(10, -7))),
	TONNE( "Tonne" , 1/Math.pow(10, -6)),
	CHANGLUANG( "Changluang" , 600.0 );

	/** name of this unit */
	public final String name;
	
	/** multiplier to convert this unit to std unit */
	public final double value;
	
	/**
	 * constructor for enum members
	 * @param name String name of unit.
	 * @param value Value double of unit.
	 */
	Weight (String name , double value){
		this.name = name;
		this.value = value;
	}
	
	/**
	 * public properties of the enum members
	 */
	@Override
	public double getValue () { return value; }
	public String toString (){ return name;}

}
