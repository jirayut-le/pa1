package converter;
/**
 * 
 * A definition of common units of Time.
 * @author Jirayut Leeupathumvong 5810546617
 */
public enum Time implements Unit{
	/**
	 * Define the members of the enumeration
	 * The attributes are :
	 * name = a string name for this unit,
	 * value = multiplier to convert to minute.
	 */
	MINUTE( "Minute" , 1.0 ),
	SECOND( "Second" , 1/60.0 ),
	HOUR( "Hour" , 1/0.0166667 ),
	DAY( "Day"  , 1/0.000694444 ),
	WEEK( "Week" , 1/9.9206e-5 ),
	MILLISECOND( "Millisecond" , 1/60000.0 ),
	MICROSECOND( "Microsecond" , 1/(6e+7)),
	BPAK ("Bpàk" , 15/0.000694444);

	/** name of this unit */
	public final String name;
	
	/** multiplier to convert this unit to std unit */
	public final double value;
	
	/**
	 * constructor for enum members
	 * @param name String name of unit.
	 * @param value Value double of unit.
	 */
	Time (String name , double value){
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


