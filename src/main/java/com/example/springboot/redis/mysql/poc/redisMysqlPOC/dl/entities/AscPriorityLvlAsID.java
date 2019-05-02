package com.example.springboot.redis.mysql.poc.redisMysqlPOC.dl.entities;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Embeddable
@Data
public class AscPriorityLvlAsID implements Serializable {
    @OneToOne(
            targetEntity = AscPriorityLevel.class,
            fetch= FetchType.EAGER,
            cascade= CascadeType.DETACH
    )
    @JoinColumn(
            name="asc_priority_lvl_id",
            referencedColumnName = "asc_priority_id",
            nullable = false,
            foreignKey = @ForeignKey(name="FK_AscPriorityId_To_AscPriorityLevelId")
    )
    private AscPriorityLevel ascPriorityLevel;

    public AscPriorityLvlAsID() {}

    public AscPriorityLvlAsID(AscPriorityLevel ascPriorityLevel) {
        this.ascPriorityLevel = ascPriorityLevel;
    }
}
