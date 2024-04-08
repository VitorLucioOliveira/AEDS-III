
/**
 * Livro
 */
import java.text.DecimalFormat;

public class Livro {

    protected int id;
    protected String titulo;
    protected String autor;
    protected float preco; 

    DecimalFormat df = new DecimalFormat("#,##0.00");



    public Livro(int id, String titulo, String autor, float preco) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.preco = preco;
    }

    public Livro() {
        id = -1;
        titulo = "";
        autor = "";
        preco = 0F;
      }

    public String toString() {
        return "\nID: " + id + "\nTítulo: " + titulo + "\nAutor: " + autor + "\nPreço: R$ " + df.format(preco);
    }
}