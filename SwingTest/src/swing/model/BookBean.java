package swing.model;

public class BookBean {
	private int num,price;
	private String title,writer,indate,outdate,gubun;
	public int getNum() {
		return num;
	}
	public int getPrice() {
		return price;
	}
	public String getTitle() {
		return title;
	}
	public String getWriter() {
		return writer;
	}
	public String getIndate() {
		return indate;
	}
	public String getOutdate() {
		return outdate;
	}
	public String getGubun() {
		return gubun;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public void setIndate(String indate) {
		this.indate = indate;
	}
	public void setOutdate(String outdate) {
		this.outdate = outdate;
	}
	public void setGubun(String gubun) {
		this.gubun = gubun;
	}
}
