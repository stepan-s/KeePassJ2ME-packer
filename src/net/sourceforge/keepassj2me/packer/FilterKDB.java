package net.sourceforge.keepassj2me.packer;

import java.io.File;
import javax.swing.filechooser.*;

public class FilterKDB extends FileFilter {

	public boolean accept(File arg0) {
		if (arg0.isDirectory()) return true;
		
		String name = arg0.getName();
		if (name.length() > 3) {
			String ext = name.substring(name.length() - 4);
			return ext.equalsIgnoreCase(".kdb");
		};
		return false;
	}

	public String getDescription() {
		 return "KeePass Key Database (*.kdb)";
	}

}
