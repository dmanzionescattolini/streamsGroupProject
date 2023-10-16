package challenges;

import domain.Student;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StudentOps {
	
	//Q1
    public static List<Student> filterStudentsByGender(List<Student> students, String gender) {
        return students.stream()
                .filter(student -> student.getGender().equalsIgnoreCase(gender))
                .toList();
    }
    
    //Q2
    public static List<Student> sortStudentsByAge(List<Student> students){
    	return students.stream().sorted(Comparator.comparing(Student::getDob)).toList();
    }
    
    //Q3
    public static double calculateAverageAge(List<Student> students){
    	return students.stream().map(s->s.getDob().until(LocalDate.now())).collect(Collectors.averagingDouble(d->d.getYears()*12+d.getMonths()))/12;
    }
    
    //Q4
    public static void printStudentNames(List<Student> students) {
    	students.stream().forEach(s->System.out.println(s.getFirst_name()+" "+s.getLast_name()));
    }
    
    //Q5
    public static Map<String, List<Student>> groupStudentsByGender(List<Student> students){
    	return students.stream().collect(Collectors.groupingBy(Student::getGender));
    }
}
