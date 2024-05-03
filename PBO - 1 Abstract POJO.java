public abstract class Shipment {

  private final String origin;
  private final String destination;
  private final double weight;

  public Shipment(String origin, String destination, double weight) {
    this.origin = origin;
    this.destination = destination;
    this.weight = weight;
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

  // Abstract method to be implemented by subclasses to calculate cost
  public abstract double calculateCost();
}

public interface CostCalculator {
  // Interface defines a method to calculate cost for different shipment types
  double calculateShipmentCost(Shipment shipment);
}

public class GroundShipment extends Shipment implements CostCalculator {

  private final double distance;

  public GroundShipment(String origin, String destination, double weight, double distance) {
    super(origin, destination, weight);
    this.distance = distance;
  }

  @Override
  public double calculateShipmentCost(Shipment shipment) {
    // Sample cost calculation based on distance and weight
    return distance * shipment.getWeight() * 0.1;
  }
}

public class AirShipment extends Shipment implements CostCalculator {

  private final boolean isFragile;

  public AirShipment(String origin, String destination, double weight, boolean isFragile) {
    super(origin, destination, weight);
    this.isFragile = isFragile;
  }

  @Override
  public double calculateShipmentCost(Shipment shipment) {
    // Sample cost calculation with additional cost for fragile items
    double baseCost = shipment.getWeight() * 0.5;
    return isFragile ? baseCost * 1.2 : baseCost;
  }
}

public class LogisticsDemo 
{
  public static void main(String[] args) {
    Shipment groundShipment = new GroundShipment("Chicago", "Los Angeles", 10, 1500);
    Shipment airShipment = new AirShipment("New York", "Tokyo", 5, true);

    CostCalculator groundCostCalculator = new GroundShipment();
    CostCalculator airCostCalculator = new AirShipment();

    System.out.println("Ground Shipment Cost: $" + groundCostCalculator.calculateShipmentCost(groundShipment));
    System.out.println("Air Shipment Cost: $" + airCostCalculator.calculateShipmentCost(airShipment));
  }
}