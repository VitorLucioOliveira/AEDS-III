
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class Main {
    public static void main(String[] args) {
        
        Livro l1 = new Livro(1, "Java Como Programar", "Deitel", 150.00f);
        Livro l2 = new Livro(2, "C Como Programar", "Deitel", 100.00f);

      

        FileOutputStream arg;
        DataOutputStream dos;

        FileInputStream arg2;
        DataInputStream dis;

        try {
            
            /* ESCRITA */
            arg = new FileOutputStream("new_livros.db");
            dos = new DataOutputStream(arg);

            dos.writeInt(l1.id);
            dos.writeUTF(l1.titulo);
            dos.writeUTF(l1.autor);
            dos.writeFloat(l1.preco);

            dos.writeInt(l2.id);
            dos.writeUTF(l2.titulo);
            dos.writeUTF(l2.autor);
            dos.writeFloat(l2.preco);

            dos.close();
            arg.close();

            /* LEITURA */

            Livro l3 = new Livro();
            Livro l4 = new Livro();

            arg2 = new FileInputStream("new_livros.db");
            dis = new DataInputStream(arg2);

            l3.id = dis.readInt();
            l3.titulo = dis.readUTF();
            l3.autor = dis.readUTF();
            l3.preco = dis.readFloat();
            System.out.println(l3);

            l4.id = dis.readInt();
            l4.titulo = dis.readUTF();
            l4.autor = dis.readUTF();
            l4.preco = dis.readFloat();
            System.out.println(l4);

            dis.close();
            arg2.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
