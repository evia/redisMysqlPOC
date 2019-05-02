package com.example.springboot.redis.mysql.poc.redisMysqlPOC.dl.entities;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="case_id_mapping")
@Data
public class CaseIdMapping implements Serializable {

    private static final long serialVersionUID = -8243145429438016233L;

    @EmbeddedId
    private AscCaseAsID ascCaseAsID;

    public CaseIdMapping(){}

    public CaseIdMapping(AscCaseAsID ascCaseAsID, SfCase sfCase) {
        this.ascCaseAsID = ascCaseAsID;
        this.sfCase = sfCase;
    }

    @OneToOne(
            targetEntity = SfCase.class,
            fetch= FetchType.EAGER,
            cascade= CascadeType.DETACH
    )
    @JoinColumn(
            name="sf_case_num",
            referencedColumnName = "sf_case_num",
            nullable = false,
            foreignKey = @ForeignKey(name="FK_CasesMapping_To_SfCaseId")
    )
    private SfCase sfCase;

}