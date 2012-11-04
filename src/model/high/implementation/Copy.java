package model.high.implementation;

import model.high.command.Command;
import model.high.editor.Editor;
import model.low.buffer.Buffer;
import model.low.document.Line;
import model.low.document.imp.LineImp;
import model.low.document.imp.SectionImp;
import model.low.document.imp.TitleImp;

public class Copy implements Command {
	
	private Editor editor;
	private Buffer buffer;
	

	public Copy(Editor editor, Buffer buffer) {
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
		
		if(line.isInTextIntro()) {
			buffer.push(new LineImp(null, line));//insert a copy
		}
		else {
			if(((SectionImp)((TitleImp)line.getParent()).getParent()).isVisible()) {
				buffer.push(new LineImp(null, line));//insert a copy
			}
			else {
				buffer.push(new SectionImp((SectionImp)((TitleImp)line.getParent()).getParent(), null));
			}
		}
	}

}
