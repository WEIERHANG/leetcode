package interviewByHead.javabase;

public class Student extends Teacher {



    @Override
    public void teacher() {
        System.out.println("i am a Stu");
    }

    /**
     * 重粘
     *  在 Teacher 类中，teacher() 和 teacher(String subject) 是重载方法，
     *  因为它们具有相同的方法名，但参数列表不同。
     *
     * 重写 :
     *  在 Student 类中，teacher() 方法是对父类 Teacher 的 teacher() 方法的重写。
     *  重写方法提供了 Student 类的不同实现。\
     *
     *  重载是同类中方法名相同但参数不同，重写是子类对父类方法的替代实现。
     * @param args
     */
    public static void main(String[] args) {
        Teacher t = new Teacher();
        t.teacher();
        t.teacher("java");

        Student s = new Student();
        s.teacher();

    }

}
