import zmath.ZMath;

public class Main
{
    ZMath math;
    public Main()
    {
      math = new ZMath();
      calc();
    }
    
    public void calc()
    {
        System.out.println(math.perc(10,0.5f));
          
    }
    
    public static void main(String[] args)
    {
      Main instance = new Main();
    }
    
}