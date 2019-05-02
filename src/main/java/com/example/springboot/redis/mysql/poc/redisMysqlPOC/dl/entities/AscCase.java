package com.example.springboot.redis.mysql.poc.redisMysqlPOC.dl.entities;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.sql.Timestamp;

@Entity
@Table(name="asc_cases")
@Data
public class AscCase implements Serializable {

    private static final long serialVersionUID = -8243145429438016231L;

    public AscCase(){}

    @Id
    @NotEmpty
    @Column(name = "asc_case_id", nullable = false)
    @Digits(fraction = 0, integer = 20)
    private String ascCaseId;

    @ManyToOne(
            targetEntity = AscWorkstep.class,
            fetch= FetchType.EAGER,
            cascade= CascadeType.DETACH
    )
    @JoinColumn(
            name="workstep_id",
            referencedColumnName = "asc_workstep_id",
            foreignKey = @ForeignKey(name="FK_AscCase_To_AscWorkstepId")
    )
    private AscWorkstep workstep;

    @Column(nullable = false)
    private Timestamp clientCreationTime;

    @Column
    private Timestamp clientUpdateTime;

    public AscCase(@NotNull String ascCaseId, AscWorkstep workstep, Timestamp clientCreationTime) {
        this.ascCaseId = ascCaseId;
        this.workstep = workstep;
        this.clientCreationTime = clientCreationTime;
    }

}