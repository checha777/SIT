/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessions;

import entities.Account;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author checha777
 */
@Stateless
public class AccountFacade extends AbstractFacade<Account> {
    @PersistenceContext(unitName = "BankApplicationPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AccountFacade() {
        super(Account.class);
    }
    
    public Account openAccount(String ounname,int balance){
    Account account=new Account();
    account.setBalance(balance);
    account.setOunername(ounname);
    em.persist(account);
    return account;
    }
    public void deposit(int accountNumber,int amount){
    Account account =em.find(Account.class,accountNumber);
    account.deposit(amount);
    }
    
    public int withdraw(int accountNumber,int amount){
    Account account=em.find(Account.class,accountNumber);
    return account.withdraw(amount);
    }
    
    public void closeAccount(int accountNumber){
    Account account=em.find(Account.class,accountNumber);
    em.remove(account);
    }
    
    public List<Account> listAccounts(){
    Query query=em.createQuery("SELECT a FROM Account a ");
    return query.getResultList();
    }
}
