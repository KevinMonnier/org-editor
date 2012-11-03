package model.low.document.imp;

import java.util.ArrayList;
import java.util.List;

import model.low.document.HasTextIntro;
import model.low.document.Line;
import model.low.document.TextIntro;

public class TextIntroImp implements TextIntro {

//	Attributes
	
	private List<Line> text;
	private HasTextIntro parent;

//	Constructors	
	
	public TextIntroImp(HasTextIntro parent) {
		this.text = new ArrayList<Line>();
		this.parent = parent;
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
	public Line getFirstLine() {
		return this.getLine(0);
	}

	@Override
	public Line getLastLine() {
		return this.getLine(this.getLineNb());
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
	public void addLine(Line line) {
		text.add(new LineImp(this, line));
	}
	
	@Override
	public void insertLine(Line line, int at) {
		this.text.add(at, line);
		
	}

	@Override
	public void insertLine(Line line, Line after) {
		this.text.add(this.text.indexOf(after)+1, line);
	}

	@Override
	public void remove(int i) {
		this.text.remove(i);
	}

	@Override
	public int getLineNb() {
		return text.size();
	}

	
	public String toString() {
		String s = "";
		for(Line l : getText()) {
			s += l.toString() + "\n";
		}
		return s;
	}

}
