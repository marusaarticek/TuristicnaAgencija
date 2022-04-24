import java.io.*;
import java.util.*;

public class Pocitinice {
	
	private int id;
	private int maxSteviloOseb;
	private String drzava;
	private int cena;
	private ArrayList<Termin> seznamTerminov;
	private ArrayList<Rezervacija> seznamRezervacij;
	
	public int getmaxSteviloOseb() {
		return this.maxSteviloOseb;
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
		this.id = 000;
		this.maxSteviloOseb = 0;
		this.drzava = "";
		this.cena = 0;
		this.seznamTerminov = new ArrayList<Termin>();
		this.seznamRezervacij = new ArrayList<Rezervacija>();
	}
	
	//-------------------------------------------
	
	@Override
	public String toString() {
		String podatki = "";
		
		podatki += "*****   Mozne pocitnice   *****\r\n";
		podatki += "---------------------------------\r\n";
		podatki += "Avtor: " + this.avtor + "\r\n";
		podatki += "Naslov: " + this.naslov + "\r\n";
		podatki += "Leto izdaje: " + this.letoIzdaje + "\r\n";
		podatki += "Stevilo izvodov: " + this.steviloIzvodov + "\r\n";
		podatki += "Maksimalno izvodov: " + this.maxIzvodov + "\r\n";
		podatki += "\r\n";
		
		for(Status s : this.seznamStatusov) {
			podatki += s.toString();
			podatki += "\r\n";
		}
		
		return podatki;
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
		
		Pocitnice p = new Pocitinice(id, maxSteviloOseb, drzava, cena);
		return p;	
	}
	
	
	
	
	
}