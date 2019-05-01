package utilities;

public class Tools {

    public static int fRandomRange(int min, int max){
        int n = (int) (Math.random() * (max-min)+min);
        return n;
    }

    public static String fName(){
        String[] names = {"Andrea","Beatriz","Claudio","Alba","Alex","Benito","Javier","Bernarda","Sergio","Anibal","Juan","Nicolas","Nahuel","Sofia","Manuel"};

        return names[fRandomRange(0,names.length)];
    }

    public static String fLastName(){
        String[] lastNames = {"Gomez","Garcia","Fernandez","Juarez","Macricio","Lopez","Perez","Stua","Duran","Grande","Guerrero","Yamaha","Teruel","Valenciano","Catalan"};

        return lastNames[fRandomRange(0,lastNames.length)];
    }

    public static void fReplicante(char c, int n){
        for(int i=0;i<n;i++){
            System.out.printf("%c",c);
        }
    }
}
