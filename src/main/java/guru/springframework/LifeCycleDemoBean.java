package guru.springframework;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class LifeCycleDemoBean implements InitializingBean, DisposableBean,
        BeanNameAware, BeanFactoryAware, ApplicationContextAware {

    public LifeCycleDemoBean() {
        System.out.println(String.format(" I'm in the %s constructor", LifeCycleDemoBean.class.getName()));
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("Life cycle bean has been terminated");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println(String.format("%s has its properties set", LifeCycleDemoBean.class.getName()));
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("Bean Factory has been set");
    }

    @Override
    public void setBeanName(String name) {
        System.out.println(String.format("This bean's name is %s", name));
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("App Context has been set");
    }

    @PostConstruct
    public void postConstruct() {
        System.out.println("Post Construct Annotation method has been called");
    }

    @PreDestroy
    public void preDestroy() {
        System.out.println("Predestroy annotated method's been called");
    }

    public void beforeInit() {
        System.out.println("Before Init - Called by Bean Post Processor");
    }

    public void afterInit() {
        System.out.println("After Init - Called by Bean Post Processsor");
    }


}
