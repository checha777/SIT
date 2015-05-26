
package by.bsuir;

import java.rmi.*;

public interface RmiCountries extends Remote {
    
    String findClothes(int sex,int country,int mounth)throws RemoteException;
    
}
