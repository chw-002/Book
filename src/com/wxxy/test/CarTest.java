package com.wxxy.test;

import com.wxxy.bean.Car;
import com.wxxy.bean.CarItems;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class CarTest {


    @Test
    public void addItem() {
        Car car = new Car();
        car.addItem(new CarItems(1,"java",1,new BigDecimal(100),new BigDecimal(100)));
        car.addItem(new CarItems(1,"java",1,new BigDecimal(100),new BigDecimal(100)));
        car.addItem(new CarItems(1,"java",1,new BigDecimal(100),new BigDecimal(100)));
        car.addItem(new CarItems(1,"java",1,new BigDecimal(100),new BigDecimal(100)));
        car.addItem(new CarItems(2,"mysql",1,new BigDecimal(1000),new BigDecimal(1000)));
        System.out.println(car);
    }

    @Test
    public void updateCount() {
        Car car = new Car();
        car.addItem(new CarItems(1,"java",1,new BigDecimal(100),new BigDecimal(100)));
        car.addItem(new CarItems(2,"mysql",1,new BigDecimal(1000),new BigDecimal(2000)));
        car.updateCount(1,2);
        System.out.println(car);
    }

    @Test
    public void deleteItems() {
        Car car = new Car();
        car.addItem(new CarItems(1,"java",1,new BigDecimal(100),new BigDecimal(100)));
        car.addItem(new CarItems(2,"mysql",1,new BigDecimal(1000),new BigDecimal(2000)));
        car.deleteItems(1);
        System.out.println(car);
    }

    @Test
    public void clear() {
        Car car = new Car();
        car.addItem(new CarItems(1,"java",1,new BigDecimal(100),new BigDecimal(100)));
        car.addItem(new CarItems(1,"java",1,new BigDecimal(100),new BigDecimal(100)));
        car.addItem(new CarItems(2,"mysql",1,new BigDecimal(1000),new BigDecimal(2000)));
        car.clear();
        System.out.println(car);
    }
}