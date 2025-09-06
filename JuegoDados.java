
/**
 * Juego de tres dados. Se tiran los tres dados.
 * Gana el jugador que tiene 3 valores iguales o la suma de los dados es mayor a 14.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class JuegoDados
{
    private DadoLogico dado1, dado2, dado3;
    private DadoGrafico dado1Grafico, dado2Grafico, dado3Grafico;
    
    public JuegoDados() {
        dado1 = new DadoLogico();
        dado2 = new DadoLogico();
        dado3 = new DadoLogico();
        dado1Grafico = new DadoGrafico(50,50,0,100);
        dado2Grafico = new DadoGrafico(170,50,0,100);
        dado3Grafico = new DadoGrafico(290,50,0,100);
    }
    
    public void lanzar3Dados(){
        dado1Grafico.setValor(dado1.lanzar());
        dado1Grafico.dibujar();
        dado2Grafico.setValor(dado2.lanzar());
        dado2Grafico.dibujar();
        dado3Grafico.setValor(dado3.lanzar());
        dado3Grafico.dibujar();
    }
    
    public boolean sonIguales() {
        return dado1.getCaraActual() == dado2.getCaraActual() && dado1.getCaraActual() == dado3.getCaraActual();
    }
    
    public int suma3Dados() {
        return dado1.getCaraActual() + dado2.getCaraActual() + dado3.getCaraActual();
    }
    
    public boolean gano() {
        return sonIguales() || (suma3Dados() > 14);
    }
    
    public void Jugar() {
        lanzar3Dados();
        System.out.println("Dados: " + dado1 + dado2 + dado3);
        System.out.println("La suma es igual a " + suma3Dados());
        System.out.println(sonIguales()? "Son iguales" : "No son iguales");
        System.out.println(gano()?" Has Ganado!" : "Perdiste");
        
        }
    }