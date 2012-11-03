package controller;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import model.high.editor.Editor;

import view.EditorView;

public class ExecuteCommand extends AbstractAction {

	private EditorView view;
	private Editor editor;

	public ExecuteCommand(EditorView view, Editor editor) {
		super("execute");
		this.view = view;
		this.editor = editor;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		String command = view.getCommand().getText();
		view.getCommand().setText("");
		command = command.substring(1);
		editor.executeCommand(command);
		view.getDocument().setText(this.editor.print());
	}

}
