package com.htp.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;
import java.util.Objects;

@Component("supercar")
//@Repository
//@Controller
//@RestController
public class Car {

    private Long id;
    private String model;

    @Autowired
    @Qualifier("carEngine")  //Spring Annotation
    //@Inject
    //@Resource(name ="") //Java Annotation JSR-330
    //@Named(name ="")
    private Engine engine;

    public Car() {
        id = 1l;
        model = "Volvo";
    }

    public Car(Long id, String model) {
        this.id = id;
        this.model = model;
    }

    public Car(Long id, String model, Engine engine) {
        this.id = id;
        this.model = model;
        this.engine = engine;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Objects.equals(id, car.id) &&
                Objects.equals(model, car.model) &&
                Objects.equals(engine, car.engine);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, model, engine);
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.JSON_STYLE);
    }

    @PostConstruct
    public void init() {
        System.out.println("Init method!");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("Destroy!");
    }
}
