package kr.co.nanalog.api.web.test.date.model.response;

public class DateResponse {

    private Integer code;
    private String formattedDate;
    private Integer dateType;
    private Integer typedDate;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getFormattedDate() {
        return formattedDate;
    }

    public void setFormattedDate(String formattedDate) {
        this.formattedDate = formattedDate;
    }

    public Integer getDateType() {
        return dateType;
    }

    public void setDateType(Integer dateType) {
        this.dateType = dateType;
    }

    public Integer getTypedDate() {
        return typedDate;
    }

    public void setTypedDate(Integer typedDate) {
        this.typedDate = typedDate;
    }

    @Override
    public String toString() {
        return "DateResponse{" +
                "code=" + code +
                ", formattedDate='" + formattedDate + '\'' +
                ", dateType=" + dateType +
                ", typedDate=" + typedDate +
                '}';
    }
}
