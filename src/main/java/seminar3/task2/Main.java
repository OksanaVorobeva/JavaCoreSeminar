package seminar3.task2;

public class Main {
    public static void main(String[] args) {
        Cat c= new Cat("Barsek");
        Cat c0=new Cat("Moorzeek");
        Dog d= new Dog("Toozeek",0.5f,500,10);
        Dog d0= new Dog("Sheareek",0.5f,500,10);

        Animal[] arr={c,c0,d,d0};
        float toJump=1.5f;
        float toRun = 350;
        float toSwim=5;

        for (int i = 0; i < arr.length; i++) {
            String nameString = arr[i].getType()+" "+arr[i].getName()+"can";

            String eventName = String.format("jump max%.2fm. Tries to jump", arr[i].getMaxJump());
            String eventResult=(arr[i].jump(toJump)) ? "succeed": "fails";
            System.out.println(nameString+eventName+toJump+"m and"+eventResult);

            eventName=String.format("run max %2fm. Tries to run", arr[i].getMaxRun());
            eventResult=arr[i].run(toRun)?"succeed": "fails";
            System.out.println(nameString+eventName+toRun+"m and"+eventResult);

            int swimResult=arr[i].swim(toSwim);
            eventName = String.format("run max %2fm. Tries to swim", arr[i].getMaxSwim());
            eventResult=(swimResult==Animal.SWIM_OK)?"succeed": "fails";
            if (swimResult==Animal.SWIM_WTF){
                eventResult="to scared to enter the water";
            }
            System.out.println(nameString+eventName+toSwim+"m and"+eventResult);
        }



    }
}
