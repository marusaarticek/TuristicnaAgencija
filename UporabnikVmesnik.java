import java.io.*;
import java.util.*;


public class UporabnikVmesnik {
	
	public static void main(String args[]) throws Exception {
		
		TuristicnaAgencija agencija = new TuristicnaAgencija();
		//agencija.dodajIzDatoteke(Uporabniki.txt);
		
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		
		char izbira;
		
		while(true) {
			System.out.println("********* Dobrodosli v sistemu. *********\r\n");
			System.out.println("Pritisni (s) za prijavo v sistem");
			System.out.println("Pritisni (r) registracijo v sistem.");
			System.out.println("Pritisni (a) za prijavo admina.");
			
			izbira = br.readLine().trim().charAt(0);
			
			switch(izbira) {
				case 's':
					boolean flag = agencija.prijavaUporabnika();
					if(flag) {
						while(true) {
							System.out.println("Pritisni (a) za prikaz pocitnic glede na datum.");
							System.out.println("Pritisni (b) iskanje pocitnic glede na drzavo");
							System.out.println("Pritisni (c) iskanje pocitnic glede na cenovni okvir.");
							System.out.println("Pritisni (d) iskanje pocitnic glede na tip.");
							System.out.println("Pritisni (e) za izpis vseh svojih rezervacij.");
							System.out.println("Pritisni (f) za novo rezervacijo.");
							System.out.println("Pritisni (q) za prekinitev programa.");
							System.out.println();
							
							izbira = br.readLine().trim().charAt(0);
							String imeDat = "";
							
							switch(izbira) {
								case 'a':
									System.out.println(agencija.izpisPoTerminu());
									break;
								case 'b':
									System.out.println(agencija.izpisDrzava());
									break;
								case 'c':
									System.out.println(agencija.izpisPoCeni());
									break;
								case 'd':
									//System.out.println(agencija.izpisPoTipu());
									break;
								case 'f':
									agencija.novaRezervacija();
									System.out.println();
									break;
								case 'p':
									break;
								case 's':
									break;
								case 'q':
									return;
								default:
									System.out.println("Pritisnili ste napacno izbiro!");
							}
						}
					}
					else{
						System.out.println("Prijava neuspesna!");
						break;
					}
				case 'r':
					agencija.registracijaUporabnika();
					break;
				case 'a':
				default:
					System.out.println("Pritisnili ste napacno izbiro!");
					System.out.println();
			}
		}

	}		
	
}