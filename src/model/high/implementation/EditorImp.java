package model.high.implementation;

import java.util.ArrayList;

import javax.naming.OperationNotSupportedException;

import model.high.command.Command;
import model.high.editor.Editor;
import model.low.cursor.Cursor;
import model.low.document.Document;
import model.low.document.HasSubSection;
import model.low.document.HasTextIntro;
import model.low.document.Line;
import model.low.document.Section;
import model.low.document.Text;
import model.low.document.TextIntro;

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
		// TODO Auto-generated method stub
		
	}

	@Override
	public char getCommandChar() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void moveCursor(int down, int right) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Cursor getCursor() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Line getSelectedLine() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String print() {
		StringBuilder printed = new StringBuilder();
		Line selectedLine = this.getSelectedLine();
		//print intro
		TextIntro intro = this.document.getTextIntro();
		for (int i = 0; i < intro.getLineNb(); i++) {
			if(intro.getLine(i).equals(selectedLine)) {
				printed.append(new StringBuilder(intro.getLine(i).toString()).insert(this.getSelectedCharacterNb(), "[]") + "\n");
			}
			else {
				printed.append(intro.getLine(i).toString() + "\n");
			}
		}
		
		for(int i = 0 ; i < this.document.getSubSectionNb() ; i++) {
			printed.append(this.printSection(this.document.getSubSection(i)));
		}
		
		return printed.toString();
	}
	
	private String printSection(Section section) {
		Line selectedLine = this.getSelectedLine();
		StringBuilder printed = new StringBuilder();
		if(section.getTitle().getLine().equals(selectedLine)) {
			printed.append(new StringBuilder(section.getTitle().getLine().toString()).insert(this.getSelectedCharacterNb(), "[]"));
		}
		else
			printed.append(section.getTitle().getLine().toString());
		
		if(section.isVisible()) {
			TextIntro intro = section.getTextIntro();
			for (int i = 0; i < intro.getLineNb(); i++) {
				if(intro.getLine(i).equals(selectedLine)) {
					printed.append(new StringBuilder(intro.getLine(i).toString()).insert(this.getSelectedCharacterNb(), "[]").append("\n"));
				}
				else {
					printed.append(intro.getLine(i).toString() + "\n");
				}
			}
			
			for(int i = 0 ; i < section.getSubSectionNb() ; i++) {
				this.printSection(section.getSubSection(i));
			}
		}
		else {
			printed.append("... \n");
		}
		
		
		return printed.toString();
	}

}
