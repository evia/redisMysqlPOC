package com.example.springboot.redis.mysql.poc.redisMysqlPOC.dl.entities;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name="asc_priority_level")
@Data
public class AscPriorityLevel {

    public enum AscPriorityLevelType {

        MAJOR_VIOLATION((short)1, "MAJOR_VIOLATION"),
        SPECIAL_HANDLING((short)2, "SPECIAL_HANDLING"),
        FAAR((short)3, "FAAR"),
        COMPLIANCE((short)4, "COMPLIANCE"),
        MINOR_VIOLATION((short)5, "MINOR_VIOLATION"),
        AUTO_HOLD_RESERVE((short)6, "AUTO_HOLD_RESERVE");

        private Short id;
        private String name;

        AscPriorityLevelType(Short id, String name) {
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
    @Column( nullable = false, name="asc_priority_id")
    private Short ascPriorityId;

    @NotEmpty
    @Column(nullable = false, name="description")
    private String description;

    public AscPriorityLevel() {
    }

    public AscPriorityLevel(AscPriorityLevelType type) {
        this.ascPriorityId = type.getId();
        this.description = type.getName();
    }
}
