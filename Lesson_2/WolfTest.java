public class WolfTest {
    public static void main(String[] args) {
        Wolf myWolf = new Wolf();
        myWolf.setGender("male");
        myWolf.setNickName("Akela");
        myWolf.setWeight(30);
        myWolf.setAge(6);
        myWolf.setColor("Gray");

        System.out.println("gender - " + myWolf.getGender());
        System.out.println("nickName - " + myWolf.getNickName());
        System.out.println("weight - " + myWolf.getWeight());
        System.out.println("age - " + myWolf.getAge());
        System.out.println("color - " + myWolf.getColor());
    }
}