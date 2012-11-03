package model.low.document.imp;

import model.low.document.Section;
import model.low.document.State;

public class Visible implements State {

	@Override
	public boolean isVisible() {
		return true;
	}

	@Override
	public void showHide(Section SECTION_CONTEXT) {
		SECTION_CONTEXT.setState(new Hidden());
	}

}
