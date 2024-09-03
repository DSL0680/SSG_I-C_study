package org.zerock.w2.vo;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class PageRequest {
	
	private int page = 1;
	
	private int size = 10;

	public void setPage(int page) {
		this.page = page <= 0 ? 1 : page;
	}

	public void setSize(int size) {
		this.size = size <= 10 ? 10 : size >= 100 ? 100 : size;
	}
	
	public int getSkip() {
		
		return (this.page -1) * 10; 
	}
	
	

}
