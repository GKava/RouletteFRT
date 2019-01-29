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

    public static List<ChallengeItem> getAllItems(){
        ArrayList<ChallengeItem> itemList = new ArrayList<>();

        return itemList;
    }
}
