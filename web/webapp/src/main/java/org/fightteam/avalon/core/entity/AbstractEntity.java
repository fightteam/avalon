package org.fightteam.avalon.core.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.springframework.hateoas.Identifiable;

import javax.persistence.*;
import java.util.Date;

/**
 * 实体公共父类
 * User: faith
 * Date: 13-7-1
 * Time: 下午5:45
 * pojo的高度抽象化父类
 * 定义了实体类的公共属性
 */
@MappedSuperclass
@EqualsAndHashCode
@Getter
@Setter
public class AbstractEntity implements Identifiable<Long> {
    @Id
    @GeneratedValue
    private Long id;
    @Temporal(TemporalType.TIMESTAMP)
    private Date createAt;
    @Temporal(TemporalType.TIMESTAMP)
    private Date updateAt;

    /**
     * 创建实体时候初始化相关属性
     */
    public AbstractEntity() {

        this.createAt = new Date();
        this.updateAt = new Date();
    }
    /*========================get and set methods==================================*/
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    public Date getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(Date updateAt) {
        this.updateAt = updateAt;
    }


}
