package com.example.springboot.redis.mysql.poc.redisMysqlPOC.dl.entities;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="case_status_mapping")
@Data
public class CaseStatusMapping implements Serializable {

    private static final long serialVersionUID = -8243145429438016235L;

    @EmbeddedId
    private AscWorkStepAsID ascWorkStepAsID;

    public CaseStatusMapping(){}

    public CaseStatusMapping(AscWorkStepAsID ascWorkStepAsID, SfStatus sfStatus) {
        this.ascWorkStepAsID = ascWorkStepAsID;
        this.sfStatus = sfStatus;
    }

    @OneToOne(
            targetEntity = SfStatus.class,
            fetch= FetchType.EAGER,
            cascade= CascadeType.DETACH
    )
    @JoinColumn(
            name="sf_status_id",
            referencedColumnName = "sf_status_id",
            nullable = false,
            foreignKey = @ForeignKey(name="FK_SfStatusId_To_SfStatusId")
    )
    private SfStatus sfStatus;

}