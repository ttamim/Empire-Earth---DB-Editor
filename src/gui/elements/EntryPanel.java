package gui.elements;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

import dbstructure.EntryStruct;

public class EntryPanel extends JPanel {
	
	private static final long serialVersionUID = 990173999618803006L;
	
	public final int index;
	public final EntryStruct entryStruct;
	public final JLabel label;
	public final ValueField field;
	
	public EntryPanel (EntryStruct entryStruct, int index){
		this.index = index;
		this.entryStruct = entryStruct;
		setLayout(new GridLayout(0, 1, 0, 0));
		setPreferredSize(new Dimension(150, 50));
		label = new JLabelEx(entryStruct, index);
		switch(entryStruct.type){
			case FLAG:
				field = new JToggleButtonEx(entryStruct, index);
				break;
			default:
				field = new JTextFieldEx(entryStruct, index, null);
		}
		add(label);
		add((Component) field);
	}
	
	public void setVal(Object val){
		field.setVal(val);
	}
	
	public Object getVal(){
		return field.getVal();
	}

}
