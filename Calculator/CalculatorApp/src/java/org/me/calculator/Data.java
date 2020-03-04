/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.me.calculator;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Class Entity
 * @version 6.0
 * @author Paulina Urbas
 */
@Entity
public class Data implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    /**
     * SentenceAfter after operation
     * @version 6.0
     * @author Paulina Urbas
     */
    private String SentenceAfter;

    /**
     * Get the value of SentenceAfter
     *@version 6.0
     * @author Paulina Urbas
     * @return the value of SentenceAfter
     */
    public String getSentenceAfter() {
        return SentenceAfter;
    }

    /**
     * Set the value of SentenceAfter
     * @version 6.0
     * @author Paulina Urbas
     * @param SentenceAfter new value of SentenceAfter
     */
    public void setSentenceAfter(String SentenceAfter) {
        this.SentenceAfter = SentenceAfter;
    }
     /**
     * Sentence before soriting
     * @version 6.0
     * @author Paulina Urbas
     */
    private String SentenceBefore;

    /**
     * Get the value of SentenceBefore
     * @version 6.0
     * @author Paulina Urbas
     * @return the value of SentenceBefore
     */
    public String getSentenceBefore() {
        return SentenceBefore;
    }

    /**
     * Set the value of SentenceBefore
     * @version 6.0
     * @author Paulina Urbas
     * @param SentenceBefore new value of SentenceBefore
     */
    public void setSentenceBefore(String SentenceBefore) {
        this.SentenceBefore = SentenceBefore;
    }
    /**
     * Hashcode function
     * @version 6.0
     * @author Paulina Urbas
     */
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }
    /**
     * Hashcode function
     * @version 6.0
     * @author Paulina Urbas
     * @param object
     */
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Data)) {
            return false;
        }
        Data other = (Data) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }
     /**
     * toString function 
     * @version 6.0
     * @author Paulina Urbas
     */
    @Override
    public String toString() {
        return " Setence before=" + SentenceBefore + " Sentence after: "+ SentenceAfter + " ";
    }
    
}
