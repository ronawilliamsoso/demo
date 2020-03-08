package com.example.demo.relations.oneToOneJoinColumn;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

/**
 * @Author wangwei
 * @Date 07.03.20
 *
 *
 * @JoinColumn的属性：（一对一但是不能保证多夫一妻）
 *
 * 新建另外一个人拥有这个wife，数据库不会出错
 *
 * 关系被维护端要负责与被维护端的关系建立，同时也要负责与被维护端的关系解除，而被维护端对这些一无所知。
 *
 * CascadeType 不设置的话，会导致人不在了，wife还在
 *
 * 关系拥有方说明自己可以有一个外联对象，但是不能保证同一个对象不能被另外一个人拥有
 *
 * name属性：外键列的名称，一般也可以自定义，也可以采用默认值。
 *
 * referencedColumnName属性：参考列，默认值是关联表的主键。例如你可以定义pet_name为参考列，那么就会将pet的name的值关联到这一列。
 *
 *
 *
 * mappedBy:拥有关联关系的域，拥有关系的这一方有建立、解除和更新与另一方关系的能力，
 * 而另一方没有，只能被动管理，这个属性被定义在关系的被拥有方
 *
 * 关系拥有放必须负责关系的建立，删除，保存，更行等。所以新建一个person的时候，需要先save一个wife(设置了级联保存和级联删除则不用这样做)
 *         wifeRepo.save(wife);
 *         personRepo.save(husband);
 *
 *  如果只删除wifi，而不清空这个外键n，那么就会报错
 *  所以
 *  CascadeType.PERSIST代表级联保存，CascadeType.REMOVE代表级联删除，
 *  所以现在可以在保存Husband的时候保存Wife，在删除Husband时候删除Wife了
 **/

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@DynamicInsert
@DynamicUpdate
public class JPerson {

    @Id
    private Integer  personId;

    private String  firstName;

    private String  lastName;

    @OneToOne(fetch= FetchType.LAZY,cascade = {CascadeType.PERSIST,CascadeType.REMOVE})
    @JoinColumn(name="wife_id", referencedColumnName="wifeId" ) //address_id  为数据库本表外键字段，id为java对象里的字段名
    private JWife jWife;

}
