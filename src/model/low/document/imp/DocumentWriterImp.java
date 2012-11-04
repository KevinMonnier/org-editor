package model.low.document.imp;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import model.low.document.Document;
import model.low.document.DocumentWriter;
import model.low.document.Section;
import model.low.document.TextIntro;

public class DocumentWriterImp implements DocumentWriter {

	@Override
	public void saveDocument(String path, Document doc) {
		// TODO Auto-generated method stub
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(path));

			StringBuilder printed = new StringBuilder();
			// print intro
			TextIntro intro = doc.getTextIntro();
			for (int i = 0; i < intro.getLineNb(); i++) {
				printed.append(intro.getLine(i).toString() + "\n");
			}

			for (int i = 0; i < doc.getSubSectionNb(); i++) {
				printed.append(this.printSection(doc.getSubSection(i), 1));
			}
			
			writer.append(printed);
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private String printSection(Section section, int lvl) {
		StringBuilder printed = new StringBuilder();
		for (int i = 0; i < lvl; i++) {
			printed.append("*");
		}
		printed.append(section.getTitle().getLine().toString());

		printed.append("\n");
		TextIntro intro = section.getTextIntro();
		for (int i = 0; i < intro.getLineNb(); i++) {

			printed.append(intro.getLine(i).toString() + "\n");
		}

		for (int i = 0; i < section.getSubSectionNb(); i++) {
			printed.append(this.printSection(section.getSubSection(i), lvl + 1));
		}
		return printed.toString();
	}

}
