public abstract class Shipment {

    private String id;
    private String origin;
    private String destination;
    private double weight;

    public Shipment(String id, String origin, String destination, double weight) {
        this.id = id;
        this.origin = origin;
        this.destination = destination;
        this.weight = weight;
    }

    public String getId() {
        return id;
    }

    public String getOrigin() {
        return origin;
    }

    public String getDestination() {
        return destination;
    }

    public double getWeight() {
        return weight;
    }

    public abstract double calculateCost(); // Abstract method for cost calculation
}

public class LandShipment extends Shipment {

    private String vehicleType; // Land-specific attribute

    public LandShipment(String id, String origin, String destination, double weight, String vehicleType) {
        super(id, origin, destination, weight);
        this.vehicleType = vehicleType;
    }

    @Override
    public double calculateCost() {
        // Cost calculation based on weight and distance (replace with your logic)
        double baseCost = weight * 10; // Hypothetical base cost per unit weight
        // Add distance-based cost calculation here (consider using a distance API)
        return baseCost;
    }
}

public class AirShipment extends Shipment {

    private String airline; // Air-specific attribute

    public AirShipment(String id, String origin, String destination, double weight, String airline) {
        super(id, origin, destination, weight);
        this.airline = airline;
    }

    @Override
    public double calculateCost() {
        // Cost calculation based on weight and distance (replace with your logic)
        double baseCost = weight * 20; // Hypothetical base cost per unit weight for air
        // Add distance-based cost calculation here (consider using a distance API)
        return baseCost;
    }
}

public class LogisticsApp {

    public static void main(String[] args) {
        Shipment landShipment = new LandShipment("LAND-001", "Jakarta", "Bandung", 100, "Truck");
        Shipment airShipment = new AirShipment("AIR-002", "Jakarta", "Bali", 50, "Garuda Indonesia");

        System.out.println("Land Shipment Cost: $" + landShipment.calculateCost());
        System.out.println("Air Shipment Cost: $" + airShipment.calculateCost());
    }
}
