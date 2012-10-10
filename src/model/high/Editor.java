package model.high;

import model.low.document.Section;

public interface Editor {
	
	public Section getSelectedSection();
	
	public int GetSelectedLineNb();
	
	public int GetSelectedCharacterNb();
}
