package jsp.service;

import jsp.domain.Person;
import jsp.dao.PersonDAO;

/**
 * 业务逻辑层(服务类)
 * */
public class PersonService {
	/**
     * 根据用户名 和 密码查询其它信息 
     * @param user
     * @return 如果返回null证明 用户名或者密码错误
     */
    public Person login(Person user) {
    	System.out.println(user.getName()+" : "+user.getPassword());
        PersonDAO dao = new PersonDAO(); //查询， 将 user对象传递 DAO
        return dao.login(user);
    }
}
