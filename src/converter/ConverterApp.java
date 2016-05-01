package converter;
import java.awt.EventQueue;
/**
 * Application of Converter.
 * @author Jirayut Leeupathumvong 5810546617
 *
 */
public class ConverterApp {
	public static void main (String[] args){
		UnitConverter uc = new UnitConverter();
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConverterUI converter = new ConverterUI(uc); 
					converter.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
