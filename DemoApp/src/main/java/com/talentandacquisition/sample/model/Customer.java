package com.talentandacquisition.sample.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name="CONVERTCSV")
@EqualsAndHashCode
public class Customer implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "_id")
	private String _id;
	@Column(name = "index")
	private Integer index;
	@Column(name = "age")
	private Integer age;
	@Column(name = "eyeColor")
	private String eyeColor;
	@Column(name = "name")
	private String name;
	@Column(name = "gender")
	private String gender;
	@Column(name = "company")
	private String company;
	@Column(name = "email")
	private String email;
	@Column(name = "phone")
	private String phone;
	/*
	 * @OneToOne(targetEntity = Address.class, cascade = CascadeType.ALL) private
	 * Address address;
	 */
	@Column(name = "number")
	private Integer number;
	@Column(name = "street")
	private String street;
	@Column(name = "city")
	private String city;
	@Column(name = "state")
	private String state;
	@Column(name = "zipcode")
	private String zipcode;

	@Column(name = "about")
	private String about;
	@Column(name = "registered")
	private String registered;
	@Column(name = "latitude")
	private Double latitude;
	@Column(name = "longitude")
	private Double longitude;
	/*@ElementCollection(targetClass = String.class)
	@Column(name = "tags")
	private List<String> tags;*/
	@Column(name = "tags0")
	private String tags0;
	@Column(name = "tags1")
	private String tags1;
	@Column(name = "tags2")
	private String tags2;
	@Column(name = "tags3")
	private String tags3;
	@Column(name = "tags4")
	private String tags4;
	@Column(name = "tags5")
	private String tags5;
	@Column(name = "tags6")
	private String tags6;

}
