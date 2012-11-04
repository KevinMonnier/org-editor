package model.high.command.imp;

import model.high.command.Command;
import model.high.editor.Editor;
import model.low.document.HasSubSection;
import model.low.document.Section;

public class HideUnhide implements Command {

	Editor editor;
	
	
	
	public HideUnhide(Editor editor) {
		super();
		this.editor = editor;
	}

	@Override
	public boolean match(CharSequence str) {
		return str.equals(EditCommands.HIDE_OR_SHOW);
	}

	@Override
	public void execute(CharSequence str) {
		HasSubSection selectedItem = editor.getSelectedItem();
		if(selectedItem instanceof Section) {
			((Section) selectedItem).getState().showHide((Section) selectedItem);
			this.editor.getCursor().setCurrentLine(((Section) selectedItem).getFirstLine());
		}
	}

}
