package converter;
/**
 * UnitFactory return unitType and unit what you want.
 * @author Jirayut Leeupathumvong 5810546617
 */
public class UnitFactory {
	private static UnitFactory unitFactory = null;
	/**
	 * Constructor of UnitFactory.
	 */
	private UnitFactory(){ }
	
	/**
	 * check instance of unitFactory that not have to new create and return or already have then return unitfactory.
	 * @return return the new UnitFactory.
	 */
	public static UnitFactory getInstance (){
		if (unitFactory == null)
			unitFactory = new UnitFactory();
		return unitFactory;
	}
	/**
	 * Return Array of known unit types.
	 * @return array of known unit types.
	 */
	public UnitType[] getUnitType(){
		return UnitType.values();
	}
	/**
	 * Return Unit array of utype.
	 * @param utype Is UnitType is type of unit.
	 * @return return array of unit of UnitType.
	 */
	public Unit[] getUnits (UnitType utype){ 
		if (utype == UnitType.Area ){
			return Area.values();
		} else if ( utype == UnitType.Length ){
			return Length.values();
		} else if ( utype == UnitType.Weight ){
			return Weight.values();
		} else 
			return Time.values();
	}

}
