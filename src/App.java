public class App {
    public static void main(String[] args) throws Exception {
        ColorCode cc = new ColorCode();
        System.out.println(cc.decode("47 ohms"));
        System.out.println(cc.decode("470 ohms"));
        System.out.println(cc.decode("330 ohms"));
        System.out.println(cc.decode("680 ohms"));
        System.out.println(cc.decode("1k ohms"));
        System.out.println(cc.decode("4.7k ohms"));
        System.out.println(cc.decode("47M ohms"));
    }
}
