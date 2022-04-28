import java.io.*;
import java.util.*;
import java.time.LocalDateTime;
import java.time.LocalDate;
import java.text.ParseException;
import java.time.format.DateTimeFormatter;

public class Kampiranje extends Pocitnice {
	
	private boolean najemSotora;
	private boolean hisniLjubljencki;
	
	public Kampiranje() {
		super();
		this.najemSotora=false;
		this.hisniLjubljencki=false;
	}
	
	public Kampiranje(int id, int maxSteviloOseb, 
	String drzava, int cena, ArrayList<Termin> termin,
	boolean najemSotora, boolean hisniLjubljencki) {
		super(id, maxSteviloOseb, drzava, cena, termin);
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
	
	public static Kampiranje ustvariKampiranje() throws Exception {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		
		System.out.println("***   Vnos novih pocitnic - kampiranje  ***");
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
	
		boolean najemSotora = true;
		while (true) {
			System.out.println("Vnesi ali zelite najeti sotor (DA/NE): ");
			String niz = br.readLine().trim();
			System.out.println();
			
			if(niz.equals("DA")) {
				break;
			} else if (niz.equals("NE")) {
				najemSotora = false;
				break;
			} else {
				System.out.println("Napacen format vnosa!");
				System.out.println();
			}
		}
		boolean hisniLjubljencki = true;
		while (true) {
			System.out.println("Vnesi ali boste imeli s sabo hisne ljubljencke (DA/NE): ");
			String niz = br.readLine().trim();
			System.out.println();
			
			if(niz.equals("DA")) {
				break;
			} else if (niz.equals("NE")) {
				hisniLjubljencki = false;
				break;
			} else {
				System.out.println("Napacen format vnosa!");
				System.out.println();
			}
		}
		
		Kampiranje k = new Kampiranje(id, maxSteviloOseb, drzava, cena, seznamTerminov, najemSotora, hisniLjubljencki);
		return k;
	}	
	
}