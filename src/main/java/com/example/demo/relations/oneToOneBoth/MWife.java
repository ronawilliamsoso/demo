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

    @OneToOne(mappedBy = "mWife", cascade = CascadeType.ALL)
    MPerson mPerson;

    private String  street;
    private String  postcode;

}
