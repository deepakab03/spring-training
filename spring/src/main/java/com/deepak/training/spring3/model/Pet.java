package com.deepak.training.spring3.model;

import java.io.Serializable;
import java.util.Date;

public class Pet implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private long id;
    private String name;
    private String owner;
    private String species;
    private String sex;
    private Date   birth;
    private Date   death;

    public Pet() {
    }

    public Pet(String name) {
        this.name = name;
    }
    
    public Pet(long petId) {
        this.id = petId;
    }

    public static Pet createTestPet() {
        Pet p = new Pet();
        
        p.setName("Ghonchu");
        p.setOwner("Pappu");
        p.setSpecies("Rodent");
        p.setSex("M");
        p.setBirth(new Date());
        p.setDeath(new Date());
        
        return p;
    }

    @Override
    public String toString() {
        return String.format("name '%s', owner '%s', species '%s', sex '%s', birth '%s', death '%s'", name,
                owner, species, sex, birth, death);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((birth == null) ? 0 : birth.hashCode());
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + ((owner == null) ? 0 : owner.hashCode());
        result = prime * result + ((sex == null) ? 0 : sex.hashCode());
        result = prime * result + ((species == null) ? 0 : species.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;
        Pet other = (Pet) obj;
        if (birth == null) {
            if (other.birth != null) return false;
        } else if (!birth.equals(other.birth)) return false;
        if (name == null) {
            if (other.name != null) return false;
        } else if (!name.equals(other.name)) return false;
        if (owner == null) {
            if (other.owner != null) return false;
        } else if (!owner.equals(other.owner)) return false;
        if (sex == null) {
            if (other.sex != null) return false;
        } else if (!sex.equals(other.sex)) return false;
        if (species == null) {
            if (other.species != null) return false;
        } else if (!species.equals(other.species)) return false;
        return true;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public Date getDeath() {
        return death;
    }

    public void setDeath(Date death) {
        this.death = death;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

}
