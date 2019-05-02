package com.example.springboot.redis.mysql.poc.redisMysqlPOC.dl.entities;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

@Entity
@Table(name="sf_sb_issue_area")
@Data
public class SFSbIssueArea implements Serializable {

    private static final long serialVersionUID = -8243145429438016236L;

    public enum SFSbIssueAreaType {

        FRAUD((short)1, "Fraud"),
        FINANCIAL((short)2, "Financial"),
        RISK_COMPLIANCE((short)3, "RiskCompliance");

        private Short id;
        private String name;

        SFSbIssueAreaType(Short id, String name) {
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
    @Column( nullable = false, name="sf_issue_area_id")
    private Short sfIssueAreaId;

    @NotEmpty
    @Column(nullable = false, name="description")
    private String description;

    public SFSbIssueArea() {
    }

    public SFSbIssueArea(SFSbIssueAreaType type) {
        this.sfIssueAreaId = type.getId();
        this.description = type.name;
    }

    public SFSbIssueArea(Short id, String description) {
        this.sfIssueAreaId = id;
        this.description = description;
    }
}
