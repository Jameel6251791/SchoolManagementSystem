package org.jameel.dto;

public class SchoolManagementSystem {
    private static final int MAX_NUM_DEPARTMENT = 5;
    private static final int MAX_NUM_STUDENT = 200;
    private static final int MAX_NUM_TEACHER = 20;
    private static final int MAX_NUM_COURSE = 30;

    private Department[] departments;
    private Student[] students;
    private Teacher[] teachers;
    private Course[] courses;
    private int departmentCounter = 0;
    private int studentCounter = 0;
    private int teacherCounter = 0;
    private int courseCounter = 0;

    public SchoolManagementSystem() {
        this.departments = new Department[MAX_NUM_DEPARTMENT];
        this.students = new Student[MAX_NUM_STUDENT];
        this.teachers = new Teacher[MAX_NUM_TEACHER];
        this.courses = new Course[MAX_NUM_COURSE];
    }

    /**
     * Finds a department based on department ID
     *
     * @param departmentId department ID
     */
    public Department findDepartment(String departmentId) {
        for (Department department : departments) {
            if (department != null) {
                if (department.getId().equals(departmentId)) {
                    return department;
                }
            }
        }
        return null;
    }

    /**
     * Finds a student based on student ID
     *
     * @param studentId student ID
     */
    public Student findStudent(String studentId) {
        for (Student student : students) {
            if (student != null) {
                if (student.getId().equals(studentId)) {
                    return student;
                }
            }
        }
        return null;
    }

    /**
     * Finds a teacher based on teacher ID
     *
     * @param teacherId teacher ID
     */
    public Teacher findTeacher(String teacherId) {
        for (Teacher teacher : teachers) {
            if (teacher != null) {
                if (teacher.getId().equals(teacherId)) {
                    return teacher;
                }
            }
        }
        return null;
    }

    /**
     * Finds a course based on course ID
     *
     * @param courseId course ID
     */
    public Course findCourse(String courseId) {
        for (Course course : courses) {
            if (course != null) {
                if (course.getId().equals(courseId)) {
                    return course;
                }
            }
        }
        return null;
    }

    /**
     * Adds a new department
     *
     * @param departmentName department name
     */
    public void addDepartment(String departmentName) {
        if (departmentCounter < MAX_NUM_DEPARTMENT) {
            for (int i = 0; i < departments.length; i++) {
                if (departments[i] == null) {
                    departments[i] = new Department(departmentName);
                    departmentCounter++;
                    break;
                }
            }
        } else {
            System.out.println("Max number of departments added");
        }
    }

    /**
     * Adds a new student
     *
     * @param lName        student's last name
     * @param fName        student's first name
     * @param departmentId student's department ID
     */
    public void addStudent(String lName, String fName, String departmentId) {
        if (studentCounter < MAX_NUM_STUDENT) {
            for (int i = 0; i < students.length; i++) {
                if (students[i] == null) {
                    students[i] = new Student(lName, fName, findDepartment(departmentId));
                    studentCounter++;
                    break;
                }
            }
        } else {
            System.out.println("Max number of students added");
        }
    }

    /**
     * Adds a new teacher
     *
     * @param lName        teacher's last name
     * @param fName        teacher's first name
     * @param departmentId teacher's department ID
     */
    public void addTeacher(String lName, String fName, String departmentId) {
        if (teacherCounter < MAX_NUM_TEACHER) {
            for (int i = 0; i < teachers.length; i++) {
                if (teachers[i] == null) {
                    teachers[i] = new Teacher(lName, fName, findDepartment(departmentId));
                    teacherCounter++;
                    break;
                }
            }
        } else {
            System.out.println("Max number of teachers added");
        }
    }

    /**
     * Add a new course
     *
     * @param courseName   course name
     * @param credit       course credit value
     * @param departmentId course's department ID
     */
    public void addCourse(String courseName, double credit, String departmentId) {
        if (courseCounter < MAX_NUM_COURSE) {
            for (int i = 0; i < courses.length; i++) {
                if (courses[i] == null) {
                    courses[i] = new Course(courseName, credit, findDepartment(departmentId));
                    courseCounter++;
                    break;
                }
            }
        } else {
            System.out.println("Max number of courses added");
        }
    }

    /**
     * Register a student to a course based on student ID and course ID
     *
     * @param studentId student ID
     * @param courseId  student ID
     */
    public void registerCourse(String studentId, String courseId) {
        if (findCourse(courseId) != null) {
            Course course = findCourse(courseId);

            if (findStudent(studentId) != null) {
                Student student = findStudent(studentId);

                if (student.getCourseNum() >= Student.MAX_COURSE_NUM) {
                    System.out.printf("Max number of courses reached for student %s %s\n", student.getFName(), student.getLName());
                } else if (course.getStudentNum() >= Student.MAX_COURSE_NUM) {
                    System.out.printf("Max number of students in course: %s\n", course.getCourseName());
                } else {
                    for (int i = 0; i < course.getStudents().length; i++) {
                        if (student.getCourses()[i] != null && student.getCourses()[i].equals(course)) {
                            System.out.printf("Student: %s %s already registered to this course: %s\n", student.getFName(), student.getLName(), course.getCourseName());
                            return;
                        }
                        if (course.getStudents()[i] == null) {
                            course.getStudents()[i] = student;
                            course.setStudentNum(course.getStudentNum() + 1);
                            break;
                        }
                    }

                    for (int i = 0; i < student.getCourses().length; i++) {
                        if (student.getCourses()[i] == null) {
                            student.getCourses()[i] = course;
                            student.setCourseNum(student.getCourseNum() + 1);
                            break;
                        }
                    }
                    System.out.printf("Student: %s %s registered successfully to course: %s\n", student.getFName(), student.getLName(), course.getCourseName());
                }
            } else {
                System.out.println("Invalid Student ID");
            }
        } else {
            System.out.println("Invalid Course ID");
        }
    }

    /**
     * Assigns a teacher to a course based on teacher ID and course ID
     *
     * @param teacherId teacher ID
     * @param courseId  course ID
     */
    public void modifyCourseTeacher(String teacherId, String courseId) {
        if (findTeacher(teacherId) != null) {
            Teacher teacher = findTeacher(teacherId);

            if (findCourse(courseId) != null) {
                Course course = findCourse(courseId);

                for (Course cours : courses) {
                    if (cours != null && cours.getTeacher() != null && cours.getTeacher().equals(teacher)) {
                        cours.setTeacher(null);
                        System.out.printf("Teacher, %s %s unassigned from course, %s. ", teacher.getFName(), teacher.getLName(), cours.getCourseName());
                    }
                }

                for (Teacher teach : teachers) {
                    if (teach != null && teach.getCourse() != null && teach.getCourse().equals(course)) {
                        teach.setCourse(null);
                        System.out.printf("Teacher, %s %s unassigned from course, %s. ", teach.getFName(), teach.getLName(), course.getCourseName());
                    }
                }

                teacher.setCourse(course);
                course.setTeacher(teacher);
                System.out.printf("Teacher: %s %s assigned successfully to course: %s\n", teacher.getFName(), teacher.getLName(), course.getCourseName());

            } else {
                System.out.println("Invalid Course ID");
            }
        } else {
            System.out.println("Invalid Teacher ID");
        }

    }

    /**
     * prints all departments
     */
    public void printDepartments() {
        String departmentString = "\n";

        for (Department department : departments) {
            if (department != null) {
                departmentString += department + "\n";
            }
        }
        System.out.println("Displaying departments: " + departmentString);
    }

    /**
     * prints all students
     */
    public void printStudents() {
        String studentString = "\n";

        for (Student student : students) {
            if (student != null) {
                studentString += student + "\n";
            }
        }
        System.out.println("Displaying students: " + studentString);
    }

    /**
     * prints all teachers
     */
    public void printTeacher() {
        String teacherString = "\n";

        for (Teacher teacher : teachers) {
            if (teacher != null) {
                teacherString += teacher + "\n";
            }
        }
        System.out.println("Displaying teachers: " + teacherString);

    }

    /**
     * prints all courses
     */
    public void printCourses() {
        String courseString = "\n";

        for (Course course : courses) {
            if (course != null) {
                courseString += course + "\n";
            }
        }
        System.out.println("Displaying courses: " + courseString);
    }
}
