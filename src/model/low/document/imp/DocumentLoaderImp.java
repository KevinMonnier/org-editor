package model.low.document.imp;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import model.low.document.Document;
import model.low.document.DocumentLoader;
import model.low.document.HasSubSection;
import model.low.document.Section;

public class DocumentLoaderImp implements DocumentLoader {

	
	
	@Override
	public Document loadDocument(String path) {
		Document document = DocumentImp.getDocument();
			try {
				FileReader fr = new FileReader(path);
				BufferedReader reader = new BufferedReader(fr);
				
				document.clear();
				String line;
				while((line = reader.readLine())!=null && !line.startsWith("*")) {
					document.getTextIntro().addLine(new LineImp(document.getTextIntro(), line));
				}
				
				while((line = readSection(document, line, reader, document))!=null && line.startsWith("*"));
				
				
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		return document;
	}

	private String readSection(Document document, String firstLine, BufferedReader reader, HasSubSection parent) throws IOException {
		int currentlvl = getLvl(firstLine);
		Section section = new SectionImp(new TitleImp(firstLine.substring(currentlvl)), parent);
		String line;
		while((line = reader.readLine())!=null && !line.startsWith("*")) {
			section.getTextIntro().addLine(new LineImp(document.getTextIntro(), line));
		}
		
		while(line!= null && this.getLvl(line) > currentlvl) {
			line = this.readSection(document, line, reader, section);
		}
		
		parent.addSubSection(section);
		
		return line;
	}
	
	private int getLvl(String line) {
		int lvl = 0;
		while(lvl < line.length() && line.charAt(lvl) == '*')
			lvl++;
		return lvl;
	}
	
}
