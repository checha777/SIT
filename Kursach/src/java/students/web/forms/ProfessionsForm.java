/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package students.web.forms;


import java.util.Collection;
import java.util.List;


/**
 *
 * @author checha777
 */
public class ProfessionsForm {
   
    private List professions;
    private List subjects;
   
    public void setSubjects(List groups) {
        this.subjects = groups;
    }

    public List getSubjects() {
        return subjects;
    }
    public void setProfessions(List groups) {
        this.professions = groups;
    }

    public List getProfessions() {
        return professions;
    }
}
