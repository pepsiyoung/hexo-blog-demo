package spring.entity;

import lombok.Data;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.EnvironmentAware;
import org.springframework.core.env.Environment;

@Data
public class Work implements BeanNameAware, EnvironmentAware {
    private String workName;

    @Override
    public void setBeanName(String name) {
        System.out.println("BeanNameAware:" + name);
    }

    @Override
    public void setEnvironment(Environment environment) {
        System.out.println("environment");
    }
}
