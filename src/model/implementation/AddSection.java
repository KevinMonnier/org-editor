package model.implementation;

import model.high.Command;
import model.high.Editor;
import model.low.document.Document;
import model.low.document.HasSubSection;
import model.low.document.Section;
import model.low.documentImp.SectionImp;
import model.low.documentImp.TextIntroImp;
import model.low.documentImp.TitleImp;

public class AddSection implements Command {

	private Editor editor;

	public AddSection(Editor editor) {
		this.editor = editor;
	}

	@Override
	public boolean match(CharSequence str) {
		return str.toString().matches("/\\*+.+");
	}

	@Override
	public void execute(CharSequence str) {
		int selectedItemLevel = this
				.getItemLevel(this.editor.getSelectedItem());
		int newSectionLvl = 0;
		for (newSectionLvl = 0; str.charAt(newSectionLvl) == '*'; newSectionLvl++)
			;
		CharSequence title = str.subSequence(newSectionLvl + 2, str.length());
		if (newSectionLvl > selectedItemLevel) {
			this.editor.getSelectedItem().addSubSection(
					new SectionImp(new TitleImp(title), this.editor
							.getSelectedItem(), new TextIntroImp())); // TODO injection here
		} else {
			HasSubSection addAfter = this.editor.getSelectedItem();
			int lvlDiff = newSectionLvl - selectedItemLevel;

			for (int i = 0; i < lvlDiff; i++) {
				addAfter = ((Section) addAfter).getParent();
			}
			HasSubSection parent = ((Section) addAfter).getParent();
			parent.addSubSection(new SectionImp(new TitleImp(title),
					this.editor.getSelectedItem(), new TextIntroImp()),
					(Section) addAfter);
		}
	}

	private int getItemLevel(HasSubSection item) {
		return item instanceof Document ? 0 : 1 + getItemLevel(((Section) item)
				.getParent());
	}

}
