package net.sourceforge.keepassj2me.packer;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.File;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;

public class MainWindow extends JFrame implements ActionListener, WindowListener {
	private static final long serialVersionUID = -62505571827133047L;
	
	private JTextField srcJar = null;
	private JButton srcJarBrowse = null;
	
	private JList srcKdb = null;
	private DefaultListModel srcKdbModel = null;
	private JButton srcKdbAdd = null;
	private JButton srcKdbRemove = null;
	
	private JTextField dstJar = null;
	private JButton dstJarBrowse = null;
	
	private JButton ok = null;
	private JButton cancel = null;
	
	MainWindow () {
		super();
		int x =0, y = 0;
		
		this.setIconImage(Toolkit.getDefaultToolkit().getImage("res/images/icon.png"));
		this.setTitle("KeePass J2ME Packer");
		this.setSize(600, 440);
		this.setMinimumSize(new Dimension(400, 300));
		this.setLocationRelativeTo(null);
		
		this.setLayout(new GridBagLayout());
		GridBagConstraints constraints = new GridBagConstraints();

		this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		this.addWindowListener(this);
		
		/*
		 * LOGO
		 */
		JLabel logo = new JLabel(new ImageIcon(Toolkit.getDefaultToolkit().getImage("res/images/logo.png")));
		constraints.anchor = GridBagConstraints.NORTH;
		constraints.fill = GridBagConstraints.NONE;
		constraints.gridheight = 7;
		constraints.gridwidth = 1;
		constraints.gridx = 0;
		constraints.gridy = 0;
		constraints.insets = new Insets(20, 20, 20, 20);
		constraints.weightx = 0;
		constraints.weighty = 0;
		this.add(logo, constraints);
		
		/*
		 * SOURCE JAR
		 */
		x = 1; y = 0;
		
		JLabel caption = new JLabel("Source JAR");
		caption.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().getImage("res/images/compress.png")));
		constraints.anchor = GridBagConstraints.WEST;
		constraints.fill = GridBagConstraints.NONE;
		constraints.gridheight = 1;
		constraints.gridwidth = 2;
		constraints.gridx = x;
		constraints.gridy = y;
		constraints.insets = new Insets(5, 5, 0, 5);
		constraints.weightx = 0;
		constraints.weighty = 0;
		this.add(caption, constraints);
		
		srcJar = new JTextField("");
		constraints.anchor = GridBagConstraints.CENTER;
		constraints.fill = GridBagConstraints.HORIZONTAL;
		constraints.gridheight = 1;
		constraints.gridwidth = 1;
		constraints.gridx = x;
		constraints.gridy = y + 1;
		constraints.insets = new Insets(5, 5, 5, 5);
		constraints.weightx = 1;
		constraints.weighty = 0;
		this.add(srcJar, constraints);
		
		srcJarBrowse = new JButton("Browse");
		srcJarBrowse.setHorizontalAlignment(JButton.LEFT);
		srcJarBrowse.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().getImage("res/images/folder.png")));
		srcJarBrowse.addActionListener(this);
		constraints.anchor = GridBagConstraints.WEST;
		constraints.fill = GridBagConstraints.HORIZONTAL;
		constraints.gridheight = 1;
		constraints.gridwidth = 1;
		constraints.gridx = x + 1;
		constraints.gridy = y + 1;
		constraints.insets = new Insets(5, 5, 5, 5);
		constraints.weightx = 0;
		constraints.weighty = 0;
		this.add(srcJarBrowse, constraints);
		
		/*
		 * SOURCE KDB
		 */
		x = 1; y = 2;
		
		JLabel caption2 = new JLabel("Source KDB");
		caption2.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().getImage("res/images/database.png")));
		constraints.anchor = GridBagConstraints.WEST;
		constraints.fill = GridBagConstraints.NONE;
		constraints.gridheight = 1;
		constraints.gridwidth = 2;
		constraints.gridx = x;
		constraints.gridy = y;
		constraints.insets = new Insets(5, 5, 0, 5);
		constraints.weightx = 0;
		constraints.weighty = 0;
		this.add(caption2, constraints);
		
		srcKdbModel = new DefaultListModel();
		/*listModel.addElement("Debbie Scott");
		listModel.addElement("Scott Hommel");
		listModel.addElement("Alan Sommerer");*/
		srcKdb = new JList(srcKdbModel);
		srcKdb.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		srcKdb.setLayoutOrientation(JList.VERTICAL);
		srcKdb.setVisibleRowCount(-1);
		JScrollPane listScroller = new JScrollPane(srcKdb);
		constraints.anchor = GridBagConstraints.CENTER;
		constraints.fill = GridBagConstraints.BOTH;
		constraints.gridheight = 2;
		constraints.gridwidth = 1;
		constraints.gridx = x;
		constraints.gridy = y + 1;
		constraints.insets = new Insets(5, 5, 5, 5);
		constraints.weightx = 1;
		constraints.weighty = 1;
		this.add(listScroller, constraints);
		
		srcKdbAdd = new JButton("Add");
		srcKdbAdd.setHorizontalAlignment(JButton.LEFT);
		srcKdbAdd.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().getImage("res/images/add.png")));
		srcKdbAdd.addActionListener(this);
		constraints.anchor = GridBagConstraints.SOUTHWEST;
		constraints.fill = GridBagConstraints.HORIZONTAL;
		constraints.gridheight = 1;
		constraints.gridwidth = 1;
		constraints.gridx = x + 1;
		constraints.gridy = y + 1;
		constraints.insets = new Insets(5, 5, 5, 5);
		constraints.weightx = 0;
		constraints.weighty = 0;
		this.add(srcKdbAdd, constraints);
		
		srcKdbRemove = new JButton("Remove");
		srcKdbRemove.setHorizontalAlignment(JButton.LEFT);
		srcKdbRemove.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().getImage("res/images/delete.png")));
		srcKdbRemove.addActionListener(this);
		constraints.anchor = GridBagConstraints.NORTHWEST;
		constraints.fill = GridBagConstraints.HORIZONTAL;
		constraints.gridheight = 1;
		constraints.gridwidth = 1;
		constraints.gridx = x + 1;
		constraints.gridy = y + 2;
		constraints.insets = new Insets(5, 5, 5, 5);
		constraints.weightx = 0;
		constraints.weighty = 0;
		this.add(srcKdbRemove, constraints);
		
		/*
		 * TARGET JAR
		 */
		x = 1; y = 5;
		
		JLabel caption3 = new JLabel("Target JAR");
		caption3.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().getImage("res/images/compress.png")));
		constraints.anchor = GridBagConstraints.WEST;
		constraints.fill = GridBagConstraints.NONE;
		constraints.gridheight = 1;
		constraints.gridwidth = 2;
		constraints.gridx = x;
		constraints.gridy = y;
		constraints.insets = new Insets(5, 5, 0, 5);
		constraints.weightx = 0;
		constraints.weighty = 0;
		this.add(caption3, constraints);
		
		dstJar = new JTextField("");
		constraints.anchor = GridBagConstraints.CENTER;
		constraints.fill = GridBagConstraints.HORIZONTAL;
		constraints.gridheight = 1;
		constraints.gridwidth = 1;
		constraints.gridx = x;
		constraints.gridy = y + 1;
		constraints.insets = new Insets(5, 5, 5, 5);
		constraints.weightx = 1;
		constraints.weighty = 0;
		this.add(dstJar, constraints);
		
		dstJarBrowse = new JButton("Browse");
		dstJarBrowse.setHorizontalAlignment(JButton.LEFT);
		dstJarBrowse.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().getImage("res/images/folder.png")));
		dstJarBrowse.addActionListener(this);
		constraints.anchor = GridBagConstraints.WEST;
		constraints.fill = GridBagConstraints.HORIZONTAL;
		constraints.gridheight = 1;
		constraints.gridwidth = 1;
		constraints.gridx = x + 1;
		constraints.gridy = y + 1;
		constraints.insets = new Insets(5, 5, 5, 5);
		constraints.weightx = 0;
		constraints.weighty = 0;
		this.add(dstJarBrowse, constraints);
		
		/*
		 * BUTTONS
		 */
		x = 0; y = 7;
		
		JPanel panel = new JPanel();
		panel.setLayout(new FlowLayout());
		
		ok = new JButton("Pack & Save");
		ok.setHorizontalAlignment(JButton.LEFT);
		ok.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().getImage("res/images/tick.png")));
		ok.addActionListener(this);
		panel.add(ok);
		
		cancel = new JButton("Cancel & Exit");
		cancel.setHorizontalAlignment(JButton.LEFT);
		cancel.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().getImage("res/images/cancel.png")));
		cancel.addActionListener(this);
		panel.add(cancel);
		
		constraints.anchor = GridBagConstraints.EAST;
		constraints.fill = GridBagConstraints.NONE;
		constraints.gridheight = 1;
		constraints.gridwidth = 3;
		constraints.gridx = x;
		constraints.gridy = y;
		constraints.insets = new Insets(20, 0, 0, 0);
		constraints.weightx = 1;
		constraints.weighty = 0;
		this.add(panel, constraints);
	}

	void exit() {
		this.setVisible(false);
    	System.exit(0);
	}
	
	public void actionPerformed(ActionEvent arg0) {
		JButton button = (JButton)arg0.getSource();
		if (button == srcJarBrowse) {
		    JFileChooser fc = new JFileChooser();
		    fc.setDialogTitle("Open source Midlet");
		    File f = new File(srcJar.getText());
		    fc.setCurrentDirectory(f.getParentFile());
		    fc.addChoosableFileFilter(new FilterJAR());
		    if (fc.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
		    	srcJar.setText(fc.getSelectedFile().getAbsolutePath());
		    };
		} else if (button == srcKdbAdd) {
		    JFileChooser fc = new JFileChooser();
		    fc.setDialogTitle("Open source KDB");
		    //File f = new File(srcJar.getText());
		    //fc.setCurrentDirectory(f.getParentFile());
		    fc.addChoosableFileFilter(new FilterKDB());
		    if (fc.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
		    	//TODO: Check file presence in list
		    	srcKdbModel.addElement(fc.getSelectedFile().getAbsolutePath());
		    };
		} else if (button == srcKdbRemove) {
			if (srcKdb.getSelectedIndex() >= 0) {
				srcKdbModel.remove(srcKdb.getSelectedIndex());
			};
		} else if (button == dstJarBrowse) {
		    JFileChooser fc = new JFileChooser();
		    fc.setDialogTitle("Save taget Midlet");
		    File f = new File(dstJar.getText());
		    fc.setCurrentDirectory(f.getParentFile());
		    fc.addChoosableFileFilter(new FilterJAR());
		    if (fc.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) {
		    	dstJar.setText(fc.getSelectedFile().getAbsolutePath()+".jar");
		    };
		} else if (button == ok) {
		} else if (button == cancel) {
			this.exit();
		}
	}

	public void windowActivated(WindowEvent e) {}
	public void windowClosed(WindowEvent e) {}
	public void windowClosing(WindowEvent e) {
		this.exit();
	}
	public void windowDeactivated(WindowEvent e) {}
	public void windowDeiconified(WindowEvent e) {}
	public void windowIconified(WindowEvent e) {}
	public void windowOpened(WindowEvent e) {}
}
