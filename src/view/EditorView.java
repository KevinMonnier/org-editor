package view;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class EditorView extends JFrame {

	JTextField command;
	JTextArea document;

	public EditorView() {
		JMenuBar menuBar = new JMenuBar();
		JMenu menu = new JMenu("File"); // TODO localization here
		menuBar.add(menu);

		JPanel pan = new JPanel();
		pan.setLayout(new BorderLayout());

		this.document = new JTextArea("Test");
		this.document.setLineWrap(true);

		this.command = new JTextField();

		pan.add(this.document, BorderLayout.CENTER);
		pan.add(this.command, BorderLayout.SOUTH);

		this.command.setVisible(false);
		this.setJMenuBar(menuBar);
		this.setContentPane(pan);
		this.pack();

		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
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
