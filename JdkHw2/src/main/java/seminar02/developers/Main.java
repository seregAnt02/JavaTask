package seminar02.developers;

public class Main {
    public static void main(String[] args) {
        Backender backender = new Backender("John", 33);
        Frontender fronender = new Frontender("Bob", 22);
        Fullstack fullstackDeveloper = new Fullstack("Mike", 44);
        Backendable fullstack2 = new Fullstack("Nick", 55);

        System.out.println("Backender try work!");
        backender.doBackendWork();
        backender.doFrontendWork();

        System.out.println("Frontender try work!");
        fronender.doBackendWork();
        fronender.doFrontendWork();

        System.out.println("Fullstack-developer try work!");
        fullstackDeveloper.doBackendWork();
        fullstackDeveloper.doFrontendWork();

        fullstack2.doBackendWork();
    }
}
