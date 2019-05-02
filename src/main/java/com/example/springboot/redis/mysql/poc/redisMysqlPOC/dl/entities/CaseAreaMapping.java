package com.example.springboot.redis.mysql.poc.redisMysqlPOC.dl.entities;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="case_area_mapping")
@Data
public class CaseAreaMapping implements Serializable {

    @EmbeddedId
    private AscPriorityLvlAsID ascPriorityLvlAsID;

    public CaseAreaMapping(){}

    public CaseAreaMapping(AscPriorityLvlAsID ascPriorityLvlAsID, SFSbIssueArea sfSbIssueArea) {
        this.ascPriorityLvlAsID = ascPriorityLvlAsID;
        this.sfSbIssueArea = sfSbIssueArea;
    }

    @OneToOne(
            targetEntity = SFSbIssueArea.class,
            fetch= FetchType.EAGER,
            cascade= CascadeType.DETACH
    )
    @JoinColumn(
            name="sf_issue_area_id",
            referencedColumnName = "sf_issue_area_id",
            nullable = false,
            foreignKey = @ForeignKey(name="FK_SfIssueArea_To_SfIssueArea")
    )
    private SFSbIssueArea sfSbIssueArea;

}
