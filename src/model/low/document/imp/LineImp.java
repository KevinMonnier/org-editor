package model.low.document.imp;

import model.low.document.Line;

public class LineImp implements Line {

	private CharSequence content;
	
	public LineImp(){
		this.content = new StringBuilder();
	}
	
	public LineImp(CharSequence content) {
		this.content = content;
	}

	public LineImp(Line line) {
		this.content = line.getContent();
	}
	
	public CharSequence getContent() {
		return content;
	}
	
	public void setContent(CharSequence content) {
		this.content = content;
	}

	@Override
	public void insert(int col, Line line) {
		this.insert(col, line);
	}

	@Override
	public void replace(int col, int i, Line line) {
		this.replace(col, i, line);
	}

	@Override
	public int length() {
		return getContent().length();
	}
}
