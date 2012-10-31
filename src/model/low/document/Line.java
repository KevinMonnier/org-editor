package model.low.document;

public interface Line {
	
	public CharSequence getContent();
	
	public void setContent(CharSequence content);

	public void insert(int col, Line line);

	public void replace(int col, int i, Line line);
	
}
