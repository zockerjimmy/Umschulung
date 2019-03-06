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
         System.out.println("Ergebnis: ");
        System.out.println(math.faku(5));     
    }
    
    public static void main(String[] args)
    {
      Main instance = new Main();
    }
    
}