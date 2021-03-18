package cn.yajienet.demo.service.impl;

import cn.yajienet.demo.dao.UserDao;
import cn.yajienet.demo.model.User;
import cn.yajienet.demo.model.UserExample;
import cn.yajienet.demo.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Description
 * @Author WangChenguang
 * @Date 2021-03-14 17:34
 */
@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Resource
    private UserDao userDao;

    @Override
    public List<User> demo(String name) {
        UserExample example = new UserExample();
        example.createCriteria().andUserNameEqualTo(name);
        return userDao.selectByExample(example);
    }

}
