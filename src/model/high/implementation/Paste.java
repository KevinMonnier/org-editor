package model.high.implementation;

import model.high.command.Command;
import model.high.editor.Editor;
import model.low.buffer.Buffer;
import model.low.document.Line;
import model.low.document.Section;
import model.low.document.Text;
import model.low.document.TextIntro;
import model.low.document.Title;
import model.low.document.imp.LineImp;

public class Paste implements Command {

	private Editor editor;
	private Buffer buffer;

	public Paste(Editor editor, Buffer buffer) {
		super();
		this.editor = editor;
		this.buffer = buffer;
	}

	@Override
	public boolean match(CharSequence str) {
		return str.equals(EditCommands.PASTE);
	}

	@Override
	public void execute(CharSequence str) {
		if (this.buffer.peek() instanceof Line)
			this.copyLine((Line) this.buffer.peek());
		//TODO section
	}

	private void copyLine(Line l) {
		if(this.editor.getSelectedLine().isInTitle()) {
			Section containingSection = ((Title)this.editor.getSelectedLine().getParent()).getParent();
			TextIntro text = containingSection.getTextIntro();
			text.insertLine(new LineImp(text, l), 0);
		}
		else {
			TextIntro text = (TextIntro) this.editor.getSelectedLine().getParent();
			text.insertLine(new LineImp(text, l), this.editor.getSelectedLine());
		}
		this.editor.getCursor().selectLineDown();
		this.editor.getCursor().setCurrentPosition(l.getContent().length());
	}
}
