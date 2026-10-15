package lab4;
public class Teacher extends Person { // EXPLAIN: Teacher IS-A Person
    private String subject;

    public Teacher(String name, int age, String subject) {
        super(name, age);
        this.subject = subject;
    }

    // EXPLAIN: Overriding to add the subject taught
    @Override
    public void display() {
        super.display();
        System.out.println("Subject: " + subject);
    }
}