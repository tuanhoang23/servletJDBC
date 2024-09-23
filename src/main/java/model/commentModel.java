package model;

public class commentModel extends abstractModel<commentModel> {
	

	private String conten;
	private long user_Id;
	private long news_Id;
	
	public commentModel() {
		super();
	}

	public commentModel(String conten, long user_Id, long news_Id) {
		super();
		this.conten = conten;
		this.user_Id = user_Id;
		this.news_Id = news_Id;
	}

	public String getConten() {
		return conten;
	}

	public void setConten(String conten) {
		this.conten = conten;
	}

	public long getUser_Id() {
		return user_Id;
	}

	public void setUser_Id(long user_Id) {
		this.user_Id = user_Id;
	}

	public long getNews_Id() {
		return news_Id;
	}

	public void setNews_Id(long news_Id) {
		this.news_Id = news_Id;
	}
	
	
	
	
}
