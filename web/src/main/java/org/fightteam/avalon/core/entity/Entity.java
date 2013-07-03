package org.fightteam.avalon.core.entity;

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
public class Entity<T> {
    @Id
    @GeneratedValue
    private T id;
    @Temporal(TemporalType.TIMESTAMP)
    private Date createAt;
    @Temporal(TemporalType.TIMESTAMP)
    private Date updateAt;

    /**
     * 创建实体时候初始化相关属性
     */
    public Entity() {

        this.createAt = new Date();
        this.updateAt = new Date();
    }
    /*========================get and set methods==================================*/
    public T getId() {
        return id;
    }

    public void setId(T id) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Entity entity = (Entity) o;

        if (!id.equals(entity.id)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }
}
