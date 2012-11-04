package model.high.command.imp;

import model.high.command.Command;
import model.high.editor.Editor;
import model.low.buffer.Buffer;
import model.low.document.Line;
import model.low.document.TextIntro;
import model.low.document.imp.LineImp;
import model.low.document.imp.SectionImp;
import model.low.document.imp.TitleImp;

public class Cut implements Command {

	private Editor editor;
	private Buffer buffer;

	public Cut(Editor editor, Buffer buffer) {
		super();
		this.editor = editor;
		this.buffer = buffer;
	}

	@Override
	public boolean match(CharSequence str) {
		return str.equals(EditCommands.REMOVE);
	}

	@Override
	public void execute(CharSequence str) {
		if(!this.match(str))
			throw new CommandException("this function does not match " + str);
		
		Line line = this.editor.getSelectedLine();
		
		if(line.isInTextIntro()) {
			buffer.push(new LineImp(null, line));//insert a copy
			editor.getCursor().selectLineDown();
			((TextIntro)line.getParent()).remove(line.getIndex());
		}
		else {
			buffer.push(new SectionImp((SectionImp)((TitleImp)line.getParent()).getParent(), null));
			editor.getCursor().selectLineUp();
			((SectionImp)((TitleImp)line.getParent()).getParent()).getParent().getSubSections().remove(((SectionImp)((TitleImp)line.getParent()).getParent()).getIndex());
			editor.getCursor().selectLineDown();
		}
	}

}
