package com.example.demo.relations.oneToMany;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.HashSet;
import java.util.Set;

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
public class OBook {

    @Id
    private Integer  bookId;

    private String  bookName;

    @OneToMany(fetch= FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "ojbBook")  //ojbbook 为java对象里的字段名
    private Set<OComment> comments = new HashSet<OComment>();


}
