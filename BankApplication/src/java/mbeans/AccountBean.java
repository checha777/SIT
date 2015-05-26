/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mbeans;

import entities.Account;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import sessions.AccountFacade;

/**
 *
 * @author checha777
 */
@ManagedBean
@RequestScoped
public class AccountBean {

    @EJB
    AccountFacade facade;
    
  private Account account;

    public AccountFacade getFacade() {
        return facade;
    }

    public void setFacade(AccountFacade facade) {
        this.facade = facade;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
  
    
    
    public AccountBean() {
        account=new Account();
    }
    public String actionMethod(){
      facade.openAccount(account.getOunername(),account.getBalance() );
    return "response";
    }
}
