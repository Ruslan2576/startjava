public class WolfTest {
    public static void main(String[] args) {
        Wolf myWolf = new Wolf();
        myWolf.gender = "male";
        myWolf.nickName = "Akela";
        myWolf.weight = 30;
        myWolf.age = 18;
        myWolf.color = "gray";

        System.out.println(myWolf.gender);
        System.out.println(myWolf.nickName);
        System.out.println(myWolf.weight);
        System.out.println(myWolf.age);
        System.out.println(myWolf.color);

        myWolf.move();
        myWolf.sit();
        myWolf.run();
        myWolf.howl();
        myWolf.hunt();
    }
}