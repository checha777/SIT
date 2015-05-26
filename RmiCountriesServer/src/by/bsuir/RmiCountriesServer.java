package by.bsuir;

import java.rmi.*;
import java.rmi.registry.*;
import java.rmi.server.*;

public class RmiCountriesServer implements RmiCountries {

    public static final String BINDING_NAME = "sample/HelloService";

    @Override
    public String findClothes (int sex, int country, int mounth) throws IllegalAccessError {
        
        if(sex>2) throw new IllegalArgumentException("ERROR TEACHER");
            int setClothes = 0;
        String clothes = null;

        switch (country) {
            case 1:
                if ((mounth < 3) || (mounth > 10)) {
                    setClothes = 3;
                } else {
                    setClothes = 4;
                }
                break;
            case 2:
                if ((mounth < 3) || (mounth > 10)) {
                    setClothes = 2;
                }
                else{
                if (((mounth >= 3) && (mounth <= 6))) {
                    setClothes = 3;
                }
                else{
                if (((mounth >= 9) && (mounth <= 10))) {
                    setClothes = 3;
                } else {
                    setClothes = 4;
                }}}
                break;
            case 3:
                if ((mounth < 3) || (mounth > 10)) {
                    setClothes = 3;
                } else {
                    setClothes = 4;
                }
                break;
            case 4:
                if ((mounth < 3) || (mounth > 10)) {
                    setClothes = 2;
                }
                else{
                if (((mounth >= 3) && (mounth <= 6))) {
                    setClothes = 3;
                }
                else{
                if (((mounth >= 9) && (mounth <= 10))) {
                    setClothes = 3;
                } else {
                    setClothes = 4;
                }}}
                break;
            case 5:
                if ((mounth < 3) || (mounth > 10)) {
                    setClothes = 2;
                }
                else{
                if (((mounth >= 3) && (mounth <= 6))) {
                    setClothes = 3;
                }
                else{
                if (((mounth >= 9) && (mounth <= 10))) {
                    setClothes = 3;
                } else {
                    setClothes = 4;
                }}}
                break;
            case 6:
                if ((mounth < 3) || (mounth > 10)) {
                    setClothes = 1;
                }
                else{
                if (((mounth >= 3) && (mounth <= 6))) {
                    setClothes = 2;
                }
                else{
                if (((mounth >= 9) && (mounth <= 10))) {
                    setClothes = 2;
                } else {
                    setClothes = 3;
                }}}
                break;
            case 7:
                if ((mounth < 3) || (mounth > 10)) {
                    setClothes = 2;
                }
                else{
                if (((mounth >= 3) && (mounth <= 6))) {
                    setClothes = 3;
                }
                else{
                if (((mounth >= 9) && (mounth <= 10))) {
                    setClothes = 3;
                } else {
                    setClothes = 4;
                }}}
                break;
            case 8:
              if ((mounth < 3) || (mounth > 10)) {
                    setClothes = 2;
                }
                else{
                if (((mounth >= 3) && (mounth <= 6))) {
                    setClothes = 3;
                }
                else{
                if (((mounth >= 9) && (mounth <= 10))) {
                    setClothes = 3;
                } else {
                    setClothes = 4;
                }}}
                break;
            case 9:
                if ((mounth < 3) || (mounth > 10)) {
                    setClothes = 1;
                }
                else{
                if (((mounth >= 3) && (mounth <= 6))) {
                    setClothes = 2;
                }
                else{
                if (((mounth >= 9) && (mounth <= 10))) {
                    setClothes = 2;
                } else {
                    setClothes = 3;
                }}}
                break;
            case 10:
                if ((mounth < 3) || (mounth > 10)) {
                    setClothes = 2;
                }
                else{
                if (((mounth >= 3) && (mounth <= 6))) {
                    setClothes = 3;
                }
                else{
                if (((mounth >= 9) && (mounth <= 10))) {
                    setClothes = 3;
                } else {
                    setClothes = 4;
                }}}
                break;
            case 11:
              if ((mounth < 3) || (mounth > 10)) {
                    setClothes = 2;
                }
                else{
                if (((mounth >= 3) && (mounth <= 6))) {
                    setClothes = 3;
                }
                else{
                if (((mounth >= 9) && (mounth <= 10))) {
                    setClothes = 3;
                } else {
                    setClothes = 4;
                }}}
                break;
            case 12:
                setClothes = 4;
                break;
            case 13:
                clothes = "USA-very diffierent-temperature country. You need to take diffierent types of clothes";
                break;
            case 14:
               if ((mounth < 3) || (mounth > 10)) {
                    setClothes = 4;
                }
                else{
                if (((mounth >= 3) && (mounth <= 6))) {
                    setClothes = 3;
                }
                else{
                if (((mounth >= 9) && (mounth <= 10))) {
                    setClothes = 3;
                } else {
                    setClothes = 2;
                }}}
                break;
            case 15:
                setClothes = 4;
                break;
            case 16:
                if ((mounth < 3) || (mounth > 10)) {
                    setClothes = 3;
                } else {
                    setClothes = 4;
                }
                break;
            case 17:
                if ((mounth < 3) || (mounth > 10)) {
                    setClothes = 2;
                }
                else{
                if (((mounth >= 3) && (mounth <= 6))) {
                    setClothes = 3;
                }
                else{
                if (((mounth >= 9) && (mounth <= 10))) {
                    setClothes = 3;
                } else {
                    setClothes = 4;
                }}}
                break;
            case 18:
                if ((mounth < 3) || (mounth > 10)) {
                    setClothes = 2;
                }
                else{
                if (((mounth >= 3) && (mounth <= 6))) {
                    setClothes = 3;
                }
                else{
                if (((mounth >= 9) && (mounth <= 10))) {
                    setClothes = 3;
                } else {
                    setClothes = 4;
                }}}
                break;
            case 19:
                clothes = "Russia-very diffierent-temperature country. You need to take diffierent types of clothes";
                break;
            case 20:
               if ((mounth < 3) || (mounth > 10)) {
                    setClothes = 2;
                }
                else{
                if (((mounth >= 3) && (mounth <= 6))) {
                    setClothes = 3;
                }
                else{
                if (((mounth >= 9) && (mounth <= 10))) {
                    setClothes = 3;
                } else {
                    setClothes = 4;
                }}}
                break;
            case 21:
                if ((mounth < 3) || (mounth > 10)) {
                    setClothes = 2;
                }
                else{
                if (((mounth >= 3) && (mounth <= 6))) {
                    setClothes = 3;
                }
                else{
                if (((mounth >= 9) && (mounth <= 10))) {
                    setClothes = 3;
                } else {
                    setClothes = 4;
                }}}
                break;
            case 22:
                if ((mounth < 3) || (mounth > 10)) {
                    setClothes = 2;
                }
                else{
                if (((mounth >= 3) && (mounth <= 6))) {
                    setClothes = 3;
                }
                else{
                if (((mounth >= 9) && (mounth <= 10))) {
                    setClothes = 3;
                } else {
                    setClothes = 4;
                }}}
                break;
            default:
                clothes = "ERROR";
        }
        switch(setClothes){
            case 1: if(sex==1)clothes="This time of year the weather is cold. It is recommended to wear a winter jacket, insulated boots, and thick cap.";
            else clothes="This time of year the weather is cold. It is recommended to wear a fur coat, insulated boots, and thick cap.";
                break;
            case 2: if(sex==1)clothes="This time of year the weather is semi-cool. It is recommended to wear a light jacket. You can also wear a sweater or a bike. You can walk without a hat. Conventional tight pants or thick pantyhose. Of the shoe is recommended to choose running shoes or closed boots.";
            else clothes="";
            break;    
            case 3: if(sex==1)clothes="This time of year the weather is warm. You can wear light pants or even shorts. Shirt or tank top. headdress discretion. it need not. Of the shoe is recommended to wear lightweight boots.";
            else clothes="This time of year the weather is warm. You can wear light pants, shorts or a skirt. Shirt, T-shirt or blouse. The dress will approached. headdress discretion. The need is not there. Of the shoe is recommended to wear light boots(pamps,hills or sandals)";
                break;
            case 4:if(sex==1)clothes="At this time the weather is very hot. It is recommended to wear only light shirts and shorts. Also required the head rev and sunglasses. At the foot should wear sandals and flip flops.";
            else clothes="At this time the weather is very hot. It is recommended to wear only light shirts, shorts, dresses. Also required the head rev and sunglasses. At the foot should wear sandals and flip flops. Bikini is imperative! Pareo can take the girl modestly.";
                break;
                default: ;
        }
        return clothes;
    }

    public static void main(String... args) throws Exception {
        
        System.out.print("Starting registry...");
        final Registry registry = LocateRegistry.createRegistry(2099);
        System.out.println(" OK");

        final RmiCountries service = new RmiCountriesServer();
        Remote stub = UnicastRemoteObject.exportObject(service, 0);

        System.out.print("Binding service...");
        registry.bind(BINDING_NAME, stub);
        System.out.println(" OK");

        
    }

}
