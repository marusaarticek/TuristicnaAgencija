import java.io.*;
import java.util.*;

public class Krizarjenje extends Pocitnice {
	
	private String tip;
	private String krizarke;
	
	public Krizarjenje () {
		super();
		this.tip="";
		this.krizarke="";
	}
	
	public Krizarjenje (int id, int maxSteviloOseb, 
	String drzava, int cena, ArrayList<Termin> termin,ArrayList<Rezervacija> rezervacija,
	String tip, String krizarke) {
		super(id, maxSteviloOseb, drzava, cena, termin, rezervacija);
		this.tip=tip;
		this.krizarke=krizarke;
	}
	
	public void setTip(String tip) {
		this.tip = tip;
	}
	public void setKrizarke(String krizarke) {
		this.krizarke=krizarke;
	}
	public String getTip() {
		return this.tip;
	}
	public String getKrizarke() {
		return this.krizarke;
	}
	
	@Override
    public String toString() {
		String podatki = "";
		
		podatki += "*****   Podatki o krizarjenju   *****\r\n";
		podatki += "--------------------------------\r\n";
		podatki += super.toStringPocitnice();
		podatki += "Tip potovanja: " + this.tip + "\r\n";
		podatki += "Krizarka: " + this.krizarke + "\r\n";
		podatki += "\r\n";
		
		for(Termin t : this.getSeznamTerminov()) {
			podatki += t.toString();
			podatki += "\r\n";
		}
		return podatki;
	}
}