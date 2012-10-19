package model.low.documentImp;

import model.low.document.Title;

public class TitleImp implements Title {
	
	String title;
	
	public TitleImp(String title) {
		super();
		this.title = title;
	}

	@Override
	public CharSequence getTitle() {
		return title;
	}

}
