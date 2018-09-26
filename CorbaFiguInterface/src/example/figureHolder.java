package example;


public final class figureHolder implements org.omg.CORBA.portable.Streamable
{
  public example.figure value = null;

  public figureHolder ()
  {
  }

  public figureHolder (example.figure initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = example.figureHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    example.figureHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return example.figureHelper.type ();
  }

}
