import java.util.Random;

/**
 * Write a description of class DadoLogico here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class DadoLogico
{
    private int numCaras, caraActual; 

    public DadoLogico()
    {
      numCaras = 6;
      caraActual = 1;
    }
    public DadoLogico(int caras){
        numCaras = caras;
        caraActual = caras;
    }
    
    public int getCaraActual() {
        return caraActual;
    }

    public int lanzar()
    {
       Random rand = new Random();
       caraActual = rand.nextInt(numCaras) + 1;
       return caraActual;
    }
    
    public String toString() {
        return " Valor :" + caraActual;
    }
}
