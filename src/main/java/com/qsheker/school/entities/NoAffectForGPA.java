package com.qsheker.school.entities;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Getter
@Setter
@AllArgsConstructor
@Entity
@DiscriminatorValue("NO_AFFECT")
public class NoAffectForGPA extends Course{
    private boolean affect;
    public NoAffectForGPA(){
        super.setAffect(false);
    }
}
