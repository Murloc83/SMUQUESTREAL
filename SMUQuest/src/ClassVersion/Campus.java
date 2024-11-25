package ClassVersion;

import java.util.ArrayList;
public class Campus {
   // creates the places ArrayList and calls the createPlaces method
    private ArrayList<Place> places;
    public Campus() {
        this.places = new ArrayList<>();
        createPlaces();
    }
// creates 15 instances of Place and add them to the places ArrayLIst, uses values from table
    private void createPlaces() {
        places.add(new Place("Bishop Boulevard", "to admire the campus view", 0));
        places.add(new Place("Perkins Theology School", "to visit the chapel", 200));
        places.add(new Place("Meadows", "to attend a concert", -100));
        places.add(new Place("Westcott Field", "to cheer for the soccer team", -100));
        places.add(new Place("Cox School of Business", "to take a class", 200));
        places.add(new Place("McFarlin Auditorium", "to watch a show", -100));
        places.add(new Place("Dedman Law Library", "to study", 200));
        places.add(new Place("Dallas Hall", "to see the downtown skyline", 0));
        places.add(new Place("Fondren Science", "to do an experiment", 200));
        places.add(new Place("Simmons", "to take a class", 200));
        places.add(new Place("Hughes-Trigg Student Center", "to get a snack", -100));
        places.add(new Place("Lyle", "to learn Java programming", 200));
        places.add(new Place("Moody", "to watch a basketball game", -100));
        places.add(new Place("Residential Commons", "to take a nap", 0));
        places.add(new Place("Ford Stadium", "to cheer for Mustang football", -100));
    }
    // returns the Place instance that is the first element of the places ArrayList
    public Place getFirstPlace() {
        return places.get(0);
    }
    //determines the index location of the Place the player has moved to.
    // returns that Place instance so the Player is placed at the new location or back to the start.
    public Place getNextPlace(Place currentPlace, int roll) {
        int currentIndex = places.indexOf(currentPlace);
        int newIndex = (currentIndex + roll) % places.size();
        return places.get(newIndex);
    }
}