package hyberintern;

import java.io.Serializable;

public class BookDTO implements Comparable<BookDTO>,Cloneable,Serializable{
	private int bid;
	private String bookName,authorName;
	private float bookPrice;
	private Comment comment;
	
	private BookDTO() {
		// TODO Auto-generated constructor stub
	}
	
	public BookDTO(int bid, String bookName, String authorName, float bookPrice, Comment comment) {	
		this.bid = bid;
		this.bookName = bookName;
		this.authorName = authorName;
		this.bookPrice = bookPrice;
		this.comment = comment;
	}
	
	public BookDTO getClone() {
		try {
			return (BookDTO)super.clone();
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public final int getBid() {
		return bid;
	}
	public final void setBid(int bid) {
		this.bid = bid;
	}
	public final String getBookName() {
		return bookName;
	}
	public final void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public final String getAuthorName() {
		return authorName;
	}
	public final void setAuthorName(String authorName) {
		this.authorName = authorName;
	}
	public final float getBookPrice() {
		return bookPrice;
	}
	public final void setBookPrice(float bookPrice) {
		this.bookPrice = bookPrice;
	}
	public final Comment getComment() {
		return comment;
	}
	public final void setComment(Comment comment) {
		this.comment = comment;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((authorName == null) ? 0 : authorName.hashCode());
		result = prime * result + bid;
		result = prime * result + ((bookName == null) ? 0 : bookName.hashCode());
		result = prime * result + Float.floatToIntBits(bookPrice);
		result = prime * result + ((comment == null) ? 0 : comment.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BookDTO other = (BookDTO) obj;
		if (authorName == null) {
			if (other.authorName != null)
				return false;
		} else if (!authorName.equals(other.authorName))
			return false;
		if (bid != other.bid)
			return false;
		if (bookName == null) {
			if (other.bookName != null)
				return false;
		} else if (!bookName.equals(other.bookName))
			return false;
		if (Float.floatToIntBits(bookPrice) != Float.floatToIntBits(other.bookPrice))
			return false;
		if (comment == null) {
			if (other.comment != null)
				return false;
		} else if (!comment.equals(other.comment))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "BookDTO [bid=" + bid + ", bookName=" + bookName + ", authorName=" + authorName + ", bookPrice="
				+ bookPrice + ", comment=" + comment + "]";
	}
	
	@Override
	public int compareTo(BookDTO o) {
		return this.bookName.compareTo(o.bookName);
	}
}
