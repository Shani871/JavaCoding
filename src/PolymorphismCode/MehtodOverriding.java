package PolymorphismCode;

class parent
{
    public void add(int num1,int num2)
    {
        int result1=num1+num2;
        System.out.println("Result of parent class method is "+result1);
    }
}
class child
{
    public void add(int num1,int num2)
    {
        int result2=num1-num2;
        System.out.println("Result of overridden method is "+result2);
    }
}
class MethodOverriding
{
    public static void main(String[] args)
    {
        parent obj1= new parent();
        obj1.add(7,5);
        child obj2=new child();
        obj2.add(7,5);
    }
}
