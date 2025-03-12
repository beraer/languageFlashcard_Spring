package tpo02.s29315tpo02.model;

public class Entry {
    private String polish;
    private String english;
    private String german;

    public Entry(String polish, String english, String german) {
        this.polish = polish;
        this.english = english;
        this.german = german;
    }

    public String getRandomWord(){
        int randomLanIndex = (int) (Math.random() * 3);
        if (randomLanIndex == 0) {
            return polish;
        } else if (randomLanIndex == 1) {
            return english;
        }else if (randomLanIndex == 2) {
            return german;
        }else
            return "";
    }

    public String getPolish() {
        return polish;
    }

    public String getEnglish() {
        return english;
    }

    public String getGerman() {
        return german;
    }

    public void setPolish(String polish) {
        this.polish = polish;
    }

    public void setEnglish(String english) {
        this.english = english;
    }

    public void setGerman(String german) {
        this.german = german;
    }
}
