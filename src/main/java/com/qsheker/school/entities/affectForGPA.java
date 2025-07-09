package com.qsheker.school.entities;

import lombok.*;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Getter
@Setter
@AllArgsConstructor
@Entity
@DiscriminatorValue("AFFECT")
public class affectForGPA extends Course{
    private boolean affect;
    public affectForGPA(){
        super.setAffect(true);
    }
}