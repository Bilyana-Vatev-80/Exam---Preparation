package classroom;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Classroom {
    private int capacity;
    private List<Student> students;

    public Classroom (int capacity){
        this.capacity = capacity;
        this.students = new ArrayList<>();
    }

    public int getCapacity() {
        return this.capacity;
    }

    public List<Student> getStudents() {
        return this.students;
    }
    public int getStudentCount(){
        return this.students.size();
    }
    public String registerStudent(Student student){
        if(this.students.size() < getCapacity()){
            this.students.add(student);
            return "Student is already in the classroom";
        }
        return "No seats in the classroom";
    }
    public String dismissStudent(Student student){
        if(this.students.contains(student)){
            String firstName = student.getFirstName();
            String lastName = student.getLastName();
            return String.format("Removed student %s %s",firstName,lastName);
        }
        return "Student not found";
    }
    public String getSubjectInfo(String subject){
        List<Student> currentSubject = this.students.stream()
                .filter(s -> s.getBestSubject().equals(subject)).collect(Collectors.toList());
        if(currentSubject.isEmpty()){
            return "No students enrolled for the subject";
        } else {
            StringBuilder sb = new StringBuilder(String.format("Subject: %s",subject));
            sb.append(System.lineSeparator()).append("Students:").append(System.lineSeparator());
            currentSubject.forEach(s -> sb.append(s.getFirstName()).append(" ").append(s.getLastName()).append(System.lineSeparator()));
            return students.toString().trim();
        }
    }
    public Student getStudent(String firstName, String lastName){
        return this.students.stream().filter(s -> s.getFirstName().equals(firstName)&& s.getLastName().equals(lastName))
                .findFirst()
                .orElse(null);
    }
    public String getStatistics(){
        StringBuilder output = new StringBuilder(String.format("Classroom size: %d",this.students.size()));
        output.append(System.lineSeparator());
        this.students.forEach(e->output.append("==").append(e).append(System.lineSeparator()));
        return output.toString().trim();
    }
}
