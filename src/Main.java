import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) {
        // Create a priority queue with a custom comparator to sort by priority and distance
        PriorityQueue<Flight> flights = new PriorityQueue<>(10, new SortQueue());

        // Adding flights to the priority queue
        flights.add(new Flight(new Data("0001", 2002), 1));
        flights.add(new Flight(new Data("0002", 200), 1));
        flights.add(new Flight(new Data("0003", 330), 2));
        flights.add(new Flight(new Data("0004", 300), 3));
        flights.add(new Flight(new Data("0005", 200), 1));
        flights.add(new Flight(new Data("0006", 550), 1));
        flights.add(new Flight(new Data("0007", 3200), 2));
        flights.add(new Flight(new Data("0008", 1130), 3));
        flights.add(new Flight(new Data("0009", 1220), 3));
        flights.add(new Flight(new Data("0010", 757), 3));
        flights.add(new Flight(new Data("0011", 635), 4));
        flights.add(new Flight(new Data("0012", 1035), 4));
        flights.add(new Flight(new Data("0013", 837), 4));
        flights.add(new Flight(new Data("0014", 1900), 4));

        // Printing all elements
        System.out.println("The queue elements:");

        // Storing data for printing
        Data[] dataRecs = new Data[14];
        int i = 0;
        while (!flights.isEmpty()) {
            dataRecs[i++] = new Data(flights.poll());
        }

        // Print the sorted flights
        for (Data recs : dataRecs) {
            System.out.println(recs.getName() + " " + recs.getMiles() + " " + recs.getPriority());
        }
    }
}

class SortQueue implements Comparator<Flight> {
    @Override
    public int compare(Flight f1, Flight f2) {
        // First compare by priority
        int priorityComparison = f1.getPriority() - f2.getPriority();
        if (priorityComparison != 0) {
            return priorityComparison;
        }
        // If priorities are the same, compare by flying distance in descending order
        return f2.getData().getMiles() - f1.getData().getMiles();
    }
}

class Flight {
    private Data data;
    private final int priority;

    public Flight(Data data, int priority) {
        this.data = data;
        this.priority = priority;
    }

    public Data getData() {
        return data;
    }

    public int getPriority() {
        return priority;
    }

    @Override
    public String toString() {
        return "Flight{ priority = " + priority + ", miles = " + data.getMiles() + ", Flight name = " + data.getName() + " }";
    }
}

class Data {
    // Global variables of the class
    String name;
    int miles;
    int priority;

    // Constructor to initialize name and miles
    Data(String name, int miles) {
        this.name = name;
        this.miles = miles;
    }

    // Constructor to initialize from a Flight object
    public Data(Flight flight) {
        name = flight.getData().getName();
        miles = flight.getData().getMiles();
        priority = flight.getPriority();
    }

    // Getter methods
    public int getPriority() {
        return priority;
    }

    public String getName() {
        return name;
    }

    public int getMiles() {
        return miles;
    }
}
