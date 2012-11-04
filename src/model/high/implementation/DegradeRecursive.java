package model.high.implementation;

import model.high.command.Command;
import model.high.editor.Editor;
import model.low.document.HasSubSection;
import model.low.document.Section;

public class DegradeRecursive implements Command {

	private Editor editor;
	
	
	
	public DegradeRecursive(Editor editor) {
		super();
		this.editor = editor;
	}

	@Override
	public boolean match(CharSequence str) {
		return str.equals(EditCommands.DOWNGRADE_RECURSIVE);
	}

	@Override
	public void execute(CharSequence str) {
		HasSubSection selectedItem = editor.getSelectedItem();
		if(selectedItem instanceof Section) {
			Section section = (Section) selectedItem;
			HasSubSection parent = section.getParent();
			int index = 0;
			while(!parent.getSubSection(index).equals(section)) ++index;
			
			if(index !=0) {
				parent.removeSubSection(index);
				parent.getSubSection(index-1).addSubSection(section);
			}
		}
	}

}
