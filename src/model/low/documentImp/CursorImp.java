package model.low.documentImp;

import model.low.document.Cursor;
import model.low.document.Line;

public class CursorImp implements Cursor {

	private int position;
	private Line line;

	public CursorImp(int position, Line line) {
		this.position = position;
		this.line = line;
	}
	
	public int getPosition() {
		return position;
	}
	public void setPosition(int position) {
		this.position = position;
	}
	public Line getLine() {
		return line;
	}
	public void setLine(Line line) {
		this.line = line;
	}

	@Override
	public void movePositionLeft() {
		if(getPosition()>0){
			setPosition(getPosition() - 1);
		}
	}

	@Override
	public void movePoistionRight() {
		if(getPosition()<getLine().length()){
			setPosition(getPosition() + 1);
		}
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
