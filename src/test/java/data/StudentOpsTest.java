package data;

import challenges.StudentOps;
import domain.Student;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class StudentOpsTest {


        private static List<Student> students;

        @BeforeAll
        static void setUp() throws IOException {
            // Fetch data before all tests
            students = FetchData.getStudentList();
        }



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
        
        @Test
    	void testSortStudentsByAge() {
    		List<Student> studentsSortedByAge = StudentOps.sortStudentsByAge(students);
    		
    		studentsSortedByAge.stream().map(x->x.getDob()).toList().forEach(x->{
    			System.out.println(x);
    		});;
    		assertTrue(studentsSortedByAge.get(0).getDob().isAfter(studentsSortedByAge.get(studentsSortedByAge.size()-1).getDob()));
    	}
        
    }

