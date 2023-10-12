package challenges;

import domain.Student;

import java.time.LocalDate;
import java.util.List;

public class StudentOps {
    public static List<Student> filterStudentsByGender(List<Student> students, String gender) {
        return students.stream()
                .filter(student -> student.getGender().equalsIgnoreCase(gender))
                .toList();
    }
    
    public static List<Student> sortStudentsByAge(List<Student> students){
    	
    	return students.stream().sorted((x,y)-> y.getDob().compareTo(x.getDob())).toList();
    
    }
   
}
