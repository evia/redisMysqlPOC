package com.example.springboot.redis.mysql.poc.redisMysqlPOC.dl.entities;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name="asc_workstep")
@Data
public class AscWorkstep {

    public enum AscWorkstepType {

        RISK_MINOR_VIOLATION((short)1, "RiskMinorViolations"),
        RISK_ACCOUNT_REVIEW((short)2, "RiskAccountReview"),
        RISK_SPECIAL_HANDLING((short)3, "RiskSpecialHandling"),
        RISK_MAJOR_VIOLATIONS((short)4, "RiskMajorViolations"),
        RISK_AWAITING_ACTIVITY((short)5, "RiskAwaitingActivity"),
        RISK_FOLLOWUP((short)6, "RiskFollowup"),
        RISK_PENDING_CLOSE((short)7, "RiskPendingClose"),
        EMPTY((short)8, "Empty-New");

        private Short id;
        private String name;

        AscWorkstepType(Short id, String name) {
            this.name = name;
            this.id = id;
        }

        public static AscWorkstepType fromString(String name) {
            for(AscWorkstepType type : AscWorkstepType.values()) {
                if(type.name.equalsIgnoreCase(name))
                    return type;
            }
            return null;
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
    @Column(name="asc_workstep_id")
    private Short ascWorkstepId;

    @NotEmpty
    @Column(nullable = false, name="description")
    private String description;

    public AscWorkstep() {
    }

    public AscWorkstep(AscWorkstepType ascWorkstepType) {
        this.ascWorkstepId = ascWorkstepType.getId();
        this.description =  ascWorkstepType.getName();
    }

    public AscWorkstep(Short ascWorkStepId, String description){
        this.ascWorkstepId = ascWorkStepId;
        this.description = description;
    }
}