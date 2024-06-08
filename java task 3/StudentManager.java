import java.io.*;
import java.util.*;

public class StudentManager {
    private HashMap<Integer, Student> studentMap;
    private TreeSet<Student> studentSet;

    public StudentManager() {
        studentMap = new HashMap<>();
        studentSet = new TreeSet<>();
    }

    public void addStudent(Student student) {
        if (!studentMap.containsKey(student.getId())) {
            studentMap.put(student.getId(), student);
            studentSet.add(student);
        } else {
            System.out.println("Student with ID " + student.getId() + " already exists.");
        }
    }

    public void removeStudent(int id) {
        Student student = studentMap.remove(id);
        if (student != null) {
            studentSet.remove(student);
        } else {
            System.out.println("Student with ID " + id + " not found.");
        }
    }

    public void updateStudent(int id, String name, int age, String grade, String address) {
        Student student = studentMap.get(id);
        if (student != null) {
            studentSet.remove(student);
            student.setName(name);
            student.setAge(age);
            student.setGrade(grade);
            student.setAddress(address);
            studentSet.add(student);
        } else {
            System.out.println("Student with ID " + id + " not found.");
        }
    }

    public Student searchStudent(int id) {
        return studentMap.get(id);
    }

    public void displayAllStudents() {
        for (Student student : studentSet) {
            System.out.println(student);
        }
    }

    public void loadFromFile(String filename) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            studentMap = (HashMap<Integer, Student>) ois.readObject();
            studentSet = new TreeSet<>(studentMap.values());
        } catch (FileNotFoundException e) {
            System.out.println("File not found, starting with an empty list.");
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void saveToFile(String filename) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(studentMap);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
