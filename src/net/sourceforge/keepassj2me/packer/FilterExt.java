package net.sourceforge.keepassj2me.packer;

import java.io.File;
import javax.swing.filechooser.*;

public class FilterExt extends FileFilter {
	private String description = null;
	private String extension = null;
	
	FilterExt(String extension, String description) {
		super();
		this.description = description;
		this.extension = extension;
	}
	
	public boolean accept(File arg0) {
		if (arg0.isDirectory()) return true;
		
		String name = arg0.getName();
		if (name.length() > this.extension.length()) {
			String ext = name.substring(name.length() - (this.extension.length() + 1));
			return ext.equalsIgnoreCase("."+this.extension);
		};
		return false;
	}

	public String getDescription() {
		 return this.description;
	}

}
