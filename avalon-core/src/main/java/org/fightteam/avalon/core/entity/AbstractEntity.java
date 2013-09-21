package org.fightteam.avalon.core.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Type;
import org.joda.time.DateTime;
import org.springframework.hateoas.Identifiable;

import javax.persistence.*;
import java.io.Serializable;

/**
 * 实体公共父类
 *
 * 实现了hateoas的Identifiable接口
 * pojo的高度抽象化父类,定义了avalon系统实体基本信息
 * 定义了实体类的公共属性，所有与数据库交互的实体类都应该继承该类
 *
 * <h2>注意！</h2>
 * <p>lombok插件与部分IDE的编译设置会产生问题，所以当产生错误是否，关闭IDE的扩展compile</p>
 *
 * @author excalibur
 * @since 0.0.1
 */
@MappedSuperclass
@EqualsAndHashCode
@Getter
@Setter
public abstract class AbstractEntity<T extends Serializable> implements Identifiable<T> {


    /**
     * id产生方式由程序来控制  方便支持不同的数据库
     */
    @Id
    @GeneratedValue
    private T id;
    @Temporal(TemporalType.TIMESTAMP)
    @Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")
    private DateTime createAt;
    @Temporal(TemporalType.TIMESTAMP)
    @Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")

    private DateTime updateAt;

    /**
     * 创建实体时候初始化相关属性
     */
    public AbstractEntity() {

        this.createAt = new DateTime();
        this.updateAt = new DateTime();
    }

}
