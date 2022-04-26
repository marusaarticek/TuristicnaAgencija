import java.io.*;
import java.util.*;


public class Uporabnik {
	
	private String ime;
	private String priimek;
	private String geslo;
	private boolean administrator;
	
	public Uporabnik() {
		ime = "";
		priimek = "";
		geslo = "";
		administrator = false;
	}
	
	public Uporabnik(String ime, String priimek, String geslo, boolean administrator) {
	
		this.ime = ime;
		this.priimek=priimek;
		this.geslo = geslo;
		this.administrator = administrator;	
	}	
	
	public String getIme() {
		return this.ime;
	}
	public String getPriimek() {
		return this.priimek;
	}

	public static Uporabnik ustvariUporabnika() throws Exception {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		
		System.out.println("***   Registracija novega uporabnika   ***");
		System.out.println();
		System.out.println("Vnesi ime: ");
		String ime = br.readLine().trim();
		System.out.println();
		System.out.println("Vnesi priimek: ");
		String priimek = br.readLine().trim();
		System.out.println();
		System.out.println("Vnesi geslo: ");
		String geslo = br.readLine().trim();
		System.out.println();
		
		Uporabnik u = new Uporabnik(ime, priimek, geslo, false);
		return u;
	}
	
	public String shraniKotNiz()
	{
		String zapis = "*U\r\n";			// Zapišemo kodo "G", ki oznacuje gradivo
		zapis += this.ime + "\r\n";		// Zapišemo avtorja
		zapis += this.priimek + "\r\n";		// Zapišemo naslov
		zapis += "##\r\n";					// Oznacimo konec branja
		return zapis;
	}
	
	/*
	public String shraniKotNiz()
	{
		String zapis = "*U\r\n";			// Zapišemo kodo "G", ki oznacuje gradivo
		zapis += u.getIme() + "\r\n";		// Zapišemo avtorja
		zapis += u.getPriimek() + "\r\n";		// Zapišemo naslov
		zapis += "##\r\n";					// Oznacimo konec branja
		return zapis;
	}
	*/
}