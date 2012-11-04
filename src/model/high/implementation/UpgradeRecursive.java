package model.high.implementation;

import java.util.ArrayList;
import java.util.List;

import model.high.command.Command;
import model.high.editor.Editor;
import model.low.document.HasSubSection;
import model.low.document.Section;

public class UpgradeRecursive implements Command {

	private Editor editor;

	public UpgradeRecursive(Editor editor) {
		this.editor = editor;
	}

	@Override
	public boolean match(CharSequence str) {
		return str.equals(EditCommands.UPGRADE_RECURSIVE);
	}

	@Override
	public void execute(CharSequence str) {
		HasSubSection selectedItem = editor.getSelectedItem();
		// if the section is not a lvl 1 section
		if (selectedItem instanceof Section
				&& ((Section) selectedItem).getParent() instanceof Section) {
			Section section = (Section) selectedItem;
			Section parent = (Section) section.getParent();
			int index = 0;
			
			// get the index of the section
			while (!parent.getSubSection(index).equals(section))
				++index;

			
			//add the following sections to the subesctions of the upgraded section
			List<Section> sectionToAdd = new ArrayList<Section>();
			while (parent.getSubSectionNb() >= index + 1) {
				sectionToAdd.add(parent.getSubSection(index + 1));
				parent.removeSubSection(index + 1);
			}

			for (int i = 0; i < sectionToAdd.size(); ++i) {
				section.addSubSection(sectionToAdd.get(i));
			}

			parent.removeSubSection(index);

			// get index of parent
			int indexParent = 0;
			while (!parent.getParent().getSubSection(indexParent)
					.equals(section))
				++indexParent;

			parent.getParent().insertSubSection(section, indexParent + 1);
		}
	}

}
