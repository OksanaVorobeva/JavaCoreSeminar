package seminar3.task2;

import java.util.Random;

public class Animal {

    static final int SWIM_FAIL=0;
    static final int SWIM_OK=1;
    static  final int SWIM_WTF=-1;

    private String type;
    private String name;
    private float maxRun;
    private float maxSwim;
    private  float maxJump;
    private final Random random=new Random();

    public Animal(String type, String name, float maxRun, float maxSwim, float maxJump) {

        float jumpDiff = random.nextFloat()*maxJump-(maxJump/2);
        float runDiff=random.nextFloat()*maxRun-(maxRun/2);
        float swimDiff = random.nextFloat()*maxSwim-(maxSwim/2);
        this.type = type;
        this.name = name;
        this.maxRun = maxRun+runDiff;
        this.maxSwim = maxSwim+swimDiff;
        this.maxJump = maxJump+jumpDiff;
    }

    public String getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public float getMaxRun() {
        return maxRun;
    }

    public float getMaxSwim() {
        return maxSwim;
    }

    public float getMaxJump() {
        return maxJump;
    }

    protected boolean run(float distance){
        return (distance<=maxRun);
    }

    protected int swim(float distance){
        return (distance<=maxSwim) ? SWIM_OK: SWIM_FAIL;
    }

    protected boolean jump(float height){
        return (height<=maxJump);
    }


}
