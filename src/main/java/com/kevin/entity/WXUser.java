package com.kevin.entity;

import java.sql.Date;
import java.util.Arrays;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 微信用户信息 暂时使用微信授权，不做登录，所以舍掉了 account 和 password等登录使用的信息
 * 
 * @author kevin
 *
 */
@Entity
@Table(name = "wx_user")
// @Cacheable
@EqualsAndHashCode(callSuper = false)
@Data
public class WXUser extends BaseEntity {

	@Column(nullable = true, length = 64)
	private String openId;// 微信用户唯一id 尝试是否可以获取到

	@Column
	private String nickName;
	@Column
	private String gender;
	@Column
	private String language;
	@Column
	private String city;
	@Column
	private String province;
	@Column
	private String country;
	@Column
	private String avatarUrl;
	@Column
	private String unionId;
	// 测试页面选择的性别 0: 男女1: 男
	@Column
	private int mpGender;
	// 测试页面选择的星座 0-11 分别代表12星座[白羊座,金牛座,双子座,巨蟹座,狮子座 ,处女座,天秤座 ,天蝎座 ,射手座 ,摩羯座 ,水瓶座
	// ,双鱼座]
	@Column
	private int constellation;
	@Column
	private int age;
	/**
	 * 用户类型：游客、会员、vvip
	 */
	@Enumerated(EnumType.STRING)
	@Column(nullable = false, length = 64)
	private Type type = Type.Guest;

	public static enum Type {
		Guest("游客"), VIP("会员"), VVIP("超级会员");
		// 超级会员，供定风内部人员使用

		private String text;

		private Type(String text) {
			this.text = text;
		}

		public String getText() {
			return this.text;
		}

		public static List<Type> getAllTypes() {
			return Arrays.asList(Type.values());
		}
	}

	// 下面的字段，会员必须填：手机号、会员名、生日
	/**
	 * 会员名称
	 */
	@Column(nullable = true, length = 64)
	private String name;
	/**
	 * 联系方式
	 */
	@Column(nullable = true, length = 64)
	private String telephone;

	/**
	 * 生日，年-月-日
	 */
	@Column(nullable = true)
	private Date birthday; // = new Date(System.currentTimeMillis())
}
