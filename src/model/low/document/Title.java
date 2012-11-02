package model.low.document;

public interface Title extends Text {
	
	/**
	 * @return the Line of the Title
	 */
	public Line getLine();
	
	/**
	 * @return the parent of the Title in the tree structure
	 */
	public Section getParent();
	
	/**
	 * @param parent the parent of the Title in the tree structure
	 */
	public void setParent(Section parent);
	
}
