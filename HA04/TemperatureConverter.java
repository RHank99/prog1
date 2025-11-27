public class TemperatureConverter {
    public static void main(String[] args) {
    double celsius = 0;
    double fahrenheit = 0;
    celsiusToFahrenheit(celsius);
    System.out.println(celsius + " Celsius = " + fahrenheit + " Fahrenheit");
    celsius = 100;
    celsiusToFahrenheit(celsius);
    System.out.println(celsius + " Celsius = " + fahrenheit + " Fahrenheit");
    fahrenheit = 32;
    fahrenheitToCelsius(fahrenheit);
    System.out.println(celsius + " Celsius = " + fahrenheit + " Fahrenheit");
    fahrenheit = 212;
    fahrenheitToCelsius(fahrenheit);
    System.out.println(celsius + " Celsius = " + fahrenheit + " Fahrenheit");
    
    }
    public static double celsiusToFahrenheit(double celsius){
            double fahrenheit = celsius * 9 / 5 + 32;
            return fahrenheit;
        
    }

    public static double fahrenheitToCelsius(double fahrenheit){
            double celsius = (fahrenheit - 32) * 5 / 9 ;
            return celsius;
        
    }
}



