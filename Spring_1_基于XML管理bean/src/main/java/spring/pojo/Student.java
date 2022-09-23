package spring.pojo;

import java.util.Arrays;
import java.util.Map;

public class Student implements Person{
    private Integer id;

    private String name;

    private Integer age;

    private String gender;

    private Clazz clazz;

    private String[] hobbies;

    private Map<String, Teacher> teacherMap;

    public Student(){}

    public Student(Integer id, String name, Integer age, String gender) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    public Student(Integer id, String name, Integer age, String gender, Clazz clazz) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.clazz = clazz;
    }

    public Student(Integer id, String name, Integer age, String gender, Clazz clazz, String[] hobbies) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.clazz = clazz;
        this.hobbies = hobbies;
    }

    public Student(Integer id, String name, Integer age, String gender, Clazz clazz, String[] hobbies, Map<String, Teacher> teacherMap) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.clazz = clazz;
        this.hobbies = hobbies;
        this.teacherMap = teacherMap;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Clazz getClazz() {
        return clazz;
    }

    public void setClazz(Clazz clazz) {
        this.clazz = clazz;
    }

    public String[] getHobbies() {
        return hobbies;
    }

    public void setHobbies(String[] hobbies) {
        this.hobbies = hobbies;
    }

    public Map<String, Teacher> getTeacherMap() {
        return teacherMap;
    }

    public void setTeacherMap(Map<String, Teacher> teacherMap) {
        this.teacherMap = teacherMap;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                ", clazz=" + clazz +
                ", hobbies=" + Arrays.toString(hobbies) +
                ", teacherMap=" + teacherMap +
                '}';
    }
}
