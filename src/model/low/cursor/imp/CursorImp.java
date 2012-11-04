package model.low.cursor.imp;

import model.low.cursor.Cursor;
import model.low.document.Line;

public class CursorImp extends VisitorImp implements Cursor {

	private final static Cursor INSTANCE = new CursorImp();
	
	private int currentPosition;
	private Line currentLine;

//	Singleton pattern, has to be replaced by the right structure with the dependency injection framework
	private CursorImp() {}
	
	public static Cursor getCursor() {
		return INSTANCE;
	}
	
	@Override
	public int getCurrentPosition() {
		return currentPosition;
	}
	
	@Override
	public void setCurrentPosition(int newPosition) {
		this.currentPosition = newPosition;
	}
	
	@Override
	public Line getCurrentLine() {
		return currentLine;
	}
	
	@Override
	public void setCurrentLine(Line newLine) {
		this.currentLine = newLine;
	}

	@Override
	public void initCursor() {
		this.currentPosition = 0;
		this.currentLine = getDocument().getTextIntro().getLine(0);	
	}
	
	@Override
	public void movePositionLeft() {
		if(getCurrentPosition()<=0){
			this.selectLineUp();
			this.setCurrentPosition(this.getCurrentLine().getPrec().length());
		}
		this.setCurrentPosition(this.getCurrentPosition() - 1);
	}

	@Override
	public void movePositionRight() {
		if(getCurrentPosition()>=getCurrentLine().length()){
			this.selectLineDown();
			this.setCurrentPosition(0);
		}
		else
			setCurrentPosition(getCurrentPosition() + 1);
	}

	@Override
	public void selectLineUp() {
		if(this.getCurrentLine().getPrec().length() < this.getCurrentPosition()) {
			this.setCurrentPosition(this.getCurrentLine().getPrec().length());
		}
		this.setCurrentLine(this.getCurrentLine().getPrec());
	}

	@Override
	public void selectLineDown() {
		if(this.getCurrentLine().getNext().length() < this.getCurrentPosition()) {
			this.setCurrentPosition(this.getCurrentLine().getNext().length());
		}
		this.setCurrentLine(this.getCurrentLine().getNext());
	}

}
