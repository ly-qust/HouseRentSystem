package com.ly;

public class houseView {
    // 其他代码保持不变
    private char key = ' ';
    private boolean loop = true;
    private HouseService houseService = new HouseService(2);

    public void addHouse() {
        System.out.println("===========添加房屋===========");
        System.out.println("请输入房主名称：");
        String name = Utility.readString(8);
        System.out.println("请输入手机号码：");
        String phone = Utility.readString(12);
        System.out.println("请输入地址：");
        String address = Utility.readString(20);
        System.out.println("请输入月租：");
        int rent = Utility.readInt();
        System.out.println("请输入状态：");
        String state = Utility.readString(10);

        House newHouse = new House(0, name, phone, address, rent, state);
        if(houseService.add(newHouse)){
            System.out.println("添加成功！");
        }
        else{
            System.out.println("添加失败！");
        }

    }
    public void deleteHouse() {
        System.out.println("===========删除房屋===========");
        System.out.println("请输入要删除的id：");
        int id = Utility.readInt();
        if(id==-1){
            System.out.println("输入的id不能为-1");
            return;
        }
        char c = Utility.readConfirmSelection();
        if(c=='Y'){
            if(houseService.delete(id)){
                System.out.println("删除成功！");
            }
            else{
                System.out.println("房间不存在,删除失败！");
            }
        }else{
            System.out.println("取消删除！");
        }
    }
    public void updateHouse() {
        System.out.println("===========修改房屋===========");
        System.out.println("请输入要修改的id：");
        int id = Utility.readInt();
        if(id==-1){
            System.out.println("输入的id不能为-1");
            return;
        }
        House newHouse = houseService.findById(id);
        if(newHouse==null){
            System.out.println("没有找到该id对应的房屋！");
            return;
        }
        System.out.println("请输入房主名称：");
        String name = Utility.readString(8,"");
        if(!"".equals(name)){
            newHouse.setName(name);
        }
        System.out.println("请输入手机号码：");
        String phone = Utility.readString(12,"");
        if(!"".equals(phone)){
            newHouse.setPhone(phone);
        }
        System.out.println("请输入地址：");
        String address = Utility.readString(20,"");
        if(!"".equals(address)){
            newHouse.setAddress(address);
        }
        System.out.println("请输入月租：");
        int rent = Utility.readInt(-1);
        if(rent!=-1){
            newHouse.setRent(rent);
        }
        System.out.println("请输入状态：");
        String state = Utility.readString(10,"");
        if(!"".equals(state)){
            newHouse.setState(state);
        }
        System.out.println("修改成功！");
    }

    public void findHouse() {
        System.out.println("===========查找房屋===========");
        System.out.println("请输入要查找的id：");
        int id = Utility.readInt();
        House house = houseService.findById(id);
        if(house==null){
            System.out.println("没有找到该id对应的房屋！");
        }
        else{
            System.out.println(house);
        }
        System.out.println("查找成功！");

    }
    public void listHouse() {
        System.out.println("===========房屋列表===========");
        System.out.println("编号\t\t房主\t\t电话\t\t地址\t\t月租\t\t状态(已出租/未出租)");
        House[] houses = houseService.list();
        for (int i = 0; i < houses.length; i++) {
            if(houses[i]== null){
                break;
            }
            System.out.println(houses[i]);
        }
        System.out.println("没有更多房屋了...");
    }


    public void exit() {
        char c = Utility.readConfirmSelection();
        if (c == 'Y') {
            loop = false;
        }
    }

    public void mainMenu() {
        do{
            System.out.println("\n===========房屋出租系统菜单===========");
            System.out.println("\t\t1 新增房源");
            System.out.println("\t\t2 查找房源");
            System.out.println("\t\t3 删除房源");
            System.out.println("\t\t4 修改房源");
            System.out.println("\t\t5 显示所有房屋");
            System.out.println("\t\t6 退出系统");
            System.out.print("请输入你的选择：");
            key = Utility.readChar();
            switch( key){
                case '1':
                    addHouse();
                    break;
                case '2':
                    findHouse();
                    break;
                case '3':
                    deleteHouse();
                    break;
                case '4':
                    updateHouse();
                    break;
                case '5':
                    listHouse();
                    break;
                case '6':
                    exit();
                    break;
            }
        }while (loop);
    }
}