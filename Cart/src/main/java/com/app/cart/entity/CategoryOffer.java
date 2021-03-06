package com.app.cart.entity;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * @author Omkar Nikam
 * @since 03-Feb-2018
 * Table for Category Offers
 */

@Entity
@Table(name="CategoryOffer")
@Data
@EqualsAndHashCode(exclude = {"category"})
@ToString(exclude = {"category"})
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "categoryOfferId")
public class CategoryOffer {
	
	@Id
	@Column(unique = true, nullable = false)
	@SequenceGenerator(name="categoryoffer_seq", sequenceName="categoryoffer_seq", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="categoryoffer_seq")
	private Integer categoryOfferId;
	
	@Column(unique = false, nullable = false, length=50)
	private String offerDescription;
	
	@Column(unique = false, nullable = false, length=15)
	private String couponCode;
	
	@Column(unique = false, nullable = true)
	private Double discountPercent;
	
	@Column(unique = false, nullable = true)
	private Double discountAmount;
	
	@Column(unique = false, nullable = false)
	private Double minOrderAmount;
	
	@Column(unique = false, nullable = false)
	private Double maxDiscountAmount;
	
	@Column(unique = false, nullable = false)
	@JsonFormat(pattern="dd-MM-yyyy")
	private Date creationDate;
	
	@Column(unique = false, nullable = false)
	@JsonFormat(pattern="dd-MM-yyyy")
	private Date expiryDate;
	
	@ManyToOne
	@JoinColumn( name = "categoryId", nullable = false )
	private Category category;
	
}
