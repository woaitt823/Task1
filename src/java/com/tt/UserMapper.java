package com.tt;

//mapper接口，相当于dao接口
public interface UserMapper {


    //根据id查询用户信息
    public User findUserById(int id) throws Exception;
    public int insertUser(User user)throws Exception;
}