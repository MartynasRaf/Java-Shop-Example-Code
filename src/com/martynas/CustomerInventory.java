package com.martynas;

public abstract class CustomerInventory extends Inventory {

    private ShopInventory shopInventory;
    public ShopInventory getShopInventory(){ return shopInventory; }
    public void setShopInventory(ShopInventory shopInv){ shopInventory=shopInv;}

    public CustomerInventory(){
    }

    public void buyStorage(){
        if (getListSize()==0) return;

        for (int i = 0; i< shopInventory.getListSize(); i++){
            for (int k=0;k<getListSize();k++) {
                if (shopInventory.getCommodity(i).getName().equals(getCommodity(k).getName())){
                    shopInventory.sellItem(i,getCommodity(k).getAmount());
                }
            }
        }
    }

    public abstract float getAllProductsPriceSum();


    /**
     * Add item to List
     * @param name Item's name
     * @param amount Amount to add
     */

    @Override
    public void addItem(String name, int amount){
        for (int i = 0; i< shopInventory.getListSize(); i++){
                if (shopInventory.getCommodity(i).getName().equals(name)){
                    super.addItem(name,amount);
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
        addItem(name,amount);
    }

}
