package com.tung2.IDclass;

import java.io.Serializable;

public class ChapterID implements Serializable {

	private Long stt;
	private Long idStory;
	
	public ChapterID() {}
	
	

	public ChapterID(Long stt, Long idStory) {
		super();
		this.stt = stt;
		this.idStory = idStory;
	}



	public Long getStt() {
		return stt;
	}

	public void setStt(Long stt) {
		this.stt = stt;
	}

	public Long getIdStory() {
		return idStory;
	}

	public void setIdStory(Long idStory) {
		this.idStory = idStory;
	}

	
}
