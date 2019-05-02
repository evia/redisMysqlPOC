package com.example.springboot.redis.mysql.poc.redisMysqlPOC.dl.entities;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;


@Entity
@Table(name = "sf_cases")
@Data
public class SfCase implements Serializable {

    private static final long serialVersionUID = -8243145429438016232L;

    public SfCase(){}

    @Id
    @NotEmpty
    @Column(name = "sf_case_num", nullable = false)
    private String sfCaseNum;

    @ManyToOne(
            targetEntity = SfStatus.class,
            fetch = FetchType.EAGER,
            cascade = CascadeType.DETACH

    )
    @JoinColumn(
            name = "status_id",
            referencedColumnName = "sf_status_id",
            nullable = false,
            foreignKey = @ForeignKey(name = "FK_SfCase_To_SFStatusId")
    )
    private SfStatus status;

    public SfCase(String sfCaseNum, SfStatus status) {
        this.sfCaseNum = sfCaseNum;
        this.status = status;
    }

}
