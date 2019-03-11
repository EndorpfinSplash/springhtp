package com.htp.domain;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Component("carEngine")
public class Engine {
    private Float volume;
    private Float price;

    public Engine() {
        volume = 2f;
        price = 2000f;
    }

    public Engine(Float volume, Float price) {
        this.volume = volume;
        this.price = price;
    }

    public Float getVolume() {
        return volume;
    }

    public void setVolume(Float volume) {
        this.volume = volume;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Engine engine = (Engine) o;
        return Objects.equals(volume, engine.volume) &&
                Objects.equals(price, engine.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(volume, price);
    }

    @Override
    public String toString() {
        return "Engine{" +
                "volume=" + volume +
                ", price=" + price +
                '}';
    }
}
