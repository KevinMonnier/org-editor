package model.low.document;

public interface Section extends Composite, Component, HasSubSection, HasTextIntro{

	public Title getTitle();
	
	public HasSubSection getParent();

}
