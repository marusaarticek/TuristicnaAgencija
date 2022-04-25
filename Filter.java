public class Filter {
	
	static String izpisPoTerminu() throws Exception {
		
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("uuuu-MM-dd");
		String preberiOdhod = "";
		String preberiPrihod = "";
		
		System.out.println("***   Iskanje glede na termin pocitnic   ***");
		System.out.println();
		System.out.println("Termin odhoda (npr: 2023-02-01):  ");
		String preberiOdhod = br.readLine().trim();
		LocalDate odhod = LocalDate.parse(preberiOdhod, dtf);
		
		System.out.println();
		System.out.println("Termin prihoda (npr: 2023-02-05):  ");
		String preberiPrihod = br.readLine().trim();
		LocalDate prihod = LocalDate.parse(preberiPrihod, dtf);
		
		String podatki = "";
		
		System.out.println("Mozne pocitnice v okvirju termina:\r\n");
		
		for(Pocitnice pocitnice : this.seznamPocitnic) {
			for(Termin termin : pocitnice.seznamTerminov) {
				if(termin.getOdhod().isEqual(odhod) || termin.getOdhod().isAfter(odhod) && termin.getPrihodod().isEqual(prihod) || termin.getPrihod().isBefore(prihod)  {
					podatki += pocitnice.toString();
					
					podatki += "\r\n";
				}
			}	
		}
		
		if(podatki.equals("")) {
			return "V izbranem terminu ni moznih pocitnic!\r\n";
		}
		
		return podatki;	
	}
	
	static String izpisDrzava() throws Exception {

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
	
	static String izpisPoCeni() throws Exception {
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
	
	static String izpisPoTipu(int tip) {
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
	
	
	
}