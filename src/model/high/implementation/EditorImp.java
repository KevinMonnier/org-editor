package model.high.implementation;

import java.util.ArrayList;

import model.high.command.Command;
import model.high.editor.Editor;
import model.low.cursor.Cursor;
import model.low.cursor.imp.CursorImp;
import model.low.document.Document;
import model.low.document.HasSubSection;
import model.low.document.Line;
import model.low.document.Section;
import model.low.document.Text;
import model.low.document.TextIntro;
import model.low.document.Title;
import model.low.document.imp.DocumentImp;
import model.low.document.imp.LineImp;

public class EditorImp implements Editor {

	private Document document;
	private ArrayList<Command> commands;
	private Cursor cursor;

	public EditorImp(Cursor cursor) {
		super();
		this.cursor = cursor;
		DocumentImp.getDocument();
		CursorImp.getCursor().visitDocument(DocumentImp.getDocument());
		this.cursor.initCursor();
		this.document = cursor.getDocument();
		this.commands = new ArrayList<Command>();
	}

	@Override
	public Document getDocument() {
		return this.document;
	}

	@Override
	public HasSubSection getSelectedItem() {
		Text lineContainer = this.getCursor().getCurrentLine().getParent();
		if (lineContainer instanceof TextIntro)
			return (HasSubSection) ((TextIntro) lineContainer).getParent();
		else
			return ((Title) lineContainer).getParent();
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
		if (c.equals("" + this.getCommandChar())) {
			this.insertChar(c.charAt(0));
			return;
		}
		int i = 0;
		while (i < this.commands.size() && !this.commands.get(i).match(c)) {
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
						.insert(this.getSelectedCharacterNb(), "[").insert(
								this.getSelectedLine().length() == this
										.getSelectedCharacterNb() ? this
										.getSelectedCharacterNb() + 1 : this
										.getSelectedCharacterNb() + 2, "]")
						+ "\n");
			} else {
				printed.append(intro.getLine(i).toString() + "\n");
			}
		}

		for (int i = 0; i < this.document.getSubSectionNb(); i++) {
			printed.append(this.printSection(this.document.getSubSection(i), 1));
		}

		return printed.toString();
	}

	private String printSection(Section section, int lvl) {
		Line selectedLine = this.getSelectedLine();
		StringBuilder printed = new StringBuilder();
		for (int i = 0; i < lvl; i++) {
			printed.append("*");
		}
		if (section.getTitle().getLine().equals(selectedLine)) {
			printed.append(new StringBuilder(section.getTitle().getLine()
					.toString()).insert(this.getSelectedCharacterNb(), "[")
					.insert(selectedLine.length() == this
							.getSelectedCharacterNb() ? this
							.getSelectedCharacterNb() + 1 : this
							.getSelectedCharacterNb() + 2, "]"));
		} else
			printed.append(section.getTitle().getLine().toString());

		if (section.isVisible()) {
			printed.append("\n");
			TextIntro intro = section.getTextIntro();
			for (int i = 0; i < intro.getLineNb(); i++) {
				if (intro.getLine(i).equals(selectedLine)) {
					printed.append(new StringBuilder(intro.getLine(i)
							.toString()).insert(this.getSelectedCharacterNb(), "[")
					.insert(selectedLine.length() == this
							.getSelectedCharacterNb() ? this
							.getSelectedCharacterNb() + 1 : this
							.getSelectedCharacterNb() + 2, "]")).append("\n");
				} else {
					printed.append(intro.getLine(i).toString() + "\n");
				}
			}

			for (int i = 0; i < section.getSubSectionNb(); i++) {
				printed.append(this.printSection(section.getSubSection(i),
						lvl + 1));
			}
		} else {
			printed.append("... \n");
		}

		return printed.toString();
	}

	@Override
	public void newLine() {
		Text parent = this.getSelectedLine().getParent();
		if (parent instanceof TextIntro) {
			((TextIntro) parent).insertLine(new LineImp(parent),
					this.getSelectedLine());
		} else if (parent instanceof Title) {
			TextIntro text = ((Title) parent).getParent().getTextIntro();
			text.insertLine(new LineImp(text), 0);
		}
		this.getCursor().selectLineDown();
	}

	@Override
	public void insertChar(char c) {
		this.getSelectedLine().insertCharAt(this.getSelectedCharacterNb(), c);
		this.getCursor().movePositionRight();
	}

}
