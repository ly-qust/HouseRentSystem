package com.ly;

public class HouseService {
    private House[] houses;
    private int houseNums = 1;
    private int idCounter = 1;

    public HouseService(int size) {
        houses = new House[size];
        houses[0] = new House(1, "张三", "12345678901", "北京", 1000, "未出租");
    }

    public House findById(int id) {
        for (int i = 0; i < houseNums; i++) {
            if (houses[i].getId() == id) {
                return houses[i];
            }
        }
        return null;
    }



    public boolean add(House newHouse) {
        if (houseNums >= houses.length) {
            System.out.println("数组已满，不能再添加了");
            return  false;
        }
        houses[houseNums++] = newHouse;
        newHouse.setId(++idCounter);
        return true;
    }

    public boolean delete(int id) {
        int index=-1;
        for(int i=0;i<houseNums;i++){
            if(id==houses[i].getId()){
                index=i;
            }
        }
        if(index==-1){
            return false;
        }
        for(int i=index;i<houseNums-1;i++){
            houses[i]=houses[i+1];
        }
        houses[--houseNums]=null;
        return true;
    }

    public House[] list() {
        return houses;
    }
}
