import java.io.IOException; 
import java.io.PrintWriter; 
import java.nio.charset.Charset; 
import java.nio.file.Files; 
import java.nio.file.Path; 
import java.nio.file.Paths; 
import java.util.Random;
import java.util.Scanner;

public class FileRead{ 

    public static void main(String args[]){ 

        // Obtem o caminho para o diretório corrente 

        String currDir = Paths.get("").toAbsolutePath().toString(); 

        // Monta o nome do arquivo 

        String nameComplete = currDir+"\\"+"numeros.dat"; 

        // Cria acesso ao "diretorio" da mídia (disco) 

        Path path = Paths.get(nameComplete); 


        int numero; 

        int acum = 0; 

        int qtdade = 0; 

        double media = 0.0; 

        // Usa a classe scanner para fazer a leitura do arquivo 

        try (Scanner sc = new Scanner(Files.newBufferedReader(path, Charset.defaultCharset()))){ 

            sc.useDelimiter("[,\n]"); // separadores: ; e nova linha 

            while (sc.hasNext()){ 

                numero = Integer.parseInt(sc.next()); 

                acum = acum+numero; 

                qtdade++; 

            } 

         }catch (IOException x){ 

             System.err.format("Erro de E/S: %s%n", x); 

         } 

         media = acum/qtdade; 

         System.out.println("Quantidade de valores lidos: "+qtdade); 

         System.out.println("Somatorio: "+acum); 

         System.out.println("Media: "+media); 

    } 

} 