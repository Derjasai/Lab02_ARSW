package edu.eci.arsw.primefinder;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		//Tomar la hora donde inicia el programa
		long st = System.currentTimeMillis();

		ArrayList<PrimeFinderThread> threads = new ArrayList<>();
		PrimeFinderThread pft1=new PrimeFinderThread(0, 10000000);
		PrimeFinderThread pft2=new PrimeFinderThread(10000001, 20000000);
		PrimeFinderThread pft3=new PrimeFinderThread(20000001, 30000000);
		threads.add(pft1);
		threads.add(pft2);
		threads.add(pft3);

		//Iniciar a correr todos los hilos
		for (PrimeFinderThread thread:threads){
			thread.start();
		}
		//Saber la hora actual de este momento del programa
		long cur = System.currentTimeMillis();
		
		//Saber cuanto tiempo a transcurrido desde que el programa inció
		long seconds = cur - st;

		while (seconds < (long) 5000){
			System.out.println(seconds);
			cur = System.currentTimeMillis();
			seconds = cur-st;
		}
		//Pausar todos los hilos
		for (PrimeFinderThread thread:threads){
			thread.pause();
		}
		Scanner scanner = new Scanner(System.in);
		System.out.println("Para reanudar el programa oprima enter");
		String input = scanner.nextLine();

		//Reaundar todos los hilos si la entrada es un enter
		if(Objects.equals(input, "")){
			for(PrimeFinderThread thread:threads){
				thread.resumes();
			}
		}

	}
}
