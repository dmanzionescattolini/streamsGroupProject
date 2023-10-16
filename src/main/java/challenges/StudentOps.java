package challenges;

import domain.Student;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collector;
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
    	return students.stream().map(s->s.getDob().until(LocalDate.now())).map(p->12*p.getYears()+p.getMonths()).anyMatch(a->a>18*12);
    }
    
    //Q10
    public static Map<String,Long> countStudentsByGender(List<Student> students){
    	return students.stream().collect(Collectors.groupingBy(Student::getGender,Collectors.counting()));
    }
    
    //Q11
    public static Student findYoungestFemaleStudent(List<Student> students) {
    	return students.stream().filter(s->s.getGender().equalsIgnoreCase("Female")).max(Comparator.comparing(Student::getDob)).orElseGet(null);
    }
    
    //Q12
    public static String joinStudentNames(List<Student> students) {
    	return students.stream().map(Student::getFirst_name).reduce("",(a,b)->a+b);
    }
    
    //Q13
    public static double calculateAgeSum(List<Student> students) {
    	return students.stream().map(s->s.getDob().until(LocalDate.now())).map(p->12*p.getYears()+p.getMonths()).reduce(0,Integer::sum)/12.0;
    }
    
    //Q14
    public static boolean checkIfAllStudentsAreAdults(List<Student> students) {
    	return students.stream().map(s->s.getDob().until(LocalDate.now())).map(p->12*p.getYears()+p.getMonths()).allMatch(a->a>18*12);
    }
    
    //Q15
    public static Student findOldestStudent(List<Student> students) {
    	return students.stream().min(Comparator.comparing(Student::getDob)).orElseGet(null);
    }
    
    //Q16
    //Since I can't change student names, I assume you just want a list returned?
    public static List<String> convertToUppercase(List<Student> students){
    	//students.stream().forEach(s->s.setFirst_name(s.getFirst_name().toUpperCase()));
    	return students.stream().map(s->s.getFirst_name().toUpperCase()).toList();
    }
    
    //Q17
    public static Student findStudentById(List<Student> students, int id) {
    	return students.stream().filter(s->s.getId()==id).findFirst().orElse(null);
    }
    
    //Helper function for 18 and 19
    public static int getAge(Student s) {
    	return LocalDate.now().getYear() - s.getDob().getYear();
    }
    
    //Q18
    public static Map<Integer,Long> computeAgeDistribution(List<Student> students){
    	return students.stream().collect(Collectors.groupingBy(s->LocalDate.now().getYear() - s.getDob().getYear(),Collectors.counting()));
    	//return students.stream().collect(Collectors.groupingBy(s->StudentOps.getAge(s),Collectors.counting()));
    }
    
    //Q19
    //I'm going to round down to the nearest year, so there's Some overlap
    public static Map<Integer,List<Student>> groupStudentsByAge(List<Student> students){
    	return students.stream().collect(Collectors.groupingBy(s->LocalDate.now().getYear() - s.getDob().getYear(),Collectors.toList()));
    	//return students.stream().collect(Collectors.groupingBy(s->StudentOps.getAge(s),Collectors.toList()));
    }
    
    //Q20
    public static double calculateAgeStandardDeviation(List<Student> students) {
    	double avg = StudentOps.calculateAverageAge(students);
    	return Math.sqrt(students.stream().map(s->s.getDob().until(LocalDate.now())).map(p->p.getYears()+p.getMonths()/12.0 - avg).collect(Collectors.averagingDouble((p-> Math.pow(p,2)))));
    }
    
}
