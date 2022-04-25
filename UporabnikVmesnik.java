import java.io.*;
import java.util.*;


public class UporabnikVmesnik {
	
	public static main void(String args[]) throws Exception {
		
		TuristicnaAgencija agencija = new TuristicnaAgencija();
		
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		
		char izbira;
		
		while(true) {
			
			System.out.println("Pritisni (r) za registracijo novega uporabnika.");
			System.out.println("Pritisni (s) za prijavo v sistem");
			
			System.out.println("Pritisni (a) za izbor pocitnic glede na datum.");
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
				case 'r':
					Uporabnik u = Uporabnik.ustvariUporabnika();
					agencija.dodajUporabnika(u);
					break;
				case 'k':
					Knjiga k = Knjiga.ustvariKnjigo();
					knjiznica.dodajGradivo(k);
					break;
				case 'r':
					Revija r = Revija.ustvariRevijo();
					knjiznica.dodajGradivo(r);
					break;
				case 'i':
					System.out.println(knjiznica.toString());
					break;
				case 'l':
					System.out.println(knjiznica.izpisPoLetu());
					break;
				case 'p':
					System.out.println("Vnesite ime datoteke: ");
					imeDat = br.readLine().trim();
					knjiznica.dodajIzDatoteke(imeDat);
					System.out.println();
					break;
				case 's':
					System.out.println("Vnesite ime datoteke: ");
					imeDat = br.readLine().trim();
					knjiznica.shraniVDatoteko(imeDat);
					System.out.println();
					break;
				case 'q':
					return;
				default:
					System.out.println("Pritisnili ste napacno izbiro!");
					System.out.println();
			}
		}

	}		
	
}