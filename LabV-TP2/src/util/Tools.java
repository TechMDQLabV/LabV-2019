package util;

public class Tools {
    public static int fRandomRange(int min, int max){
        int n = (int) (Math.random() * (max-min)+min);
        return n;
    }

    public static int fRandomAge(){
        return fRandomRange(1,90);
    }

    public static int fRandomDNI(){
        return fRandomRange(10000000,90000000);
    }

    public static String fName(){
        String[] names = {"Andrea","Beatriz","Claudio","Alba","Alex","Benito","Javier","Bernarda","Sergio","Anibal","Juan","Nicolas","Nahuel","Sofia","Manuel"};

        return names[fRandomRange(0,names.length)];
    }

    public static String fLastName(){
        String[] lastNames = {"Gomez","Garcia","Fernandez","Juarez","Macricio","Lopez","Perez","Stua","Duran","Grande","Guerrero","Yamaha","Teruel","Valenciano","Catalan"};

        return lastNames[fRandomRange(0,lastNames.length)];
    }

    public static String fEventName(){
        String[] eventNames = {"IKEA","Makro","Malvinas","MacriGato","Tupac","Jarry","UBU","Vian","EraserHead","Lola","Lili Marlen","Yamaha","Lobo-Hombre","Fassbinder","Zappa"};

        return eventNames[fRandomRange(0,eventNames.length)];
    }

    public static String fLocationName(int i){
        String[] locations = {"Centro de Deportes","Auditorium","Teatro Colon","Minela","Polideportivo","Chapadmalal","Batan","Carcel","Municipalidad","Ferroautomotora","Punta Mogotes","Faro","La Reserva del Mar","Bosques del Faro","La Caseta"};

        return locations[i];
    }

    public static String fCityName(int i){
        String[] cities = {"Mar del Plata","Paris","Londres","New York","Madrid","Barcelona","Valencia","Buenos Aires","Rosario","Cordoba","Alicante","Miami","Los Angeles","Rio de Janeiro","Bruselas"};

        return cities[i];
    }
}
