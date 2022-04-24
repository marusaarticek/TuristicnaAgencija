public class Rezervacija {
	
	private String ime;
	private String priimek;
	private int stOdraslih;
	private int stOtrok;
	
	public Rezervacija() {
		ime = "";
		priimek = "";
		stOdraslih = 0;
		stOtrok = 0;	
	}
	
	public Rezervacija(String ime, String priimek, int stOdraslih, int stOtrok) {
		this.ime = ime;
		this.priimek = priimek;
		this.stOdraslih = stOdraslih;
		this.stOtrok = stOtrok;	
	}
	
	public static Rezervacija ustvariRezervacijo() throws Exception {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		
		System.out.println("***   Vnos nove Rezervacije   ***");
		System.out.println();
		System.out.println("Vnesi ime: ");
		String avtor = br.readLine().trim();
		System.out.println();
		System.out.println("Vnesi priimek: ");
		String naslov = br.readLine().trim();
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
	}
}