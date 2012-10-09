package model.low.document;

public interface TextIntro {

	public CharSequence getLine(int i);

	public void addLine(CharSequence cs);
	
	public void insert(int line, int col, CharSequence str);
	
	public void remove(int line, int col, int length);

	public void deleteLine(int i);
}
