import java.io.*;
import java.util.*;
import java.time.LocalDateTime;
import java.time.LocalDate;
import java.text.ParseException;
import java.time.format.DateTimeFormatter;

public class UporabnikVmesnik {
	
	public static void main(String args[]) throws Exception {
		
		TuristicnaAgencija agencija = new TuristicnaAgencija();
		
		String imeDatU = "Uporabniki.txt";
		String imeDatP = "Pocitnice.txt";
		agencija.dodajIzDatotekeU(imeDatU);
		agencija.dodajIzDatotekeP(imeDatP);
		
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		
		char izbira;
		char c;
		boolean flag = false;
		boolean check = false;
		//boolean admin = false;
		while(true) {
			System.out.println("********* Dobrodosli v sistemu. *********\r\n");
			System.out.println("Pritisni (s) za prijavo v sistem");
			System.out.println("Pritisni (r) registracijo v sistem.");
			System.out.println("Pritisni (a) za prijavo admina.");
			System.out.println("Pritisni (q) za prekinitev programa.");
			
			izbira = br.readLine().trim().charAt(0);
			
			switch(izbira) {
				case 'q':
					return;
				case 's':
					flag = agencija.prijavaUporabnika(false);
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
									System.out.println(agencija.izpisPoTerminu(false));
									break;
								case 'b':
									System.out.println(agencija.izpisDrzava(false));
									break;
								case 'c':
									System.out.println(agencija.izpisPoCeni(false));
									break;
								case '1':
									System.out.println(agencija.izpisPoTipu(1, false));
									break;
								case '2':
									System.out.println(agencija.izpisPoTipu(2, false));
									break;
								case '3':
									System.out.println(agencija.izpisPoTipu(3, false));
									break;
								case '4':
									System.out.println(agencija.izpisPoTipu(4, false));
									break;
								case 'f':
									agencija.novaRezervacija();
									System.out.println();
									break;
								case 'e':
									System.out.println(agencija.izpisRezervacij(false));
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
					agencija.registracijaUporabnika(false);
					break;
				case 'a':
					check = agencija.prijavaUporabnika(true);
					if(check) {
						adminloop: while(true) {
							System.out.println("***   ***");
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
							System.out.println("Pritisni (k) za dodajanje novega administratorja.");
							System.out.println("Pritisni (x) za brisanje uporabnikov/administratorjev.");
							System.out.println("Pritisni (z) za vrnitev na zacetno stran.");
							
							System.out.println();
							
							izbira = br.readLine().trim().charAt(0);
							String imeDat = "";
							
							switch(izbira) {
								case 'a':
									System.out.println(agencija.izpisPoTerminu(check));
									break;
								case 'b':
									System.out.println(agencija.izpisDrzava(check));
									break;
								case 'c':
									System.out.println(agencija.izpisPoCeni(check));
									break;
								case '1':
									System.out.println(agencija.izpisPoTipu(1, true));
									break;
								case '2':
									System.out.println(agencija.izpisPoTipu(2, true));
									break;
								case '3':
									System.out.println(agencija.izpisPoTipu(3, true));
									break;
								case '4':
									System.out.println(agencija.izpisPoTipu(4, true));
									break;
								case 'e':
									System.out.println(agencija.izpisRezervacij(true));
									break;
								case 'f':
									agencija.novaRezervacija();
									System.out.println();
									break;
								case 'g':
									System.out.println(agencija.izpisPoId(true));
									break;
								case 'h':
									Pocitnice p = Pocitnice.ustvariPocitnice();
									agencija.dodajPocitnice(p);
									break;
								case 'd':
									agencija.izbrisId();
									break;
								case 'k':
									agencija.registracijaUporabnika(true);
									break;
								case 'i':
									System.out.println("Vnesite ime datoteke: ");
									imeDat = br.readLine().trim();
									agencija.shraniVDatoteko(imeDat);
									System.out.println();
									break;
								case 'u':
									loop: while(true) {
										System.out.println("Pritisni (1) za urejanje pocitnic glede na datum.");
										System.out.println("Pritisni (2) za urejanje glede na cenovni okvir.");
										System.out.println("Pritisni (3) za prekinitev.");
										c = br.readLine().trim().charAt(0);
										
										switch(c) {
											case '1':
												agencija.Spremeni(1);
												break;
											case '2':
												agencija.Spremeni(2);
												break;
											case '3':
												break loop;
											default:
												System.out.println("Pritisnili ste napacno izbiro!");
												System.out.println();
										}
									}
									break;
								case 'x':
									agencija.izbrisUporabnika();
									break;
								case 'z':
									break adminloop;
								case 'q':
									return;
								default:
									System.out.println("Pritisnili ste napacno izbiro!");
							}
						}
					}
					else if (!check){
						System.out.println("Prijava neuspesna!\r\n");
						break;
					}
				default:
					System.out.println("Pritisnili ste napacno izbiro!");
					System.out.println();
			}
		}

	}		
	
}