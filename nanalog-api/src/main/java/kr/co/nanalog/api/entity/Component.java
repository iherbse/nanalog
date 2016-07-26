package kr.co.nanalog.api.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by choijinjoo on 2016. 7. 26..
 */
@Entity
@Table(name = "component_tb")
public class Component {

    @Id
    @GeneratedValue
    private long id;
    private String componentId;
    private Integer componentType;
    //private  ?? componentPreference;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getComponentId() {
        return componentId;
    }

    public void setComponentId(String componentId) {
        this.componentId = componentId;
    }

    public Integer getComponentType() {
        return componentType;
    }

    public void setComponentType(Integer componentType) {
        this.componentType = componentType;
    }

    @Override
    public String toString() {
        return "Component{" +
                "id=" + id +
                ", componentId='" + componentId + '\'' +
                ", componentType=" + componentType +
                '}';
    }
}
