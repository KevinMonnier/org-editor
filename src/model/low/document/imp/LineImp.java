package model.low.document.imp;

import model.low.document.Line;

public class LineImp implements Line {

//	Attributes
	
	private StringBuilder content;
	
//	Constructors
	
	public LineImp(){
		this.content = new StringBuilder();
	}
	
	public LineImp(CharSequence content) {
		this.content = new StringBuilder(content);
	}
	
	public LineImp(StringBuilder content) {
		this.content = content;
	}

	public LineImp(Line line) {
		this.content = line.getContent();
	}
	
//	Accessors	
	
	public StringBuilder getContent() {
		return content;
	}
	
	public void setContent(StringBuilder content) {
		this.content = content;
	}

//	Methods	
	
	@Override
	public void insertContent(int pos, Line line) {
		if(pos > this.length() || pos < 0) {
			throw new DocumentException("Impossible to insert something in this line at this position!");
		}
		this.getContent().insert(pos, line.getContent());
	}

	@Override
	public void insertContent(int pos, StringBuilder newContent) {
		if(pos > this.length() || pos < 0) {
			throw new DocumentException("Impossible to insert something in this line at this position!");
		}
		this.getContent().insert(pos, newContent);
	}
	
	@Override
	public void insertCharAt(int pos, char c) {
		if(pos > this.length() || pos < 0) {
			throw new DocumentException("Impossible to insert something in this line at this position!");
		}
		this.getContent().insert(pos, c);
	}
	
	@Override
	public void replaceContent(Line line) {
		this.setContent(new StringBuilder(line.getContent()));
	}

	@Override
	public void replaceContent(StringBuilder newContent) {
		this.setContent(new StringBuilder(newContent));
	}
	
	@Override
	public void removeContent() {
		this.setContent(null);
	}
	
	@Override
	public void deleteContent() {
		this.getContent().delete(0, this.length());
	}
	
	@Override
	public void deletePrecedentCharAt(int pos) {
		if((pos-1) > this.length() || (pos-1) < 0) {
			throw new DocumentException("Impossible to delete something in this line at this position!");
		}
		this.getContent().deleteCharAt(pos - 1);
	}

	@Override
	public void deleteCharAt(int pos) {
		if(pos > this.length() || pos < 0) {
			throw new DocumentException("Impossible to delete something in this line at this position!");
		}
		this.getContent().deleteCharAt(pos);
	}
	
	@Override
	public int length() {
		return getContent().length();
	}
	
	@Override
	public String toString() {
		return this.getContent().toString();
	}

//	Tests	
	
	public static void main(String[] args) {
		Line line1 = new LineImp();
		line1.setContent(new StringBuilder("Bonjour"));
		System.out.println(line1);
		Line line2 = new LineImp(new StringBuilder(" Monsieur!"));
		Line line3 = new LineImp(line1);
		System.out.println("line3 : "+ line3);
		line1.insertContent(line1.length(), line2);
		System.out.println(line1);
		line1.insertContent(0, line2);
		System.out.println(line1);
		line1.setContent(line2.getContent());
		System.out.println(line1);
		System.out.println(line1.length());
		line1.insertCharAt(0, '1');
		System.out.println(line1);
		System.out.println(line2);
		System.out.println("line3 : "+ line3);
	}
	
}
