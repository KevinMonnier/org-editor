package model.low.document.imp;

import java.util.List;

import model.low.document.Line;
import model.low.document.Text;

public class LineImp implements Line {

//	Attributes
	
	private StringBuilder content;
	
	private Text parent;
	
//	Constructors
	
	public LineImp(Text parent){
		this.content = new StringBuilder();
		this.parent = parent;
	}
	
	public LineImp(Text parent, CharSequence content) {
		this.content = new StringBuilder(content);
		this.parent = parent;
	}
	
	public LineImp(Text parent, StringBuilder content) {
		this.content = content;
		this.parent = parent;
	}

	public LineImp(Text parent, Line line) {
		this.content = line.getContent();
		this.parent = parent;
	}
	
//	Accessors	
	
	@Override
	public StringBuilder getContent() {
		return content;
	}
	
	@Override
	public void setContent(StringBuilder content) {
		this.content = content;
	}

	@Override
	public Text getParent() {
		return parent;
	}
	
	@Override
	public void setParent(Text parent) {
		this.parent = parent;
	}
	
//	Methods
	
//	Methods to navigate between different Lines
	
	@Override
	public boolean isInTitle() {
		return (this.getParent() instanceof TitleImp);
	}

	@Override
	public boolean isInTextIntro() {
		return (this.getParent() instanceof TextIntroImp);
	}
	
	@Override
	public boolean isInSection() {
		return (isInTitle() || (((TextIntroImp)this.getParent()).getParent() instanceof SectionImp));
	}

	@Override
	public boolean isInDocument() {
		return (isInTextIntro() && (((TextIntroImp)this.getParent()).getParent() instanceof DocumentImp));
	}
	
	@Override
	public Line getNext() {
		if(isInTextIntro()) {
			return getNextFromTextIntro();
		}
		return getNextFromTitle();
	}

	@Override
	public Line getPrec() {
		if(isInTextIntro()) {
			return getPrecFromTextIntro();
		}
		return getPrecFromTitle();
	}
	
	@Override
	public Line getNextFromTitle() {	
		if (((TitleImp)this.getParent()).getParent().isVisible()) {
			return ((TitleImp)this.getParent()).getParent().getTextIntro().getFirstLine();
		} else {
			if(((TitleImp)this.getParent()).getParent().getNext() != null) {
				return ((TitleImp)this.getParent()).getParent().getNext().getFirstLine();
			}
			return this;
		}
	}

	@Override
	public Line getPrecFromTitle() {
		if(((TitleImp)this.getParent()).getParent().getParent() instanceof DocumentImp) {
			return ((DocumentImp)((TitleImp)this.getParent()).getParent().getParent()).getTextIntro().getLastLine();
		}else {
			return ((TitleImp)this.getParent()).getParent().getPrec().getLastLine();
		}
	}

	@Override
	public Line getNextFromTextIntro() {
		if (this.getIndex() < ((TextIntroImp)this.getParent()).getLineNb()) {
			return ((TextIntroImp)this.getParent()).getLine(this.getIndex() + 1);
		} else {
			if (((TextIntroImp)this.getParent()).getParent() instanceof DocumentImp) {
				return ((DocumentImp)((TextIntroImp)this.getParent()).getParent()).getSubSection(0).getTitle().getLine();
			} else if (((SectionImp)((TextIntroImp)this.getParent()).getParent()).getNext() != null) {
				return ((SectionImp)((TextIntroImp)this.getParent()).getParent()).getNext().getFirstLine();
			} else {
				return this;
			}	
		}
		
	}

	@Override
	public Line getPrecFromTextIntro() {
		if(this.getIndex() == 0) {
			if(((TextIntroImp)this.getParent()).getParent() instanceof DocumentImp) {
				return this;
			} else {
				((SectionImp)((TextIntroImp)this.getParent()).getParent()).getTitle().getLine();
			}
		}
		return ((TextIntroImp)this.getParent()).getLine(this.getIndex()-1);
	}
	
	@Override
	public int getIndex() {
		if(this.isInSection()) {
			List<Line> list = ((TextIntroImp)this.getParent()).getText();
			return list.indexOf(this);
		}
		return 0;
	}
	
	
//	Methods to manipulate the content of the Line
	
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
		Line line1 = new LineImp(new TitleImp());
		line1.setContent(new StringBuilder("Bonjour"));
		System.out.println(line1);
		Line line2 = new LineImp(new TitleImp(), new StringBuilder(" Monsieur!"));
		Line line3 = new LineImp(new TitleImp(), line1);
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
