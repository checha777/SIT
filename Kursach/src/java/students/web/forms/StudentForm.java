package students.web.forms;

import java.util.Collection;
import students.view.ApplicantView;


public class StudentForm
{
    

    private Long studentId;
    private String firstName;
    private String surName;
    private String patronymic;
    private int educationYear;
    private Long professionId;
    private String professionName;
    private Collection professions;

    public void initFromStudent(ApplicantView st) {
        this.studentId = st.getApplicantId();
        this.firstName = st.getFirstName();
        this.surName = st.getLastName();
        this.patronymic = st.getMiddleName();
        this.educationYear = st.getEntranceYear();
        this.professionId = st.getProfessionId();
        this.professionName=st.getProfessionName();
        
    }

 

    public int getEducationYear() {
        return educationYear;
    }

    public void setEducationYear(int educationYear) {
        this.educationYear = educationYear;
    }

 

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

  
     public void setProfessionId(Long id) {
        this.professionId = id;
    }

    public Long getProfessionId() {
        return professionId;
        
    }
     public void setProfessionName(String name) {
        this.professionName = name;
    }

    public String getProfessionName() {
        return professionName;
        
    }
    public void setProfessions(Collection groups) {
        this.professions = groups;
    }

    public Collection getProfessions() {
        return professions;
        
    }
    
}
