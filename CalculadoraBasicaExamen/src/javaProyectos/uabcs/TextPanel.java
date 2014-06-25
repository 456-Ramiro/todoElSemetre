package javaProyectos.uabcs;

import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class TextPanel extends JPanel {
	
	private JTextArea textArea;
	

	public TextPanel() {
		textArea = new JTextArea(2,2);		
		setLayout(new BorderLayout());	
		
		
		textArea.setFont(new Font("ARIAL",Font.BOLD,20));
		add(new JScrollPane(textArea), BorderLayout.CENTER);
	}
	
	public void appendText(String text) {
		textArea.append(text);
	}

}
