package org.zerock.w2.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BoardVO {

	private Long bno;
	private String title;
	private String content;
	private String writer;
	
	private LocalDateTime regDate;
	private LocalDateTime modDate;
	
	
	
}
