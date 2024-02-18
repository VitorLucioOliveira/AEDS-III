
import java.io.DataOutputStream;
import java.io.FileOutputStream;

public class Main {
    public static void main(String[] args) {
        
        Livro l1 = new Livro(1, "Java Como Programar", "Deitel", 150.00f);
        Livro l2 = new Livro(2, "C Como Programar", "Deitel", 100.00f);

        System.out.println(l1);
        System.out.println(l2);

        FileOutputStream arg;
        DataOutputStream dos;

        try {
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
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
