import java.io.*;
import java.util.*;

public class Smucanje extends Pocitnice {
	
	private boolean najemHotela;
	private boolean hisniLjubljencki;
	
	public Smucanje() {
		super();
		this.najemHotela=false;
		this.hisniLjubljencki=false;
	}
	
	public Smucanje(int id, int maxSteviloOseb, 
	String drzava, int cena, ArrayList<Termin> termin,ArrayList<Rezervacija> rezervacija,
	boolean najemHotela, boolean hisniLjubljencki) {
		super(id, maxSteviloOseb, drzava, cena, termin, rezervacija);
		this.najemHotela=najemHotela;
		this.hisniLjubljencki=hisniLjubljencki;
	}
	
	public void setNajem(boolean najem) {
		najemHotela = najem;
	}
	public void setPet(boolean pet) {
		hisniLjubljencki = pet;
	}
	public boolean getNajem() {
		return this.najemHotela;
	}
	public boolean getPet() {
		return this.hisniLjubljencki;
	}
	
	@Override
    public String toString() {
		String podatki = "";
		
		podatki += "*****   Podatki o smucanju   *****\r\n";
		podatki += "--------------------------------\r\n";
		podatki += super.toStringPocitnice();
		podatki += "Najem hotela: " + this.najemHotela + "\r\n";
		podatki += "Hisni ljubljencki: " + this.hisniLjubljencki + "\r\n";
		podatki += "\r\n";
		
		for(Termin t : this.getSeznamTerminov()) {
			podatki += t.toString();
			podatki += "\r\n";
		}
		return podatki;
	}
}