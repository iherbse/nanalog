package kr.co.nanalog.api.web.test.date.model.request;


public class DateRequest {
    String formatter;
    Integer type;

    public String getFormatter() {
        return formatter;
    }

    public void setFormatter(String formatter) {
        this.formatter = formatter;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }
}
