package allinone.rull.frt.fortrouletteallinone;

import java.util.ArrayList;
import java.util.List;


public class ChallengeItem {
    private int imageName1;
    private String textName;

    public ChallengeItem (int imageName1, String textName){
        this.imageName1 = imageName1;
        this.textName = textName;
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
        itemList.add(new ChallengeItem(R.drawable.landing, "Go landing on loot lake"));
        itemList.add(new ChallengeItem(R.drawable.landing, "Go landing on snow tower"));
        itemList.add(new ChallengeItem(R.drawable.landing, "Go landing on sea"));
        return itemList;
    }
    public static List<ChallengeItem> getKillChallenge(){
        ArrayList<ChallengeItem> itemList = new ArrayList<>();
        itemList.add(new ChallengeItem(R.drawable.skull, "Kill 1 enemy with a machine gun"));
        itemList.add(new ChallengeItem(R.drawable.skull, "Kill 2 enemy with a shotgun"));
        itemList.add(new ChallengeItem(R.drawable.skull, "3 kill"));
        return itemList;
    }
    // Случайный челендэ это моежт быть танец или что угодно в зависимости от этого будет меняться значок
    public static List<ChallengeItem> getSecretChallenge(){
        ArrayList<ChallengeItem> itemList = new ArrayList<>();
        itemList.add(new ChallengeItem(R.drawable.lama, "Don't use dance"));
        itemList.add(new ChallengeItem(R.drawable.dance, "d 2"));
        itemList.add(new ChallengeItem(R.drawable.dance, "d 3"));
        itemList.add(new ChallengeItem(R.drawable.skull, "s 2"));
        itemList.add(new ChallengeItem(R.drawable.lama, "s 3 "));
        return itemList;
    }
}
