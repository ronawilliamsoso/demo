package com.example.demo.relations.oneToOneBoth;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

/**
 * @Author wangwei
 * @Date 07.03.20
 *
 * mappedBy表明了关系被维护端，好处是，
 *
 * 这样我们就可以通过Wife得到对应的person，仅此而已
 *
 * 通过新建wife 指定一个新建的person，结果是person和wifi之间没有关联，
 * 即使加上CascadeType.ALL，仍然不能建立关系，所以关系的建立还是要依赖关系维护端来操作。
 *
 * 这种关系下，指定多个person的wife为同一个人并不会立马报错，但是查询一个拥有多个wifi的对象（wife.getPerson();）会导致报错
 * more than one row with the given identifier was found.(脏数据了？)
 *
 *
 * 指定了mappedBy 就相当于指定了双向关系。
 * 即使有了双向关系，也不能通过 wife建立和person之间的"健康关系"，关系的建立和维护还是需要通过关系拥有者去健康的实现。
 *
 * 所谓一对一映射，并不能保证双向一夫一妻，只能保证一夫只有一个妻子（关系维护端只关联一个被维护端），一个妻子被多人拥有不可避免。
 *
 *
 * 总结上述
 *
 * 无论单向还是双向，关系的保存都需要关系维护段来进行操作
 * 所谓一对一映射，其实是关系维护端的映射关系，关系维护端确实只关联一个被维护端，但是被维护端和几个维护段关联就不得而知了
 * 关系维护端可以主动修改关系，而被维护端只能被动接受
 *
 **/

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MWife {

    @Id
    private Integer  wifeId;

    @OneToOne(mappedBy = "mWife", cascade = CascadeType.ALL) // mWife  是 MPerson对象里的那个属性，所以mappedBy不能独立存在
    MPerson mPerson;

    private String  street;
    private String  postcode;

}
