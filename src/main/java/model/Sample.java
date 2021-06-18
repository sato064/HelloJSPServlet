package model;

public class Sample {
    private int sampleId;
    private String content;

    public Sample(int sampleId) {
    }

    public Sample() {
    }

    public int getSampleId() {
        return sampleId;
    }

    public void setSampleId(int sampleId) {
        this.sampleId = sampleId;
    }
    
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

}