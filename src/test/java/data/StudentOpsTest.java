package data;

import challenges.StudentOps;
import domain.Student;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.time.LocalDate;
import java.time.Period;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class StudentOpsTest {


        private static List<Student> students;

        @BeforeEach
        void setUp() throws IOException {
            // Fetch data before all tests
            students = FetchData.getStudentList();
        }

        @AfterEach
        void tearDown() {
        	students = null;
        }
        
        //Q1

        @Test
        void shouldReturnEmptyListWhenNoStudentsMatchGender() {
            List<Student> filteredStudents = StudentOps.filterStudentsByGender(students, "Other");
            assertThat(filteredStudents).isEmpty();
        }

        @Test
        void shouldReturnListStudentsMatchingGender() {
            List<Student> filteredStudents = StudentOps.filterStudentsByGender(students, "Female");
            assertEquals("Female",filteredStudents.get(5).getGender());
        }
        
        //Q2
        
        @Test
        void shouldReturnListStudentsSortedByBirthday() {
        	List<Student> sortedStudents = StudentOps.sortStudentsByAge(students);
        	for(int i = 0; i<sortedStudents.size()-1; i++) {
        		assertTrue(sortedStudents.get(i).getDob().compareTo(sortedStudents.get(i+1).getDob())<=0);
        	}
        }
        
        //Q3
        
        @Test
        void shouldReturnCorrectAverageAge() {
        	double avg = StudentOps.calculateAverageAge(students);
        	double sum = 0;
        	Period age;
        	for(Student s:students) {
        		age = s.getDob().until(LocalDate.now());
        		sum += age.getYears()*12 + age.getMonths();
        	}
        	sum /= students.size();
        	sum /= 12;
        	assertEquals(sum,avg);
        }
        
        //Q4
        @Test
        void firstStudentNamePrintedCorrectly() {
        	
        	//https://stackoverflow.com/questions/21913408/reading-system-out-java-test
        	java.io.ByteArrayOutputStream out = new java.io.ByteArrayOutputStream(); 
        	java.io.PrintStream temp = System.out;   
        	System.setOut(new java.io.PrintStream(out));
        	
        	StudentOps.printStudentNames(students);
        	assertTrue(out.toString().contains("Kaitlyn Padden"));
        	
        	System.setOut(temp);
        	
        }
        

        @Test
        void allStudentNamePrintedCorrectly() {
        	
        	//https://stackoverflow.com/questions/21913408/reading-system-out-java-test
        	java.io.ByteArrayOutputStream out = new java.io.ByteArrayOutputStream();
        	java.io.PrintStream temp = System.out;
        	System.setOut(new java.io.PrintStream(out));
        	StringBuilder nameList =new StringBuilder();
        	
        	StudentOps.printStudentNames(students);
        	
        	char problem = out.toString().charAt(14);
        	
        	for(Student s:students) {
        		nameList.append(s.getFirst_name());
        		nameList.append(" ");
        		nameList.append(s.getLast_name());
        		nameList.append(problem);
        		nameList.append('\n');
        	}
        	
        	assertTrue(nameList.toString().equals(out.toString()));
        	
        	
        	System.setOut(temp);
        }
        
        //Q5
        @Test
        void shouldReturnStudentsGroupedByGender() {
        	Map<String,List<Student>> groups = StudentOps.groupStudentsByGender(students);
        	for(String g: groups.keySet()) {
        		for(Student s:groups.get(g)) {
        			assertEquals(s.getGender(),g);
        		}
        	}
        }
        
        //Q6
        @Test
        void shouldReturnLargestAge() {
        	double age = StudentOps.findMaximumAge(students);
        	LocalDate min = students.get(0).getDob();
        	for(Student s:students) {
        		if (s.getDob().compareTo(min)<0) {
        			min = s.getDob();
        		}
        	}
        	Period p = min.until(LocalDate.now());
        	double minAge = (p.getYears()*12+p.getMonths())/12.0;
        	assertEquals(age,minAge);
        }
        
        //Q7
        @Test
        void shouldMapIdToStudent() {
        	Map<Integer,Student> m = StudentOps.transformToMap(students);
        	for(Integer i:m.keySet()) {
        		assertEquals(i,m.get(i).getId());
        	}
        }
        
        //Q8
        @Test
        void shouldGetListOfEmails() {
        	List<String> emails = StudentOps.getStudentEmails(students);
        	for(String e:emails) {
        		assertTrue(e.contains("@"));
        	}
        }
        
        //Q9
        @Test
        void checkIfAnyStudentIsAdult() {
        	boolean isAdult = StudentOps.checkIfAnyStudentIsAdult(students);
        	Period p;
        	for(Student s:students) {
        		p = s.getDob().until(LocalDate.now());
        		if(p.getYears()*12+p.getMonths()>18*12) {
        			assertTrue(isAdult);
        			return;
        		}
        	}
        	assertFalse(isAdult);
        }
        
        //Q10
        @Test
        void checkStudentGenderCount() {
        	Map<String,Long> count = StudentOps.countStudentsByGender(students);
        	for(Student s: students) {
        		if(count.containsKey(s.getGender())){
        			if(count.get(s.getGender())<=0) {
        				assert false;
        			}
        			count.put(s.getGender(), count.get(s.getGender())-1);
        		}else {
        			assert false;
        		}
        	}
        	for(String g:count.keySet()) {
        		assertEquals(count.get(g),0);
        	}
        }
        
        //Q11
        @Test
        void checkStudentYoungestFemale() {
        	Student f = StudentOps.findYoungestFemaleStudent(students);
        	Student youngest=null;
        	for(Student s: students) {
        		if(s.getGender().equalsIgnoreCase("female")) {
        			if(youngest==null||s.getDob().compareTo(youngest.getDob())>0) {
        				youngest=s;
        			}
        		}
        	}
        	assertEquals(f,youngest);
        	
        }
        
        //Q12
        @Test
        void joinStudentNames() {
        	String joined = StudentOps.joinStudentNames(students);
        	StringBuilder build = new StringBuilder();
        	for(Student s:students) {
        		build.append(s.getFirst_name());
        	}
        	assertTrue(build.toString().equals(joined));
        }
        
        //Q13
        @Test
        void checkAgeSum() {
        	double sumOps = StudentOps.calculateAgeSum(students);
        	double sum = 0;
        	Period age;
        	for(Student s:students) {
        		age = s.getDob().until(LocalDate.now());
        		sum += age.getYears()*12 + age.getMonths();
        	}
        	sum /= 12;
        	assertEquals(sum,sumOps);
        }
        
        //Q14
        @Test
        void checkIfAllStudentsAreAdults() {
        	boolean allAdult = StudentOps.checkIfAllStudentsAreAdults(students);
        	Period p;
        	for(Student s:students) {
        		p = s.getDob().until(LocalDate.now());
        		if(p.getYears()*12+p.getMonths()<18*12) {
        			assertFalse(allAdult);
        			return;
        		}
        	}
        	assertTrue(allAdult);
        }
        
        //Q15
        @Test
        void shouldFindOldestStudent() {
        	Student old = StudentOps.findOldestStudent(students);
        	Student oldest=null;
        	for(Student s: students) {
        		
    			if(oldest==null||s.getDob().compareTo(oldest.getDob())<0) {
    				oldest=s;
    			}
        		
        	}
        	assertEquals(old,oldest);
        }
        
        //Q16
        @Test
        void checkIfAllUppercase() {
        	List<String> names = StudentOps.convertToUppercase(students);
        	for(String s: names) {
        		assertTrue(s.toUpperCase().equals(s));
        	}
        }

        @Test
        void checkIfFirstNames() {
        	List<String> names = StudentOps.convertToUppercase(students);
        	Iterator<String> it = names.iterator();
        	for(Student s: students) {
        		assertTrue(s.getFirst_name().equalsIgnoreCase(it.next()));
        	}
        }
        
        //Q17
        @Test
        void shouldReturnStudentWithId() {
        	for(Student s:students) {
        		assertEquals(s,StudentOps.findStudentById(students, s.getId()));
        	}
        }
        
        //Q18
        @Test
        void checkComputedAgeDistribution() {
        	Map<Integer, Long> distribution = StudentOps.computeAgeDistribution(students);
        	
        	int age;
        	for(Student s:students) {
        		age = LocalDate.now().getYear() - s.getDob().getYear();
        		if(distribution.containsKey(age)) {
        			if(distribution.get(age)<=0) {
        				assert false;
        			}
        			distribution.put(age, distribution.get(age)-1);
        		}else {
        			assert false;
        		}
        	}
        	
        	for(Integer i:distribution.keySet()) {
        		assertEquals(distribution.get(i),0);
        	}
        }
        
        //Q19
        @Test
        void checkStudentsGroupedByAge() {
        	Map<Integer,List<Student>> lst = StudentOps.groupStudentsByAge(students);
        	int age;
        	for(Integer i: lst.keySet()) {
        		for(Student s: lst.get(i)) {
        			age = LocalDate.now().getYear() - s.getDob().getYear();
        			assertEquals(i,age);
        		}
        	}
        }
        
        //Q20
        @Test
        void checkStandardDeviationAgeCalculation() {
        	double stdDev = 0;
        	double avg = StudentOps.calculateAverageAge(students);
        	Period p;
        	for(Student s:students) {
        		p = s.getDob().until(LocalDate.now());
        		stdDev+= Math.pow(p.getYears()+p.getMonths()/12.0 -avg,2);
        	}
        	stdDev /= students.size();
        	stdDev = Math.sqrt(stdDev);
        	//floating point arithmetic will deviate slightly. If it's Almost the same, down to 5 decimal points, then it's probably the same number.
        	assertTrue(Math.abs(stdDev-StudentOps.calculateAgeStandardDeviation(students))<0.0000001);
        }
    }

