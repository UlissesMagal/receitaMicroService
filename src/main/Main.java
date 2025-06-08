
package src.main;
import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@SpringBootApplication
public class Main {  //to cansado ja macho
   public static void main(String[] args) {
    
        Dotenv dotenv = Dotenv.load();
       System.setProperty("DB_PASS", dotenv.get("DB_PASS"));
    SpringApplication.run(Main.class, args);
}
}
