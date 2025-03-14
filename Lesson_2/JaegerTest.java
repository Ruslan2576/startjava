public class JaegerTest {
    public static void main(String[] args) {
        Jaeger gipsyDanger = new Jaeger();

        gipsyDanger.setModelName("Gipsy Danger");
        gipsyDanger.setMark("Mark-3");
        gipsyDanger.setOrigin("USA");
        gipsyDanger.setHeight(260f);
        gipsyDanger.setWeight(1.980f);
        gipsyDanger.setStrength(8);
        gipsyDanger.setArmour(6);
        gipsyDanger.setSpeed(7);

        System.out.println("Model name: " + gipsyDanger.getModelName());
        System.out.println("Mark: " + gipsyDanger.getMark());
        System.out.println("Origin: " + gipsyDanger.getOrigin());
        System.out.println("Height: " + gipsyDanger.getHeight() + "ft(76.2m)");
        System.out.printf("Weight: %.3f tons%n", gipsyDanger.getWeight());
        System.out.println("Strength: " + gipsyDanger.getStrength());
        System.out.println("Armour: " + gipsyDanger.getArmour());
        System.out.println("Speed: " + gipsyDanger.getSpeed());
        System.out.println("Can I drift?: " + gipsyDanger.drift());
        gipsyDanger.move();
        System.out.println("I can " + gipsyDanger.scanKaiju());
        gipsyDanger.useVortexCannon();

        Jaeger strikerEureka = new Jaeger("Striker Eureka", "Mark-5", "Australia", 250, 6650, 10, 9, 10);
        System.out.println("\nModel name: " + strikerEureka.getModelName());
        System.out.println("Mark: " + strikerEureka.getMark());
        System.out.println("Origin: " + strikerEureka.getOrigin());
        System.out.println("Height: " + strikerEureka.getHeight() + " ft(79.25m)");
        System.out.println("Weight: " + strikerEureka.getWeight() + " tons");
        System.out.println("Strength: " + strikerEureka.getStrength());
        System.out.println("Armour: " + strikerEureka.getArmour());
        System.out.println("Speed: " + strikerEureka.getSpeed());
        System.out.println("Can I drift?: " + strikerEureka.drift());
        strikerEureka.move();
        System.out.println("I can " + strikerEureka.scanKaiju());
        strikerEureka.useVortexCannon();
    }
}