package am.itspace.bagariocompanyrest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@ComponentScan({"am.itspace.bagariocompanycommon.*","am.itspace.bagariocompanyrest.*"})
@EnableJpaRepositories(basePackages = {"am.itspace.bagariocompanycommon.repository"})
@EntityScan({"am.itspace.bagariocompanycommon.entity"})
@SpringBootApplication
public class BagarioCompanyRestApplication {

    public static void main(String[] args) {
        SpringApplication.run(BagarioCompanyRestApplication.class, args);
    }

}
