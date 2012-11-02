package model.high.implementation;

import java.util.ArrayList;

import model.high.command.Command;
import model.high.editor.Editor;
import model.low.cursor.Cursor;
import model.low.document.Document;
import model.low.document.HasSubSection;
import model.low.document.Line;
import model.low.document.Text;

public class EditorImp implements Editor {

	private Document document;
	private Text selectedText;
	private int selectedLine;
	private int selectedCol;
	private ArrayList<Command> commands;
	private HasSubSection selectedItem;
	private Cursor cursor;
	

	public EditorImp(Document document, Cursor cursor) {
		super();
		this.document = document;
		this.cursor = cursor;
	}

	@Override
	public Document getDocument() {
		return this.document;
	}

	@Override
	public HasSubSection getSelectedItem() {
		return this.selectedItem;
	}

	@Override
	public Text getSelectedText() {
		return this.selectedText;
	}

	@Override
	public int getSelectedLineNb() {
		return this.selectedLine;
	}

	@Override
	public int getSelectedCharacterNb() {
		return this.selectedCol;
	}

	@Override
	public void addCommand(Command c) {
		this.commands.add(c);
	}

	@Override
	public void executeCommand(String c) {
		int i=0;
		while(!this.commands.get(i).match(c)) {
			i++;
		}
		if(i>=this.commands.size())
			throw new CommandNotFoundException(c);
		else
			this.commands.get(i).execute(c);
	}

	@Override
	public void loadDocument(CharSequence filePath) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public char getCommandChar() {
		return EditCommands.COMMAND_CHAR;
	}

	@Override
	public void moveCursor(int down, int right) {
		for (int i = 0; i < right; i++) {
			this.getCursor().movePositionRight();
		}
		for (int i = 0; i > right; i--) {
			this.getCursor().movePositionLeft();
		}
		for (int i = 0; i < down; i++) {
			this.getCursor().selectLineDown();
		}
		for (int i = 0; i > down; i--) {
			this.getCursor().selectLineUp();
		}
	}

	@Override
	public Cursor getCursor() {
		return this.cursor;
	}

	@Override
	public Line getSelectedLine() {
		// TODO Auto-generated method stub
		return null;
	}

}
