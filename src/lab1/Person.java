package lab1;
public class Person {
    String name;
    Address address; // EXPLAIN: A field that is a reference to another object

    public static void main(String[] args) {
        // Scenario 1: Person has a valid address
        Address addr = new Address("Harare", "Main Street");
        Person p1 = new Person();
        p1.name = "Tinashe";
        p1.address = addr;

        // EXPLAIN: Chained dot operator to access the city inside the address object
        System.out.println("Person 1 City: " + p1.address.city);

        // Scenario 2: Person has a null address
        Person p2 = new Person();
        p2.name = "Rudo";
        p2.address = null; // The address is explicitly set to null

        // EXPLAIN: We must check for null to avoid a NullPointerException
        if (p2.address == null) {
            System.out.println("Person 2 has no address (it is null).");
        } else {
            System.out.println("Person 2 City: " + p2.address.city);
        }
    }
}