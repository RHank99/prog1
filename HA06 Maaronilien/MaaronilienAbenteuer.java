import java.util.Scanner;

public class MaaronilienAbenteuer {
	public static void main (String[]args) {
		System.out.println("---------------------------------------");
		System.out.println("--Herzlich Willkommen zu Maaronilien!--");
		System.out.println("---------------------------------------");
		System.out.println("");
		System.out.println("Wie lautet ihr Name?");
		Scanner consoleInput = new Scanner(System.in);
		String name = consoleInput.nextLine();
		System.out.println("Und welche Klasse wollen Sie spielen? Tippen Sie 1 für Zauberer,2 für Kleriker oder 3 für Kämpfer)");
		String klasse = consoleInput.nextLine();
		klassenWahl(name, klasse);
		//jede xxxStats array hat folgende aufteilung:
		//xxxStats[0] = Leben; xxxStats[1] = Angriff, xxxStats[2] = Verteidigung, xxxStats[3] = Magie Verteidigung
		double[] spielerStats = {25, 4, 3, 3};
		System.out.println("Ein Slime kommt von einem Busch hervorgesprungen!");
		double[] slimeStats = {20, 3, 0, 0};
		while (true) {
			System.out.println("Was wirst du tun? ");
			System.out.println("Deine Leben: " + spielerStats[0]);
			System.out.println("Die Leben vom Slime: " + slimeStats[0]);
			System.out.print("Gebe 1 ein um anzugreifen oder gebe 2 ein um dich zu heilen: ");
			int spielerAktion = consoleInput.nextInt();
			if (spielerAktion == 1) {
				slimeStats[0] = slimeStats[0] - spielerStats[1] ;
			}
			else if (spielerAktion == 2) {
				spielerStats[0] = spielerStats[0] + 2;
			}
			else {
				System.out.println("Du machst einen Komischen Tanz vor dem Slime und machst ihn damit Aggresiv");
				slimeStats[1] = 25;
			}
			if (slimeStats[0] <= 0) {
				System.out.println("Du hast gewonnen!");
				System.out.println("In den Slime Überresten findest du eine Lebenstrank und trinkst sie sofort");
				System.out.println("*Du Heilst dich wieder auf deine volle HP*");
				break;	
			}
			spielerStats[0] = spielerStats[0] - slimeStats[1];
			System.out.println("Der Slime macht dir " + slimeStats[1] + " Schaden.");
			if (spielerStats[0] <= 0) {
				System.out.println("Du hast verloren!");
				System.out.println("Du wirst bewusstlos und wachst nach ein paar Stunden ohne Kratzer auf.");
				break;
			}
			
		}
		System.out.println("Du gehst weiter nach Norden und begegnest einen Dungeon");
		spielerStats[0] = 25; 	
		//Ausgabe: Wähle ein Symbol für eine Rune:
		System.out.println("Am Dungeon Eingang siehst du eine große Steinere Tür mit zwei Schubladen.");
		System.out.println("Über den beiden Schubladen siehst du leuchtende Buchstaben. In denen steht:");
		System.out.println("\"In der linken Schublade ist eine magische Rune von Kathusia, während in der rechte Rune eine Rune von Agatha ist.\"");
		System.out.println("Welche, von den beiden Runen, nimmst du? Tippe 1 für die linke Schublade tippe 2 für die Rechte");

		byte rune = consoleInput.nextByte();
		
   		if (rune==1) {
			spielerStats[2] = spielerStats[2]  * 1.5;
			System.out.println("Nachdem du Rune aufgenommen hast spührst du, wie sich deine Verteidigng sich steigert.");
    	}
		if (rune==2){
			spielerStats[3] = spielerStats[3] * 3.5;
			System.out.println("Nachdem du Rune aufgenommen hast spührst du, wie sich deine Magische Verteidigng sich steigert");
		}
		
		System.out.println("Nachdem du die Rune rausgeholt hast schließen sich die Schublade und die leuchtende Schrift ändert sich.");
		System.out.println("\"Um weiter zu kommen musst du folgendes Rätsel Lösen");
		System.out.println("Wie oft muss man die 4 mal 2 Multiplizieren um 512 als Ergebnis zu haben?\"");
		
		byte raetsel = consoleInput.nextByte();
		spielerStats[0] = raetselRechnung(raetsel, spielerStats[0], spielerStats[2] , spielerStats[3]);

		if (spielerStats[0] == 0) {
			System.out.println("Du bist gestorben!");
		} 
		else {
			System.out.println("Die Buchstaben verändern sich wiedermal diesmal steht folgendes bei ihnen:");
			System.out.println("\"Bevor ich mich öffne muss du noch ein letztes Rätsel lösen.");
        	String wort;
        	do{ 
            	System.out.println("Bitte gebe mir dafür ein Wort mit mindestens 5 Buchstaben.\"");
            	wort = consoleInput.nextLine();
            	System.out.println("\"Du hast das Wort " + wort + " ausgewählt.");
        	}	while(wort.length() < 5);
			wort = wort.replace("a", "*");
			wort = wort.replace("e", "*");
			wort = wort.replace("i", "*");
			wort = wort.replace("o", "*");
			wort = wort.replace("u", "*");
			wort = wort.replace("A", "*");
			wort = wort.replace("E", "*");
			wort = wort.replace("I", "*");
			wort = wort.replace("O", "*");
			wort = wort.replace("U", "*");
			System.out.println("\"Ich habe alle Vokale in Sternchen (\"*\") umgewandelt. Wie lautet dein Wort jetzt?");
			String lösungwort = consoleInput.nextLine();
			if (!wort.equals(lösungwort)){
				System.out.println("Nachdem du das Ergebnis laut gesagt hast werden die Buchstaben immer heller und Explodieren");
				spielerStats[0] = spielerStats[0] - 28 + spielerStats[3];
				System.out.println("Du hast " + spielerStats[0] + " Leben");
				if (spielerStats[0] <= 0) {
					System.out.println("Du hast verloren!");
				}
			}
			System.out.println("Und damit ist die Demo vorbei =]");
		}

		
	}
	public static void klassenWahl(String name, String klasse){
		if (klasse.equalsIgnoreCase("Zauberer")){
			System.out.println("Du befindest dich in deinem Magier Turm. Du liest gemütlich in deinen Büchern rum, bis eine Brief Eule sich an deinem Fenster bemerkbar macht.");
			System.out.println("Als du ihr näher kommst verschindet sie wieder und hintlässt dir einen Brief. Neugierig öffnest du den Brief. Sieh mal es ist von deinem Freund Sneezlius.");
			System.out.println("Folgendes Schrieb er in sein Brief:");
			System.out.println("\"Zabiu " + name + ",");		
			System.out.println("Wie geht es dir? Ich habe länger nichts mehr von dir gehört. Geht es deiner Brief Eule gut?");
			System.out.println("Weshalb ich dir eigentlich schreibe ist ich habe etwas ganz Fantastisches Gefunden. Nördlich von meiner Unterkunft ist eines Tages ein Nebel erschienen.");	 
			System.out.println("Ich dachte mir erstmal nichts dabei doch als der Nebel über mehrere jahre bestanden blieb musste ich mir das genauer angucken.");
			System.out.println("Ich habe herausgefunden das der Nebel magisch erzeugt wird und anscheinend niemand ihn beschworen hat. Faszinierend, oder?");
			System.out.println("Wenn du dir ihn auch mal anschauen möchtest dann komm einfach nach Maaronilia.");
			System.out.println("Ich werde dort auf dich warten. Wenn du keine Lust hast schreib mir das einfach.");
			System.out.println("Zibau, dein Sneezlius\"");	
			System.out.println("Geblendet von deiner Neugier und deiner Isolation packst du schnell deine Bücher und Schreibfedern ein und fliegst mit deinen Besen nach Maaronilien.");	
		} else if (klasse.equalsIgnoreCase("Kleriker")){
			System.out.println("Du wurdest von Papst deiner Religion gerufen um sich vor ihn aufzutreten. Als du dich vor seiner Präsens hinkniest, schaut er zur dir runter und sprach:");
			System.out.println("\""+ name +", du hast dich in dieser Kirche Gott bewiesen, doch Gott befiehlte mir dich woanders hinzuschicken.");
			System.out.println("Ein Nekromat hat ein ganzes Reich für sich beansprucht. Diese Welt ist Gottes Land.Du, "+ name +", sollst nach Maaronilien um den Sündigen zu bestrafen.");      
			System.out.println("Möge du, "+ name + ", auf deinem Weg von Gottes Hand begleitet werden und möge Gott Gerechtigkeit über den Sünder ergehen.\"");
			System.out.println("Geblendet von deiner Rechtfertigkeit und deinem Glauben wanderst du nach Maaronilia um den Bösen Nekromaten den Gar auszumachen.");
		} else if (klasse.equalsIgnoreCase("Kaempfer")){
			System.out.println("Du bist wieder mal in deinem Gilden Haus. Dir ist langweilig und in letzter Zeit gibt es immer weniger Quest für dich, die sich Lohnen. \"Hallo " + name + "!\",");
			System.out.println("kommt es plötzlich von der der Gilden Theke.\"Wir habe haben eine neue Aufgabe für dich, die gut bezhalt wird!\".");
			System.out.println("Aufgeregt gehst du zur Theke und liest dir die Quest Informationen durch. Die Quest befindet sich in Maaronilien.");
			System.out.println("Du hast von den Gerüchten gehört, dass es dort etliche Schätze geben soll, aber auch von viele Gefahren geplagt ist");
			System.out.println("Geblendet von deiner Gier und deiner Abenteuerlust nimmst du die Quest an."); 
			System.out.println("Gleich am nächsten Morgen springst du auf dein Pferd und machst dich auf den Weg zu Maaronilien.");
		} else {
			System.out.println("Du weißt nur wer du bist, du weißt aber was du bist und das nicht niemand aufhalten kann um nach Maaronilien zu kommen.");
		}
	}

	public static double raetselRechnung(byte raetsel, double spielerLeben, double defense, double magicDefense){
		int rechnung = 4 << raetsel;
		if (rechnung > 512) {
			System.out.println("Nachdem du das Ergebnis laut gesagt hast verschwindet der Boden unter dir und du siehst wie du auf Spitze Stacheln fällst.");
			spielerLeben = spielerLeben - 28 + defense;
			System.out.println("Du hast " + spielerLeben + "Leben");
		}
		if (rechnung < 512) {
			System.out.println("Nachdem du das Ergebnis laut gesagt hast werden die Buchstaben immer heller und Explodieren");
			spielerLeben = spielerLeben - 28 + magicDefense;
			System.out.println("Du hast " + spielerLeben + "Leben");
			
		}
		return spielerLeben;

	}
}
