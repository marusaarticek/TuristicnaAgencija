import java.io.*;
import java.util.*;
import java.time.LocalDateTime;
import java.time.LocalDate;
import java.text.ParseException;
import java.time.format.DateTimeFormatter;

public class Potovanje extends Pocitnice {
	
	private String tip;
	private boolean vodenoPotovanje;
	
	public Potovanje () {
		super();
		this.tip="";
		this.vodenoPotovanje=false;
	}
	
	public Potovanje (int id, int maxSteviloOseb, 
	String drzava, int cena, ArrayList<Termin> termin,
	String tip, boolean vodenoPotovanje) {
		super(id, maxSteviloOseb, drzava, cena, termin);
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
	
	public static Potovanje ustvariPotovanje() throws Exception {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		
		System.out.println("***   Vnos novih pocitnic - potovanje  ***");
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
	
		System.out.println("Vnesi tip potovanja(solo, eksoticno, sluzbeno,..): ");
		String tip = br.readLine().trim();
		System.out.println();
		
		boolean vodenoPotovanje = true;
		while (true) {
			System.out.println("Vnesi ali zelite voden ogled (DA/NE): ");
			String niz = br.readLine().trim();
			System.out.println();
			
			if(niz.equals("DA")) {
				break;
			} else if (niz.equals("NE")) {
				vodenoPotovanje = false;
				break;
			} else {
				System.out.println("Napacen format vnosa!");
				System.out.println();
			}
		}
		
		Potovanje p = new Potovanje(id, maxSteviloOseb, drzava, cena, seznamTerminov, tip, vodenoPotovanje);
		return p;
	}	
}