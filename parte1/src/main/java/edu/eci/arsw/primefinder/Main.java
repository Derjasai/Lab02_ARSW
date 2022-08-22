package edu.eci.arsw.primefinder;

public class Main {

	public static void main(String[] args) {
		long s = System.currentTimeMillis();
		PrimeFinderThread pft1=new PrimeFinderThread(0, 10000000);
//		PrimeFinderThread pft2=new PrimeFinderThread(10000001, 20000000);
//		PrimeFinderThread pft3=new PrimeFinderThread(20000001, 30000000);
		
		pft1.start();
//		pft2.start();
//		pft3.start();


		synchronized (pft1) {
			while (System.currentTimeMillis() - s <= 5000){
				System.out.println(time);
				try {
					pft1.wait();
				} catch (InterruptedException ex) {
					throw new RuntimeException(ex);
				}
			}
		}
		long ef = System.currentTimeMillis();
		double time = ef - s;
		System.out.println("time" + time);
		
	}
	
}
