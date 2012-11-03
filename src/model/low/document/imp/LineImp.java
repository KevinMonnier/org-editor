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
	}
	
	public LineImp(Text parent, CharSequence content) {
		this.content = new StringBuilder(content);
	}
	
	public LineImp(Text parent, StringBuilder content) {
		this.content = content;
	}

	public LineImp(Text parent, Line line) {
		this.content = line.getContent();
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
		// TODO Auto-generated method stub
		//Le cas où la section actuelle serait cachée sont à traiter ici
		return null;
	}

	@Override
	public Line getPrecFromTitle() {
		// TODO Auto-generated method stub
		//Le cas où la section precedente serait cachée est traité dans getLastLine() de SectionImp
		return null;
	}

	@Override
	public Line getNextFromTextIntro() {
		List<Line> list = ((TextIntroImp)this.getParent()).getText();
		if (this.getIndex() >= list.size()) {
			if(this.isInDocument()) {
				return ((DocumentImp)((TextIntroImp)this.getParent()).getParent()).getSubSection(0).getFirstLine();
			}
			//Penser à traiter le cas où il n'y a pas de section suivante
			return ((SectionImp)((TextIntroImp)this.getParent()).getParent()).getNext().getFirstLine();
		}
		return list.get(this.getIndex() + 1);
	}

	@Override
	public Line getPrecFromTextIntro() {
		if(this.getIndex() == 0) {
			if(this.isInDocument()) {
				return this;
			}
			return ((SectionImp)((TextIntroImp)this.getParent()).getParent()).getTitle().getLine();
		}
		List<Line> list = ((TextIntroImp)this.getParent()).getText();
		return list.get(this.getIndex() - 1);
	}
	
	@Override
	public int getIndex() {
		if(this.isInSection()) {
			List<Line> list = ((TextIntroImp)this.getParent()).getText();
			int lineIndex = 0;
			for(int i = 0 ; i < list.size() ; i ++) {
				if(list.get(i).equals(this)){
					lineIndex = i;
				}
			}
			return lineIndex;
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
