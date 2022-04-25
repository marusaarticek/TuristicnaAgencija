import java.io.*;
import java.util.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


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
	
	
	
	public void dodajRezervacijo(Rezervacija r) {
		boolean = false;
		
		for(Pocitnice pocitnice : this.seznamPocitnic) {
			if( pocitnice.getmaxSteviloOseb() 
		}
		
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
		
		return podatki;
	}
	
	
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