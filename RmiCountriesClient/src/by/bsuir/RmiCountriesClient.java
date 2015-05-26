package by.bsuir;

import java.rmi.registry.*;
import java.util.Scanner;


public class RmiCountriesClient {

    public static void main(String... args) throws Exception {
        int sex,country,mounth;
        Scanner in = new Scanner(System.in);
        Registry registry = LocateRegistry.getRegistry("localhost", 2099);
        RmiCountries service = (RmiCountries) registry.lookup("sample/HelloService");
        
        System.out.println("Hello, my dear traveler!!! \n This program will help you to pick up a set of clothes to rest. Answer only 3 simple questions please.\n");
        
        System.out.println("1) Your sex? (1-men/2-women)\n");
        sex=in.nextInt();
       System.out.println(sex);
        System.out.println("2) Countries in which to want to go?\n "
                + "(1-Turkey|2-France|3-Greece|4-Britain|5-Denmark|6-Finland|7-Poland|8-Spain|9-Sweden|10-Bulgaria|11-Germany|"
                + "12-Mexico|13-The United States|14-Australia|15-Brazil|16-Egypt|17-Italy|18-Korea|19-Russia|20-China|21-Japan|22-Portugal");
        country=in.nextInt();
        
        System.out.println("3) Mounth? (1-12)\n");
        mounth=in.nextInt();

        System.out.println(service.findClothes(sex, country, mounth));

    }

}
