package com.example.springboot.redis.mysql.poc.redisMysqlPOC.dl.entities;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

@Entity
@Table(name="sf_status")
@Data
public class SfStatus implements Serializable {

    private static final long serialVersionUID = -8243145429438016237L;

    public enum SfStatusType {

        OPEN((short)1, "Open"),
        RESEARCHING((short)2, "Researching"),
        UPDATED((short)3, "Updated"),
        CLOSED((short)4, "Closed");

        private Short id;
        private String name;

        SfStatusType(Short id, String name) {
            this.name = name;
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public Short getId() {
            return id;
        }
    }

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "sf_status_id",  nullable = false)
    private short sfStatusId;

    @Column(nullable = false, name="description")
    @NotEmpty
    private String description;

    public SfStatus(){}
    public SfStatus(short id, String description){
        this.sfStatusId = id;
        this.description = description;
    }

    public SfStatus(SfStatusType sfStatusType) {
        this.sfStatusId = sfStatusType.id;
        this.description = sfStatusType.name;
    }
}