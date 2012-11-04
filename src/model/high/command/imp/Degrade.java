package model.high.command.imp;

import java.util.ArrayList;

import model.high.command.Command;
import model.high.editor.Editor;
import model.low.document.HasSubSection;
import model.low.document.Section;

public class Degrade implements Command {

	private Editor editor;
	
	
	public Degrade(Editor editor) {
		this.editor = editor;
	}

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
			int index = 0;
			while(!parent.getSubSection(index).equals(section)) ++index;
			
			//insert the sections if there is a preceding section
			if(index !=0) {
				parent.removeSubSection(index);
				ArrayList<Section> sectionsToAdd = new ArrayList<Section>(section.getSubSectionNb() +1);
				
				for(int i = 0 ; i < section.getSubSectionNb() ; ++i) {
					sectionsToAdd.add(section.getSubSection(0));
					section.removeSubSection(0);
				}
				sectionsToAdd.add(0, section);
				
				for(int i = 0 ; i < sectionsToAdd.size() ; ++i) {
					parent.getSubSection(index -1).addSubSection(sectionsToAdd.get(i));
				}
				
			}
		}
	}

}
