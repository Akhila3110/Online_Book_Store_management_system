package com.obsm.customer.model;

public class Review {
	private long reviewId;
	private int rating;
	private String headline;
	private String comment;
	private long customerId;
	private long bookId;
	public long getBookId() {
		return bookId;
	}
	public void setBookId(long bookId) {
		this.bookId = bookId;
	}
	public long getCustomerId() {
		return customerId;
	}
	public void setCustomerId(long customerId) {
		this.customerId = customerId;
	}
	public long getReviewId() {
		return reviewId;
	}
	public void setReviewId(long reviewId) {
		this.reviewId = reviewId;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	public String getHeadline() {
		return headline;
	}
	public void setHeadline(String headline) {
		this.headline = headline;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public Review() {
	}
	@Override
	public String toString() {
		return "Review [reviewId=" + reviewId + ", rating=" + rating + ", headline=" + headline + ", comment=" + comment
				+ "]";
	}
}
