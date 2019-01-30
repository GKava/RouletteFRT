package allinone.rull.frt.fortrouletteallinone;

import java.util.ArrayList;
import java.util.List;


public class ChallengeItem {
    private int imageName1;
    private String textName;
    private  int rarityColor;

    public int getRarityColor() {
        return rarityColor;
    }

    public void setRarityColor(int rarityColor) {
        this.rarityColor = rarityColor;
    }

    public ChallengeItem (int imageName1, String textName, int rarityColor){
        this.imageName1 = imageName1;
        this.textName = textName;
        this.rarityColor = rarityColor;
    }

    public int getImageName1() {
        return imageName1;
    }

    public void setImageName1(int imageName1) {
        this.imageName1 = imageName1;
    }

    public String getTextName() {
        return textName;
    }

    public void setTextName(String textName) {
        this.textName = textName;
    }


    public static List<ChallengeItem> getLandingPoint(){
        ArrayList<ChallengeItem> itemList = new ArrayList<>();
        itemList.add(new ChallengeItem(R.drawable.landing, "Go landing 1",1));
        itemList.add(new ChallengeItem(R.drawable.landing, "Go landing 2",2));
        itemList.add(new ChallengeItem(R.drawable.landing, "Go landing 3",3));
        itemList.add(new ChallengeItem(R.drawable.landing, "Go landing 4",4));
        return itemList;
    }
    public static List<ChallengeItem> getKillChallenge(){
        ArrayList<ChallengeItem> itemList = new ArrayList<>();
        itemList.add(new ChallengeItem(R.drawable.skull, "Kill 1 enemy with a machine gun",1));
        itemList.add(new ChallengeItem(R.drawable.skull, "2 kill",4));
        return itemList;
    }
    // Случайный челендэ это моежт быть танец или что угодно в зависимости от этого будет меняться значок
    public static List<ChallengeItem> getSecretChallenge(){
        ArrayList<ChallengeItem> itemList = new ArrayList<>();
        itemList.add(new ChallengeItem(R.drawable.lama, "lama",1));
        itemList.add(new ChallengeItem(R.drawable.dance, "dance",2));
        itemList.add(new ChallengeItem(R.drawable.skull, "skull",3));
        itemList.add(new ChallengeItem(R.drawable.landing, "Go landing 3",4));
        return itemList;
    }
}
