package ClassVersion;

import java.util.ArrayList;

public class Campus {
    private ArrayList<Place> places;

    public Campus() {
        this.places = new ArrayList<>();
        createPlaces();
    }

    private void createPlaces() {
        places.add(new Place("Bishop Boulevard", "admire the campus view", 0));
        places.add(new Place("Perkins Theology School", "visit the chapel", 200));
        places.add(new Place("Meadows", "attend a concert", -100));
        places.add(new Place("Westcott Field", "cheer for the soccer team", -100));
        places.add(new Place("Cox School of Business", "take a class", 200));
        places.add(new Place("McFarlin Auditorium", "watch a show", -100));
        places.add(new Place("Dedman Law Library", "study", 200));
        places.add(new Place("Dallas Hall", "see the downtown skyline", 0));
        places.add(new Place("Fondren Science", "do an experiment", 200));
        places.add(new Place("Simmons", "take a class", 200));
        places.add(new Place("Hughes-Trigg Student Center", "get a snack", -100));
        places.add(new Place("Lyle", "learn Java programming", 200));
        places.add(new Place("Moody", "watch a basketball game", -100));
        places.add(new Place("Residential Commons", "take a nap", 0));
        places.add(new Place("Ford Stadium", "cheer for Mustang football", -100));
    }

    public Place getFirstPlace() {
        return places.get(0);
    }

    public Place getNextPlace(Place currentPlace, int roll) {
        int currentIndex = places.indexOf(currentPlace);
        int newIndex = (currentIndex + roll) % places.size();
        return places.get(newIndex);
    }
}