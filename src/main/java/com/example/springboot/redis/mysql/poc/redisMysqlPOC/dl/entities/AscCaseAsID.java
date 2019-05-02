package com.example.springboot.redis.mysql.poc.redisMysqlPOC.dl.entities;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Embeddable
@Data
public class AscCaseAsID implements Serializable {

    private static final long serialVersionUID = -8243145429438016234L;

    @OneToOne(
            targetEntity = AscCase.class,
            fetch= FetchType.EAGER,
            cascade= CascadeType.DETACH
    )
    @JoinColumn(
            name="asc_case_id",
            referencedColumnName = "asc_case_id",
            nullable = false,
            foreignKey = @ForeignKey(name="FK_CasesMapping_To_AscCaseId")
    )
    private AscCase ascCase;

    public AscCaseAsID(){}

    public AscCaseAsID(AscCase ascCase) {
        this.ascCase = ascCase;
    }

}
