package model.low.document;

import model.low.cursor.Visitor;

public interface Visitable {

	public void accept(Visitor visitor);
}
