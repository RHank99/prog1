import java.util.Scanner;

public class EmojiParser{
  public static void main(String[] args) {

    Scanner consoleInput = new Scanner(System.in);
    String benutzerEingabe = consoleInput.nextLine();
    System.out.println(parseEmojis(benutzerEingabe));
  }
public static String parseEmojis(String message){
    Scanner consoleInput = new Scanner(System.in);
    int laengeWort =  message.length();
    if (laengeWort == 0 || message == null) {
      System.out.println("Eingabe ungueltig");
    }
    int ersterPunkt;
    int zweiterPunkt;
    int start = 0;
    
    while(true){
      ersterPunkt = message.indexOf(":", start);
      zweiterPunkt = message.indexOf(":", ersterPunkt + 1);
      if (ersterPunkt == -1 || zweiterPunkt == -1) {
        break;
      }
      String emojistelle = message.substring(ersterPunkt , zweiterPunkt);

      emojistelle = emojistelle.toLowerCase();
      if (emojistelle.equals("smile")) {
        message = message.substring(0, ersterPunkt) + ":-)" + message.substring(zweiterPunkt + 1);
      } 
      if (emojistelle.equals("sad")) {
        message = message.substring(0, ersterPunkt) + ":-(" + message.substring(zweiterPunkt + 1);
      } 
      if (emojistelle.equals("wink")) {
        message = message.substring(0, ersterPunkt) + ";-)" + message.substring(zweiterPunkt + 1); 
      } 
      if (emojistelle.equals("heart")) {
        message = message.substring(0, ersterPunkt) + "<3" + message.substring(zweiterPunkt + 1);
      } 
      if (emojistelle.equals("thumbsup")) {
        message = message.substring(0, ersterPunkt) + "(y)" + message.substring(zweiterPunkt + 1);
      }
      if (emojistelle.equals("star")) {
        message = message.substring(0, ersterPunkt) + "*" + message.substring(zweiterPunkt + 1);
      }
      start = ersterPunkt + 1;
      
    }
   
    return message;
  }

}