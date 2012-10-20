package model.high;

import model.low.document.Section;
import model.low.document.Text;

public interface Editor {
	
	public Section getSelectedSection();
	
	public Text getSelectedText();
	
	public int getSelectedLineNb();
	
	public int getSelectedCharacterNb();
	
	public int addCommand(Command c);
}