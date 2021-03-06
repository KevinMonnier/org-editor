package model.high.command.imp;

import model.high.command.Command;
import model.high.editor.Editor;
import model.low.buffer.Buffer;
import model.low.document.Document;
import model.low.document.HasSubSection;
import model.low.document.Line;
import model.low.document.Section;
import model.low.document.TextIntro;
import model.low.document.Title;
import model.low.document.imp.LineImp;
import model.low.document.imp.SectionImp;

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
		if(!this.buffer.empty()) {
			if (this.buffer.peek() instanceof Line)
				this.copyLine((Line) this.buffer.peek());
			else if(this.buffer.peek() instanceof Section)
				this.copySection((Section) this.buffer.peek());
		}	
	}

	private void copySection(Section peek) {
		// TODO Auto-generated method stub
		HasSubSection parent =  this.editor.getSelectedItem();
		
		if(parent instanceof Document)
			parent.addSubSection(new SectionImp(peek, parent));
		else
			((Section)parent).getParent().insertSubSection(peek, (Section)parent);
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
