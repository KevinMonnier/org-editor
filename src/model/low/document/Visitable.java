package model.low.document;

import model.low.cursor.Visitor;

public interface Visitable {

	/**
	 * Method to accept a visitor
	 * @param visitor
	 */
	public void accept(Visitor visitor);
}
