import java.io.*;
import java.util.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Rezervacija {
	
	private String ime;
	private String priimek;
	private int stOdraslih;
	private int stOtrok;
	
	public Rezervacija() {
		ime = "";
		priimek = "";
		stOdraslih = 0;
		stOtrok = 0;	
	}
	
	public Rezervacija(String ime, String priimek, int stOdraslih, int stOtrok) {
		this.ime = ime;
		this.priimek = priimek;
		this.stOdraslih = stOdraslih;
		this.stOtrok = stOtrok;	
	}
	
	public int getStOtrok() {
		return this.stOdraslih;
	}
	
	public int getStOdraslih() {
		return this.stOdraslih;
	}
	
	public String shraniKotNiz() {
		String zapis = "*R\r\n";			// Zapišemo kodo "S", ki oznacuje status
		zapis += this.ime + "\r\n";
		zapis += this.priimek + "\r\n";
		zapis += this.stOdraslih + "\r\n";
		zapis += this.stOtrok+ "\r\n";
		zapis += "#\r\n";
		return zapis;
	}
	
	
    public String toString(boolean admin) {
		String podatki = "";
		
		podatki += "***   Podatki o rezervaciji  ***\r\n";
		podatki += "Ime: " + this.ime + "\r\n";
		podatki += "Priimek: " + this.priimek + "\r\n";
		int st = this.stOdraslih + this.stOtrok;
		if(admin) {
			podatki += "Stevilo oseb:  " + st + "\r\n";
		}
		return podatki;
	}
	
	/*
	public static Rezervacija ustvariRezervacijo() throws Exception {
		
		
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		
		System.out.println("***   Vnos nove Rezervacije   ***");
		System.out.println();
		System.out.println("Vnesi ime: ");
		String avtor = br.readLine().trim();
		System.out.println();
		System.out.println("Vnesi priimek: ");
		String naslov = br.readLine().trim();
		System.out.println();
		
		int stOdraslih = 0;
		while(true) {
			try {
				System.out.println("Vnesi stevilo odraslih: ");
				stOdraslih = Integer.parseInt(br.readLine().trim());
				System.out.println();
				break;
			} 
			catch (Exception e) {
				System.out.println("Napacen format vnosa!");
				System.out.println();
			}
		}
		
		int stOtrok = 0;
		while(true) {
			try {
				System.out.println("Vnesi stevilo otrok: ");
				stOtrok = Integer.parseInt(br.readLine().trim());
				System.out.println();
				break;
			}
			catch (Exception e) {
				System.out.println("Napacen format vnosa!");
				System.out.println();
			}
		}
		
		System.out.println("Vnesi izbrane pocitnice (Potovanje, Krizarjenje, Kampiranje, Smucanje)");
		String izbor = br.readLine().trim();
		System.out.println();
		
		
		
		
		
		int stOseb = stOdraslih + stOtrok;
		
		
		
		
		return stOseb;
		
	}
	*/
}