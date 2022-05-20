package spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import spring.entity.Company;
import spring.entity.Work;

import javax.annotation.PostConstruct;

import static org.springframework.beans.factory.support.BeanDefinitionBuilder.rootBeanDefinition;

public class SpringBeanDemo {

//    @Autowired
//    private Company company;
//
//    @PostConstruct
//    public void init() {
//        System.out.println(company);
//    }

    public static void main(String[] args) {

//        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
//
//        // 注册 Configuration Class
//        context.register(SpringBeanDemo.class, Company.class, Work.class);
//
//        // 启动 Spring 应用上下文
//        context.refresh();
//
//        // 关闭 Spring 应用上下文
//        context.close();

        System.out.println(System.getProperty("java.version"));
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        beanFactory.registerBeanDefinition("work", rootBeanDefinition(Work.class).getBeanDefinition());
        Work work = beanFactory.getBean("work", Work.class);
        System.out.println(work);
    }
}
