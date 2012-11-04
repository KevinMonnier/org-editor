package model.high.command.imp;

import model.high.command.Command;
import model.high.editor.Editor;
import model.low.document.DocumentWriter;

public class Save implements Command {

	private Editor editor;
	private DocumentWriter writer;

	public Save(Editor editor, DocumentWriter writer) {
		super();
		this.editor = editor;
		this.writer = writer;
	}

	@Override
	public boolean match(CharSequence str) {
		return str.toString().startsWith(EditCommands.SAVE_FILE + " ");
	}

	@Override
	public void execute(CharSequence str) {
		String path = str.toString().substring(EditCommands.SAVE_FILE.length() + 1 );
		this.writer.saveDocument(path, this.editor.getDocument());
	}

}
