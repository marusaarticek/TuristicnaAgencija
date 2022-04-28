import java.io.*;
import java.util.*;
import java.time.LocalDateTime;
import java.time.LocalDate;
import java.text.ParseException;
import java.time.format.DateTimeFormatter;

public class Krizarjenje extends Pocitnice {
	
	private String tip;
	private String krizarke;
	
	public Krizarjenje () {
		super();
		this.tip="";
		this.krizarke="";
	}
	
	public Krizarjenje (int id, int maxSteviloOseb, 
	String drzava, int cena, ArrayList<Termin> termin,
	String tip, String krizarke) {
		super(id, maxSteviloOseb, drzava, cena, termin);
		this.tip=tip;
		this.krizarke=krizarke;
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
	
	public static Krizarjenje ustvariKrizarjenje() throws Exception {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		
		System.out.println("***   Vnos novih pocitnic - krizarjenje  ***");
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
		
		int n = 0;
		while(true) {
			try {
				System.out.println("Vnesi stevilo moznih terminov: ");
				n = Integer.parseInt(br.readLine().trim());
				System.out.println();
				break;
			}
			catch (Exception e) {
				System.out.println("Napacen format vnosa!");
				System.out.println();
			}
		}
		
		ArrayList<Termin> seznamTerminov = new ArrayList<Termin>();
		for(int i=0; i < n; i++) {
			
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("uuuu-MM-dd HH:mm");
			String preberiOdhod = "";
			String preberiPrihod = "";
			
			System.out.println("Vnesi termin in cas odhoda (npr: 2022-05-31 10:00):  ");
			preberiOdhod = br.readLine().trim();
			LocalDateTime odhod = LocalDateTime.parse(preberiOdhod, dtf);
			
			System.out.println();
			System.out.println("Vnesi termin in cas prihoda (npr: 2022-06-05 10:00):  ");
			preberiPrihod = br.readLine().trim();
			LocalDateTime prihod = LocalDateTime.parse(preberiPrihod, dtf);
			
			Termin t = new Termin(odhod, prihod, i);
			seznamTerminov.add(t);
		}
	
		System.out.println("Vnesi tip krizarjenja(mini, eksoticno, cezoceansko,..): ");
		String tip = br.readLine().trim();
		System.out.println();
		System.out.println("Vnesi krizarko(Costa, Royal, Holland,..) : ");
		String krizarke = br.readLine().trim();
		System.out.println();
		
		Krizarjenje k = new Krizarjenje(id, maxSteviloOseb, drzava, cena, seznamTerminov, tip, krizarke);
		return k;
	}
}