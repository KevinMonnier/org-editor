package model.high.implementation;

import model.high.command.Command;
import model.high.editor.Editor;
import model.low.document.DocumentLoader;

public class LoadFile implements Command {
	
	
	private Editor editor;
	private DocumentLoader documentLoader;
	
	
	
	public LoadFile(Editor editor, DocumentLoader documentLoader) {
		super();
		this.editor = editor;
		this.documentLoader = documentLoader;
	}

	@Override
	public boolean match(CharSequence str) {
		return str.toString().startsWith(EditCommands.LOAD_FILE + " ");
	}

	@Override
	public void execute(CharSequence str) {
		String path = str.toString().substring(EditCommands.LOAD_FILE.length() + 1);
		documentLoader.loadDocument(path);
	}

}
