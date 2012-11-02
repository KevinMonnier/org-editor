package model.low.cursor.imp;

import model.low.cursor.Cursor;
import model.low.document.Line;
import model.low.document.imp.DocumentException;
import model.low.document.imp.TextIntroImp;
import model.low.document.imp.TitleImp;

public class CursorImp extends VisitorImp implements Cursor {

	private final static Cursor INSTANCE = new CursorImp();
	
	private int currentPosition;
	private Line currentLine;

//	Singleton pattern, has to be replaced by the right structure with the dependency injection framework
	private CursorImp() {}
	
	public static Cursor getCursor() {
		return INSTANCE;
	}
	
	public int getCurrentPosition() {
		return currentPosition;
	}
	public void setCurrentPosition(int newPosition) {
		this.currentPosition = newPosition;
	}
	public Line getCurrentLine() {
		return currentLine;
	}
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
			throw new DocumentException("Impossible to move the cursor left" +
					", the cursor is already at the position 0 of the current Line.");
		}
		setCurrentPosition(getCurrentPosition() - 1);
	}

	@Override
	public void movePositionRight() {
		if(getCurrentPosition()>=getCurrentLine().length()){
			throw new DocumentException("Impossible to move the cursor right" +
					", the cursor is positioned at the end of the current Line");
		}
		setCurrentPosition(getCurrentPosition() + 1);
	}

	@Override
	public void selectLineUp() {
		setCurrentPosition(0);
		if(getCurrentLine().getParent() instanceof TitleImp) {
			
		}
		else if(getCurrentLine().getParent() instanceof TextIntroImp) {
			
		}
	}

	@Override
	public void selectLineDown() {
		setCurrentPosition(0);
		
	}

}
