package model.high.implementation;

import model.high.command.Command;
import model.high.editor.Editor;

public class Cut implements Command {

	private Editor editor;

	public Cut(Editor editor) {
		super();
		this.editor = editor;
	}

	@Override
	public boolean match(CharSequence str) {
		return str.equals(EditCommands.REMOVE);
	}

	@Override
	public void execute(CharSequence str) {
		// TODO Auto-generated method stub
		if(this.editor.getSelectedLine().isInTitle()) {
			
		}
		else {
			
		}
	}

}
