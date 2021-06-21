package model;

public class HotSpring {
    private String name;
    private int star;
    private String comment;

    public HotSpring(String name,int star,String comment) {
    }

    public HotSpring() {
    }

    public String getName() {
        return name;
    }

    public void setName (String name) {
        this.name = name;
    }
    
    public int getStar() {
        return star;
    }

    public void setStar(int star) {
        this.star = star;
    }

    public String getComment() {
        return comment;
    }

    public void setComment (String comment) {
        this.comment = comment;
    }

}