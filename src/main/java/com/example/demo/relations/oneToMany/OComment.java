package com.example.demo.relations.oneToMany;

import com.example.demo.relations.oneToOneBoth.MWife;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author wangwei
 * @Date 07.03.20
 **/

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class OComment {

    @Id
    private Integer  commentId;

    private String  commentText;

    @ManyToOne(targetEntity=OBook.class)
    @JoinColumn(name = "book_id")
    private OBook  ojbBook;

}
