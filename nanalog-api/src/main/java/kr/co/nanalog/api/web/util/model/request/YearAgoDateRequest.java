package kr.co.nanalog.api.web.util.model.request;

public class YearAgoDateRequest extends DateRequest{

    //now
    private String date;
    private Integer to;

    public String getDate() { return date; }

    public void setDate(String date) { this.date = date; }

    public Integer getTo() { return to; }

    public void setTo(Integer to) { this.to = to; }

    @Override
    public String toString() {
        return "YearAgoDateRequest{" +
                "date='" + date + '\'' +
                ", to=" + to +
                '}';
    }
}
