package model.high.command.imp;

import model.high.command.Command;
import model.high.editor.Editor;

public class MoveCursor implements Command {
	
	private Editor editor;

	public MoveCursor(Editor editor) {
		this.editor = editor;
	}
	
	@Override
	public boolean match(CharSequence str) {
		return (str.equals(EditCommands.CURSOR_UP)
				|| str.equals(EditCommands.CURSOR_DOWN)
				|| str.equals(EditCommands.CURSOR_LEFT) 
				|| str.equals(EditCommands.CURSOR_RIGHT));
	}

	@Override
	public void execute(CharSequence str) {
		if(str.equals(EditCommands.CURSOR_UP)) {
			this.editor.moveCursor(-1, 0);
		}
		else if(str.equals(EditCommands.CURSOR_DOWN)) {
			this.editor.moveCursor(1, 0);
		}
		else if(str.equals(EditCommands.CURSOR_LEFT)) {
			this.editor.moveCursor(0, -1);
		}
		else if (str.equals(EditCommands.CURSOR_RIGHT)) {
			this.editor.moveCursor(0, 1);
		}
	}

}
