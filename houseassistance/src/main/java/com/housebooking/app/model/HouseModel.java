package com.housebooking.app.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "houses")
public class HouseModel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;
	private String houseOwnerMail;
	private String houseName;
	private String houseAddress;
	private String houseType;
	private String houseContact;
	private String houseRent;
	private String houseDetails;
	private String city;
	private String availableFrom;
	private String parking;
	private String petFriendly;
	private String lawn;

	@Lob
	@Column(columnDefinition = "MEDIUMBLOB")
	private String housePhoto;
	private String isBooked;
	private String isHide;
	private int likes;
	private int dislikes;
	@Lob
	@Column(columnDefinition = "MEDIUMBLOB")
	private String document;
	
	
	
}
