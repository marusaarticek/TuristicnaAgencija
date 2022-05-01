import java.io.*;
import java.util.*;
import java.time.LocalDateTime;
import java.time.LocalDate;
import java.text.ParseException;
import java.time.format.DateTimeFormatter;


public class TuristicnaAgencija {
	
	private ArrayList<Pocitnice> seznamPocitnic;
	private ArrayList<Uporabnik> seznamUporabnikov;
	
	//konstruktorji
	
	public TuristicnaAgencija() {
		this.seznamPocitnic = new ArrayList<Pocitnice>();
		this.seznamUporabnikov = new ArrayList<Uporabnik>();
		}
	
	public TuristicnaAgencija(ArrayList<Pocitnice> seznamPocitnic, ArrayList<Uporabnik> seznamUporabnikov) {
		this.seznamPocitnic = seznamPocitnic;
		this.seznamUporabnikov = seznamUporabnikov;
		}
	
	//---------------------------------------
	
	// metoda get
	public ArrayList<Pocitnice> getSeznamPocitnic() {
		return this.seznamPocitnic;
	}
	
	public ArrayList<Uporabnik> getSeznamUporabnikov() {
		return this.seznamUporabnikov;
	}
	
	

	// metoda set
	public void setSeznamPocitnic(ArrayList<Pocitnice> seznamPocitnic) {
		this.seznamPocitnic = seznamPocitnic;
	}
	
	public void setSeznamUporabnikov(ArrayList<Uporabnik> seznamUporabnikov) {
		this.seznamUporabnikov = seznamUporabnikov;
	}
	
	
	
	//********************************************
	
	
	public void registracijaUporabnika(boolean admin) throws Exception {
		
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		
		System.out.println("***   Registracija novega uporabnika   ***");
		System.out.println();
		System.out.println("Vnesi ime: ");
		String ime = br.readLine().trim();
		System.out.println();
		System.out.println("Vnesi priimek: ");
		String priimek = br.readLine().trim();
		System.out.println();
		System.out.println("Vnesi geslo: ");
		String geslo = br.readLine().trim();
		System.out.println();
		
		
		boolean pogoj = false;
		for(Uporabnik uporabnik : this.seznamUporabnikov) {
			if(uporabnik.getIme().equals(ime) && uporabnik.getPriimek().equals(priimek)) {
				pogoj = true;
				System.out.println("Uporabnik s tem imenom je ze registriran.");
				break;
			}
		}
		if(!pogoj) {
			Uporabnik u = new Uporabnik(ime, priimek, geslo, false);
			this.seznamUporabnikov.add(u);
			System.out.println("Registracija uspesna.");
		}
		
		if(admin) {
			Uporabnik u = new Uporabnik(ime, priimek, geslo, true);
			this.seznamUporabnikov.add(u);
			System.out.println("Registracija admina uspesna.");
		}
	}
	
	public void dodajPocitnice(Pocitnice p) {
		this.seznamPocitnic.add(p);
		
	}
	
	
	/*
	public void dodajUporabnika(Uporabnik u) {
		boolean pogoj = false;
		for(Uporabnik uporabnik : this.seznamUporabnikov) {
			if(uporabnik.getIme().equals(u.getIme()) && uporabnik.getPriimek().equals(u.getPriimek())) {
				pogoj = true;
				break;
			}
		}
		if(!pogoj) {
			this.seznamUporabnikov.add(u);
			System.out.println("Registracija uspesna.");
		}
		else {
		System.out.println("Uporabnik je ze registriran.");
		System.out.println();
		}
	}
	*/
	
	public boolean prijavaUporabnika() throws Exception {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		
		System.out.println("***   Prijava v sistem.   ***");
		System.out.println();
		System.out.println("Vnesi ime: ");
		String ime = br.readLine().trim();
		System.out.println();
		System.out.println("Vnesi priimek: ");
		String priimek = br.readLine().trim();
		System.out.println();
		System.out.println("Vnesi geslo: ");
		String geslo = br.readLine().trim();
		System.out.println();
		
		boolean flag = false;
		for(Uporabnik u : this.seznamUporabnikov) {
			if(u.getIme().equals(ime) && u.getPriimek().equals(priimek) && u.getGeslo().equals(geslo)) {
				System.out.println("Prijava v sistem uspesna.");
				flag = true;
				break;
			}
			else {
				System.out.println("Uporabnik se ni registriran.");
			}
		}
		return flag;
	}
	
	public boolean izbrisUporabnika() throws Exception {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		
		System.out.println("***   Brisanje uporabnikov:   ***");
		System.out.println();
		System.out.println("Vnesi ime: ");
		String ime = br.readLine().trim();
		System.out.println();
		System.out.println("Vnesi priimek: ");
		String priimek = br.readLine().trim();
		System.out.println();
		System.out.println("Vnesi geslo: ");
		String geslo = br.readLine().trim();
		System.out.println();
		
		boolean flag = false;
		int count = 0;
		
		for(Uporabnik u : this.seznamUporabnikov) {
			if(u.getAdmin()) {
				count += 1;
			}
		}
		
		for(Uporabnik u : this.seznamUporabnikov) {
			if(u.getIme().equals(ime) && u.getPriimek().equals(priimek) && u.getGeslo().equals(geslo)) {
				System.out.println("Prijava v sistem uspesna.");
				flag = true;
				break;
			}
			else {
				System.out.println("Uporabnik se ni registriran.");
			}
		}
		return flag;
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
			podatki += p.toString();
			podatki += "\r\n";
		}
		
		return podatki;
	}
	
	public void shraniVDatotekoP(String imeDatoteke) throws IOException
	{
		//FileWriter fw = new FileWriter(imeDatoteke, true); // Drugi parameter doloèa, da se že obstojeèi datoteki zapis doda
		FileWriter fw = new FileWriter(imeDatoteke, false); //datoteki se spremeni zapis v celoti
		PrintWriter dat = new PrintWriter(fw);

		for(Pocitnice p : this.seznamPocitnic)
		{
			dat.print(p.shraniKotNiz());
		}
		dat.println("###");

		dat.close();
	} 
	
	public void shraniVDatoteko(String imeDatoteke) throws IOException
	{
		//FileWriter fw = new FileWriter(imeDatoteke, true); // Drugi parameter doloèa, da se že obstojeèi datoteki zapis doda
		FileWriter fw = new FileWriter(imeDatoteke, false); //datoteki se spremeni zapis v celoti
		PrintWriter dat = new PrintWriter(fw);

		for(Uporabnik u : this.seznamUporabnikov)
		{
			dat.print(u.shraniKotNiz());
		}
		dat.println("***");

		dat.close();
	} 
	

	// Metoda doda uporabnike, shranjene v datoteki, v turisticno agencijo
	//preberi uporabnike iz datoteke
	public void dodajIzDatotekeU(String imeDatoteke) throws Exception
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
	
	public void dodajIzDatotekeP(String imeDatoteke) throws Exception
	{
		FileReader fr = new FileReader(imeDatoteke);
		BufferedReader dat = new BufferedReader(fr);

		ArrayList<String> pocitnicePodatki;
		
		while(dat.ready())
		{
			String vrstica = dat.readLine().trim();
			if(vrstica.equals("*S"))
			{
				pocitnicePodatki = new ArrayList<String>();
				while(dat.ready() && !vrstica.equals("##"))
				{
					vrstica = dat.readLine().trim();
					pocitnicePodatki.add(vrstica);
				}

				Smucanje s = Smucanje.preberiIzNiza(pocitnicePodatki);
				this.seznamPocitnic.add(s);
			}
			if(vrstica.equals("*K"))
			{
				pocitnicePodatki = new ArrayList<String>();
				while(dat.ready() && !vrstica.equals("##"))
				{
					vrstica = dat.readLine().trim();
					pocitnicePodatki.add(vrstica);
				}

				Krizarjenje k = Krizarjenje.preberiIzNiza(pocitnicePodatki);
				this.seznamPocitnic.add(k);
			}
			if(vrstica.equals("*C"))
			{
				pocitnicePodatki = new ArrayList<String>();
				while(dat.ready() && !vrstica.equals("##"))
				{
					vrstica = dat.readLine().trim();
					pocitnicePodatki.add(vrstica);
				}

				Kampiranje kamp = Kampiranje.preberiIzNiza(pocitnicePodatki);
				this.seznamPocitnic.add(kamp);
			}
			if(vrstica.equals("*M"))
			{
				pocitnicePodatki = new ArrayList<String>();
				while(dat.ready() && !vrstica.equals("##"))
				{
					vrstica = dat.readLine().trim();
					pocitnicePodatki.add(vrstica);
				}

				Pocitnice p = Pocitnice.preberiIzNiza(pocitnicePodatki);
				this.seznamPocitnic.add(p);
			}
		}
		dat.close();
	}
	
	//-------------------------------------------------------------------
	public void izbrisId() throws Exception {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		
		int id = 0;
		while(true) {
			try {
				System.out.println("Vnesi id pocitnic, ki jih zelis izbrisati: ");
				System.out.println();
				System.out.println("id: ");
				id = Integer.parseInt(br.readLine().trim());
				System.out.println();
				break;
			}
			catch (Exception e) {
				System.out.println("Napacen format vnosa!");
				System.out.println();
			}
		}
		
		int i = 0;
		for(Pocitnice p : this.seznamPocitnic) {
			if(p.getId() == id) {
				this.seznamPocitnic.remove(p);
				p.getSeznamRezervacij().clear();
				i += 1;
			}
		}
		System.out.println("Izbrisali ste pocitnice: " + i);
		System.out.println();
		
		if(i == 0) {
			System.out.println("Pocitnice s to id ne obstajajo");
		}
	}
	
	/*
	public String spremeni() throws Exception {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		
		int id = 0;
		while(true) {
			try {
				System.out.println("Vnesi id pocitnic, ki jih zelis spremeniti: ");
				System.out.println();
				System.out.println("id: ");
				id = Integer.parseInt(br.readLine().trim());
				System.out.println();
				break;
			}
			catch (Exception e) {
				System.out.println("Napacen format vnosa!");
				System.out.println();
			}
		}
		
		while(true) {
			System.out.println("Pritisni (a) za spremebo drzave pocitnic: ");
			System.out.println("Pritisni (b) za spremembo termina pocitnic: ");
			System.out.println("Pritisni (c) za spremembo cene pocitnic.");
			
			izbira = br.readLine().trim().charAt(0);
			
			switch(izbira) {
				case 'g':
					Pocitnice p = Pocitnice.ustvariPocitnice();
					agencija.dodajPocitnice(p);
					break;
				case 'g':
					Pocitnice p = Pocitnice.ustvariPocitnice();
					agencija.dodajPocitnice(p);
					break;
		
		if(podatki.equals("")) {
			return "Ni pocitnic s to id!\r\n";
		}
		
		return podatki;
	}
	*/
	
	public String izpisPoId() throws Exception {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		
		int id = 0;
		while(true) {
			try {
				System.out.println("Vnesi id: ");
				System.out.println();
				System.out.println("id: ");
				id = Integer.parseInt(br.readLine().trim());
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
			if(p.getId() == id) {
				podatki += p.toString();
				podatki += p.zasedenost();
				podatki += "\r\n";
			}
		}
		
		if(podatki.equals("")) {
			return "Ni pocitnic s to id!\r\n";
		}
		
		return podatki;
	}
	
	public String izpisPoTipu(int tip, boolean admin) {
		String podatki = "";
		if(tip == 1) {
			for(int i = 0; i < this.seznamPocitnic.size(); i++) {
				if(this.seznamPocitnic.get(i) instanceof Potovanje) {
					podatki += this.seznamPocitnic.get(i).toString(admin);
					podatki += "\r\n";
				}
			}
		} 
		else if(tip == 2) {
			for(int i = 0; i < this.seznamPocitnic.size(); i++) {
				if(this.seznamPocitnic.get(i) instanceof Kampiranje) {
					podatki += this.seznamPocitnic.get(i).toString(admin);
					podatki += "\r\n";
				}
			}
		}
		else if(tip == 3) {
			for(int i = 0; i < this.seznamPocitnic.size(); i++) {
				if(this.seznamPocitnic.get(i) instanceof Krizarjenje) {
					podatki += this.seznamPocitnic.get(i).toString(admin);
					podatki += "\r\n";
				}
			}
		}
		else if(tip == 4) {
			for(int i = 0; i < this.seznamPocitnic.size(); i++) {
				if(this.seznamPocitnic.get(i) instanceof Smucanje) {
					podatki += this.seznamPocitnic.get(i).toString(admin);
					podatki += "\r\n";
				}
			}
		}
		return podatki;
	}
	
	public String izpisPoTerminu(boolean admin) throws Exception {
		
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("uuuu-MM-dd");
		String preberiOdhod = "";
		String preberiPrihod = "";
		
		System.out.println("***   Iskanje glede na termin pocitnic   ***");
		System.out.println();
		System.out.println("Termin odhoda (npr: 2023-02-01):  ");
		preberiOdhod = br.readLine().trim();
		LocalDate odhod = LocalDate.parse(preberiOdhod, dtf);
		
		System.out.println();
		System.out.println("Termin prihoda (npr: 2023-02-05):  ");
		preberiPrihod = br.readLine().trim();
		LocalDate prihod = LocalDate.parse(preberiPrihod, dtf);
		
		String podatki = "";
		
		System.out.println("Mozne pocitnice v okvirju termina:\r\n");
		
		for(Pocitnice pocitnice : this.seznamPocitnic) {
			for(Termin termin : pocitnice.getSeznamTerminov()) {
				if(termin.getOdhod().isEqual(odhod) || termin.getOdhod().isAfter(odhod) 
					&& termin.getPrihod().isEqual(prihod) || termin.getPrihod().isBefore(prihod) ) {
					podatki += pocitnice.toString(admin);
					podatki += pocitnice.zasedenost();
					podatki += "\r\n";
				}
			}	
		}
		
		if(podatki.equals("")) {
			return "V izbranem terminu ni moznih pocitnic!\r\n";
		}
		
		return podatki;	
	}
	
	public String izpisDrzava(boolean admin) throws Exception {

		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		
		System.out.println("***   Vnesi ime drzave:   ***");
		System.out.println();
		System.out.println("Drzava: ");
		String drzava = br.readLine().trim();
		
		String podatki = "";
		
		for(Pocitnice p : this.seznamPocitnic) {
			if(p.getDrzava().equals(drzava)) {
				podatki += p.toString(admin);
				podatki += p.zasedenost();
				podatki += "\r\n";
			}
		}
		
		if(podatki.equals("")) {
			return "Za izbrano drzavo ni moznih pocitnic!\r\n";
		}
		return podatki;
	}
	
	public String izpisPoCeni(boolean admin) throws Exception {
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
				podatki += p.toString(admin);
				podatki += p.zasedenost();
				podatki += "\r\n";
			}
		}
		
		if(podatki.equals("")) {
			return "V cenovnem okvirju ni moznih pocitnic!\r\n";
		}
		
		return podatki;
	}
	//-------------------------------------------
	
	public void novaRezervacija() throws Exception {
		
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		
		System.out.println("***   Vnos nove Rezervacije   ***");
		System.out.println();
		System.out.println("Vnesi ime: ");
		String ime = br.readLine().trim();
		System.out.println();
		System.out.println("Vnesi priimek: ");
		String priimek = br.readLine().trim();
		System.out.println();
		
		int stOdraslih = 0;
		while(true) {
			try {
				System.out.println("Vnesi stevilo odraslih: ");
				stOdraslih = Integer.parseInt(br.readLine().trim());
				System.out.println();
				break;
			} 
			catch (Exception e) {
				System.out.println("Napacen format vnosa!");
				System.out.println();
			}
		}
		int stOtrok = 0;
		while(true) {
			try {
				System.out.println("Vnesi stevilo otrok: ");
				stOtrok = Integer.parseInt(br.readLine().trim());
				System.out.println();
				break;
			}
			catch (Exception e) {
				System.out.println("Napacen format vnosa!");
				System.out.println();
			}
		}
		int turisti = stOdraslih+stOtrok;
		
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("uuuu-MM-dd");
		String preberiOdhod = "";
		String preberiPrihod = "";
		
		// za vsak tip pocitnic so na voljo termini
		// za vsak termin je na voljo maxstoseb - prostih mest
		
		System.out.println("***   Rezervacija pocitnic - TERMIN   ***");
		System.out.println();
		System.out.println("Termin odhoda (npr: 2023-02-01):  ");
		preberiOdhod = br.readLine().trim();
		LocalDate odhod = LocalDate.parse(preberiOdhod, dtf);
		
		System.out.println();
		System.out.println("Termin prihoda (npr: 2023-02-05):  ");
		preberiPrihod = br.readLine().trim();
		LocalDate prihod = LocalDate.parse(preberiPrihod, dtf);
		
		int stevilo = 0;
		for(Pocitnice pocitnice : this.seznamPocitnic) {
			for(Termin termin : pocitnice.getSeznamTerminov()) {
				if(termin.getOdhod().isEqual(odhod) || termin.getOdhod().isAfter(odhod) && termin.getPrihod().isEqual(prihod) || termin.getPrihod().isBefore(prihod) ) {
					System.out.println("uspesen termin");
					break;
				}
				else{
					System.out.println("neuspesen termin");
					break;
				}
			}
			for(Rezervacija r : pocitnice.getSeznamRezervacij()) {
				stevilo += r.getStOdraslih() + r.getStOtrok();
			}
			if(stevilo + turisti <= pocitnice.getmaxSteviloOseb()) {
				System.out.println("Rezervacija uspesna.");
				Rezervacija r = new Rezervacija(ime, priimek, stOdraslih, stOtrok);
				pocitnice.dodajRezervacijo(r);
				break;
			}
			else {
				System.out.println("Rezervacija NE uspesna.");
				return;
			}	
		}
	}
	
	
	public static void main(String[] args) {
		TuristicnaAgencija agencija = new TuristicnaAgencija();
		
		
		Pocitnice p2 = new Pocitnice(3, "Slovenija", 100);
		System.out.println(p2.toString());
	}
	
	
}

	