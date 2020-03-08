package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Stream implements Serializable {

    @EmbeddedId
    private StreamPK id;

    @Column(name = "ACTIVE_")
    private Character active;

    @Column(name = "SUBSCRIBE_ON_PARTICIPATION")
    private Character subscribeOnParticipation;

    @Column(name = "DIALOGUE_SUBSCRIBE")
    private String dialogueSubscribe;

    @Column(name = "DIALOGUE_UNSUBSCRIBE")
    private String dialogueUnsubscribe;

    @ManyToOne
    @JoinColumn(name = "fundraiser", referencedColumnName = "code", insertable = false, updatable = false)
    private Fundraiser fundraiser;

    @ManyToOne
    @JoinColumn(name = "medium", referencedColumnName = "code", insertable = false, updatable = false)
    private Medium medium;

    private Stream(String name) {
        StreamPK streamPK = new StreamPK();
        streamPK.setName(name);
        id = streamPK;
    }

    public String getFundraiserCode() {
        return getId().getFundraiser();
    }

    public String getMediumCode() {
        return getId().getMedium();
    }

    public String getName() {
        return getId().getName();
    }

    public Boolean getActive() {
        if (active == null) return null;
        return active == 'Y' ? Boolean.TRUE : Boolean.FALSE;
    }

    public void setActive(Boolean active) {
        if (active == null) this.active = null;
        else this.active = ((active == true) ? 'Y' : 'N');
    }

    public boolean isSubscribeOnParticipation() {
        return subscribeOnParticipation.equals('Y');
    }

    public void setSubscribeOnParticipation(boolean subscribeOnParticipation) {
        this.subscribeOnParticipation = subscribeOnParticipation ? 'Y' : 'N';
    }

    @Override
    public String toString() {
        return String.format("Stream [id=%s, active=%s]", id, active);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;
        Stream other = (Stream) obj;
        if (id == null) {
            if (other.id != null) return false;
        } else if (!id.equals(other.id)) return false;
        return true;
    }

}