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
	
	
	@Override
    public String toString() {
		String podatki = "";
		
		podatki += "***   Podatki o terminu   ***\r\n";
		podatki += "Datum odhoda: " + this.odhod + "\r\n";
		podatki += "Datum prihoda: " + this.prihod + "\r\n";
		
		return podatki;
	}
	
	
	
	
	
	
	
	
	
	//------------------------------------------
	
}