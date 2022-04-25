import java.io.*;
import java.util.*;
import java.util.Date;


public class TuristicnaAgencija {
	
	private ArrayList<Pocitnice> seznamPocitnic;
	private ArrayList<Uporabnik> seznamUporabnikov;
	private ArrayList<Rezervacija> seznamRezervacij;
	
	
	//konstruktorji
	
	public TuristicnaAgencija() {
		this.seznamPocitnic = new ArrayList<Pocitnice>();
		this.seznamUporabnikov = new ArrayList<Uporabnik>();
		this.seznamRezervacij = new ArrayList<Rezervacija>();
	}
	
	public TuristicnaAgencija(ArrayList<Pocitnice> seznamPocitnic,
		
		ArrayList<Uporabnik> seznamUporabnikov, ArrayList<Rezervacija> seznamRezervacij) {
		this.seznamPocitnic = seznamP;
		this.seznamUporabnikov = seznamU;
		this.seznamRezervacij = seznamRezervacij;
	}
	
	//---------------------------------------
	
	// metoda get
	public ArrayList<Pocitnice> getSeznamPocitnic() {
		return this.seznamPocitnic;
	}
	
	public ArrayList<Uporabnik> getSeznamUporabnikov() {
		return this.seznamUporabnikov;
	}
	
	public ArrayList<Rezervacija> getSeznamRezervacij() {
		return this.seznamRezervacij;
	}

	// metoda set
	public void setSeznamPocitnic(ArrayList<Pocitnice> seznamPocitnic) {
		this.seznamPocitnic = seznamPocitnic;
	}
	
	public void setSeznamUporabnikov(ArrayList<Uporabnik> seznamUporabnikov) {
		this.seznamUporabnikov = seznamUporabnikov;
	}
	
	public void setSeznamRezervacij(ArrayList<Rezervacija> seznamRezervacij) {
		this.seznamUporabnikov = seznamRezervacij;
	}
	
	//********************************************
	
	public void dodajRezervacijo(Rezervacija r) {
		boolean = false;
		
		for(Pocitnice pocitnice : this.seznamPocitnic) {
			if( pocitnice.getmaxSteviloOseb() 
		}
		
	}
	
	public String izpisPoTerminu() throws Exception {
		
		
		
		int danOdhoda = 0;
		while(true) {
			try {
				System.out.println("Vnesi dan odhoda(npr. 3): ");
				dan = Integer.parseInt(br.readLine().trim());
				System.out.println();
				break;
			}
			catch (Exception e) {
				System.out.println("Napacen format vnosa!");
				System.out.println();
			}
		}
		
		int mesecOdhoda = 0;
		while(true) {
			try {
				System.out.println("Vnesi mesec odhoda(npr. 10): ");
				mesecOdhoda = Integer.parseInt(br.readLine().trim());
				System.out.println();
				break;
			}
			catch (Exception e) {
				System.out.println("Napacen format vnosa!");
				System.out.println();
			}
		}
		
		int danPrihoda = 0;
		while(true) {
			try {
				System.out.println("Vnesi dan prihoda(npr. 5): ");
				danPrihoda = Integer.parseInt(br.readLine().trim());
				System.out.println();
				break;
			}
			catch (Exception e) {
				System.out.println("Napacen format vnosa!");
				System.out.println();
			}
		}
		
		int mesecPrihoda = 0;
		while(true) {
			try {
				System.out.println("Vnesi mesec odhoda(npr. 10): ");
				danOdhoda = Integer.parseInt(br.readLine().trim());
				System.out.println();
				break;
			}
			catch (Exception e) {
				System.out.println("Napacen format vnosa!");
				System.out.println();
			}
		}
		
		
		String podatki = "";
		
		System.out.println("Mozne pocitnice v okvirju termina:\r\n");
		
		for(Pocitnice pocitnice : this.seznamPocitnic) {
			for(Termin termin : pocitnice.seznamTerminov) {
				if(termin.getmesecOdhoda() == mesecOdhoda && termin.getmesecPrihoda() == mesecPrihoda) {
					if(termin.getdanOdhoda() >= danOdhoda && termin.getdanPrihoda() <= danPrihoda ) {
						podatki += pocitnice.toString();
						podatki += "\r\n";
					}
				}
				else if(termin.getmesecOdhoda() == mesecOdhoda && termin.getmese) {
					
				}
			}	
		}
		
		if(podatki.equals("")) {
			return "V izbranem letu ni bilo izdanih gradiv!\r\n";
		}
		
		return podatki;
	}
	
	
	
	
	
	
	
	@Override
	public String toString() {
		String podatki = "";
		
		podatki += "\r\n";
		podatki += "-----------------------------------\r\n";
		podatki += "**********   TURISTICNA AGENCIJA   **********\r\n";
		podatki += "-----------------------------------\r\n";
		podatki += "\r\n";
		
		podatki += "\r\n";
		podatki += "**********   POCITNICE   **********\r\n";
		podatki += "\r\n";
		
		for(Pocitnice p : this.seznamPocitnic) {
			podatki += g.toString();
			podatki += "\r\n";
		}
		
		podatki += "\r\n";
		podatki += "**********   UPORABNIKI   **********\r\n";
		podatki += "\r\n";
		
		for(Pocitnice p : this.seznamPocitnic) {
			podatki += g.toString();
			podatki += "\r\n";
		}
		
		return podatki;
	}
	
	public String izpisDrzava() throws Exception {

		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		
		System.out.println("***   Vnesi ime drzave:   ***");
		System.out.println();
		System.out.println("Drzava: ");
		String drzava = br.readLine().trim();
		
		String podatki = "";
		
		for(Pocitnice p : this.setSeznamPocitnic) {
			if(p.getDrzava().equals(drzava)) {
				podatki += p.toString();
				podatki += "\r\n";
			}
		}
		
		if(podatki.equals("")) {
			return "Za izbrano drzavo ni moznih pocitnic!\r\n";
		}
		return podatki;
	}
	
	public String izpisPoCeni() throws Exception {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		
		int cena = 0;
		while(true) {
			try {
				System.out.println("Vnesi cenovni okvir: ");
				System.out.println();
				System.out.println("Cena: ");
				cena = Integer.parseInt(br.readLine().trim());
				System.out.println();
				break;
			}
			catch (Exception e) {
				System.out.println("Napacen format vnosa!");
				System.out.println();
			}
		}
		String podatki = "";
		
		for(Pocitnice p : this.seznamPocitnic) {
			if(p.getCena() == cena) {
				podatki += p.toString();
				podatki += "\r\n";
			}
		}
		
		if(podatki.equals("")) {
			return "V cenovnem okvirju ni moznih pocitnic!\r\n";
		}
		
		return podatki;
	}
	
	
	public String izpisPoTipu(int tip) {
		String podatki = "";
		if(tip == 1) {
			for(int i = 0; i < this.seznamPocitnic.size(); i++) {
				if(this.seznamPocitnic.get(i) instanceof Potovanje) {
					podatki += this.seznamPocitnic.get(i).toString();
					podatki += "\r\n";
				}
			}
		} 
		else if(tip == 2) {
			for(int i = 0; i < this.seznamPocitnic.size(); i++) {
				if(this.seznamPocitnic.get(i) instanceof Kampiranje) {
					podatki += this.seznamPocitnic.get(i).toString();
					podatki += "\r\n";
				}
			}
		}
		else if(tip == 3) {
			for(int i = 0; i < this.seznamPocitnic.size(); i++) {
				if(this.seznamPocitnic.get(i) instanceof Krizarjenje) {
					podatki += this.seznamPocitnic.get(i).toString();
					podatki += "\r\n";
				}
			}
		}
		else if(tip == 4) {
			for(int i = 0; i < this.seznamPocitnic.size(); i++) {
				if(this.seznamPocitnic.get(i) instanceof Smučanje) {
					podatki += this.seznamPocitnic.get(i).toString();
					podatki += "\r\n";
				}
			}
		}
		return podatki;
	}
	
	/*
	// Object je nadrazred vseh razredov
	public static void main(String[] args) {
		Knjiznica k = new Knjiznica();
		Gradivo g = new Gradivo("A", "N", 2022, 2, 10);
		Knjiga knjiga = new Knjiga("Ar", "Na", 2022, 2, 5, 20, "P");
		
		k.dodajGradivo(g);
		k.dodajGradivo(knjiga);
		
		System.out.println(k.toString());
	}
	*/
	
	// Metoda shrani podatke o 
	public void shraniVDatoteko(String imeDatoteke) throws IOException
	{
		//FileWriter fw = new FileWriter(imeDatoteke, true); // Drugi parameter doloèa, da se že obstojeèi datoteki zapis doda
		FileWriter fw = new FileWriter(imeDatoteke, false); //datoteki se spremeni zapis v celoti
		PrintWriter dat = new PrintWriter(fw);

		for(Pocitnice p : this.seznamPocitnic)
		{
			dat.print(p.shraniKotNiz());
		}
		dat.println("###");
		
		for(Uporabnik u : this.seznamUporabnikov)
		{
			dat.print(u.shraniKotNiz());
		}
		dat.println("***");

		dat.close();
	}

	// Metoda doda uporabnike, shranjene v datoteki, v turisticno agencijo
	//preberi uporabnike iz datoteke
	public void dodajIzDatoteke(String imeDatoteke) throws Exception
	{
		FileReader fr = new FileReader(imeDatoteke);
		BufferedReader dat = new BufferedReader(fr);

		ArrayList<String> uporabnikiPodatki;
		
		while(dat.ready())
		{
			String vrstica = dat.readLine().trim();
			if(vrstica.equals("*U"))
			{
				uporabnikiPodatki = new ArrayList<String>();
				while(dat.ready() && !vrstica.equals("##"))
				{
					vrstica = dat.readLine().trim();
					uporabnikiPodatki.add(vrstica);
				}

				Uporabnik novUporabnik = Uporabnik.preberiIzNiza(uporabnikiPodatki);
				this.seznamUporabnikov.add(novUporabnik);
			}
		}
		dat.close();
	}
	
	
	
}