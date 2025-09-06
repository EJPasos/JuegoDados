/**
 * Write a description of class DadoView here.
 *
 * @author Julian Pasos
 * @version 2025.09.01
 */
public class DadoGrafico
{
    private int valor;
    private int coordenadaX;
    private int coordenadaY;
    private final Square Fondo;
    private final Square Contorno;
    private final Circle[] puntos = new Circle[9];
    private int size;
    private boolean faceUp, rotated;
    private String colorDado, colorPuntos;
    private final int[] posX = {1, 1, 1, 4, 7, 7, 7, 4, 4};
    private final int[] posY = {1, 4, 7, 4, 1, 4, 7, 1, 7};
    private static final int[][] PUNTOS_VISIBLES = {
            {},                 // 0 (no se usa)
            {3},                // 1
            {0, 6},             // 2
            {0, 3, 6},          // 3
            {0, 2, 4, 6},       // 4
            {0, 2, 3, 4, 6},    // 5
            {0, 1, 2, 4, 5, 6}, // 6
            {0, 1, 2, 3, 4, 5, 6}, // 7
            {0, 1, 2, 4, 5, 6, 7, 8}, // 8
            {0, 1, 2, 3, 4, 5, 6, 7, 8} // 9
    };
    private static final int[][] PUNTOS_VISIBLES_ROTADO = {
            {},                 // 0 (no se usa)
            {3},                // 1
            {2, 4},             // 2
            {2, 3, 4},          // 3
            {0, 2, 4, 6},       // 4 (igual)
            {0, 2, 3, 4, 6},    // 5 (igual)
            {0, 2, 4, 6, 7, 8}, // 6 rotado
            {0, 2, 3, 4, 6, 7, 8}, // 7 rotado
            {0, 1, 2, 4, 5, 6, 7, 8}, // 8 (igual)
            {0, 1, 2, 3, 4, 5, 6, 7, 8} // 9 (igual)
    };

    public DadoGrafico() {
        faceUp = true;
        rotated = false;
        valor = 6;
        coordenadaX = 50;
        coordenadaY = 50;
        size = 100;
        colorDado = "white";
        Fondo = new Square(size - 8, coordenadaX + 4, coordenadaY + 4,colorDado);
        Contorno = new Square(size, coordenadaX, coordenadaY, "black");
        colorPuntos = "black";
        crearPuntos();
        actualizarPuntos();
        
        dibujar();
    }

    public DadoGrafico(int coordenadaX, int coordenadaY, int valor, int size){
        faceUp = true;
        rotated = false;
        this.valor = valor;
        this.coordenadaX = coordenadaX;
        this.coordenadaY = coordenadaY;
        this.size = size;
        colorPuntos = "black";
        Fondo = new Square(size - 8, coordenadaX + 4, coordenadaY + 4,"white");
        Contorno = new Square(size, coordenadaX, coordenadaY, "black");
        
        crearPuntos();
        actualizarPuntos();
    }

    public void crearPuntos() {
        for (int i = 0; i < puntos.length; i++) {
            puntos[i] = new Circle();
        }
    }

    public int getValor() {
        return valor;
    }
    
    public void setValor(int valor) {
        this.valor = valor;
    }
    
    public void dibujar(){
        Contorno.makeVisible();
        if(faceUp) {
        Fondo.makeVisible();
    } else {
        Fondo.makeInvisible();
    }
        mostrarPuntos();
    }

    public void rotar(){
        rotated = !rotated;
        dibujar();
    }
    
   public void move(int X, int Y) {
    this.coordenadaX = X;
    this.coordenadaY = Y;
    
    // Mover el contorno y el fondo del dado
    Contorno.setPosition(coordenadaX, coordenadaY);
    Fondo.setPosition(coordenadaX + 4, coordenadaY + 4);
    
    actualizarPuntos();
    
    // Redibujar el dado
    dibujar();
}

    public void changeSize(int newSize) {
    size = newSize;
    
    int dotSize = size/8;
    Contorno.setSize(size);
    Fondo.setSize(size - 8);
    
    actualizarPuntos();
    dibujar();
    }

    private void mostrarPuntos() {
        // Ocultar todos los puntos usando el arreglo
        for (Circle punto : puntos) {
            punto.makeInvisible();
        }

        if (faceUp && valor >= 1 && valor <= 9) {
            int[] indicesVisibles = rotated ? PUNTOS_VISIBLES_ROTADO[valor] : PUNTOS_VISIBLES[valor];
            for (int idx : indicesVisibles) {
                puntos[idx].makeVisible();
            }
        }
    }

    private void actualizarPuntos() {
        int dotSize = size / 8;
        for (int i = 0; i < puntos.length; i++) {
            puntos[i].setPosition(coordenadaX + (size * posX[i] / 9), coordenadaY + (size * posY[i] / 9));
            puntos[i].setDiameter(dotSize);
            puntos[i].setColor(colorPuntos);
        }
    }

            public void flip() {
        faceUp = !faceUp;
        dibujar();
    }
     
    
}