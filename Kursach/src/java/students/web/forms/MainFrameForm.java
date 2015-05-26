package students.web.forms;

import java.util.Collection;
import java.util.List;

public class MainFrameForm
{
    private int year;
    private long professionId;
    
    private Collection students;
    private List professions;
    

    public void setYear(int year) {
        this.year = year;
    }

    public int getYear() {
        return year;
    }

    public void setStudents(Collection students) {
        this.students = students;
    }

    public Collection getStudents() {
        return students;
    }
     public void setProfessionId(long groupId) {
        this.professionId = groupId;
    }

    public long getProfessionId() {
        return professionId;
    }

    public void setProfessions(List groups) {
        this.professions = groups;
    }

    public Collection getProfessions() {
        return professions;
    }
}
