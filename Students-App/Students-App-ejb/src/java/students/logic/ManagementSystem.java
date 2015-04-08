/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package students.logic;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import students.entity.Students;

/**
 *
 * @author checha777
 */
@Stateless
public class ManagementSystem implements ManagementSystemLocal {
    @PersistenceContext(unitName = "Students-App-ejbPU")
    private EntityManager em;

    @Override
    public Students getStudents(int studentId) {
        return em.find(Students.class, studentId);
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    public void persist(Object object) {
        em.persist(object);
    }
    
}
