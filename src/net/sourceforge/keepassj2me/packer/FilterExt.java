/*
	Copyright 2008-2011 Stepan Strelets
	http://keepassj2me.sourceforge.net/

	This file is part of KeePass for J2ME Packer.
	
	KeePass for J2ME Packer is free software: you can redistribute it and/or modify
	it under the terms of the GNU General Public License as published by
	the Free Software Foundation, version 2.
	
	KeePass for J2ME Packer is distributed in the hope that it will be useful,
	but WITHOUT ANY WARRANTY; without even the implied warranty of
	MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
	GNU General Public License for more details.
	
	You should have received a copy of the GNU General Public License
	along with KeePass for J2ME Packer.  If not, see <http://www.gnu.org/licenses/>.
 */

package net.sourceforge.keepassj2me.packer;

import java.io.File;
import javax.swing.filechooser.*;

/**
 * FilterExt - filter by extension for file browse dialog
 * 
 * @author Stepan Strelets
 *
 */
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
