package model.high.implementation;

import model.high.command.Command;
import model.high.editor.Editor;
import model.low.document.HasSubSection;
import model.low.document.Section;

public class Degrade implements Command {

	private Editor editor;
	
	@Override
	public boolean match(CharSequence str) {
		return str.equals(EditCommands.DOWNGRADE);
	}

	@Override
	public void execute(CharSequence str) {
		HasSubSection selectedItem = editor.getSelectedItem();
		if(selectedItem instanceof Section) {
			Section section = (Section) selectedItem;
			HasSubSection parent = section.getParent();
			//TODO finish
		}
	}

}
