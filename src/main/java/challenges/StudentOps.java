package challenges;

import domain.Student;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
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
    
    //Q6
    public static double findMaximumAge(List<Student> students) {
    	Optional<Integer> eldest = students.stream().map(s->s.getDob().until(LocalDate.now())).map(p->12*p.getYears()+p.getMonths()).max(Comparator.naturalOrder());
    	if(eldest.isEmpty()) {
    		return 0.0;
    	}
    	return eldest.get()/12.0;
    }
    
    //Q7
    public static Map<Integer,Student> transformToMap(List<Student> students){
    	return students.stream().collect(Collectors.toMap(Student::getId, s->s));
    }
    
    //Q8
    public static List<String> getStudentEmails(List<Student> students){
    	return students.stream().map(s->s.getEmail()).toList();
    }
    
    //Q9
    public static boolean checkIfAnyStudentIsAdult(List<Student> students) {
    	return students.stream().map(s->s.getDob().until(LocalDate.now())).map(p->12*p.getYears()+p.getMonths()).anyMatch(a->a>18);
    }
    
    //Q10
    public static Map<String,Long> countStudentsByGender(List<Student> students){
    	return students.stream().collect(Collectors.groupingBy(Student::getGender,Collectors.counting()));
    }
}
