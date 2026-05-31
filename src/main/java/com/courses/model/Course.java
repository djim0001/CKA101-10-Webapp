package com.courses.model;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "courses")
public class Course {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "course_id")
	private Integer courseId;
	@Column(name = "course_name")
	private String courseName;
	@Column(name = "psych_id")
	private Integer psychId;
	@Column(name = "admin_id")
	private Integer adminId;
	@Column(name = "course_cat_id")
	private Integer courseCatId;
	@Column(name = "video_src")
	private String videoSrc;
	@Column(name = "video_src_pre")
	private String videoSrcPre;
	@Column(name = "outline")
	private String outline;
	@Column(name = "listed_at")
	private Date listedAt;
	@Column(name = "delisted_at")
	private Date delistedAt;
	@Column(name = "delist_reason")
	private String delistReason;
	@Column(name = "course_status")
	private String courseStatus;
	@Column(name = "save_count")
	private Integer saveCount;
	@Column(name = "star_count")
	private Integer starCount;
	@Column(name = "review_count")
	private Integer reviewCount;
	@Column(name = "comment_count")
	private Integer commentCount;
	@Column(name = "psych_discount")
	private Double psychDiscount;
	@Column(name = "discount_start")
	private Date discountStart;
	@Column(name = "discount_end")
	private Date discountEnd;
	@Column(name = "price")
	private Integer price;
	
	
	public Course() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Integer getCourseId() {
		return courseId;
	}
	public void setCourseId(Integer courseId) {
		this.courseId = courseId;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public Integer getPsychId() {
		return psychId;
	}
	public void setPsychId(Integer psychId) {
		this.psychId = psychId;
	}
	public Integer getAdminId() {
		return adminId;
	}
	public void setAdminId(Integer adminId) {
		this.adminId = adminId;
	}
	public Integer getCourseCatId() {
		return courseCatId;
	}
	public void setCourseCatId(Integer courseCatId) {
		this.courseCatId = courseCatId;
	}
	public String getVideoSrc() {
		return videoSrc;
	}
	public void setVideoSrc(String videoSrc) {
		this.videoSrc = videoSrc;
	}
	public String getVideoSrcPre() {
		return videoSrcPre;
	}
	public void setVideoSrcPre(String videoSrcPre) {
		this.videoSrcPre = videoSrcPre;
	}
	public String getOutline() {
		return outline;
	}
	public void setOutline(String outline) {
		this.outline = outline;
	}
	public Date getListedAt() {
		return listedAt;
	}
	public void setListedAt(Date listedAt) {
		this.listedAt = listedAt;
	}
	public Date getDelistedAt() {
		return delistedAt;
	}
	public void setDelistedAt(Date delistedAt) {
		this.delistedAt = delistedAt;
	}
	public String getDelistReason() {
		return delistReason;
	}
	public void setDelistReason(String delistReason) {
		this.delistReason = delistReason;
	}
	public String getCourseStatus() {
		return courseStatus;
	}
	public void setCourseStatus(String courseStatus) {
		this.courseStatus = courseStatus;
	}
	public Integer getSaveCount() {
		return saveCount;
	}
	public void setSaveCount(Integer saveCount) {
		this.saveCount = saveCount;
	}
	public Integer getStarCount() {
		return starCount;
	}
	public void setStarCount(Integer starCount) {
		this.starCount = starCount;
	}
	public Integer getReviewCount() {
		return reviewCount;
	}
	public void setReviewCount(Integer reviewCount) {
		this.reviewCount = reviewCount;
	}
	public Integer getCommentCount() {
		return commentCount;
	}
	public void setCommentCount(Integer commentCount) {
		this.commentCount = commentCount;
	}
	public Double getPsychDiscount() {
		return psychDiscount;
	}
	public void setPsychDiscount(Double psychDiscount) {
		this.psychDiscount = psychDiscount;
	}
	public Date getDiscountStart() {
		return discountStart;
	}
	public void setDiscountStart(Date discountStart) {
		this.discountStart = discountStart;
	}
	public Date getDiscountEnd() {
		return discountEnd;
	}
	public void setDiscountEnd(Date discountEnd) {
		this.discountEnd = discountEnd;
	}
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	
	
}
