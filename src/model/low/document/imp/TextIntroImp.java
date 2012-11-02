package model.low.document.imp;

import java.util.ArrayList;
import java.util.List;

import model.low.cursor.Visitor;
import model.low.document.HasTextIntro;
import model.low.document.Line;
import model.low.document.TextIntro;

public class TextIntroImp implements TextIntro {

//	Attributes
	
	private List<Line> text;
	private HasTextIntro parent;

//	Constructors	
	
	public TextIntroImp() {
		this.text = new ArrayList<Line>();
	}

//	Accessors		
	
	@Override
	public List<Line> getText() {
		return text;
	}
	
	@Override
	public Line getLine(int i) {
		return text.get(i);
	}
	
	@Override
	public HasTextIntro getParent() {
		return parent;
	}

	@Override
	public void setParent(HasTextIntro parent) {
		this.parent = parent;
	}

//	Methods	
	
	@Override
	public void insert(int lineNb, int col, Line line) {
		text.get(lineNb).insertContent(col, line);
	}

	@Override
	public void remove(int lineNb, int col, int length) {
		text.get(lineNb).removeContent();
	}

	@Override
	public void deleteLine(int i) {
		text.remove(i);
	}

	@Override
	public int getLineNb() {
		return text.size();
	}

	@Override
	public void addLine(int after, Line line) {
		text.add(after + 1, new LineImp(line));
	}
	
	@Override
	public void accept(Visitor visitor) {
		visitor.visitTextIntro(this);
		
	}
	
	public String toString() {
		String s = "";
		for(Line l : getText()) {
			s += l.toString() + "\n";
		}
		return s;
	}

}
