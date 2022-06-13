package com.StudentService.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BookDTO {

	private Integer bookId;
	private String bookName;
	private Double bookCost;
	private Integer quantity;
	private Double totalPrice;
}
