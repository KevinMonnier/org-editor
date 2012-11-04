package controller;

import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import view.EditorView;

import model.high.editor.Editor;

public class WriteKey extends KeyAdapter {

	private Editor editor;
	private EditorView view;
	

	public WriteKey(Editor editor, EditorView view) {
		super();
		this.editor = editor;
		this.view = view;
	}

	@Override
	public void keyTyped(KeyEvent e) {
		if(e.getKeyChar() == this.editor.getCommandChar()) {
			this.view.getCommand().setVisible(true);
			this.view.getCommand().setText(this.editor.getCommandChar()+"");
			this.view.getCommand().requestFocusInWindow();
		}
		else switch (e.getKeyChar()) {
		case '\u0008':
		case '\u007F':
			break;
		case '\n':
			this.editor.newLine();
			break;
		default:
			this.editor.insertChar(e.getKeyChar());	
			
		}
		view.getDocument().setText(this.editor.print());
	}

	@Override
	public void keyPressed(KeyEvent e) {

        
		switch(e.getKeyCode()) {
		case KeyEvent.VK_UP:
			this.editor.getCursor().selectLineUp();
			break;
		case KeyEvent.VK_DOWN:
			this.editor.getCursor().selectLineDown();
			break;
		case KeyEvent.VK_LEFT:
			this.editor.getCursor().movePositionLeft();
			break;
		case KeyEvent.VK_RIGHT:
			this.editor.getCursor().movePositionRight();
			break;
		case KeyEvent.VK_DELETE:
			this.editor.getSelectedLine().deleteCharAt(this.editor.getSelectedCharacterNb());
			break;
		case KeyEvent.VK_BACK_SPACE:
			this.editor.getSelectedLine().deleteCharAt(this.editor.getSelectedCharacterNb()-1);
			this.editor.getCursor().movePositionLeft();
			break;
		}

		view.getDocument().setText(this.editor.print());
	}

	
	

}
