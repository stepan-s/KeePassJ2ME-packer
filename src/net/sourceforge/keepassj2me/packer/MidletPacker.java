package net.sourceforge.keepassj2me.packer;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.Vector;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
import java.util.jar.JarOutputStream;

import javax.swing.JOptionPane;

/**
 * MidletPacker - pack custom midlet
 * 
 * @author Stepan Strelets
 *
 */
public class MidletPacker {
	private Config conf;
	
	MidletPacker(Config conf) {
		this.conf = conf;
	}
	
	public void pack() throws Exception {
		// check source
		File srcJar = new File(conf.getSourceJar());
		if (!srcJar.exists()) throw new Exception("Source JAR not exists");
		if (!srcJar.isFile()) throw new Exception("Source JAR not is file");
		if (!srcJar.canRead()) throw new Exception("Source JAR not readable");

		// check target
		File dstJar = new File(conf.getTargetJar());
		if (dstJar.exists()) {
			if (JOptionPane.showConfirmDialog(null, "Target JAR exists, overwrite?", "Overwrite?", JOptionPane.YES_NO_OPTION) != JOptionPane.OK_OPTION)
				return;
			
			if (!dstJar.isFile()) throw new Exception("Target JAR not is file");
			if (!dstJar.canWrite()) throw new Exception("Target JAR not writable");
		};
		
		JarFile src = new JarFile(srcJar);
		JarOutputStream dst = new JarOutputStream(new FileOutputStream(dstJar));

        byte buffer[] = new byte[1024];
        int bytesRead;

        // copy jar content
		Enumeration<JarEntry> entries = src.entries();
		while (entries.hasMoreElements()) {
			JarEntry entry = entries.nextElement();
			InputStream is = src.getInputStream(entry);
			dst.putNextEntry(entry);
			
			while ((bytesRead = is.read(buffer)) != -1) {
				dst.write(buffer, 0, bytesRead);
			};
		};

		src.close();
		
		// add kdb to jar
		String kdb, name, names = "";
		Vector<String> already = new Vector<String>();
		int i = 0;
		while((kdb = conf.getSourceKdb(i++)) != null) {
			File srcKdb = new File(kdb);
			if (!srcKdb.exists()) throw new Exception("Source KDB '"+kdb+"' not exists");
			if (!srcKdb.isFile()) throw new Exception("Source KDB '"+kdb+"' not is file");
			if (!srcKdb.canRead()) throw new Exception("Source KDB '"+kdb+"' not readable");
			
			name = srcKdb.getName();
			
			// check duplicate filename
			String name2 = name;
			int n = 1;
			while(already.contains(name)) {
				name = name2+"."+n;
				i++;
			};
			
			JarEntry entry = new JarEntry("kdb/"+name);
			dst.putNextEntry(entry);
			names += name+"\n";
			already.add(name);
			
			FileInputStream kdbStream = new FileInputStream(srcKdb);
			while ((bytesRead = kdbStream.read(buffer)) != -1) {
				dst.write(buffer, 0, bytesRead);
			};
		};
		// add kdb list to jar
		JarEntry lsentry = new JarEntry("kdb/ls");
		dst.putNextEntry(lsentry);
		dst.write(names.getBytes(), 0, names.getBytes().length);
		
		dst.close();
	}
}
