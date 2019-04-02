import util.Tools;
import classes.City;
import classes.Event;
import classes.Location;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main{
    public static void main(String[] args) {
        List<City> cities = new ArrayList<>();
        for(int i=0;i<15;i++){
            cities.add(new City(Tools.fCityName(i)));
        }

        List<Location> locations = new ArrayList<>();
        for(int i=0;i<15;i++) {
            locations.add(new Location(Tools.fLocationName(i), cities.get(Tools.fRandomRange(0, cities.size()))));
        }

        List<Event> events = new ArrayList<>();
        for(int i=0;i<30;i++){
            events.add(new Event(Tools.fEventName(),locations.get(Tools.fRandomRange(0,locations.size()))));
        }

        System.out.printf("Eventos: %s\n",events);

        System.out.println(String.format("\nEventos ordenados por Id limit 5: %s", events.stream()
                .limit(5)
                .collect(Collectors.toList())));

        System.out.println(String.format("\nEventos con id en orden inverso: %s", events.stream()
                .sorted(Comparator.comparing(Event::getId).reversed())
                .collect(Collectors.toList())));

        System.out.println(String.format("\nEventos, los 5 primeros ordenados alfabeticamente: %s", events.stream()
                .limit(5)
                .sorted(Comparator.comparing(Event::getName))
                .collect(Collectors.toList())));

        System.out.println(String.format("\nEventos en ciudades con id mayor a 5: %s", events.stream()
                .filter(ev -> ev.getLocation().getCity().getId() > 5)
                .limit(10)
                .collect(Collectors.toList())));

        System.out.println(String.format("\nEventos en ciudad con id 1: %s", events.stream()
                .filter(ev -> ev.getLocation().getCity().getId() == 1)
                .collect(Collectors.toList())));
    }
}
