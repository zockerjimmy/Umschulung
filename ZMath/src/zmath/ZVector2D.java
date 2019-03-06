package zmath;

public class ZVector2D
{
    float x;
    float y;
    
    public ZVector2D()
    {
        this.x = 0f;
        this.y = 0f;
    }
    
    public ZVector2D(float v1, float v2)
    {
        this.x = v1;
        this.y = v2;
    }
    
//##############################################################################
    
    public ZVector2D Vector2DAdd(ZVector2D v1, ZVector2D v2)
    {
    ZVector2D result = new ZVector2D();
    result.x = v1.x + v2.x;
    result.y = v1.y + v2.y;
    return result;
    }
  
    public ZVector2D Vector2DAdd(float xv1, float xv2, float yv1, float yv2)
    {
    ZVector2D result = new ZVector2D();
    result.x = xv1 + xv2;
    result.y = yv1 + yv2;
    return result;
    }
}
