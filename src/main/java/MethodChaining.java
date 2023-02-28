public class MethodChaining {

    //Significance with example
    public static void main(String[] args){


        a1().a2().a3();


    }

    public static MethodChaining a1(){
        System.out.println("This is a1");
        return new MethodChaining();
    }

    public MethodChaining a2(){
        System.out.println("This is a2");
        return this;
    }

    public MethodChaining a3(){
        System.out.println("This is a3");
        return this;
    }

}
