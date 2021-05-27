package com.wxxy.bean;

import java.math.BigDecimal;
import java.util.LinkedHashMap;
import java.util.Map;

public class Car {
    private Map<Integer, CarItems> items = new LinkedHashMap<Integer, CarItems>();



    //添加商品
    public void addItem(CarItems carItems){
        //判断是否已存在商品
        Integer carItemsId = carItems.getId();
        CarItems item = items.get(carItemsId);
        if (item == null){
            //不存在 加入商品项
            items.put(carItemsId,carItems);
        }else {
            //已存在
            //商品数量累加
            item.setCount(item.getCount() + 1);
            //更新总金额
            item.setTotalPrice(carItems.getPrice().multiply(new BigDecimal(item.getCount())));
        }
    }
    //根据id修改商品数量
    public void updateCount(Integer id,Integer count){
        //获取商品项
        CarItems carItems = items.get(id);
        //判断商品是否存在
        if (carItems != null) {
            //修改商品数量
            carItems.setCount(count);
            //修改总金额
            carItems.setTotalPrice(carItems.getPrice().multiply(new BigDecimal(carItems.getCount())));
        }
    }
    //删除商品
    public void deleteItems(Integer id){
        items.remove(id);
    }
    //清空购物车
    public void clear(){
        items.clear();
    }


    public Car() {
    }


    public Integer getTotalCount() {
        Integer totalCount = 0;
        for (Map.Entry<Integer, CarItems> entry : items.entrySet()) {
               totalCount += entry.getValue().getCount();
        }
        return totalCount;
    }

    public BigDecimal getTotalPrice() {
        BigDecimal totalPrice = new BigDecimal(0);
        for (Map.Entry<Integer, CarItems> entry : items.entrySet()) {
            totalPrice = totalPrice.add(entry.getValue().getTotalPrice());
        }
        return totalPrice;
    }

    public Map<Integer, CarItems> getItems() {
        return items;
    }

    public void setItems(Map<Integer, CarItems> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "Car{" +
                "totalCount=" + getTotalCount() +
                ", totalPrice=" + getTotalPrice() +
                ", items=" + items +
                '}';
    }
}
