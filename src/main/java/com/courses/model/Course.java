package com.courses.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
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
	private LocalDateTime listedAt;
	@Column(name = "delisted_at")
	private LocalDateTime delistedAt;
	@Enumerated(EnumType.STRING)
	@Column(name = "delist_reason")
	private DelistReason delistReason;
	@Column(name = "course_status")
	private Byte courseStatus;
	@Column(name = "save_count")
	private Integer saveCount;
	@Column(name = "star_count")
	private Integer starCount;
	@Column(name = "review_count")
	private Integer reviewCount;
	@Column(name = "comment_count")
	private Integer commentCount;
	@Column(name = "psych_discount")
	private BigDecimal psychDiscount;
	@Column(name = "discount_start")
	private LocalDateTime discountStart;
	@Column(name = "discount_end")
	private LocalDateTime discountEnd;
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
	public LocalDateTime getListedAt() {
		return listedAt;
	}
	public void setListedAt(LocalDateTime listedAt) {
		this.listedAt = listedAt;
	}
	public LocalDateTime getDelistedAt() {
		return delistedAt;
	}
	public void setDelistedAt(LocalDateTime delistedAt) {
		this.delistedAt = delistedAt;
	}
	public DelistReason getDelistReason() {
		return delistReason;
	}
	public void setDelistReason(DelistReason delistReason) {
		this.delistReason = delistReason;
	}
	public Byte getCourseStatus() {
		return courseStatus;
	}
	public String getCourseStatusMsg() {
		courseStatus = getCourseStatus();
		String courseStatusMsg = "";
		switch(courseStatus) {
		case 1:
			courseStatusMsg = "待審核";
			break;
		case 2:
			courseStatusMsg = "審核成功";
			break;
		case 3:
			courseStatusMsg = "審核失敗";
			break;
		case 4:
			courseStatusMsg = "已上架";
			break;
		case 5:
			courseStatusMsg = "已下架";
			break;
		default:
			courseStatusMsg = "草稿";
	}
		return courseStatusMsg;
	}
	public void setCourseStatus(Byte courseStatus) {
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
	public BigDecimal getPsychDiscount() {
		return psychDiscount;
	}
	public void setPsychDiscount(BigDecimal psychDiscount) {
		this.psychDiscount = psychDiscount;
	}
	public LocalDateTime getDiscountStart() {
		return discountStart;
	}
	public void setDiscountStart(LocalDateTime discountStart) {
		this.discountStart = discountStart;
	}
	public LocalDateTime getDiscountEnd() {
		return discountEnd;
	}
	public void setDiscountEnd(LocalDateTime discountEnd) {
		this.discountEnd = discountEnd;
	}
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	
	
}
