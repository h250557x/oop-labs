package lab5;
// Interface (Contract for all payments)
interface Payment {
    void process();
}

class CardPayment implements Payment {
    @Override
    public void process() {
        System.out.println("Processing card payment...");
    }
}

class MobileMoneyPayment implements Payment {
    @Override
    public void process() {
        System.out.println("Processing mobile money payment...");
    }
}

class PaymentProcessor {

    // DESIGN 1: The "Bad" way using instanceof pattern matching.
    // EXPLAIN: This violates the Open/Closed Principle. If we add a new payment type,
    // we MUST come back and modify this method (add another else-if).
    public void pay(Payment p) {
        if (p instanceof CardPayment card) {
            card.process();
        } else if (p instanceof MobileMoneyPayment mobile) {
            mobile.process();
        } else {
            System.out.println("Unknown payment type");
        }
    }

    // DESIGN 2: The "Polymorphic" way.
    // EXPLAIN: This is better. The method doesn't care what type of payment it is.
    // If we add a new payment type later, this method DOES NOT need to change.
    public void polymorphicPay(Payment p) {
        p.process();
    }
}

public class PaymentDemo {
    public static void main(String[] args) {
        PaymentProcessor processor = new PaymentProcessor();

        Payment card = new CardPayment();
        Payment mobile = new MobileMoneyPayment();

        System.out.println("--- Design 1 (instanceof) ---");
        processor.pay(card);
        processor.pay(mobile);

        System.out.println("\n--- Design 2 (Polymorphic) ---");
        processor.polymorphicPay(card);
        processor.polymorphicPay(mobile);
    }
}