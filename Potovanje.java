import java.io.*;
import java.util.*;

public class Potovanje extends Pocitnice {
	
	private String tip;
	private boolean vodenoPotovanje;
	
	public Potovanje () {
		super();
		this.tip="";
		this.vodenoPotovanje=false;
	}
	
	public Potovanje (int id, int maxSteviloOseb, 
	String drzava, int cena, ArrayList<Termin> termin,ArrayList<Rezervacija> rezervacija,
	String tip, boolean vodenoPotovanje) {
		super(id, maxSteviloOseb, drzava, cena, termin, rezervacija);
		this.tip=tip;
		this.vodenoPotovanje=vodenoPotovanje;
	}
	
	public void setTip(String tip) {
		this.tip = tip;
	}
	public void setVodeno(boolean vodeno) {
		vodenoPotovanje = vodeno;
	}
	public String getTip() {
		return this.tip;
	}
	public boolean getVodeno() {
		return this.vodenoPotovanje;
	}
	
	@Override
    public String toString() {
		String podatki = "";
		
		podatki += "*****   Podatki o potovanju   *****\r\n";
		podatki += "--------------------------------\r\n";
		podatki += super.toStringPocitnice();
		podatki += "Tip potovanja: " + this.tip + "\r\n";
		podatki += "Vodeno potovanje: " + this.vodenoPotovanje + "\r\n";
		podatki += "\r\n";
		
		for(Termin t : this.getSeznamTerminov()) {
			podatki += t.toString();
			podatki += "\r\n";
		}
		return podatki;
	}
}