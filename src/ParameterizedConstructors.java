public class ParameterizedConstructors {
    int rollNO;
    String Name;
    ParameterizedConstructors(int i ,String n){
        rollNO = i;
        Name=n;
    }
    void Display(){
        System.out.println("Student Roll Number :"+rollNO);
        System.out.println("Student Name :"+Name);
    }

    public static void main(String[] args) {
        ParameterizedConstructors p = new ParameterizedConstructors(1,"SHani");
        ParameterizedConstructors s = new ParameterizedConstructors(2,"Rohan");
        p.Display();
        s.Display();
    }
}
