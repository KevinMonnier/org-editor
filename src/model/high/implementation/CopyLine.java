package model.high.implementation;

import model.high.command.Command;
import model.high.editor.Editor;
import model.low.buffer.Buffer;
import model.low.document.Line;
import model.low.document.imp.LineImp;

public class CopyLine implements Command {
	
	private Editor editor;
	private Buffer buffer;
	

	public CopyLine(Editor editor, Buffer buffer) {
		super();
		this.editor = editor;
		this.buffer = buffer;
	}

	@Override
	public boolean match(CharSequence str) {
		return str.equals(EditCommands.COPY);
	}

	@Override
	public void execute(CharSequence str) {
		if(!this.match(str))
			throw new CommandException("this function does not match " + str);
		
		Line line = this.editor.getSelectedLine();
		buffer.push(new LineImp(null, line));//insert a copy
		
	}

}
