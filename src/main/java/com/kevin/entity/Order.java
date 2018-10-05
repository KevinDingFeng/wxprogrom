package com.kevin.entity;

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
 * 订单
 * 	目前用于秒杀、积分兑换 商品
 * @author kevin
 *
 */
@Entity
@Table(name = "orders")
//@Cacheable
@EqualsAndHashCode(callSuper=false)
@Data
public class Order extends BaseEntity{

	private Long goodId;
	
	private Long userId;
	
	@Enumerated(EnumType.STRING)
	@Column(nullable = false, length = 64)
	private Status status = Status.Complete;
	public static enum Status{
		Complete("完成");
		private String text;
		private Status(String text) {
			this.text = text;
		}
		public String getText() {
			return text;
		}
		public static List<Status> getAllStatus(){
			return Arrays.asList(Status.values());
		}
	}
	
	@Enumerated(EnumType.STRING)
	@Column(nullable = false, length = 64)
	private Type type ;
	
	public static enum Type{
		Second("秒杀"), Exchange("兑换");
		
		private String text;
		
		private Type(String text) {
			this.text = text;
		}
		public String getText() {
			return this.text;
		}
		
		public static List<Type> getAllTypes(){
			return Arrays.asList(Type.values());
		}
	}
}
