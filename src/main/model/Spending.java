package model;





public class Spending {
    int amount;
    String tag;
    String description;




    public Spending() {
        this.amount = 0;
        this.tag = "";
        this.description = "";



    }

    //MODIFIES: this
    //EFFECTS: add a tag to the spending
    public void addTag(String str) {
        this.tag = str;
    }

    //REQUIRES: Amount > 0
    //MODIFIES: this
    //EFFECTS: add an amount to the spending
    public void addAmount(int x) {
        this.amount = this.amount + x;
    }

    //REQUIRES: No empty string
    //MODIFIES:this
    //EFFECTS: add a brief description to the spending
    public void addDescription(String str) {
        this.description = this.description + str;
    }

    //MODIFIES:this
    //EFFECTS:set it to the local time



    //REQUIRES: tag must be one of the Tags
    //MODIFIES:this
    //EFFECTS: create a tag for the spending
    public String getTag() {
        return this.tag;
    }

    public String getDescription() {
        return this.description;
    }


    //MODIFIES: this
    //EFFECTS:get the amount in that class
    public int getAmount() {
        return this.amount;
    }


}
