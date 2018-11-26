package swing.model;

import java.util.ArrayList;

public interface FriendDBA {//구현할 함수 명을 정하기 위해 인터페이스 만들고 함수명 정함.
	//추가
	//보기
	//검색
	public void friendInsert(Friend f) ;
	public ArrayList<Friend> friendView();
	public ArrayList<Friend> friendSearch(String key,String str);
}
