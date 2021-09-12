package _7_设计模式._04工厂方法模式;

public class Test {
    public static void main(String[] args) {
        //要换成'社区志愿者'，修改这里就可以
        IFactory factory = new UndergraduateFactory();
        LeiFeng student = factory.CreateLeiFeng();

        student.Sweep();
        student.Wash();
        student.BuyRice();
        System.out.println("\n --------------------------");

        IFactory factory2 = new VolunteerFactory();
        LeiFeng volunteer = factory2.CreateLeiFeng();

        volunteer.Sweep();
        volunteer.Wash();
        volunteer.BuyRice();
    }
}
