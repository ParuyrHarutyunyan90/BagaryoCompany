package am.itspace.bagariocompanyweb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@ComponentScan({"am.itspace.bagariocompanycommon.*","am.itspace.bagariocompanyweb.*"})
@EnableJpaRepositories(basePackages = {"am.itspace.bagariocompanycommon.repository"})
@EntityScan({"am.itspace.bagariocompanycommon.entity"})
@SpringBootApplication
public class BagarioCompanyWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(BagarioCompanyWebApplication.class, args);
    }

}
