package converter;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
/**
 * Graphic User interface of Converter.
 * @author Jirayut Leeupathumvong 5810546617
 *
 */
public class ConverterUI extends JFrame {

	private JButton convertButton;
	private UnitConverter unitconverter;
	private JPanel contentPane;
	private JTextField firstTextField , secondTextField;
	private JComboBox<Unit> chooseUnitFirstBox;
	private JComboBox<Unit> chooseUnitSecondBox;
	private JButton clearButton;
	private JMenuBar menuBar;
	private JMenu unitTypesMenu;
	private JMenuItem lengthMenuItem , areaMenuItem , weightMenuItem , timeMenuItem , mntmExit;
	private JSeparator separator;
	/**
	 * Constructor of ConverterUI
	 * @param uc is Object from UnitConverter
	 */
	public ConverterUI ( UnitConverter uc){
		this.unitconverter = uc;
		this.setTitle("Unit Converter");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		initComponents();
	}
	/**
	 * initialize components in the window
	 */
	private void initComponents(){
		setBounds(100, 100, 720, 80);
		setResizable(false);
		
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		unitTypesMenu = new JMenu("Unit Types");
		menuBar.add(unitTypesMenu);
		
		lengthMenuItem = new JMenuItem("Length");
		lengthMenuItem.addActionListener(new SetUnitLength() );
		unitTypesMenu.add(lengthMenuItem);
		
		areaMenuItem = new JMenuItem("Area");
		areaMenuItem.addActionListener(new SetUnitArea() );
		unitTypesMenu.add(areaMenuItem);
		
		weightMenuItem = new JMenuItem("Weight");
		weightMenuItem.addActionListener(new SetUnitWeight() );
		unitTypesMenu.add(weightMenuItem);
		
		timeMenuItem = new JMenuItem("Time");
		timeMenuItem.addActionListener(new SetUnitTime() );
		unitTypesMenu.add(timeMenuItem);
		
		separator = new JSeparator();
		unitTypesMenu.add(separator);
		
		mntmExit = new JMenuItem("Exit");
		mntmExit.addActionListener(new Exit() );
		unitTypesMenu.add(mntmExit);

		contentPane = new JPanel(new FlowLayout( FlowLayout.CENTER ,5,5));
		setContentPane(contentPane);

		firstTextField = new JTextField();
		firstTextField.setPreferredSize( new Dimension (100,30));
		firstTextField.addKeyListener(new ConvertButtonListener());
		contentPane.add(firstTextField );

		chooseUnitFirstBox = new JComboBox<Unit>( unitconverter.getUnits( UnitType.Length ));
		chooseUnitFirstBox.addActionListener( new ConvertButtonListener() );
		contentPane.add(chooseUnitFirstBox);

		JLabel equalsLabel = new JLabel("=");
		contentPane.add(equalsLabel);

		secondTextField = new JTextField();
		secondTextField.setPreferredSize( new Dimension (100,30) );
		secondTextField.addKeyListener(new ConvertButtonListener());
		contentPane.add( secondTextField );

		chooseUnitSecondBox = new JComboBox<Unit>( unitconverter.getUnits( UnitType.Length ) );
		chooseUnitSecondBox.addActionListener( new ConvertButtonListener() );
		contentPane.add(chooseUnitSecondBox);

		convertButton = new JButton("Convert!");
		convertButton.addActionListener( new ConvertButtonListener() );
		contentPane.add(convertButton);

		clearButton = new JButton("Clear");
		clearButton.addActionListener(new Clear());
		contentPane.add(clearButton);
	}

	/**
	 * ConvertButtonListener is an ActionListener that performs an action when the button is pressed.
	 * It read the text form JTextField , Convert the value ,  call the unitconvecter to convert ,
	 * set Text in other text field and when user input not a number color of text change to red.
	 */
	class ConvertButtonListener implements ActionListener , KeyListener {

		/**
		 * The method convert is action to convert any direction you want.
		 */
		public void convert(){
			JTextField[] textFieldArray = { firstTextField , secondTextField };
			int numberArrayToConverter = ( (firstTextField.isFocusOwner() || chooseUnitSecondBox.isFocusOwner() )) ? 0 : 1 ;
			String s = textFieldArray[numberArrayToConverter].getText().trim();
			if ( s.length() > 0 ){
				firstTextField.setForeground(Color.BLACK);
				secondTextField.setForeground(Color.BLACK);
				try {
					double value = Double.valueOf(s);
					Unit unitFirstSelected = (Unit) chooseUnitFirstBox.getSelectedItem();
					Unit unitSecondSelected = (Unit) chooseUnitSecondBox.getSelectedItem();
					Unit[] unitArray = {unitFirstSelected , unitSecondSelected};
					int numberSwitch = (numberArrayToConverter == 0) ? 1 : 0 ;
					textFieldArray[numberSwitch].setText( String.format("%.5g", unitconverter.convert(value, unitArray[numberArrayToConverter], unitArray[numberSwitch])));
				} catch (NumberFormatException e){
					firstTextField.setForeground(Color.RED);
					secondTextField.setForeground(Color.RED);
				}
			}
		}

		/**
		 * The action to perform action when pressed the convert button and change Unit vector
		 */
		public void actionPerformed( ActionEvent evt){
			this.convert();
		}

		/**
		 * The action to keyPressed action when pressed Key "ENTER" in each JTextField
		 */
		@Override
		public void keyPressed(KeyEvent e) {
			if(e.getKeyCode() == KeyEvent.VK_ENTER )
				this.convert();
		}

		@Override
		public void keyTyped(KeyEvent e) {}

		/**
		 * The action to keyReleased action when released the key in each JTextField
		 */
		@Override
		public void keyReleased(KeyEvent e) {
			this.convert();
			if ( firstTextField.getText().equals("") && e.getKeyCode() == KeyEvent.VK_BACK_SPACE )
				secondTextField.setText("");
			else if ( secondTextField.getText().equals("") && e.getKeyCode() == KeyEvent.VK_BACK_SPACE )
				firstTextField.setText("");
		}
	}
	
	/**
	 * Clear is an ActionListener that performs an action when pressed "Clear" button.
	 * It reset null in both JTextField , and reset selected to first list in JComboBox
	 */
	class Clear implements ActionListener{
		public void actionPerformed ( ActionEvent evt ){
			chooseUnitFirstBox.setSelectedIndex(0);
			chooseUnitSecondBox.setSelectedIndex(0);
			firstTextField.setText(null);
			secondTextField.setText(null);
		}
	}
	/**
	 * Exit is an ActionListener that performs an action when pressed Exit menu item to close the program.
	 */
	class Exit implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			System.exit(JFrame.EXIT_ON_CLOSE);
		}
	}
	/**
	 * SetUnitLength is an ActionListener to set new Unit when you choose Length unit to convert.
	 */
	class SetUnitLength implements ActionListener{
		public void actionPerformed ( ActionEvent evt ){
			chooseUnitFirstBox.setModel( new DefaultComboBoxModel<Unit>( unitconverter.getUnits( UnitType.Length ) ) );
			chooseUnitSecondBox.setModel( new DefaultComboBoxModel<Unit>( unitconverter.getUnits( UnitType.Length ) ) );
		}
	}
	/**
	 * SetUnitArea is an ActionListener to set new Unit when you choose Area unit to convert.
	 */
	class SetUnitArea implements ActionListener{
		public void actionPerformed ( ActionEvent evt ){
			chooseUnitFirstBox.setModel( new DefaultComboBoxModel<Unit>( unitconverter.getUnits( UnitType.Area ) ) );
			chooseUnitSecondBox.setModel( new DefaultComboBoxModel<Unit>( unitconverter.getUnits( UnitType.Area ) ) );
		}
	}
	/**
	 * SetUnitTime is an ActionListener to set new Unit when you choose Time unit to convert.
	 */
	class SetUnitTime implements ActionListener{
		public void actionPerformed ( ActionEvent evt ){
			chooseUnitFirstBox.setModel( new DefaultComboBoxModel<Unit>( unitconverter.getUnits( UnitType.Time ) ) );
			chooseUnitSecondBox.setModel( new DefaultComboBoxModel<Unit>( unitconverter.getUnits( UnitType.Time )) );
		}
	}
	/**
	 * SetUnitWeight is an ActionListener to set new Unit when you choose Weight unit to convert.
	 */
	class SetUnitWeight implements ActionListener{
		public void actionPerformed ( ActionEvent evt ){
			chooseUnitFirstBox.setModel( new DefaultComboBoxModel<Unit>( unitconverter.getUnits( UnitType.Weight ) ) );
			chooseUnitSecondBox.setModel( new DefaultComboBoxModel<Unit>( unitconverter.getUnits( UnitType.Weight ) ) );
		}
	}


}