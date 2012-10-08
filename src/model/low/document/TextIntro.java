package model.low.document;

public interface TextIntro {

	public CharSequence getLine(int i);

	public void addLine(CharSequence cs);

	public void deleteLine(int i);
}
