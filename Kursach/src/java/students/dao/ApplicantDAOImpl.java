package students.dao;

import java.util.List;
import students.entity.Applicant;
import students.entity.Profession;

public class ApplicantDAOImpl extends BaseStudentDAO implements ApplicantDAO {

    public Long addApplicant(Applicant a) {
        return (Long) template.save(a);
    }

    public void updateApplicant(Applicant a) {
        template.saveOrUpdate(a);
    }

    public void deleteApplicant(Applicant a) {
        template.delete(a);
    }

    public Applicant getApplicant(Long applicantId) {
        return (Applicant) template.load(Applicant.class, applicantId);
    }

    public List<Applicant> findApplicant() {
        return template.find("FROM Applicant ORDER BY lastName, firstName, middleName, profession.professionName, entranceYear");
    }
    public List<Applicant> findApplicantByProfessionAndYear(int year, long professionId) {
        Object []param2= {year,professionId};
        String []param1= {"year","professionId"};
        
        return template.findByNamedParam("FROM Applicant WHERE entranceYear=:year AND profession.professionId=:professionId  ORDER BY lastName, firstName, middleName, profession.professionName, entranceYear ",param1,param2);
    }
    public List<Applicant> findApplicantForProfession(Profession p) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
