package zmath;

public class ZMath
{
  public int add(int v1, int v2)
  {
      return v1 + v2;
  }
  
  public double add(double v1, double v2)
  {
      return v1 + v2;
  }
  
  public float add(float v1, float v2)
  {
      return v1 + v2;
  }
   
//#############################################################################
   
  public int sub(int v1, int v2)
  {
      return v1 - v2;
  }
  
  public double sub(double v1, double v2)
  {
      return v1 - v2;
  }
  
  public float sub(float v1, float v2)
  {
      return v1 - v2;
  }
     
//#############################################################################
   
  public int mult(int v1, int v2)
  {
      return v1 * v2;
  }
  
  public double mult(double v1, double v2)
  {
      return v1 * v2;
  }
  
  public float mult(float v1, float v2)
  {
      return v1 * v2;
  }
       
//#############################################################################
   
  public int div(int v1, int v2)
  {
      return v1 / v2;
  }
  
  public double div(double v1, double v2)
  {
      return v1 / v2;
  }
  
  public float div(float v1, float v2)
  {
      return v1 / v2;
  }
         
//#############################################################################
   
  public int mod(int v1, int v2)
  {
      return v1 % v2;
  }
  
  public double mod(double v1, double v2)
  {
      return v1 % v2;
  }
  
  public float mod(float v1, float v2)
  {
      return v1 % v2;
  }
  
           
//#############################################################################
   
  public int perc(int v1, int v2)
  {
      float t1 = (float)v1, t2 = (float)v2;
      return (int)((t1 / 100) * t2);
  }
  
  public float perc(float v1, int v2)
  {
      return ((v1 / 100) * v2);
  }
   
  public double perc(double v1, int v2)
  {
      return ((v1 / 100) * v2);
  }
//############################################################################# 
  public int perc(int v1, float v2)
  {
     return (int)(v1 * v2);
  }
  
  public double perc(double v1, float v2)
  {
      return v1 * v2;
  }
   
  public float perc(float v1, float v2)
  {
      return v1 * v2;
  }

//#############################################################################
  
  
}
