package desmos;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

public class Colatz {
	
	public Colatz(int x) throws InterruptedException, AWTException {
		int rounds = 0;
		int place = x;
		Robot r = new Robot();
		
		while(x != 1) {
			if(x % 2 == 1) {
				x = 3 * x + 1;
				rounds++;
			}else {
				x = x / 2;
				rounds++;
			}
		}
		
		
		Thread.sleep(5000);
		
		
		for(int z = 0; z < rounds; z++) {
			String str = String.valueOf(z);
			String str2 = String.valueOf(place);
			Thread.sleep(50);
			
			for(int zz = 0; zz < (str.length()); zz++) {
				r.keyPress(KeyEvent.getExtendedKeyCodeForChar(str.charAt(zz)));
				r.keyRelease(KeyEvent.getExtendedKeyCodeForChar(str.charAt(zz)));
				Thread.sleep(90);
			}
			
			Thread.sleep(90);
			r.keyPress(KeyEvent.VK_RIGHT);
			r.keyRelease(KeyEvent.VK_RIGHT);
			Thread.sleep(90);
			
			for(int zzz = 0; zzz < (str2.length()); zzz++) {
				r.keyPress(KeyEvent.getExtendedKeyCodeForChar(str2.charAt(zzz)));
				r.keyRelease(KeyEvent.getExtendedKeyCodeForChar(str2.charAt(zzz)));
				Thread.sleep(90);
			}
			
			r.keyPress(KeyEvent.VK_DOWN);
			r.keyRelease(KeyEvent.VK_DOWN);
			r.keyPress(KeyEvent.VK_LEFT);
			r.keyRelease(KeyEvent.VK_LEFT);
			Thread.sleep(90);
			
			if(place % 2 == 1) {
				place = 3 * place + 1;
			}else {
				place = place / 2;
			}
		}
		
	}

}
