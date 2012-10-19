package model.low.documentImp;

import java.util.ArrayList;
import java.util.List;

import model.low.document.TextIntro;

public class TextIntroImp implements TextIntro {

	private List<StringBuilder> text;

	public TextIntroImp() {
		this.text = new ArrayList<StringBuilder>();
	}

	@Override
	public CharSequence getLine(int i) {
		return text.get(i).toString();
	}

	@Override
	public void insert(int line, int col, CharSequence str) {
		text.get(line).insert(col, str);
	}

	@Override
	public void remove(int line, int col, int length) {
		text.get(line).replace(col, col + length, "");
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
	public void addLine(int after, CharSequence cs) {
		text.add(after + 1, new StringBuilder(cs));
	}

}
