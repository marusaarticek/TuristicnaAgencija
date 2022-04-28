import java.io.*;
import java.util.*;
import java.time.LocalDateTime;
import java.time.LocalDate;
import java.text.ParseException;
import java.time.format.DateTimeFormatter;

public class Termin {
	
	private int idTermina;
	private LocalDateTime odhod;
	private LocalDateTime prihod;
	
	DateTimeFormatter dtf = DateTimeFormatter.ofPattern("uuuu-MM-dd HH:mm");

	
	public Termin() {
		idTermina = 000;
		odhod = LocalDateTime.parse("2023-02-01 HH:mm", dtf);
		prihod = LocalDateTime.parse("2023-02-01 HH:mm", dtf);	
	}
	
	public Termin(LocalDateTime odhod, LocalDateTime prihod, int idTermina) {
		this.idTermina = idTermina;
		this.odhod = odhod;
		this.prihod = prihod;
	}
	
	public LocalDate getOdhod() {
		return this.odhod.toLocalDate();
	}
	public LocalDate getPrihod() {
		return this.prihod.toLocalDate();
	}
	public void setOdhod(LocalDateTime odhod) {
		this.odhod = odhod;
	}
	public void setPrihod(LocalDateTime prihod) {
		this.prihod = prihod;
	}
	
	@Override
    public String toString() {
		String podatki = "";
		
		podatki += "***   Podatki o terminu   ***\r\n";
		podatki += "Datum odhoda: " + this.odhod + "\r\n";
		podatki += "Datum prihoda: " + this.prihod + "\r\n";
		
		return podatki;
	}
	
	public String shraniKotNiz() {
		String zapis = "*T\r\n";			// Zapišemo kodo "S", ki oznacuje status
		zapis += this.odhod + "\r\n";
		zapis += this.prihod + "\r\n";
		zapis += "#\r\n";
		return zapis;
	}
	
	public static Termin preberiIzNiza(ArrayList<String> zapis)
	{
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("uuuu-MM-dd HH:mm");
		Termin termin = new Termin();  // Najprej ustvarimo objekt, kateremu bomo nastavili podane lastnosti
		try
		{
			termin.setOdhod(LocalDateTime.parse(zapis.get(0), dtf));
			
			termin.setPrihod(LocalDateTime.parse(zapis.get(1), dtf));
			
			return termin;
		}
		catch(Exception ex)
		{
			System.out.println("Prišlo je do napake v zapisu!");
			System.out.println();
			throw ex;
		}
	}
	
	
	
	
	
	//------------------------------------------
	
}