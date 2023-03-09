package challengeConversor;

import java.awt.Color;
import java.awt.Font;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

public class MainGUI {

	private JFrame frame;
	private JTextField baseValue;
	private String selectedBaseValue = "";
	private String selectedFinalValue = "";

	/**
	 * Create the application.
	 */
	public MainGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		setFrame(new JFrame());
		getFrame().setResizable(false);
		getFrame().setBounds(100, 100, 700, 450);
		getFrame().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getFrame().getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(UIManager.getColor("Button.background"));
		panel.setBounds(0, 0, 684, 411);
		getFrame().getContentPane().add(panel);
		panel.setLayout(null);

		baseValue = new JTextField();
		baseValue.setForeground(new Color(0, 128, 64));
		baseValue.setBounds(55, 189, 199, 34);
		baseValue.setFont(new Font("Open Sans", Font.PLAIN, 20));
		panel.add(baseValue);
		baseValue.setColumns(8);

		JComboBox<Object> baseCurrency = new JComboBox<Object>();
		baseCurrency.addActionListener(e -> {
				setSelectedBaseValue((String)baseCurrency.getSelectedItem());
		});
		baseCurrency.setBackground(new Color(200, 200, 200));
		baseCurrency.setForeground(new Color(0, 0, 255));
		baseCurrency.setModel(new DefaultComboBoxModel<Object>(new String[] {"", "Real (BRL)", "Dolar Americano (USD)", "Euro (EUR)", "Libra Esterlina (GBP)", "Peso Argentino (ARS)", "Peso Chileno (CLP)", "Iene (JPY)"}));
		baseCurrency.setFont(new Font("Open Sans", Font.PLAIN, 17));
		baseCurrency.setBounds(55, 144, 250, 34);
		panel.add(baseCurrency);

		JComboBox<Object> finalCurrency = new JComboBox<Object>();
		finalCurrency.addActionListener(e -> {
				setSelectedFinalValue((String)finalCurrency.getSelectedItem());				
		});
		finalCurrency.setModel(new DefaultComboBoxModel<Object>(new String[] {"", "Real (BRL)", "Dolar Americano (USD)", "Euro (EUR)", "Libra Esterlina (GBP)", "Peso Argentino (ARS)", "Peso Chileno (CLP)", "Iene (JPY)"}));
		finalCurrency.setForeground(Color.BLUE);
		finalCurrency.setFont(new Font("Open Sans", Font.PLAIN, 17));
		finalCurrency.setBackground(new Color(200, 200, 200));
		finalCurrency.setBounds(380, 144, 250, 34);
		panel.add(finalCurrency);

		JSeparator separator = new JSeparator();
		separator.setBounds(10, 123, 664, 10);
		panel.add(separator);

		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(10, 319, 664, 10);
		panel.add(separator_1);

		JLabel lblHeader = new JLabel("Conversor de Moedas");
		lblHeader.setForeground(new Color(0, 0, 255));
		lblHeader.setFont(new Font("Open Sans", Font.BOLD | Font.ITALIC, 20));
		lblHeader.setBounds(232, 51, 220, 34);
		panel.add(lblHeader);

		JLabel lblResult = new JLabel(" ");
		lblResult.setHorizontalAlignment(SwingConstants.TRAILING);
		lblResult.setFont(new Font("Open Sans", Font.PLAIN, 15));
		lblResult.setBounds(326, 189, 304, 34);
		panel.add(lblResult);
		
		JLabel lblException = new JLabel("Exception");
		lblException.setForeground(new Color(255, 50, 50));
		lblException.setFont(new Font("Open Sans", Font.PLAIN, 17));
		lblException.setHorizontalAlignment(SwingConstants.CENTER);
		lblException.setBounds(217, 294, 250, 20);
		panel.add(lblException);
		lblException.setVisible(false);


		JButton btnConvert = new JButton("Converter");
		btnConvert.setForeground(new Color(0, 64, 128));
		btnConvert.setFont(new Font("Open Sans", Font.PLAIN, 20));
		btnConvert.setBounds(267, 340, 150, 50);
		
		btnConvert.addActionListener(e -> {
		    try {
		        String finalValue = CurrencyConverter.convertCurrency(selectedBaseValue, selectedFinalValue, Double.parseDouble(baseValue.getText()));
		        if(finalValue.isEmpty()) {
	        		lblException.setText("Selecione a Moeda!");
			        lblException.setVisible(true);
		        } else {
		        	lblResult.setText(finalValue);
		        	lblException.setVisible(false);		        	
		        }
		    } catch (NumberFormatException ex) {
		        lblException.setText("Insira um valor!");
		        lblException.setVisible(true);
		    }
		});

		panel.add(btnConvert);
	}

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

	public void setSelectedBaseValue(String selectedCurrency) {
		this.selectedBaseValue = selectedCurrency;
	}

	public void setSelectedFinalValue(String selectedFinalValue) {
		this.selectedFinalValue = selectedFinalValue;
	}
}
