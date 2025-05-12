package com.glendon.makerClass.makerClass.model.entity;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Entity
@Getter
@Setter
public class Diretor extends Usuario implements Serializable {

    private static final long serialVersionUID = 1L;


}
