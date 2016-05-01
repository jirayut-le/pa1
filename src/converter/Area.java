package converter;
/**
 * 
 * A definition of common units of Area.
 * @author Jirayut Leeupathumvong 5810546617
 */
public enum Area implements Unit{
	/**
	 * Define the members of the enumeration
	 * The attributes are :
	 * name = a string name for this unit,
	 * value = multiplier to convert to square meter.
	 */
	SQUAREMETER ( "Sq.Meter", 1.0 ),
	SQUARECENTIMETER( "Sq.Centimeter" , 1/Math.pow(10, 6)),
	SQUAREKILOMETER( "Sq.Kilometer" , 1/Math.pow(10, -6) ),
	SQUAREMILE( "Sq.Mile" , 1/(3.861*Math.pow(10, -7)) ),
	SQUAREYARD( "Sq.Yard" , 1/1.19599 ),
	SQUAREFOOT( "Sq.Foot" , 1/10.7639 ),
	HECTARE( "Hectare" , 1/Math.pow(10, -4) ),
	ACRE( "Acre" , 1/0.000247105 ),
	SQUAREWA( "Sq.Wa" , 1/0.25 );

	/** name of this unit */
	public final String name;
	
	/** multiplier to convert this unit to std unit */
	public final double value;
	
	/**
	 * constructor for enum members
	 * @param name String name of unit.
	 * @param value Value double of unit.
	 */
	Area (String name , double value){
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
