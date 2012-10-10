package model.low.document;

public interface TextIntro extends Component, Text {
	
	public int getLineNb();

	public CharSequence getLine(int i);

	public void addLine(int after, CharSequence cs);
	
	public void insert(int line, int col, CharSequence str);
	
	public void remove(int line, int col, int length);

	public void deleteLine(int i);
	
}
