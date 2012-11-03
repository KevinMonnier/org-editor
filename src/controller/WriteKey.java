package controller;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import view.EditorView;

import model.high.editor.Editor;
import model.low.document.Text;
import model.low.document.TextIntro;
import model.low.document.imp.LineImp;

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
			break;
		case '\n':
			this.editor.newLine();
			break;
		default:
			this.editor.insertChar(e.getKeyChar());	
			
		}
		view.getDocument().setText(this.editor.print());
	}

}
