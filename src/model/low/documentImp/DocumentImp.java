package model.low.documentImp;

import java.util.List;

import model.low.document.Document;
import model.low.document.Section;
import model.low.document.TextIntro;

public class DocumentImp implements Document {
	private TextIntro text;
	private List<Section> sections;

	@Override
	public Section getSubSection(int i) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getSubSectionNb() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public TextIntro getTextIntro() {
		// TODO Auto-generated method stub
		return null;
	}
}
