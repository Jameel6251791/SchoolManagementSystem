package org.jameel.dto;

/**
 * SchoolManagementSystem class is a system for managing departments, students, teachers, and courses
 * of a school. Contains methods for adding departments, students, teachers, and courses,
 * as well as methods to find, register, and modify information related to students, teachers, and courses.
 * Also includes a methods that display all departments, students, teachers, and courses that have been added.
 *
 * @author Jameel Hassan
 */
public class SchoolManagementSystem {
    private static final int MAX_NUM_DEPARTMENT = 5;
    private static final int MAX_NUM_STUDENT = 200;
    private static final int MAX_NUM_TEACHER = 20;
    private static final int MAX_NUM_COURSE = 30;

    private String schoolName;
    private Department[] departments;
    private Student[] students;
    private Teacher[] teachers;
    private Course[] courses;
    private int departmentCounter = 0;
    private int studentCounter = 0;
    private int teacherCounter = 0;
    private int courseCounter = 0;

    /**
     * Constructor with parameter school name. Initializes department array, student array, teacher array and course array
     *
     * @param schoolName school name
     * @author Jameel Hassan
     */
    public SchoolManagementSystem(String schoolName) {
        this.schoolName = schoolName;
        this.departments = new Department[MAX_NUM_DEPARTMENT];
        this.students = new Student[MAX_NUM_STUDENT];
        this.teachers = new Teacher[MAX_NUM_TEACHER];
        this.courses = new Course[MAX_NUM_COURSE];
    }

    /**
     * Finds a department based on department ID. If it can't be found returns null
     *
     * @param departmentId department ID
     * @return department
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
     * Finds a student based on student ID. If it can't be found returns null
     *
     * @param studentId student ID
     * @return student
     * @author Jameel Hassan
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
     * Finds a teacher based on teacher ID. If it can't be found returns null
     *
     * @param teacherId teacher ID
     * @return teacher
     * @author Jameel Hassan
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
     * Finds a course based on course ID. If it can't be found returns null
     *
     * @param courseId course ID
     * @return course
     * @author Jameel Hassan
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
     * @author Jameel Hassan
     */
    public void addDepartment(String departmentName) {
        if (departmentCounter < MAX_NUM_DEPARTMENT) {
            for (int i = 0; i < departments.length; i++) {
                if (departments[i] == null) {
                    departments[i] = new Department(departmentName);
                    System.out.printf("\n%s added successfully.\n", departments[i]);
                    departmentCounter++;
                    break;
                }
            }
        } else {
            System.out.println("\nMax number of departments added");
        }
    }

    /**
     * Adds a new student
     *
     * @param lName        student's last name
     * @param fName        student's first name
     * @param departmentId student's department ID
     * @author Jameel Hassan
     */
    public void addStudent(String lName, String fName, String departmentId) {
        if (studentCounter < MAX_NUM_STUDENT) {
            for (int i = 0; i < students.length; i++) {
                if (students[i] == null) {
                    students[i] = new Student(lName, fName, findDepartment(departmentId));
                    System.out.printf("\n%s added successfully.\n", students[i]);
                    studentCounter++;
                    break;
                }
            }
        } else {
            System.out.println("\nMax number of students added");
        }
    }

    /**
     * Adds a new teacher
     *
     * @param lName        teacher's last name
     * @param fName        teacher's first name
     * @param departmentId teacher's department ID
     * @author Jameel Hassan
     */
    public void addTeacher(String lName, String fName, String departmentId) {
        if (teacherCounter < MAX_NUM_TEACHER) {
            for (int i = 0; i < teachers.length; i++) {
                if (teachers[i] == null) {
                    teachers[i] = new Teacher(lName, fName, findDepartment(departmentId));
                    System.out.printf("\n%s added successfully.\n", teachers[i]);
                    teacherCounter++;
                    break;
                }
            }
        } else {
            System.out.println("\nMax number of teachers added");
        }
    }

    /**
     * Add a new course
     *
     * @param courseName   course name
     * @param credit       course credit value
     * @param departmentId course's department ID
     * @author Jameel Hassan
     */
    public void addCourse(String courseName, double credit, String departmentId) {
        if (courseCounter < MAX_NUM_COURSE) {
            for (int i = 0; i < courses.length; i++) {
                if (courses[i] == null) {
                    courses[i] = new Course(courseName, credit, findDepartment(departmentId));
                    System.out.printf("\n%s added successfully.\n", courses[i]);
                    courseCounter++;
                    break;
                }
            }
        } else {
            System.out.println("\nMax number of courses added");
        }
    }

    /**
     * Register a student to a course based on student ID and course ID
     *
     * @param studentId student ID
     * @param courseId  student ID
     * @author Jameel Hassan
     */
    public void registerCourse(String studentId, String courseId) {
        // If a course cannot be found using findCourse method, prints warning. Registration failed.
        // Otherwise, continues method
        if (findCourse(courseId) != null) {
            Course course = findCourse(courseId);

            // if a student cannot be found using findStudent method, print warning. Registration failed.
            // Otherwise, continues method.
            if (findStudent(studentId) != null) {
                Student student = findStudent(studentId);

                if (student.getCourseNum() >= Student.MAX_COURSE_NUM) {
                    System.out.printf("\nStudent %s has already registered 5 courses, " +
                            "register course %s for student %s failed.\n", studentId, courseId, studentId);
                } else if (course.getStudentNum() >= Student.MAX_COURSE_NUM) {
                    System.out.printf("\nCourse %s has been fully registered, " +
                            "register course %s for student %s failed.\n", courseId, courseId, studentId);
                } else {
                    // Goes through all the students in the student array of the object course.
                    for (int i = 0; i < course.getStudents().length; i++) {
                        // If a student in the array matches with the student found using findStudent earlier in the method,
                        // prints warning. Registration failed. Otherwise, continues method.
                        if (course.getStudents()[i] != null && course.getStudents()[i].equals(student)) {
                            System.out.printf("\nStudent %s has already registered Course %s, register course %s " +
                                    "for student %s failed.\n", studentId, courseId, courseId, studentId);
                            return;
                        }
                        // if a student in the array is null, the null student is replaced with
                        // the student found using findStudent earlier in the method
                        if (course.getStudents()[i] == null) {
                            course.getStudents()[i] = student;
                            course.setStudentNum(course.getStudentNum() + 1);
                            break;
                        }
                    }
                    // Goes through all the courses in the course array of the object student
                    for (int i = 0; i < student.getCourses().length; i++) {
                        // if a course in the array is null, the null course is replaced with
                        // the course found using findCourse earlier in the method.
                        if (student.getCourses()[i] == null) {
                            student.getCourses()[i] = course;
                            student.setCourseNum(student.getCourseNum() + 1);
                            break;
                        }
                    }
                    System.out.printf("\nStudent %s registered to course %s successfully\n" +
                            "Latest student info: %s\nLatest course info: %s\n", studentId, courseId, student, course);
                }
            } else {
                System.out.printf("\nCannot find any student match with studentId %s, " +
                        "registration to course %s failed.\n", studentId, courseId);
            }
        } else {
            System.out.printf("\nCannot find any course match with courseId %s, " +
                    "register course for student %s failed.\n", courseId, studentId);
        }
    }

    /**
     * Assigns a teacher to a course based on teacher ID and course ID
     *
     * @param teacherId teacher ID
     * @param courseId  course ID
     * @author Jameel Hassan
     */
    public void modifyCourseTeacher(String teacherId, String courseId) {
        // if teacher cannot be found using method findTeacher, prints warning. Modification failed.
        // Otherwise, continues method.
        if (findTeacher(teacherId) != null) {
            Teacher teacher = findTeacher(teacherId);

            // if a course cannot be found using method find Course, prints warning. Modification failed.
            // Otherwise, continues method.
            if (findCourse(courseId) != null) {
                Course course = findCourse(courseId);

                // assigns the teacher to the teacher array in the object course
                course.setTeacher(teacher);
                System.out.printf("\nTeacher %s assigned successfully to course %s\n" +
                        "Latest course info: %s\n", teacherId, courseId, course);
            } else {
                System.out.printf("\nCannot find any course match with courseId %s, " +
                        "modify teacher %s for course %s failed.\n", courseId, teacherId, courseId);
            }
        } else {
            System.out.printf("\nCannot find any teacher match with teacherId %s, " +
                    "modify teacher %s for course %s failed.\n", teacherId, teacherId, courseId);
        }
    }

    /**
     * prints all departments that are nor null
     *
     * @author Jameel Hassan
     */
    public void printDepartments() {
        String departmentString = "\n";

        for (Department department : departments) {
            if (department != null) {
                departmentString += department + "\n";
            }
        }
        System.out.print("\nDisplaying departments:\n---------------------- " + departmentString);
    }

    /**
     * prints all students that are not null
     *
     * @author Jameel Hassan
     */
    public void printStudents() {
        String studentString = "\n";

        for (Student student : students) {
            if (student != null) {
                studentString += student + "\n";
            }
        }
        System.out.print("\nDisplaying students:\n----------------------" + studentString);
    }

    /**
     * prints all teachers that are not null
     *
     * @author Jameel Hassan
     */
    public void printTeacher() {
        String teacherString = "\n";

        for (Teacher teacher : teachers) {
            if (teacher != null) {
                teacherString += teacher + "\n";
            }
        }
        System.out.print("\nDisplaying teachers:\n----------------------" + teacherString);
    }

    /**
     * prints all courses that are not null
     *
     * @author Jameel Hassan
     */
    public void printCourses() {
        String courseString = "\n";

        for (Course course : courses) {
            if (course != null) {
                courseString += course + "\n";
            }
        }
        System.out.print("\nDisplaying courses:\n----------------------" + courseString);
    }
}
