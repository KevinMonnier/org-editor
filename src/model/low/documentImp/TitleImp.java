package model.low.documentImp;

import model.low.document.Line;
import model.low.document.Title;

public class TitleImp implements Title {
	
	Line title;
	
	public TitleImp() {
		title = new LineImp();
	}
	
	public TitleImp(CharSequence title) {
		super();
		this.title = new LineImp(title);
	}

	@Override
	public Line getTitle() {
		return title;
	}

}
