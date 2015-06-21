package com.testtask;

public class DeadLock {

	static String om = "om";
	static String nom = "nom";
	
	public static void main(String[] args) {
		
		
		Thread omThread= new Thread("omThread"){
			public void run(){
				while (!nom.equals(om)){//infinite loop
					synchronized (om) {
						//trying to lock om
						synchronized (nom) {
							//trying to lock nom
							System.out.println("omThread");	

						}
					}
				}
			}
		};
		Thread nomThread = new Thread("nomThread"){
			public void run(){
				while (!nom.equals(om)){//infinite loop
					synchronized (nom) {
						//trying to lock nom
						synchronized (om) {
							//trying to lock om
							System.out.println("nomThread");	
						}
					}
				}
			}
		};
		
		
	omThread.start();
	nomThread.start();
		
		
	}
	
	

}
