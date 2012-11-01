package model.low.document.imp;

import model.low.document.Line;
import model.low.document.Title;

public class TitleImp implements Title {
	
//	Attributes
	
	Line line;
	
//	Constructors	
	
	public TitleImp() {
		line = new LineImp();
	}
	
	public TitleImp(StringBuilder lineContent) {
		super();
		this.line = new LineImp(lineContent);
	}
	
//	Accessors	

	@Override
	public Line getLine() {
		return line;
	}

}
