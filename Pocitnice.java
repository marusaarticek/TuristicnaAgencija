import java.io.*;
import java.util.*;

public class Pocitnice {
	
	private int id;
	private int maxSteviloOseb;
	private String drzava;
	private int cena;
	private ArrayList<Termin> seznamTerminov;
	private ArrayList<Rezervacija> seznamRezervacij;
	
	public void setDrzava(String drzava) {
		this.drzava = drzava;
	}
	public void setCena(int cena) {
		this.cena=cena;
	}
	public void setTermin(ArrayList<Termin> termin) {
		seznamTerminov=termin;
	}
	public void setRezervacija(ArrayList<Rezervacija> rezervacija) {
		seznamRezervacij=rezervacija;
	}
	
	public int getmaxSteviloOseb() {
		return this.maxSteviloOseb;
	}
	
	public int getCena() {
		return this.cena;
	}
	
	public String getDrzava() {
		return this.drzava;
	}
	
	public ArrayList<Termin> getSeznamTerminov() {
		return this.seznamTerminov;
	}
	
	public ArrayList<Rezervacija> getSeznamRezervacij() {
		return this.seznamRezervacij;
	}
	
	public void dodajTermin(Termin t) {
		this.seznamTerminov.add(t);
	}
	
	public Pocitnice() {
		id = 000;
		maxSteviloOseb = 0;
		drzava = "";
		cena = 0;
		seznamTerminov = new ArrayList<Termin>();
		seznamRezervacij = new ArrayList<Rezervacija>();
	}
	
	public Pocitnice(int id, int maxSteviloOseb, String drzava, int cena) {
		this.id = id;
		this.maxSteviloOseb = maxSteviloOseb;
		this.drzava = drzava;
		this.cena = cena;
		seznamTerminov =  new ArrayList<Termin>();
		seznamRezervacij = new ArrayList<Rezervacija>();
	}
	
	public Pocitnice(int id, int maxSteviloOseb, String drzava, int cena,ArrayList<Termin> termin ) {
		this.id = id;
		this.maxSteviloOseb = maxSteviloOseb;
		this.drzava = drzava;
		this.cena = cena;
		seznamTerminov =  termin;
		seznamRezervacij = new ArrayList<Rezervacija>();
	}
	
	public Pocitnice(int maxSteviloOseb, String drzava, int cena) {
		id = 11;
		this.maxSteviloOseb = maxSteviloOseb;
		this.drzava = drzava;
		this.cena = cena;
		seznamTerminov =  new ArrayList<Termin>();
		seznamRezervacij = new ArrayList<Rezervacija>();
	}
	
	public Pocitnice(int id, int maxSteviloOseb, String drzava, int cena,
	ArrayList<Termin> termin,ArrayList<Rezervacija> rezervacija) {
		this.id = 000;
		this.maxSteviloOseb = 0;
		this.drzava = "";
		this.cena = 0;
		this.seznamTerminov = termin;
		this.seznamRezervacij = rezervacija;
	}
	
	//-------------------------------------------
	public String shraniKotNiz()
	{
		String zapis = "*P\r\n";			
		zapis += this.drzava + "\r\n";		
		zapis += this.cena + "\r\n";		// Zapišemo naslov
		
		for(Termin t : this.seznamTerminov) // Zapišemo še vsak status posebej
		{
			zapis += t.shraniKotNiz();
		}
		for(Rezervacija r : this.seznamRezervacij) // Zapišemo še vsak status posebej
		{
			zapis += r.shraniKotNiz();
		}
		zapis += "##\r\n";					// Oznacimo konec branja
		return zapis;
	}
	
	public String toStringPocitnice() {
		String podatki = "";
		
		podatki += "Drzava: " + this.drzava + "\r\n";
		podatki += "Cena: " + this.cena + "\r\n";
		return podatki;
	}
	
	@Override
	public String toString() {
		String podatki = "";
		
		podatki += "*****   Mozne pocitnice   *****\r\n";
		podatki += "---------------------------------\r\n";
		podatki += "Drzava: " + this.drzava + "\r\n";
		podatki += "Cenovni okvir: " + this.cena + "\r\n";
		
		for(Termin t : this.seznamTerminov) {
			podatki += t.toString();
			podatki += "\r\n";
		}
		
		return podatki;
	}
	
	public static Pocitnice preberiIzNiza(ArrayList<String> zapis)
	{
		Pocitnice  p = new Pocitnice (); 
		try
		{
			p.setDrzava(zapis.get(0));
			p.setCena(Integer.parseInt(zapis.get(1)));

			ArrayList<String> terminPodatki;
			//ArrayList<String> rezervacijaPodatki;
			for(int i=2; i < zapis.size(); i++)
			{
				if(zapis.get(i).trim().equals("*T"))	// Ce vrstica vsebuje *S, imamo zapis o statusu
				{
					terminPodatki = new ArrayList<String>();	// Pripravimo nov seznam, v katerega bomo dodajali podatke o trenutnem statusu
					i++;
					while(!zapis.get(i).trim().equals("#"))	// Dokler se zapis o statusu ne konca (dokler se ne pojavi #), dodajamo podatke v seznam
					{
						terminPodatki.add(zapis.get(i));
						i++;
					}
					Termin termin = Termin.preberiIzNiza(terminPodatki);

					p.dodajTermin(termin);
				}
			}
			return p;
		}
		catch(Exception ex)
		{
			System.out.println("Prišlo je do napake v zapisu!");
			System.out.println();
			throw ex;
		}
	}
	
	
	public String zasedenost() {
		int stevilo = 0;
		String podatki = "";
		for(Rezervacija r : this.seznamRezervacij) {
			stevilo += r.getStOdraslih() + r.getStOtrok();
		}
		if(stevilo == 0) {
			podatki += "Zagotovljeno.";
		}
		else if(stevilo <= this.maxSteviloOseb/2) {
			podatki += "Skoraj zagotovljeno.";
		}
		else {
			podatki = "Ni mozno.";	
		}
		return podatki;
	}
	
	public void dodajRezervacijo(Rezervacija r) {
		this.seznamRezervacij.add(r);
	}
	
	
	public static Pocitnice ustvariPocitnice() throws Exception {
		
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		
		System.out.println("***   Vnos novih pocitnic   ***");
		System.out.println();
		System.out.println("Vnesi drzavo: ");
		String drzava = br.readLine().trim();
		System.out.println();
		
		
		int id = 0;
		while(true) {
			try {
				System.out.println("Vnesi id pocitnic: ");
				id = Integer.parseInt(br.readLine().trim());
				System.out.println();
				break;
			} 
			catch (Exception e) {
				System.out.println("Napacen format vnosa!");
				System.out.println();
			}
		}
		
		int stevilo;
		int maxSteviloOseb = 0;
		while(true) {
			try {
				System.out.println("Vnesi max stevilo oseb: ");
				stevilo = Integer.parseInt(br.readLine().trim());
				System.out.println();
				break;
			}
			catch (Exception e) {
				System.out.println("Napacen format vnosa!");
				System.out.println();
			}
		}
		
		int cena = 0;
		while(true) {
			try {
				System.out.println("Vnesi ceno Pocitnic: ");
				cena = Integer.parseInt(br.readLine().trim());
				System.out.println();
				break;
			}
			catch (Exception e) {
				System.out.println("Napacen format vnosa!");
				System.out.println();
			}
		}
		
		Pocitnice p = new Pocitnice(id, maxSteviloOseb, drzava, cena);
		return p;	
	}
	
	public static void main(String[] args) {
		Pocitnice p = new Pocitnice();
		Pocitnice p2 = new Pocitnice(3, "Slovenija", 100);
		
		System.out.println(p.toString());
		System.out.println(p2.toString());
	}
}