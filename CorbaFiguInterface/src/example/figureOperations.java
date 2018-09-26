package example;



public interface figureOperations 
{

  /*
        * Para generar
        * in: el valor del parametro se lo envia el cliente al servidor
        * long: -231..231-1 (32 bits)
        * numero: nombre de la variable
        */
  String generar (int numero);
  double areaCubo (double a);
  double volumenCubo (double a);
  double areaParalelepipedo (double a, double b, double c);
  double volumenParalelepipedo (double a, double b, double c);
  double areaCilindro (double r, double h);
  double volumenCilindro (double r, double h);
  double areaEsfera (double r);
  double volumenEsfera (double r);
} // interface figureOperations
