package kr.co.nanalog.api.web.util.model.request;

public class DateRequest {

    private String formatter;
    private Integer type;

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

    @Override
    public String toString() {
        return "DateRequest{" +
                "formatter='" + formatter + '\'' +
                ", type=" + type +
                '}';
    }
}
