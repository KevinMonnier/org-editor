package model.low.cursor.imp;

import model.low.cursor.Cursor;
import model.low.document.Line;
import model.low.document.imp.DocumentException;
import model.low.document.imp.DocumentImp;

public class CursorImp implements Cursor {

	private int currentPosition;
	private Line currentLine;
	private DocumentImp documentImp;

//	Singleton pattern, has to be replaced by the right structure with the dependency injection framework
	private CursorImp() {
		this.currentPosition = 0;
	}
	
	public Cursor getCursor() {
		if(this != null) {
			return this;
		}
		return new CursorImp();
	}
	
	@Override
	public DocumentImp getDocumentImp() {
		return documentImp;
	}
	
	@Override
	public void setDocumentImp(DocumentImp documentImp) {
		this.documentImp = documentImp;
		this.currentLine = this.documentImp.getTextIntro().getLine(0);
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
		// TODO Auto-generated method stub
		
	}

	@Override
	public void selectLineDown() {
		// TODO Auto-generated method stub
		
	}

	
}
