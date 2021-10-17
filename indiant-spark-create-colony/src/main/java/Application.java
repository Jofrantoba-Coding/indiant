
import java.util.TimeZone;
import javax.annotation.PostConstruct;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author jona
 */
@SpringBootApplication
@ComponentScan(basePackages = {"com.jofrantoba.indiant.spark"})
public class Application{

    @PostConstruct
    public void init() {
        TimeZone.setDefault(TimeZone.getTimeZone("America/Lima"));
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
        //NettyServer nettyServer = new NettyServer();
        //nettyServer.start(new InetSocketAddress("127.0.0.1", 8090));
    }        

    
}
