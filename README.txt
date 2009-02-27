KeePass J2ME Packer

* This package requires JRE-1.6.0 or above to be installed.

- Run `keepassj2me-packer.jar`
  (Or `java -jar keepassj2me-packer.jar`, java must be in the path)
- Choose your KeePassJ2ME Midlet as Source JAR (1.2.0 or above)
- Choose your KeePass Key Database Files
- Choose file name for target midlet
- Click the `Pack` button, this will create packed jar with you KDB.
- Download packed file to your J2ME phone through USB, Bluetooth, etc.
- On your J2ME phone, launch KeePass for J2ME.


* Phone specific information

- Motorola RAZR V3

Use MIDway to download KeePassJ2ME-KDB.jar.  Use the jad file in the package.
If the jad file does not work, use JADMAker to create a new one.

If it still does not work, check this (http://sourceforge.net/forum/forum.php?thread_id=1826315&forum_id=709880).

"So I used JADMAker to create a JAD file, then loaded it in the emulator, and I got 'Invalid application' error messages on load. I noticed that the MIDlet name was truncated. Looked at the Manifest file, and there was a <CR> in the middle of the name. Changed the manifest file, no difference. Te\hen I noticed that the JAD file had the same thing. A hard carriage return at org.phoneid.keepassj2me.KeePas So I editted the JAD file to remove that carriage return, and the app worked. I was able to download it to the phone using MIDway, and the app worked there as well. Just to be sure I went back to the original manifest file, and that didn't make a difference. In this case, I guess it really wants a JAD file for MIDway, and it really wants the full entrypoint name on one line. I can live with that. "
