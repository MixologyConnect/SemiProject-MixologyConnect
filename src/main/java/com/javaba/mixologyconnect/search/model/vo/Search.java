package com.javaba.mixologyconnect.search.model.vo;

import java.util.List;

import com.javaba.mixologyconnect.board.model.vo.Board;
import com.javaba.mixologyconnect.board.model.vo.BoardImage;
import com.javaba.mixologyconnect.cocktail.model.vo.Cocktail;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@ToString
@NoArgsConstructor
public class Search {
	
	private String keyWord;
	int keyWordAllNo; 
	private List<Board> boardList;
	private List<Cocktail> cocktailList;
	
}
