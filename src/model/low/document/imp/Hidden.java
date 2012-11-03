package model.low.document.imp;

import model.low.document.Section;
import model.low.document.State;

public class Hidden implements State {

	@Override
	public boolean isVisible() {
		return false;
	}

	@Override
	public void showHide(Section SECTION_CONTEXT) {
		SECTION_CONTEXT.setState(new Visible());
	}

}
