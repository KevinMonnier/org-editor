package controller;

import model.high.command.imp.AddSection;
import model.high.command.imp.Copy;
import model.high.command.imp.Cut;
import model.high.command.imp.Degrade;
import model.high.command.imp.DegradeRecursive;
import model.high.command.imp.DeleteFromBuffer;
import model.high.command.imp.HideUnhide;
import model.high.command.imp.LoadFile;
import model.high.command.imp.MoveCursor;
import model.high.command.imp.Paste;
import model.high.command.imp.Save;
import model.high.command.imp.UpgradeRecursive;
import model.high.editor.Editor;
import model.high.editor.imp.EditorImp;
import model.low.buffer.Buffer;
import model.low.buffer.imp.BufferImp;
import model.low.cursor.imp.CursorImp;
import model.low.document.imp.DocumentLoaderImp;
import model.low.document.imp.DocumentWriterImp;
import view.EditorView;

public class Controller {
	EditorView view;
	Editor editor;
	Buffer buffer;
	
	public Controller() {
		this.editor = new EditorImp(CursorImp.getCursor());
		this.buffer = new BufferImp();
		
		this.view = new EditorView();
		this.addCommands();
		this.view.getDocument().addKeyListener(new WriteKey(editor, view));
		this.view.getCommand().setAction(new ExecuteCommand(view, editor));
		
		//[TEST]
		this.editor.getDocument().getTextIntro().getFirstLine().replaceContent(new StringBuilder("testing document"));
		this.editor.executeCommand("* section 1");
		this.editor.executeCommand("** section 1.1");
		this.editor.executeCommand("** section 1.2");
		this.editor.executeCommand("* section 2");
		this.editor.executeCommand("** section 2.1");
		this.editor.executeCommand("** section 2.2");
		this.editor.executeCommand("*** section 2.2.1");
		
		//[/TEST]
		
		this.view.getDocument().setText(this.editor.print());
	}
	
	private void addCommands() {
		this.editor.addCommand(new AddSection(this.editor));
		this.editor.addCommand(new MoveCursor(this.editor));
		this.editor.addCommand(new HideUnhide(this.editor));
		this.editor.addCommand(new DegradeRecursive(this.editor));
		this.editor.addCommand(new UpgradeRecursive(this.editor));
		this.editor.addCommand(new Degrade(this.editor));
		this.editor.addCommand(new Copy(this.editor, this.buffer));
		this.editor.addCommand(new Cut(this.editor, this.buffer));
		this.editor.addCommand(new Paste(this.editor, this.buffer));
		this.editor.addCommand(new DeleteFromBuffer(this.buffer));
		this.editor.addCommand(new LoadFile(new DocumentLoaderImp()));
		this.editor.addCommand(new Save(this.editor, new DocumentWriterImp()));
	}
}
