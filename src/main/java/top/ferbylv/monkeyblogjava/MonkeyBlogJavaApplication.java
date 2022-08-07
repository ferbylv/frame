package top.ferbylv.monkeyblogjava;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class MonkeyBlogJavaApplication {

    public static void main(String[] args) {
        SpringApplication.run(MonkeyBlogJavaApplication.class, args);
    }

}
