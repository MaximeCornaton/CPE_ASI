package com.sp.model;

public enum Family{
	Tree("Happy Tree Family"), Ocean("Ocean lover"), Bird("Bird's friend"), DC("DC Comics"), Marvel("Marvel");
	
	private String display_Family;
	
	Family(String display_name){
		this.display_Family = display_name;
	}
	
	public String displayName() { return display_Family; }
	
	public String getFamily() {
        return this.display_Family;
    }
}