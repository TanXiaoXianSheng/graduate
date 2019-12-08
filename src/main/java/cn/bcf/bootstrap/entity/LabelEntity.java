package cn.bcf.bootstrap.entity;

import javax.persistence.*;

@Entity
@Table(name = "labels")
public class LabelEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "label")
    private String label;

    @Column(name = "start_time")
    private String startTime;

    @Column(name = "update_time")
    private String updateTime;

    //1：未删除，0：暂存，-1：删除
    @Column(name = "delete_flag")
    private int deleteFlag;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public int getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(int deleteFlag) {
        this.deleteFlag = deleteFlag;
    }

    @Override
    public String toString() {
        return "{" +
                "id=" + id +
                ", label='" + label + '\'' +
                ", startTime='" + startTime + '\'' +
                ", updateTime='" + updateTime + '\'' +
                ", deleteFlag=" + deleteFlag +
                '}';
    }
}
