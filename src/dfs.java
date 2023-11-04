
import javax.swing.JOptionPane;
/**
 *
 * @author andresnitolamoreno
 */

//Se crea la clase para el el recorrido DFS
public class dfs {
    //Definicion de variables
    private int numVertices;
    private int[][] matrizAdyacente;
    private char[] Vertices;
    //La clase DFS recibe la matriz de adyacencia y la cadena con los nombres de los vertices
    public dfs(int[][] matrizAdyacente, char[] Vertices) {
        this.numVertices = matrizAdyacente.length;
        this.matrizAdyacente = matrizAdyacente;
        this.Vertices = Vertices;
    }
    //Metodo que recorre los vertices y hace seguimiento a los vertices por visistar
    public void dfsTraversal(int inicioVertice) {
        boolean[] recorrido = new boolean[numVertices];
        StringBuilder resultado = new StringBuilder();

        dfsRecursivo(inicioVertice, recorrido, resultado);

        JOptionPane.showMessageDialog(null, "Recorrido DFS desde el vertice " + Vertices[inicioVertice] + ":\n" + resultado.toString());
    }
    //Utilizamos recursividad para hacer el recorrido DFS marcando el actual como recorrido, se agrega a resultado para luego mostrarlo en pantalla
    //tambien se agrega un espacio para que se vea bien, se repite el proceso mediante un ciclo for que cuando encuentre un 1 en la matriz es una arista que une los vertices
    private void dfsRecursivo(int verticeActual, boolean[] recorrido, StringBuilder resultado) {
        recorrido[verticeActual] = true;
        resultado.append(Vertices[verticeActual]).append(" ");

        for (int i = 0; i < numVertices; i++) {
            if (matrizAdyacente[verticeActual][i] == 1 && !recorrido[i]) {
                dfsRecursivo(i, recorrido, resultado);
            }
        }
    }
    //Matriz adyacente
    public static void main(String[] args) {
        int[][] matrizAdyacente = {
            {0, 1, 1, 0, 0, 0},
            {1, 0, 0, 1, 1, 0},
            {1, 0, 0, 0, 0, 1},
            {0, 1, 0, 0, 1, 0},
            {0, 1, 0, 1, 0, 1},
            {0, 0, 1, 0, 1, 0}
        };
        //Nombramos los vertices
        char[] Vertices = {'A', 'B', 'C', 'D', 'E', 'F'};
        //Con este se une la matriz para poder pintarla mediante JoptionPane
        StringBuilder matrizCadena = new StringBuilder("Matriz de adyacencia:\n");
        //Ciclo que llena la matriz adyacente  con los valores y luego la pinta en pantalla
        for (int i = 0; i < matrizAdyacente.length; i++) {
            for (int j = 0; j < matrizAdyacente[i].length; j++) {
                matrizCadena.append(matrizAdyacente[i][j]).append(" ");
            }
            matrizCadena.append("\n");
        }

        JOptionPane.showMessageDialog(null, matrizCadena.toString());
        //Se instancia la clase con la matriz adyacente y los vertices
        dfs dfs = new dfs(matrizAdyacente, Vertices);
        //Llamamos el metodo transversal desde el primer vertice A para hacer el recorrido DFS
        dfs.dfsTraversal(0);
    }
}
