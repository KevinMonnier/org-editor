package model.low.documentImp;

import model.low.document.Title;

public class TitleImp implements Title {
	
	StringBuilder title;
	
	public TitleImp() {
		title = new StringBuilder();
	}
	
	public TitleImp(String title) {
		super();
		this.title = new StringBuilder(title);
	}

	@Override
	public CharSequence getTitle() {
		return title;
	}

}
