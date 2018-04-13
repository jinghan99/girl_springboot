package com.yf.core.service.appuser;

import com.yf.core.dao.DaoSupport;
import com.yf.core.system.entiy.system.AppUser;
import com.yf.utils.Page;
import com.yf.utils.PageData;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Transactional
@Service("appuserService")
public class AppuserService {

	@Resource(name = "daoSupport")
	private DaoSupport dao;

	//======================================================================================
    


	/*
	* 通过id获取数据
	*/
	public PageData findByUiId(PageData pd)throws Exception {
		return (PageData)dao.findForObject("AppuserMapper.findByUiId", pd);
	}
	/*
	* 通过loginname获取数据
	*/
	public PageData findByUId(PageData pd)throws Exception {
		return (PageData)dao.findForObject("AppuserMapper.findByUId", pd);
	}
	
	
	
	/*
	* 通过邮箱获取数据
	*/
	public PageData findByUE(PageData pd)throws Exception {
		return (PageData)dao.findForObject("AppuserMapper.findByUE", pd);
	}
	
	/*
	* 通过编号获取数据
	*/
	public PageData findByUN(PageData pd)throws Exception {
		return (PageData)dao.findForObject("AppuserMapper.findByUN", pd);
	}
	
	
	/*
	* 通过账号或者手机号登录
	*/
	public PageData findByAC(PageData pd)throws Exception {
		return (PageData)dao.findForObject("AppuserMapper.findByAC", pd);
	}
	
	/*
	* 通过手机号登录
	*/
	public AppUser findByPhone(PageData pd)throws Exception {
		return (AppUser)dao.findForObject("AppuserMapper.getUserByPhone", pd);
	}
	
	/*
	* 保存用户
	*/
	public void saveU(PageData pd)throws Exception {
		dao.save("AppuserMapper.saveU", pd);
	}
	
	/*
	* 保存用户
	*/
	public void saveAppUser(AppUser appUser)throws Exception {
		dao.save("AppuserMapper.saveAppUser", appUser);
	}
	
	/*
	* 修改用户
	*/
	public void editU(PageData pd)throws Exception {
		dao.update("AppuserMapper.editU", pd);
	}
	
	/*
	* 部分保存用户资料
	*/
	public void editUD(PageData pd)throws Exception {
		dao.update("AppuserMapper.editUD", pd);
	}
	
	/*
	* 部分保存用户头像
	*/
	public void editUH(PageData pd)throws Exception {
		dao.update("AppuserMapper.editUH", pd);
	}
	
	/*
	* 部分保存身份证审核
	*/
	public void editCD(PageData pd)throws Exception {
		dao.update("AppuserMapper.editCD", pd);
	}
	
	/*
	* 更改审核状态
	*/
	public void editAudit(PageData pd)throws Exception {
		dao.update("AppuserMapper.editAudit", pd);
	}
	

	
	/**
	 * 只减用户积分
	 * @Title: editIntegral 
	 * @Description:  
	 * @param pd
	 * @throws Exception
	 */
	public void cutIntegral(PageData pd) throws Exception {
		dao.update("AppuserMapper.cutIntegral", pd);
	}
	
	/*
	* 删除用户
	*/
	public void deleteU(PageData pd)throws Exception {
		dao.delete("AppuserMapper.deleteU", pd);
	}
	/*
	* 批量删除用户
	*/
	public void deleteAllU(String[] USER_IDS)throws Exception {
		dao.delete("AppuserMapper.deleteAllU", USER_IDS);
	}
	/*
	*用户列表(全部)
	*/
	public List<PageData> listAllUser(PageData pd)throws Exception {
		return (List<PageData>) dao.findForList("AppuserMapper.listAllUser", pd);
	}
	
	/*
	*用户列表(用户组)
	*/
	public List<PageData> listPdPageUser(Page page)throws Exception {
		return (List<PageData>) dao.findForList("AppuserMapper.userlistPage", page);
	}
	
	/*
	* 保存用户IP
	*/
	public void saveIP(PageData pd)throws Exception {
		dao.update("AppuserMapper.saveIP", pd);
	}
	
	/*
	* 登录判断
	*/
	public PageData getUserByNameAndPwd(PageData pd)throws Exception {
		return (PageData)dao.findForObject("AppuserMapper.getUserInfo", pd);
	}
	/*
	* 更新登录时间
	*/
	public void updateLastLogin(PageData pd)throws Exception {
		dao.update("AppuserMapper.updateLastLogin", pd);
	}
	
	/*
	* 更新密码
	*/
	public void updatePwd(PageData pd)throws Exception {
		dao.update("AppuserMapper.editP", pd);
	}
	
	/*
	 * 判断手机号是否被占用
	 */
	public boolean isAvailable(PageData pd)throws Exception {
		AppUser appUser =  (AppUser)dao.findForObject("AppuserMapper.getUserByPhone" , pd);
		//true表示手机号已经被占用
		if(appUser != null){
			return false;	
		}
		return true;
	}
	
	/*
	 * 查询用户并返回appuser对象
	 */
	public AppUser findByACUser(PageData pd)throws Exception {
		return (AppUser)dao.findForObject("AppuserMapper.findByACUser", pd);
	}
	
	
	
	/**
	 * 查询积分 前十名
	 * @Title: findUserByMonthTop 
	 * @Description:  
	 * @param
	 * @return
	 * @throws Exception
	 */
	public List<PageData> findUserByIntegralTop()throws Exception {
		return (List<PageData>)dao.findForList("AppuserMapper.findUserByIntegralTop",null);
	}
}

