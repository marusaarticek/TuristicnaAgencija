import java.io.*;
import java.util.*;


public class Uporabnik {
	
	private String ime;
	Private String priimek;
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
	
	
}