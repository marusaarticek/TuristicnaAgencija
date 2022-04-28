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
	
	public String shraniKotNiz()
	{
		String zapis = "*M\r\n";			
		zapis += this.getDrzava() + "\r\n";		
		zapis += this.getCena() + "\r\n";
		zapis += this.tip + "\r\n";		
		zapis += this.vodenoPotovanje  + "\r\n";
		
		for(Termin t : this.getSeznamTerminov()) // Zapišemo še vsak status posebej
		{
			zapis += t.shraniKotNiz();
		}
		for(Rezervacija r : this.getSeznamRezervacij()) // Zapišemo še vsak status posebej
		{
			zapis += r.shraniKotNiz();
		}
		zapis += "##\r\n";					// Oznacimo konec branja
		return zapis;
	}
	
	
	public static Potovanje preberiIzNiza(ArrayList<String> zapis)
	{
		Potovanje pot = new Potovanje(); 
		try
		{
			pot.setDrzava(zapis.get(0));
			pot.setCena(Integer.parseInt(zapis.get(1)));
			pot.setTip(zapis.get(2));
			if(zapis.get(3).equals("true")) {
				pot.setVodeno(true);
			} else {
				pot.setVodeno(false);
			}
			
			ArrayList<String> terminPodatki;
			//ArrayList<String> rezervacijaPodatki;
			for(int i=4; i < zapis.size(); i++)
			{
				if(zapis.get(i).trim().equals("*T"))	// Ce vrstica vsebuje *S, imamo zapis o statusu
				{
					terminPodatki = new ArrayList<String>();	// Pripravimo nov seznam, v katerega bomo dodajali podatke o trenutnem statusu
					i++;
					while(!zapis.get(i).trim().equals("#"))	// Dokler se zapis o statusu ne konca (dokler se ne pojavi #), dodajamo podatke v seznam
					{
						terminPodatki.add(zapis.get(i));
						i++;
					}
					Termin termin = Termin.preberiIzNiza(terminPodatki);

					pot.dodajTermin(termin);
				}
			}
			return pot;
		}
		catch(Exception ex)
		{
			System.out.println("Prišlo je do napake v zapisu!");
			System.out.println();
			throw ex;
		}
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