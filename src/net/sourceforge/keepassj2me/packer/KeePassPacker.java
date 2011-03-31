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

import javax.swing.UIManager;

/**
 * KeePassPacker
 * 
 * @author Stepan Strelets
 *
 */
public final class KeePassPacker {
	
    /**
     * @param args
     */
    public static void main(String[] args) {
    	try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {};
    	
    	MainWindow main = new MainWindow();
    	main.setVisible(true);
    } 
}
