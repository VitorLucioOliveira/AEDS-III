
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

        byte[] ba;// array de bytes

        try {
            
            /* ESCRITA */
            arg = new FileOutputStream("new_livros.db");//cria um arquivo para armazenar os bytes
            dos = new DataOutputStream(arg);//cria um fluxo de saída para armazenar os bytes (convertendo os tipos primitivos para bytes) 

            ba = l1.toByteArray();//converte o objeto l1 para um array de bytes
            dos.writeInt(ba.length);//escreve o tamanho do array de bytes no arquivo
            dos.write(ba);//escreve o conteudo no arquivo


            ba = l2.toByteArray();//converte o objeto l2 para um array de bytes
            dos.writeInt(ba.length);//escreve o tamanho do array de bytes no arquivo
            dos.write(ba);//escreve o conteudo no arquivo


            dos.close();
            arg.close();

            /* LEITURA */
            Livro l3 = new Livro();
            Livro l4 = new Livro();
            int tam;

            arg2 = new FileInputStream("new_livros.db");//abre o arquivo para leitura de bytes
            dis = new DataInputStream(arg2);//cria um fluxo de entrada para ler os bytes (convertendo os bytes para tipos primitivos)

            tam = dis.readInt();//lê o tamanho do array de bytes
            ba = new byte[tam];//cria um array de bytes com o tamanho lido no array
            dis.read(ba);//lê o conteudo do arquivo e armazena no array de bytes
            l3.fromByteArray(ba);//converte o array de bytes para um objeto do tipo Livro


            tam = dis.readInt();//lê o tamanho do array de bytes
            ba = new byte[tam];//cria um array de bytes com o tamanho lido no array
            dis.read(ba);//lê o conteudo do arquivo e armazena no array de bytes
            l4.fromByteArray(ba);//converte o array de bytes para um objeto do tipo Livro

            System.out.println(l3);
            System.out.println(l4);

            dis.close();
            arg2.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
