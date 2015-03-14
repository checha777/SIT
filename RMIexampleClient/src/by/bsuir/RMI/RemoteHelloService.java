/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package by.bsuir.RMI;

import java.rmi.*;
 
public interface RemoteHelloService extends Remote {
 
	Object sayHello(String name) throws RemoteException;
 
}
