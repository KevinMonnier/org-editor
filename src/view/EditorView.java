package view;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class EditorView extends JFrame {

	private static final long serialVersionUID = 1L;

	JTextField command;
	JTextArea document;
	JButton executeButton;

	public EditorView() {
		super("Editor");
		JMenuBar menuBar = new JMenuBar();
		JMenu menu = new JMenu("File"); // TODO localization here
		menuBar.add(menu);

		JPanel pan = new JPanel();
		pan.setLayout(new BorderLayout());

		this.document = new JTextArea("Test");
		this.document.setLineWrap(true);

		this.command = new JTextField(20);
		this.executeButton = new JButton("Execute");
		
		pan.add(this.command, BorderLayout.WEST);
		pan.add(this.executeButton, BorderLayout.EAST);
		pan.add(this.document, BorderLayout.NORTH);
		

//		this.command.setVisible(false);
		this.setJMenuBar(menuBar);
		this.setContentPane(pan);
		this.pack();

		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setVisible(true);
	}

	public JTextField getCommand() {
		return command;
	}

	public JTextArea getDocument() {
		return document;
	}

	public static void main(String[] args) {
		new EditorView();
	}
}
