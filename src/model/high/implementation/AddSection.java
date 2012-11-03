package model.high.implementation;

import model.high.command.Command;
import model.high.editor.Editor;
import model.low.document.Document;
import model.low.document.HasSubSection;
import model.low.document.Section;
import model.low.document.imp.SectionImp;
import model.low.document.imp.TextIntroImp;
import model.low.document.imp.TitleImp;

public class AddSection implements Command {

	private Editor editor;

	public AddSection(Editor editor) {
		this.editor = editor;
	}

	@Override
	public boolean match(CharSequence str) {
		return str.toString().matches("\\*+.+");
	}

	@Override
	public void execute(CharSequence str) {
		int selectedItemLevel = this
				.getItemLevel(this.editor.getSelectedItem());
		int newSectionLvl = 0;
		for (newSectionLvl = 0; str.charAt(newSectionLvl) == '*'; newSectionLvl++);
		
		StringBuilder title = new StringBuilder(str.subSequence(newSectionLvl + 1, str.length()));
		if (newSectionLvl > selectedItemLevel) {
			this.editor.getSelectedItem().addSubSection(
					new SectionImp(new TitleImp(title), this.editor
							.getSelectedItem())); // TODO injection here
		} else {
			HasSubSection addAfter = this.editor.getSelectedItem();
			int lvlDiff = newSectionLvl - selectedItemLevel;

			for (int i = 0; i < lvlDiff; i++) {
				addAfter = ((Section) addAfter).getParent();
			}
			HasSubSection parent = ((Section) addAfter).getParent();
			parent.insertSubSection(new SectionImp(new TitleImp(title),
					this.editor.getSelectedItem()),
					(Section) addAfter);
		}
		this.editor.getCursor().selectLineDown();
		//this.editor.getCursor().selectLineDown();
	}

	private int getItemLevel(HasSubSection item) {
		return item instanceof Document ? 0 : 1 + getItemLevel(((Section) item)
				.getParent());
	}
	
}
