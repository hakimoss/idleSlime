package com.hakim;

public class Chrono implements Runnable {

	private final int PAUSE = 3;
	public int compteurWalk = 0;

	@Override
	public void run() {
		
		while(true) {
			Main.scene.repaint();
			
			try {
				Thread.sleep(PAUSE);
				this.compteurWalk++;
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}


	
	
	
}
