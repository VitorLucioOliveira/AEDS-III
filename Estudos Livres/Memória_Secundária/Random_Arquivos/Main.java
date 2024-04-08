

import java.io.IOException;
import java.io.RandomAccessFile;

public class Main {
    public static void main(String[] args) {
        
        Livro l1 = new Livro(1, "Java Como Programar", "Deitel", 150.00f);
        Livro l2 = new Livro(2, "C Como Programar", "Deitel", 100.00f);

      

        RandomAccessFile arg;
        byte[] ba;// array de bytes

        try {
            
            /* ESCRITA */
            arg = new RandomAccessFile("new_livros.db", "rw");//abre o arquivo para escrita ou leitura de bytes
            
            
            long p1 = arg.getFilePointer();//salvaa posição do ponteiro no arquivo
            
            ba = l1.toByteArray();//converte o objeto l1 para um array de bytes
            arg.writeInt(ba.length);//escreve o tamanho do array de bytes no arquivo
            arg.write(ba);//escreve o conteudo no arquivo

           

            long p2 = arg.getFilePointer();//salvaa posição do ponteiro no arquivo
            
            ba = l2.toByteArray();//converte o objeto l2 para um array de bytes
            arg.writeInt(ba.length);//escreve o tamanho do array de bytes no arquivo
            arg.write(ba);//escreve o conteudo no arquivo

           


            /* LEITURA */
            Livro l3 = new Livro();
            Livro l4 = new Livro();
            int tam;

            arg.seek(p2);//posiciona o ponteiro na posição escolhida

            tam = arg.readInt();//lê o tamanho do array de bytes
            ba = new byte[tam];//cria um array de bytes com o tamanho lido no array
            arg.read(ba);//lê o conteudo do arquivo e armazena no array de bytes
            l3.fromByteArray(ba);//converte o array de bytes para um objeto do tipo Livro

            arg.seek(p1);//posiciona o ponteiro na posição escolhida

            tam = arg.readInt();//lê o tamanho do array de bytes
            ba = new byte[tam];//cria um array de bytes com o tamanho lido no array
            arg.read(ba);//lê o conteudo do arquivo e armazena no array de bytes
            l4.fromByteArray(ba);//converte o array de bytes para um objeto do tipo Livro

            System.out.println(l3);
            System.out.println(l4);

           
            arg.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
