import java.io.*;
import java.util.*;

public class Kampiranje extends Pocitnice {
	
	private boolean najemSotora;
	private boolean hisniLjubljencki;
	
	public Kampiranje() {
		super();
		this.najemSotora=false;
		this.hisniLjubljencki=false;
	}
	
	public Kampiranje(int id, int maxSteviloOseb, 
	String drzava, int cena, ArrayList<Termin> termin,ArrayList<Rezervacija> rezervacija,
	boolean najemSotora, boolean hisniLjubljencki) {
		super(id, maxSteviloOseb, drzava, cena, termin, rezervacija);
		this.najemSotora=najemSotora;
		this.hisniLjubljencki=hisniLjubljencki;
	}
	
	public void setNajem(boolean najem) {
		najemSotora = najem;
	}
	public void setPet(boolean pet) {
		hisniLjubljencki = pet;
	}
	public boolean getNajem() {
		return this.najemSotora;
	}
	public boolean getPet() {
		return this.hisniLjubljencki;
	}
	
	@Override
    public String toString() {
		String podatki = "";
		
		podatki += "*****   Podatki o kampiranju   *****\r\n";
		podatki += "--------------------------------\r\n";
		podatki += super.toStringPocitnice();
		podatki += "Najem sotora: " + this.najemSotora + "\r\n";
		podatki += "Hisni ljubljencki: " + this.hisniLjubljencki + "\r\n";
		podatki += "\r\n";
		
		for(Termin t : this.getSeznamTerminov()) {
			podatki += t.toString();
			podatki += "\r\n";
		}
		return podatki;
	}
}