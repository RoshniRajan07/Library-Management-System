package in.kce.book.bean;

public class BookBean {
    private String ISBN;
    private String bookName;
    private AuthorBean author;
    private char bookType;
    private float cost;

    public String getISBN() {
        return ISBN;
    }
    public void setISBN(String iSBN) {
        ISBN = iSBN;
    }
    public String getBookName() {
        return bookName;
    }
    public void setBookName(String bookName) {
        this.bookName = bookName;
    }
    public AuthorBean getAuthor() {
        return author;
    }
    public void setAuthor(AuthorBean author) {
        this.author = author;
    }
    public char getBookType() {
        return bookType;
    }
    public void setBookType(char bookType) {
        this.bookType = bookType;
    }
    public float getCost() {
        return cost;
    }
    public void setCost(float cost) {
        this.cost = cost;
    }
	@Override
	public String toString() {
		return "BookBean [ISBN=" + ISBN + ", bookName=" + bookName + ", author=" + author + ", bookType=" + bookType
				+ ", cost=" + cost + "]";
	}
}
