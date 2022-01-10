package com.hakim;

import com.hakim.gameplay.Upgrade;

public class ChronoSelectedCharatere implements Runnable {

	private final int PAUSE = 150;
	

	@Override
	public void run() {
		while(Upgrade.isExit() == false) {
			//SelecteHeroScreen s = new SelecteHeroScreen();
			Main.frame.repaint();

			try {
				Thread.sleep(PAUSE);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}



	
	
	
}
