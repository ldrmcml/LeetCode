package TestQuestion;

public class MyNative
{
  public void showParms( String s, int i, boolean b )
  {
    showParms0( s, i , b );
  }
  private native void showParms0( String s, int i, boolean b );
  static
  {
    System.loadLibrary( "MyNative" );
  }
  public static void main( String[] args )
  {
    MyNative obj = new MyNative();
    obj.showParms( "Hello", 23, true );
    obj.showParms( "World", 34, false );
  }
}
