package controller;

import model.high.editor.Editor;
import model.high.implementation.AddSection;
import model.high.implementation.EditorImp;
import model.low.cursor.imp.CursorImp;
import model.low.document.imp.DocumentImp;
import view.EditorView;

public class Controller {
	EditorView view;
	Editor editor;
	
	public Controller() {
		this.editor = new EditorImp(CursorImp.getCursor());
		
		this.view = new EditorView();
		this.editor.addCommand(new AddSection(this.editor));
		this.view.getDocument().addKeyListener(new WriteKey(editor, view));
		this.view.getCommand().setAction(new ExecuteCommand(view, editor));
		
	}
}
