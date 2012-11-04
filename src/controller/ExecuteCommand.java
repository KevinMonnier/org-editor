package controller;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import model.high.editor.Editor;

import view.EditorView;

public class ExecuteCommand extends AbstractAction {

	private static final long serialVersionUID = 3461234318923481245L;

	private EditorView view;
	private Editor editor;

	public ExecuteCommand(EditorView view, Editor editor) {
		super("execute");
		this.view = view;
		this.editor = editor;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		String command = view.getCommand().getText();
		view.getCommand().setText("");
		this.view.getCommand().setVisible(false);
		command = command.substring(1);
		editor.executeCommand(command);
		view.getDocument().setText(this.editor.print());
	}

}
