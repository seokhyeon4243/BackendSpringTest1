package myspring.user.dao;

import java.util.List;

import myspring.user.vo.UserVO;

public interface UserDao {
	public void insert(UserVO user);


	public void update(UserVO user);

	public void delete(String id);

	public List<UserVO> readAll();

	public UserVO read(String id);

}
