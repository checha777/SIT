/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package students.web.forms;

import java.util.List;

/**
 *
 * @author checha777
 */
public class StudentResultsForm {

public Long studentId;
public Long subjectId;
public List subjects;

public int mark;
public List resultsList;

     public void setResultsList(List groups) {
        this.resultsList = groups;
    }

    public List getResultsList() {
        return resultsList;
    }
     public void setSubjects(List groups) {
        this.subjects = groups;
    }

    public List getSubjects() {
        return subjects;
    }
     public void setStudentId(Long id) {
        this.studentId = id;
    }

    public Long getStudentId() {
        return studentId;
    }
      public void setSubjectId(Long id) {
        this.subjectId = id;
    }

    public Long getSubjectId() {
        return subjectId;
    }
       public void setMark(int id) {
        this.mark = id;
    }

    public int getMark() {
        return mark;
    }
}
