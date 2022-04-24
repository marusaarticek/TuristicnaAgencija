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
		this. administrator = administrator;	
	}		
	
	
}