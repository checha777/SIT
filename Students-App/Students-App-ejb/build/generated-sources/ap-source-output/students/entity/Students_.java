package students.entity;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-04-08T16:53:56")
@StaticMetamodel(Students.class)
public class Students_ { 

    public static volatile SingularAttribute<Students, Integer> studentId;
    public static volatile SingularAttribute<Students, String> firstName;
    public static volatile SingularAttribute<Students, String> patronymic;
    public static volatile SingularAttribute<Students, String> surName;
    public static volatile SingularAttribute<Students, Character> sex;
    public static volatile SingularAttribute<Students, Integer> groupId;
    public static volatile SingularAttribute<Students, Date> dateOfBirth;
    public static volatile SingularAttribute<Students, Integer> educationYear;

}