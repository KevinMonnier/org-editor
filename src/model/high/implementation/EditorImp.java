package model.high.implementation;

import java.util.ArrayList;

import javax.naming.OperationNotSupportedException;

import model.high.Command;
import model.high.Editor;
import model.low.document.Document;
import model.low.document.HasSubSection;
import model.low.document.HasTextIntro;
import model.low.document.Text;

public class EditorImp implements Editor {

	private Document document;
	private Text selectedText;
	private int selectedLine;
	private int selectedCol;
	private ArrayList<Command> commands;
	private HasSubSection selectedItem;

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
		//TODO implement
		throw new RuntimeException("not implemented");
	}

	@Override
	public char getCommandChar() {
		return EditCommands.COMMAND_CHAR;
	}

	@Override
	public void moveCursor(int down, int right) {
		// TODO Auto-generated method stub
		
		if(this.selectedLine - down < 0 ) {
			
		}
	}

}
