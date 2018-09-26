package example;


public abstract class figurePOA extends org.omg.PortableServer.Servant
 implements example.figureOperations, org.omg.CORBA.portable.InvokeHandler
{

  // Constructors

  private static java.util.Hashtable _methods = new java.util.Hashtable ();
  static
  {
    _methods.put ("generar", new java.lang.Integer (0));
    _methods.put ("areaCubo", new java.lang.Integer (1));
    _methods.put ("volumenCubo", new java.lang.Integer (2));
    _methods.put ("areaParalelepipedo", new java.lang.Integer (3));
    _methods.put ("volumenParalelepipedo", new java.lang.Integer (4));
    _methods.put ("areaCilindro", new java.lang.Integer (5));
    _methods.put ("volumenCilindro", new java.lang.Integer (6));
    _methods.put ("areaEsfera", new java.lang.Integer (7));
    _methods.put ("volumenEsfera", new java.lang.Integer (8));
  }

  public org.omg.CORBA.portable.OutputStream _invoke (String $method,
                                org.omg.CORBA.portable.InputStream in,
                                org.omg.CORBA.portable.ResponseHandler $rh)
  {
    org.omg.CORBA.portable.OutputStream out = null;
    java.lang.Integer __method = (java.lang.Integer)_methods.get ($method);
    if (__method == null)
      throw new org.omg.CORBA.BAD_OPERATION (0, org.omg.CORBA.CompletionStatus.COMPLETED_MAYBE);

    switch (__method.intValue ())
    {

  /*
        * Para generar
        * in: el valor del parametro se lo envia el cliente al servidor
        * long: -231..231-1 (32 bits)
        * numero: nombre de la variable
        */
       case 0:  // example/figure/generar
       {
         int numero = in.read_long ();
         String $result = null;
         $result = this.generar (numero);
         out = $rh.createReply();
         out.write_string ($result);
         break;
       }

       case 1:  // example/figure/areaCubo
       {
         double a = in.read_double ();
         double $result = (double)0;
         $result = this.areaCubo (a);
         out = $rh.createReply();
         out.write_double ($result);
         break;
       }

       case 2:  // example/figure/volumenCubo
       {
         double a = in.read_double ();
         double $result = (double)0;
         $result = this.volumenCubo (a);
         out = $rh.createReply();
         out.write_double ($result);
         break;
       }

       case 3:  // example/figure/areaParalelepipedo
       {
         double a = in.read_double ();
         double b = in.read_double ();
         double c = in.read_double ();
         double $result = (double)0;
         $result = this.areaParalelepipedo (a, b, c);
         out = $rh.createReply();
         out.write_double ($result);
         break;
       }

       case 4:  // example/figure/volumenParalelepipedo
       {
         double a = in.read_double ();
         double b = in.read_double ();
         double c = in.read_double ();
         double $result = (double)0;
         $result = this.volumenParalelepipedo (a, b, c);
         out = $rh.createReply();
         out.write_double ($result);
         break;
       }

       case 5:  // example/figure/areaCilindro
       {
         double r = in.read_double ();
         double h = in.read_double ();
         double $result = (double)0;
         $result = this.areaCilindro (r, h);
         out = $rh.createReply();
         out.write_double ($result);
         break;
       }

       case 6:  // example/figure/volumenCilindro
       {
         double r = in.read_double ();
         double h = in.read_double ();
         double $result = (double)0;
         $result = this.volumenCilindro (r, h);
         out = $rh.createReply();
         out.write_double ($result);
         break;
       }

       case 7:  // example/figure/areaEsfera
       {
         double r = in.read_double ();
         double $result = (double)0;
         $result = this.areaEsfera (r);
         out = $rh.createReply();
         out.write_double ($result);
         break;
       }

       case 8:  // example/figure/volumenEsfera
       {
         double r = in.read_double ();
         double $result = (double)0;
         $result = this.volumenEsfera (r);
         out = $rh.createReply();
         out.write_double ($result);
         break;
       }

       default:
         throw new org.omg.CORBA.BAD_OPERATION (0, org.omg.CORBA.CompletionStatus.COMPLETED_MAYBE);
    }

    return out;
  } // _invoke

  // Type-specific CORBA::Object operations
  private static String[] __ids = {
    "IDL:example/figure:1.0"};

  public String[] _all_interfaces (org.omg.PortableServer.POA poa, byte[] objectId)
  {
    return (String[])__ids.clone ();
  }

  public figure _this() 
  {
    return figureHelper.narrow(
    super._this_object());
  }

  public figure _this(org.omg.CORBA.ORB orb) 
  {
    return figureHelper.narrow(
    super._this_object(orb));
  }


} // class figurePOA
