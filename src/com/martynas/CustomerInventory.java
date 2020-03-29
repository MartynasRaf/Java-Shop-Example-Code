package com.martynas;

public abstract class CustomerInventory extends Inventory {

    private ShopInventory shopInventory;
    public ShopInventory getShopInventory(){ return shopInventory; }
    public void setShopInventory(ShopInventory shopInv){ shopInventory=shopInv;}

    public CustomerInventory(){
    }

    public int buyStorage(Customer c){
        if (getListSize()==0) return 1;

        for (int i = 0; i< shopInventory.getListSize(); i++){
            for (int k=0;k<getListSize();k++) {
                if (shopInventory.getCommodity(i).getName().equals(getCommodity(k).getName())){
                    if(getCommodity(k).getAmount()*shopInventory.getCommodity(k).getPrice()>c.getBalance()) {
                        return 1;
                    }

                    c.changeBalance(-getCommodity(k).getAmount()*shopInventory.getCommodity(k).getPrice());

                    shopInventory.sellItem(i,getCommodity(k).getAmount());

                }
            }
        }
        return 0;
    }

    /**
     * Add item to List
     * @param name Item's name
     * @param amount Amount to add
     */

    @Override
    public void addItem(String name, int amount){
        for (int i = 0; i< shopInventory.getListSize(); i++){
                if (shopInventory.getCommodity(i).getName().equals(name)){
                    super.addItem(name, shopInventory.getCommodity(i).getPrice(),amount);
                    return;

            }
        }
    }

    /**
     * Add item to List
     * @param name Item's name
     * @param price Item's price
     * @param amount amount to add
     */
    @Override
    public void addItem(String name, float price, int amount){
        this.addItem(name,amount);
    }

}
