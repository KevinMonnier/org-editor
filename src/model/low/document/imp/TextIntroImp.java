package model.low.document.imp;

import java.util.ArrayList;
import java.util.List;

import model.low.document.Line;
import model.low.document.TextIntro;

public class TextIntroImp implements TextIntro {

	private List<Line> text;

	public TextIntroImp() {
		this.text = new ArrayList<Line>();
	}

	@Override
	public Line getLine(int i) {
		return text.get(i);
	}

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

}
