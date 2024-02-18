
/**
 * Livro
 */
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
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


    /* Escreve em uma array de bytes */
    public byte[] toByteArray() throws IOException{

        ByteArrayOutputStream byte_array_out = new ByteArrayOutputStream();
        DataOutputStream data_out = new DataOutputStream(byte_array_out);
        data_out.writeInt(id);
        data_out.writeUTF(titulo);
        data_out.writeUTF(autor);
        data_out.writeFloat(preco);

        return byte_array_out.toByteArray();

    }

    /* Lê de uma array de bytes */
    public void fromByteArray(byte[] byte_array) throws IOException{

        ByteArrayInputStream byte_array_in = new ByteArrayInputStream(byte_array);
        DataInputStream data_in = new DataInputStream(byte_array_in);

        //Lê os dados na mesma ordem que foram escritos
        id = data_in.readInt();
        titulo = data_in.readUTF();
        autor = data_in.readUTF();
        preco = data_in.readFloat();


    }
}