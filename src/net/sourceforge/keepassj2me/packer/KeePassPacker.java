/*
 KeePass for J2ME Packer
 
 This program is free software; you can redistribute it and/or modify
 it under the terms of the GNU General Public License as published by
 the Free Software Foundation; version 2
 
 This program is distributed in the hope that it will be useful,
 but WITHOUT ANY WARRANTY; without even the implied warranty of
 MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 GNU General Public License for more details.

 You should have received a copy of the GNU General Public License
 along with this program; if not, write to the Free Software
 Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA  02110-1301  USA
 */

package net.sourceforge.keepassj2me.packer;

import java.awt.EventQueue;
import javax.swing.UIManager;

/**
 * KeePassPacker
 * 
 * @author Naomaru Itoi
 * @author Stepan Strelets
 *
 */
public final class KeePassPacker implements Runnable {

    public static void main(String[] args) {
        EventQueue.invokeLater (new KeePassPacker());
    } 

	public void run() {
    	try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {};
    	
    	MainWindow main = new MainWindow();
    	main.setVisible(true);
    }
}
