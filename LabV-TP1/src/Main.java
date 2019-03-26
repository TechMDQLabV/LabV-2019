import clases.Persona;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import util.tools;

public class Main {
    public static void main(String[] args){

        List<Persona> personas = new ArrayList<>();
        for(int i=0;i<30;i++){
            personas.add(new Persona(tools.fName(),tools.fLastName(),tools.fRandomAge(),tools.fRandomDNI()));
        }

        //personas = Arrays.asList(a,b,c,d);
        //System.out.println(String.format("Personas\n %s",personas));

        System.out.printf("\nPersonas con printf: %s\n",personas);

        System.out.println(String.format("\nMayores a 21: %s", personas.stream()
                .filter(p->p.getAge() > 21)
                .collect(Collectors.toList())));

        System.out.println(String.format("\nMenores a 18: %s", personas.stream()
                .filter(p->p.getAge() < 18)
                .collect(Collectors.toList())));

        System.out.println(String.format("\nMayores a 21 y DNI > 20.000.000: %s", personas.stream()
                .filter(p->p.getAge() > 21)
                .filter(p->p.getDni() > 20000000)
                .collect(Collectors.toList())));
    }
}
