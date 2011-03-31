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

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Enumeration;
import java.util.Properties;

/**
 * Config - programm configuration
 * @author Stepan Strelets
 *
 */
public class Config {
	private String filename;
	private Properties prop;
	
	/**
	 * Constructor
	 * @param filename - config filename or <code>null</code> to use default
	 */
	Config(String filename) {
		if (filename != null) {
			this.filename = filename; 
		} else {
			this.filename = System.getProperty("user.home")
							+ System.getProperty("file.separator")
							+ ".keepassj2me-packer";
		}
		prop = new Properties();
	}
	
	public boolean Load() {
		InputStream in;
		try {
			in = new FileInputStream(filename);
			prop.load(in);
			return true;
		} catch (IOException e) {
		}
		return false;
	}
	
	public boolean Save() {
		OutputStream out;
		try {
			out = new FileOutputStream(filename);
			prop.store(out, "KeePass J2ME Packer configuration");
			return true;
		} catch (IOException e) {
		}
		return false;
	}
	
	public String getSourceJar() {
		return prop.getProperty("src.jar", "");
	}
	public void setSourceJar(String value) {
		prop.setProperty("src.jar", value);
	}
	
	public String getTargetJar() {
		return prop.getProperty("dst.jar", "");
	}
	public void setTargetJar(String value) {
		prop.setProperty("dst.jar", value);
	}
	
	public String getSourceKdb(int index) {
		if (prop.containsKey("src.kdb."+index)) return prop.getProperty("src.kdb."+index);
		else return null;
	}
	public void setSourceKdb(int index, String value) {
		prop.setProperty("src.kdb."+index, value);
	}
	public void clearSourceKdb() {
		String name;
		for (Enumeration<?> e = prop.propertyNames(); e.hasMoreElements();) {
			name = e.nextElement().toString();
			if (name.indexOf("src.kdb.") == 0) prop.remove(name);
		};
	}
	
	public String getKdbLastDir() {
		return prop.getProperty("src.kdbdir", "");
	}
	public void setKdbLastDir(String value) {
		prop.setProperty("src.kdbdir", value);
	}
	
	public boolean getResourcesPackEnable() {
		String value = prop.getProperty("respack.enable", "0");
		return Integer.parseInt(value) != 0;
	}
	public void setResourcesPackEnable(boolean value) {
		prop.setProperty("respack.enable", value ? "1" : "0");
	}
	public String getIconsPackName() {
		return prop.getProperty("respack.icons.name", "");
	}
	public void setIconsPackName(String value) {
		prop.setProperty("respack.icons.name", value);
	}
	public String getLogoPackName() {
		return prop.getProperty("respack.logo.name", "");
	}
	public void setLogoPackName(String value) {
		prop.setProperty("respack.logo.name", value);
	}
}
