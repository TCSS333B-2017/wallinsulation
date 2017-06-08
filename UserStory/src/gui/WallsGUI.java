package gui;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class WallsGUI {
	private JPanel myPanel;
	private JButton storeButton;
	private JButton calculatorButton;
	private JButton wallsButton;
	private JComboBox<String> myComboBox;
	private int myWallsInt;
	private int numWalls;
	private JLabel numOfWallsLabel;
	private JLabel nextLabel;
	public WallsGUI(JPanel thePanel, JButton theWalls, JButton theStore, JButton theCalc){
		myPanel = thePanel;
		wallsButton = theWalls;
		storeButton = theStore;
		calculatorButton = theCalc;
	}
	void evokeWalls(){
		numOfWallsLabel = new JLabel("Number of Walls:");
		numOfWallsLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		numOfWallsLabel.setBounds(12, 13, 162, 41);
		myPanel.add(numOfWallsLabel);
		
		nextLabel = new JLabel("<-- To the next page!");
		nextLabel.setBounds(12, 75, 162, 41);
		nextLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		String[] choice = {"0", "1", "2", "3", "4", "5"};
		myComboBox = new JComboBox<String>(choice);
		myComboBox.setSelectedIndex(0);
		myComboBox.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				String choice = (String) myComboBox.getSelectedItem();
				//System.out.println(choice);
				if (choice.equals("0")){
					JOptionPane.showMessageDialog(null,"Pick a Number","Alert",JOptionPane.ERROR_MESSAGE);
					//btnNext.setEnabled(false);
					storeButton.setEnabled(false);
					calculatorButton.setEnabled(false);
					myPanel.remove(nextLabel);
					myPanel.repaint();
				} else{
					//////////////////////////////////////////////////
					//CHANGE SYSTEM.OUT.PRINTLN TO THE CALCULATOR CALL 
					//System.out.println(myComboBox.getSelectedIndex());
					//////////////////////////////////////////////////
					myWallsInt = Integer.parseInt(choice);
					//btnNext.setEnabled(true);
					storeButton.setEnabled(true);
					myPanel.add(nextLabel);
					myPanel.repaint();
					//System.out.println(myNumWalls);
				}
			}
		});
		myComboBox.setBounds(172, 23, 116, 22);
		myPanel.add(myComboBox);
	}
}
