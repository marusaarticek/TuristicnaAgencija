import java.io.*;
import java.util.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Termin {
	
	private int idTermina;
	private LocalDateTime odhod;
	private LocalDateTime prihod;
	
	DateTimeFormatter dtf = DateTimeFormatter.ofPattern("uuuu-MM-dd");

	
	public Termin() {
		idTermina = 000;
		odhod = LocalDate.parse("2023-02-01 HH:mm", dtf);
		prihod = LocalDate.parse("2023-02-01 HH:mm", dtf);	
	}
	
	public Termin(LocalDateTime odhod, LocalDateTime prihod, int idTermina) {
		this.idTermina = idTermina;
		this.odhod = odhod;
		this.prihod = prihod;
	}
	
	public Localdate getOdhod() {
		return this.odhod;
	}
	public Localdate getPrihod() {
		return this.prihod;
	}
	
	
	@Override
    public String toString() {
		String podatki = "";
		
		podatki += "***   Podatki o terminu   ***\r\n";
		podatki += "Datum odhoda: " + this.odhod + "\r\n";
		podatki += "Datum prihoda: " + this.prihod + "\r\n";
		
		return podatki;
	}
	
	
	
	
	
	
	
	
	
	//------------------------------------------
	DateTimeFormatter dtf = DateTimeFormatter.ofPattern("uuuu-MM-dd");


	LocalDateTime date1 = LocalDate.parse("2020-02-01 HH:mm", dtf);
	LocalDateTime date2 = LocalDate.parse("2020-01-31 HH:mm", dtf);

	System.out.println("date1 : " + date1);
	System.out.println("date2 : " + date2);

	if (date1.isEqual(date2)) {
		System.out.println("Date1 is equal Date2");
	}

	if (date1.isBefore(date2)) {
		System.out.println("Date1 is before Date2");
	}

	if (date1.isAfter(date2)) {
		System.out.println("Date1 is after Date2");
	}

	// test compareTo
	if (date1.compareTo(date2) > 0) {
		System.out.println("Date1 is after Date2");
	} else if (date1.compareTo(date2) < 0) {
		System.out.println("Date1 is before Date2");
	} else if (date1.compareTo(date2) == 0) {
		System.out.println("Date1 is equal to Date2");
	} else {
		System.out.println("How to get here?");
	}
}