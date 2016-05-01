package converter;

/**
 * This class is to calculate the convert unit and return unit.
 * @author Jirayut Leeupathumvong 5810546617
 */
public class UnitConverter {
	
	/**
	* Returns conversion result from an amount of fromUnit to toUnit.
	* @param amount the quantity to convert
	* @param fromUnit base unit before conversion
	* @param toUnit target unit after conversion
	* @return value of conversion result
	*/
	public double convert( double amount , Unit fromUnit , Unit toUnit ){
		return (amount*fromUnit.getValue())/toUnit.getValue();
	}

	/**
	 * Return array unit of UnitType form UnitFactory.
	 * @param utype is Unit Type that you choose.
	 * @return return array unit of UnitType.
	 */
	public Unit[] getUnits(UnitType utype){
		return UnitFactory.getInstance().getUnits( utype );
	}
}
