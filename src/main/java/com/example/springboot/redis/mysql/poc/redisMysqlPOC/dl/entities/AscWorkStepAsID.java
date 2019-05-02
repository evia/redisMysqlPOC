package com.example.springboot.redis.mysql.poc.redisMysqlPOC.dl.entities;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Embeddable
@Data
public class AscWorkStepAsID implements Serializable {

    @OneToOne(
            targetEntity = AscWorkstep.class,
            fetch= FetchType.EAGER,
            cascade= CascadeType.DETACH
    )
    @JoinColumn(
            name="asc_workstep_id",
            referencedColumnName = "asc_workstep_id",
            foreignKey = @ForeignKey(name="FK_AscWorkstepId_To_AscWorkstepId")
    )
    private AscWorkstep ascWorkstep;

    public AscWorkStepAsID() {}

    public AscWorkStepAsID(AscWorkstep ascWorkstep) {
        this.ascWorkstep = ascWorkstep;
    }

}
