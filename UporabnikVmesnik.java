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
				case 'q':
					return;
				case 's':
					boolean flag = agencija.prijavaUporabnika();
					if(flag) {
						while(true) {
							System.out.println("Pritisni (a) za prikaz pocitnic glede na datum.");
							System.out.println("Pritisni (b) iskanje pocitnic glede na drzavo");
							System.out.println("Pritisni (c) iskanje pocitnic glede na cenovni okvir.");
							System.out.println("Pritisni (3) za izpis pocitnic tipa - krizarjenje.");
							System.out.println("Pritisni (4) za izpis pocitnic tipa - smucanje.");
							System.out.println("Pritisni (2) za izpis pocitnic tipa - kampiranje.");
							System.out.println("Pritisni (1) za izpis pocitnic tipa - potovanje.");
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
								case '1':
									System.out.println(agencija.izpisPoTipu(1));
									break;
								case '2':
									System.out.println(agencija.izpisPoTipu(2));
									break;
								case '3':
									System.out.println(agencija.izpisPoTipu(3));
									break;
								case '4':
									System.out.println(agencija.izpisPoTipu(4));
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
					boolean flag = agencija.prijavaUporabnika();
					if(flag) {
						while(true) {
							System.out.println("***       ADMIN       ***");
							System.out.println("Pritisni (a) za prikaz pocitnic glede na datum.");
							System.out.println("Pritisni (b) iskanje pocitnic glede na drzavo");
							System.out.println("Pritisni (c) iskanje pocitnic glede na cenovni okvir.");
							System.out.println("Pritisni (1) za izpis pocitnic tipa - potovanje.");
							System.out.println("Pritisni (2) za izpis pocitnic tipa - kampiranje.");
							System.out.println("Pritisni (3) za izpis pocitnic tipa - krizarjenje.");
							System.out.println("Pritisni (4) za izpis pocitnic tipa - smucanje.");
							System.out.println("Pritisni (e) za izpis vseh svojih rezervacij.");
							System.out.println("Pritisni (f) za novo rezervacijo.");
							System.out.println("Pritisni (q) za prekinitev programa.");
							System.out.println("***       ADMIN       ***");
							System.out.println("Pritisni (g) za iskanje glede na id-pocitnic.");
							System.out.println("Pritisni (h) za vnos novih pocitnic.");
							System.out.println("Pritisni (d) za brisanje pocitnic.");
							System.out.println("Pritisni (u) za urejenje pocitnic.");
							System.out.println("Pritisni (i) za shranjevanje v datoteko.");
							System.out.println("Pritisni (u) za dodajanje novega administratorja.");
							System.out.println("Pritisni (x) za brisanje uporabnikov/administratorjev.");
							
							System.out.println();
							
							izbira = br.readLine().trim().charAt(0);
							String imeDat = "";
							
							switch(izbira) {
								case 'a':
									System.out.println(agencija.izpisPoTerminu(flag));
									break;
								case 'b':
									System.out.println(agencija.izpisDrzava(flag));
									break;
								case 'c':
									System.out.println(agencija.izpisPoCeni(flag));
									break;
								case '1':
									System.out.println(agencija.izpisPoTipu(1));
									break;
								case '2':
									System.out.println(agencija.izpisPoTipu(2));
									break;
								case '3':
									System.out.println(agencija.izpisPoTipu(3));
									break;
								case '4':
									System.out.println(agencija.izpisPoTipu(4));
									break;
								case 'e':
									//System.out.println(agencija.izpisPoTipu(flag));
									break;
								case 'f':
									agencija.novaRezervacija();
									System.out.println();
									break;
								case 'g':
									System.out.println(agencija.izpisPoId());
									break;
								case 'h':
									Pocitnice p = Pocitnice.ustvariPocitnice();
									agencija.dodajPocitnice(p);
									break;
								case 'd':
									agencija.izbrisId();
									break;
								case 'i':
									System.out.println("Vnesite ime datoteke: ");
									imeDat = br.readLine().trim();
									agencija.dodajIzDatoteke(imeDat);
									System.out.println();
									break;
								case 'u':
									agencija.registracijaUporabnika(flag);
									break;
								case 'x':
									agencija.registracijaUporabnika(flag);
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
				default:
					System.out.println("Pritisnili ste napacno izbiro!");
					System.out.println();
			}
		}

	}		
	
}