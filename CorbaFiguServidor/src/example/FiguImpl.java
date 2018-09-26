package example;

public class FiguImpl extends figurePOA {
    @Override
    public String generar(int numero) {
        String cadena = "";
        for (int i = 1; i <= numero; i++) {
            double raiz = Math.sqrt(5);
            double rta = (1 / raiz) * (Math.pow((1 + raiz) / 2, i)) - (1 / raiz) * (Math.pow((1 - raiz) / 2, i));
            cadena += Math.round(rta) + " ";
        }
        return cadena;
    }
    
    @Override
    public double areaCubo(double a){
        return 6.0*Math.pow(a, 2.0);
    }
    
    @Override
    public double volumenCubo(double a){
        return Math.pow(a, 3.0);
    }
    
    @Override
    public double areaParalelepipedo(double a, double b, double c){
        return 2.0*(a*b+a*c+b*c);
    }
    
    @Override
    public double volumenParalelepipedo(double a, double b, double c){
        return a*b*c;
    }
    
    @Override
    public double areaCilindro(double r, double h){
        return 2*Math.PI*r*(h+r);
    }
    
    @Override
    public double volumenCilindro(double r, double h){
        return Math.PI*Math.pow(r, 2.0)*h;

    }
    
    @Override
    public double areaEsfera(double r){
        return 4*Math.PI*Math.pow(r, 2.0);
    }
    
    @Override
    public double volumenEsfera(double r){
        return 4.0/3.0*Math.PI*Math.pow(r, 3.0);
    }
}