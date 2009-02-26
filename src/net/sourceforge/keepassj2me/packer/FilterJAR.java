package net.sourceforge.keepassj2me.packer;

import java.io.File;

import javax.swing.filechooser.FileFilter;

public class FilterJAR extends FileFilter {

	public boolean accept(File arg0) {
		if (arg0.isDirectory()) return true;
		
		String name = arg0.getName();
		if (name.length() > 3) {
			String ext = name.substring(name.length() - 4);
			return ext.equalsIgnoreCase(".jar");
		};
		return false;
	}

	public String getDescription() {
		 return "Midlet (*.jar)";
	}

}
