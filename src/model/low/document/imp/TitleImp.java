package model.low.document.imp;

import model.low.cursor.Visitor;
import model.low.document.Line;
import model.low.document.Section;
import model.low.document.Title;

public class TitleImp implements Title {
	
//	Attributes
	
	private Line line;
	private Section parent;
	
//	Constructors	
	
	public TitleImp() {
		line = new LineImp();
	}
	
	public TitleImp(CharSequence lineContent) {
		super();
		this.line = new LineImp(lineContent);
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
	
	@Override
	public Section getParent() {
		return parent;
	}

	@Override
	public void setParent(Section parent) {
		this.parent = parent;
	}
	
//	Methods
	
	@Override
	public void accept(Visitor visitor) {
		visitor.visitTitle(this);
	}
	
	public String toString() {
		return getLine().toString() + "\n";
	}

}
