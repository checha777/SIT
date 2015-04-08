/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package students.logic;

import javax.ejb.Local;
import students.entity.Students;

/**
 *
 * @author checha777
 */
@Local
public interface ManagementSystemLocal {

    Students getStudents(int studentId);
    
}
