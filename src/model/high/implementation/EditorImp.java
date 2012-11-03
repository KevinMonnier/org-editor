package model.high.implementation;

import java.util.ArrayList;

import model.high.command.Command;
import model.high.editor.Editor;
import model.low.cursor.Cursor;
import model.low.document.Document;
import model.low.document.HasSubSection;
import model.low.document.Line;
import model.low.document.Section;
import model.low.document.Text;
import model.low.document.TextIntro;
import model.low.document.imp.LineImp;

public class EditorImp implements Editor {

	private Document document;
	private Text selectedText;
	private int selectedLine;
	private int selectedCol;
	private ArrayList<Command> commands;
	private HasSubSection selectedItem;
	private Cursor cursor;

	@Override
	public Document getDocument() {
		return this.document;
	}

	@Override
	public HasSubSection getSelectedItem() {
		return this.selectedItem;
	}

	@Override
	public int getSelectedLineNb() {
		return this.selectedLine;
	}

	@Override
	public int getSelectedCharacterNb() {
		return this.cursor.getCurrentPosition();
	}

	@Override
	public void addCommand(Command c) {
		this.commands.add(c);
	}

	@Override
	public void executeCommand(String c) {
		int i = 0;
		while (!this.commands.get(i).match(c)) {
			i++;
		}
		if (i >= this.commands.size())
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
		return this.cursor.getCurrentLine();
	}

	@Override
	public String print() {
		StringBuilder printed = new StringBuilder();
		Line selectedLine = this.getSelectedLine();
		// print intro
		TextIntro intro = this.document.getTextIntro();
		for (int i = 0; i < intro.getLineNb(); i++) {
			if (intro.getLine(i).equals(selectedLine)) {
				printed.append(new StringBuilder(intro.getLine(i).toString())
						.insert(this.getSelectedCharacterNb(), "[]") + "\n");
			} else {
				printed.append(intro.getLine(i).toString() + "\n");
			}
		}

		for (int i = 0; i < this.document.getSubSectionNb(); i++) {
			printed.append(this.printSection(this.document.getSubSection(i)));
		}

		return printed.toString();
	}

	private String printSection(Section section) {
		Line selectedLine = this.getSelectedLine();
		StringBuilder printed = new StringBuilder();
		if (section.getTitle().getLine().equals(selectedLine)) {
			printed.append(new StringBuilder(section.getTitle().getLine()
					.toString()).insert(this.getSelectedCharacterNb(), "[]"));
		} else
			printed.append(section.getTitle().getLine().toString());

		if (section.isVisible()) {
			TextIntro intro = section.getTextIntro();
			for (int i = 0; i < intro.getLineNb(); i++) {
				if (intro.getLine(i).equals(selectedLine)) {
					printed.append(new StringBuilder(intro.getLine(i)
							.toString()).insert(this.getSelectedCharacterNb(),
							"[]").append("\n"));
				} else {
					printed.append(intro.getLine(i).toString() + "\n");
				}
			}

			for (int i = 0; i < section.getSubSectionNb(); i++) {
				this.printSection(section.getSubSection(i));
			}
		} else {
			printed.append("... \n");
		}

		return printed.toString();
	}

	@Override
	public void newLine() {
		// TODO Auto-generated method stub
		Text parent = this.getSelectedLine().getParent();
		if(parent instanceof TextIntro) {
			((TextIntro)parent).insertLine(new LineImp(parent), this.getSelectedLine());
			this.getCursor().selectLineDown();
		}
	}

	@Override
	public void insertChar(char c) {
		this.getSelectedLine().insertCharAt(this.getSelectedCharacterNb(), c);
	}

}
