package com.xiaobao.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xiaobao.common.pojo.EUDataGridResult;
import com.xiaobao.common.pojo.XiaobaoResult;
import com.xiaobao.common.utils.DateUtils;
import com.xiaobao.mapper.TbMoneyMapper;
import com.xiaobao.mapper.TbOrderMapper;
import com.xiaobao.pojo.TbMoney;
import com.xiaobao.pojo.TbMoneyExample;
import com.xiaobao.pojo.TbMoneyExample.Criteria;
import com.xiaobao.pojo.TbOrder;
import com.xiaobao.pojo.TbOrderExample;
import com.xiaobao.service.MoneyService;



@Service
public class MoneyServiceImpl implements MoneyService {

//	@Autowired
//	private JdbcTemplate jdbcTemplate;
	@Autowired
	private TbMoneyMapper moneyMapper;
	@Autowired
	private TbOrderMapper orderMapper;
	
	// 定义每天每单的分红金额
	@Value("${EVERY_REWARD}")
	private double EVERY_REWARD;
	@Value("${REFERRER_BONUS}")
	private double REFERRER_BONUS;
	// 奖励梯度
	@Value("${ONE_GENERATION_BONUS}")
	private double ONE_GENERATION_BONUS;
	@Value("${TWO_GENERATION_BONUS}")
	private double TWO_GENERATION_BONUS;
	@Value("${THREE_GENERATION_BONUS}")
	private double THREE_GENERATION_BONUS;
	@Value("${FOUR_GENERATION_BONUS}")
	private double FOUR_GENERATION_BONUS;
	@Value("${FIVE_GENERATION_BONUS}")
	private double FIVE_GENERATION_BONUS;
	@Value("${SIX_GENERATION_BONUS}")
	private double SIX_GENERATION_BONUS;
	
	/**
	 * 无条件查询资金总记录
	 */
	@Override
	@Transactional
	public EUDataGridResult getMoneyList(int page, int rows) {	
		//无条件查询分红列表
		TbMoneyExample example = new TbMoneyExample();
		//分页处理
		PageHelper.startPage(page, rows);
		List<TbMoney> list = moneyMapper.selectByExample(example);
		//创建一个返回对象
		EUDataGridResult result = new EUDataGridResult();
		result.setRows(list);
		//取记录总条数
		PageInfo<TbMoney> pageInfo = new PageInfo<>(list);
		result.setTotal(pageInfo.getTotal());
		return result;
	}
	
	/**
	 * 根据name查询资金记录
	 */
	@Override
	@Transactional
	public EUDataGridResult getMoneyListByName(int page, int rows, String name) {	
		//按照name查询资金记录列表
		TbMoneyExample example = new TbMoneyExample();
		Criteria criteria = example.createCriteria();
		criteria.andNameEqualTo(name);
		List<TbMoney> list = moneyMapper.selectByExample(example);
		//分页处理
		PageHelper.startPage(page, rows);		
		//创建一个返回对象
		EUDataGridResult result = new EUDataGridResult();
		result.setRows(list);
		//取记录总条数
		PageInfo<TbMoney> pageInfo = new PageInfo<>(list);
		result.setTotal(pageInfo.getTotal());
		return result;	
	}
	
	/**
	 * 根据mobile查询资金记录
	 */
	@Override
	@Transactional
	public EUDataGridResult getMoneyListByMobile(int page, int rows, String mobile) {
		//按照mobile查询资金记录列表
		TbMoneyExample example = new TbMoneyExample();
		Criteria criteria = example.createCriteria();
		criteria.andMobileEqualTo(mobile);
		List<TbMoney> list = moneyMapper.selectByExample(example);
		//分页处理
		PageHelper.startPage(page, rows);		
		//创建一个返回对象
		EUDataGridResult result = new EUDataGridResult();
		result.setRows(list);
		//取记录总条数
		PageInfo<TbMoney> pageInfo = new PageInfo<>(list);
		result.setTotal(pageInfo.getTotal());
		return result;
	}
	
	/**
	 * 根据releasedate查询资金记录
	 */
	@Override
	@Transactional
	public EUDataGridResult getMoneyListByDate(int page, int rows, String releasedate) {
		//按照releasedate查询资金记录列表
		TbMoneyExample example = new TbMoneyExample();
		Criteria criteria = example.createCriteria();
		criteria.andReleasedateEqualTo(releasedate);
		List<TbMoney> list = moneyMapper.selectByExample(example);
		//分页处理
		PageHelper.startPage(page, rows);		
		//创建一个返回对象
		EUDataGridResult result = new EUDataGridResult();
		result.setRows(list);
		//取记录总条数
		PageInfo<TbMoney> pageInfo = new PageInfo<>(list);
		result.setTotal(pageInfo.getTotal());
		return result;
	}
	
	/**
	 * 根据name和mobile联合查询资金记录
	 */
	@Override
	@Transactional
	public EUDataGridResult getMoneyListByNameAndMobile(int page, int rows, String name, String mobile) {
		//按照name和mobile联合查询资金记录列表
		TbMoneyExample example = new TbMoneyExample();
		Criteria criteria = example.createCriteria();
		criteria.andNameEqualTo(name);
		criteria.andMobileEqualTo(mobile);
		List<TbMoney> list = moneyMapper.selectByExample(example);
		//分页处理
		PageHelper.startPage(page, rows);		
		//创建一个返回对象
		EUDataGridResult result = new EUDataGridResult();
		result.setRows(list);
		//取记录总条数
		PageInfo<TbMoney> pageInfo = new PageInfo<>(list);
		result.setTotal(pageInfo.getTotal());
		return result;
	}	
	
	/**
	 * 根据name和releasedate联合查询资金记录
	 */
	@Override
	@Transactional
	public EUDataGridResult getMoneyListByNameAndDate(int page, int rows, String name, String releasedate) {
		//按照name和releasedate联合查询资金记录列表
		TbMoneyExample example = new TbMoneyExample();
		Criteria criteria = example.createCriteria();
		criteria.andNameEqualTo(name);
		criteria.andReleasedateEqualTo(releasedate);
		List<TbMoney> list = moneyMapper.selectByExample(example);
		//分页处理
		PageHelper.startPage(page, rows);		
		//创建一个返回对象
		EUDataGridResult result = new EUDataGridResult();
		result.setRows(list);
		//取记录总条数
		PageInfo<TbMoney> pageInfo = new PageInfo<>(list);
		result.setTotal(pageInfo.getTotal());
		return result;
	}

	/**
	 * 根据mobile和releasedate联合查询资金记录
	 */
	@Override
	@Transactional
	public EUDataGridResult getMoneyListByMobileAndDate(int page, int rows, String mobile, String releasedate) {
		//按照mobile和releasedate联合查询资金记录列表
		TbMoneyExample example = new TbMoneyExample();
		Criteria criteria = example.createCriteria();
		criteria.andMobileEqualTo(mobile);
		criteria.andReleasedateEqualTo(releasedate);
		List<TbMoney> list = moneyMapper.selectByExample(example);
		//分页处理
		PageHelper.startPage(page, rows);		
		//创建一个返回对象
		EUDataGridResult result = new EUDataGridResult();
		result.setRows(list);
		//取记录总条数
		PageInfo<TbMoney> pageInfo = new PageInfo<>(list);
		result.setTotal(pageInfo.getTotal());
		return result;
	}

	/**
	 * 根据name、mobile和releasedate联合查询资金记录
	 */
	@Override
	@Transactional
	public EUDataGridResult getMoneyListByNameAndMobileAndDate(int page, int rows, String name, String mobile, String releasedate) {
		//按照name、mobile和releasedate联合查询资金记录列表
		TbMoneyExample example = new TbMoneyExample();
		Criteria criteria = example.createCriteria();
		criteria.andNameEqualTo(name);
		criteria.andMobileEqualTo(mobile);
		criteria.andReleasedateEqualTo(releasedate);
		List<TbMoney> list = moneyMapper.selectByExample(example);
		//分页处理
		PageHelper.startPage(page, rows);		
		//创建一个返回对象
		EUDataGridResult result = new EUDataGridResult();
		result.setRows(list);
		//取记录总条数
		PageInfo<TbMoney> pageInfo = new PageInfo<>(list);
		result.setTotal(pageInfo.getTotal());
		return result;
	}

	/**
	 * 确认发放分红
	 */
	@Override
	@Transactional
	public XiaobaoResult distributeReward(String mobiles, String rewards) {
		String[] mobileArr = mobiles.split(",");
		String[] rewardArr = rewards.split(",");
		//遍历所有选中的手机号
		for(int i = 0; i < mobileArr.length; i++){
			//取得手机号以及对应的分红金额
			String mobile = mobileArr[i];
			Double reward = Double.parseDouble(rewardArr[i]);
			
			TbMoneyExample moneyExample = new TbMoneyExample();
			Criteria moneyCriteria = moneyExample.createCriteria();	
			moneyCriteria.andMobileEqualTo(mobile);
			List<TbMoney> moneyList = moneyMapper.selectByExample(moneyExample);	//根据mobile查询money
			if(moneyList != null && moneyList.size() > 0){
				TbMoney money = moneyList.get(0);				
				//修改mobile对应的当天tb_order表信息
				//根据手机号更新tb_order表分红累计以及已分红天数信息
				if(updateReward(mobile, reward)){
					money.setIsrewardrelease(true);
					moneyMapper.updateByExample(money, moneyExample);		
				}else{
					return XiaobaoResult.build(400, "更新分红失败");
				}
			}
		}
		return XiaobaoResult.ok();		
	}
	
	/**
	 * 根据手机号更新tb_order表分红累计以及已分红天数信息
	 * @param mobile
	 * @return
	 */
	@Transactional
	private boolean updateReward(String mobile, double reward){
		TbOrderExample example1 = new TbOrderExample();
		com.xiaobao.pojo.TbOrderExample.Criteria criteria1 = example1.createCriteria();
		
		criteria1.andMobileEqualTo(mobile);
		criteria1.andOrderstatusEqualTo((byte) 1);
		
		List<TbOrder> list = orderMapper.selectByExample(example1);	//根据手机号和订单状态查询相关订单
		if(list != null && list.size() > 0){
			double todayRewardTotal = 0;
			for(int i = 0; i < list.size(); i++){
				TbOrder order = list.get(i);
				Integer ordercnt = order.getOrdercnt();
				double rewardToday = EVERY_REWARD * ordercnt;
				todayRewardTotal += rewardToday;
			}
			if(todayRewardTotal == reward){	//校验前台传来的reward是否和后台数据库读取计算的todayRewardTotal一致
				//遍历该mobile下的有效订单，并更新分红累计以及已分红天数信息
				for(int i = 0; i < list.size(); i++){
					TbOrder order = list.get(i);		
					String orderid = order.getOrderid();
					Double rewardalready = order.getRewardalready();
					Integer rewardDays = order.getRewarddays();
					Integer ordercnt = order.getOrdercnt();
					Integer daysalready = order.getDaysalready();
					Double rewardToday = EVERY_REWARD * ordercnt;
					
					rewardalready += rewardToday;	//累计每天的分红金额
					daysalready += 1;	//分红天数自加1
					
					//如果分红总天数等于已分红天数，则关闭该订单
					if(rewardDays == daysalready){
						order.setOrderstatus((byte) 0);
					}
					
					order.setRewardalready(rewardalready);
					order.setDaysalready(daysalready);
					order.setUpdatedate(new Date());

					TbOrderExample example2 = new TbOrderExample();
					com.xiaobao.pojo.TbOrderExample.Criteria criteria2 = example2.createCriteria();
					criteria2.andOrderidEqualTo(orderid);
					orderMapper.updateByExample(order, example2);	//根据订单号更新订单信息				
				}
				return true;
			}
			return false;	
		}
		return false;
	}
	
	/**
	 * 根据手机号更新tb_order表奖励信息（未完成）
	 * @param mobile
	 * @return
	 */
	@Transactional
	private boolean updateBonus(String mobile){
		TbOrderExample example1 = new TbOrderExample();
		com.xiaobao.pojo.TbOrderExample.Criteria criteria1 = example1.createCriteria();
		
		criteria1.andMobileEqualTo(mobile);
		criteria1.andOrderstatusEqualTo((byte) 1);
		
		List<TbOrder> list = orderMapper.selectByExample(example1);	//根据手机号和订单状态查询相关订单
		if(list != null && list.size() > 0){
			//遍历该mobile下的有效订单
			for(int i = 0; i < list.size(); i++){
				TbOrder order = list.get(i);
				/**
				 *  奖励的回写逻辑
				 */
				
				
				return true;
			}
		}
		return false;
	}
	
	
	/**
	 * 确认发放奖励
	 */
	@Override
	@Transactional
	public XiaobaoResult distributeBonus(String mobiles) {
		String[] mobileArr = mobiles.split(",");
		for(int i = 0; i < mobileArr.length; i++){
			String mobile = mobileArr[i];
			System.err.println("mobile = "+mobile);
			TbMoneyExample example = new TbMoneyExample();
			Criteria criteria = example.createCriteria();	
			criteria.andMobileEqualTo(mobile);
			List<TbMoney> list = moneyMapper.selectByExample(example);	//根据mobile查询rewardVO
			if(list != null && list.size() > 0){
				TbMoney moneyVO = list.get(0);
				System.err.println("name = "+moneyVO.getName());
				moneyVO.setIsbonusrelease(true);;
				moneyMapper.updateByExample(moneyVO, example);
			}
		}	
		return XiaobaoResult.ok();
	}

	/**
	 * 计算推荐人奖励
	 * 
	 * @param mobile
	 * @return
	 */
	@Override
	@Transactional
	public boolean referrerBonus(String name, String mobile){
		try {
			TbMoney moneyVO = new TbMoney();
			moneyVO.setName(name);
			moneyVO.setMobile(mobile);
			moneyVO.setBonus(REFERRER_BONUS);
			moneyVO.setReward(0.00);
			moneyVO.setIsbonusrelease(false);
			moneyVO.setIsrewardrelease(false);
			Date releaseDate = DateUtils.dateAdd(new Date(), 1);
			String releaseDateStr = DateUtils.format(releaseDate, "yyyy-MM-dd");
			moneyVO.setReleasedate(releaseDateStr);	//默认第二天发放
			moneyMapper.insert(moneyVO);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
	}
	
	/**
	 * 计算投单人奖励
	 * 
	 * @param name
	 * @param mobile
	 * @param totalCnt
	 * @param orderCnt
	 * @return
	 */
	@Override
	@Transactional
	public boolean userBonus(String name, String mobile, int totalCnt, int orderCnt){
		try {
			TbMoney moneyVO = new TbMoney();
			moneyVO.setName(name);
			moneyVO.setMobile(mobile);
			moneyVO.setBonus(getGenerationBonus(totalCnt, orderCnt));
			moneyVO.setReward(0.00);
			moneyVO.setIsbonusrelease(false);
			moneyVO.setIsrewardrelease(false);
			Date releaseDate = DateUtils.dateAdd(new Date(), 1);
			String releaseDateStr = DateUtils.format(releaseDate, "yyyy-MM-dd");
			moneyVO.setReleasedate(releaseDateStr);	//默认第二天发放
			moneyMapper.insert(moneyVO);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
	}
	
	/**
	 * **** 业务重点 ****
	 * 
	 * 投单人根据总单数获取奖励金额
	 * 
	 * @param totalCnt
	 * @param orderCnt
	 * @return sumGenerationBonus
	 */
	private double getGenerationBonus(int totalCnt, int orderCnt){
		
		int newCnt = totalCnt + orderCnt;	// 投单后的单数
		int newCntInt = (int)newCnt / 10; // 取整
		int newCntRem = newCnt % 10;	// 取余
		int totalCntInt = (int)totalCnt / 10;
		int totalCntRem = totalCnt % 10;
		double sumGenerationBonus = 0.00;
		double totalCntUp = Math.ceil((double)totalCnt / 10) * 10;	// 区间最大值
		// 投单后区间没变，如原来17单，投了3单后20单，仍然属于第二代奖励范围
		if(newCnt <= totalCntUp){
			for(int i = totalCnt + 1; i <= newCnt; i++){
				sumGenerationBonus += caseGenerationBonus(totalCntInt);		
			}
		}
		// 投单后区间变化（跨了一个区间）
		else if((newCnt > totalCntUp) && (newCnt <= totalCntUp + 10)) {
			for(int i = totalCnt + 1; i <= totalCntUp; i++){
				sumGenerationBonus += caseGenerationBonus(totalCntInt);		
			}
			for(int i = (int)totalCntUp + 1; i <= newCnt; i++){
				sumGenerationBonus += caseGenerationBonus(totalCntInt + 1);		
			}
		}
		// 投单后区间变化（跨两个区间）
		else if((newCnt > totalCntUp + 10) && (newCnt <= totalCntUp + 20)){
			for(int i = totalCnt + 1; i <= totalCntUp; i++){
				sumGenerationBonus += caseGenerationBonus(totalCntInt);		
			}
			for(int i = (int)totalCntUp + 1; i <= (int)totalCntUp + 10; i++){
				sumGenerationBonus += caseGenerationBonus(totalCntInt + 1);		
			}
			for(int i = (int)totalCntUp + 11; i <= newCnt; i++){
				sumGenerationBonus += caseGenerationBonus(totalCntInt + 2);		
			}
		}
		// 投单后区间变化（跨三个区间）
		else if((newCnt > totalCntUp + 20) && (newCnt <= totalCntUp + 30)){
			for(int i = totalCnt + 1; i <= totalCntUp; i++){
				sumGenerationBonus += caseGenerationBonus(totalCntInt);		
			}
			for(int i = (int)totalCntUp + 1; i <= (int)totalCntUp + 10; i++){
				sumGenerationBonus += caseGenerationBonus(totalCntInt + 1);		
			}
			for(int i = (int)totalCntUp + 11; i <= (int)totalCntUp + 20; i++){
				sumGenerationBonus += caseGenerationBonus(totalCntInt + 2);		
			}
			for(int i = (int)totalCntUp + 21; i <= newCnt; i++){
				sumGenerationBonus += caseGenerationBonus(totalCntInt + 3);		
			}
		}
		// 投单后区间变化（跨四个区间）
		else if((newCnt > totalCntUp + 30) && (newCnt <= totalCntUp + 40)){
			for(int i = totalCnt + 1; i <= totalCntUp; i++){
				sumGenerationBonus += caseGenerationBonus(totalCntInt);		
			}
			for(int i = (int)totalCntUp + 1; i <= (int)totalCntUp + 10; i++){
				sumGenerationBonus += caseGenerationBonus(totalCntInt + 1);		
			}
			for(int i = (int)totalCntUp + 11; i <= (int)totalCntUp + 20; i++){
				sumGenerationBonus += caseGenerationBonus(totalCntInt + 2);		
			}
			for(int i = (int)totalCntUp + 21; i <= (int)totalCntUp + 30; i++){
				sumGenerationBonus += caseGenerationBonus(totalCntInt + 3);		
			}
			for(int i = (int)totalCntUp + 31; i <= newCnt; i++){
				sumGenerationBonus += caseGenerationBonus(totalCntInt + 4);		
			}
		}
		// 投单后区间变化（跨四个区间）
		else if((newCnt > totalCntUp + 40) && (newCnt <= totalCntUp + 50)){
			for(int i = totalCnt + 1; i <= totalCntUp; i++){
				sumGenerationBonus += caseGenerationBonus(totalCntInt);		
			}
			for(int i = (int)totalCntUp + 1; i <= (int)totalCntUp + 10; i++){
				sumGenerationBonus += caseGenerationBonus(totalCntInt + 1);		
			}
			for(int i = (int)totalCntUp + 11; i <= (int)totalCntUp + 20; i++){
				sumGenerationBonus += caseGenerationBonus(totalCntInt + 2);		
			}
			for(int i = (int)totalCntUp + 21; i <= (int)totalCntUp + 30; i++){
				sumGenerationBonus += caseGenerationBonus(totalCntInt + 3);		
			}
			for(int i = (int)totalCntUp + 31; i <= (int)totalCntUp + 40; i++){
				sumGenerationBonus += caseGenerationBonus(totalCntInt + 4);		
			}
			for(int i = (int)totalCntUp + 41; i <= newCnt; i++){
				sumGenerationBonus += caseGenerationBonus(totalCntInt + 5);		
			}
		}
		return sumGenerationBonus;
	}
		
	/**
	 * 奖励梯度
	 * 1-10单，一代奖励；2-20单，二代奖励，以此类推，目前只到六代
	 * 
	 * @param num
	 * @return generationBonus
	 */
	private double caseGenerationBonus(int num){
		double generationBonus;
		switch((int)num){
			case 0 : generationBonus =  ONE_GENERATION_BONUS; break;
			case 1 : generationBonus =  TWO_GENERATION_BONUS; break;
			case 2 : generationBonus =  THREE_GENERATION_BONUS; break;
			case 3 : generationBonus =  FOUR_GENERATION_BONUS; break;
			case 4 : generationBonus =  FIVE_GENERATION_BONUS; break;
			case 5 : generationBonus =  SIX_GENERATION_BONUS; break;
			default : generationBonus =  SIX_GENERATION_BONUS;
		}
		return generationBonus;
	}
		
		
		

	//通过jdbcTemplate以及VO对象编写
//	@Transactional
//	public EUDataGridResult getRewardList(int page, int rows) {
//		
//		final String reward = "63";
//		
//		//分页处理
//		PageHelper.startPage(page, rows);
//
//		final String sql = "select name, mobile, sum(orderCnt*"+ reward +") todayReward from tb_order where orderStatus = 1 group by name, mobile";
//		List<Map<String, Object>> rewardOrderListMap = new ArrayList<Map<String, Object>>();
//		rewardOrderListMap = jdbcTemplate.queryForList(sql);
//		
//		List<RewardOrderVO> rewardOrderList = new ArrayList<RewardOrderVO>();	
//		if(rewardOrderListMap.size() != 0){	
//			
//			//不能写在for循环外，因为for循环中List会给rewardOrderVO多次赋予对象值，但是rewardOrderVO对象引用是同一个，
//			//这会导致后来的对象值会覆盖之前的对象引用，造成最终的结果是：对象的个数没有问题，但是所有对象都会相同，并且都为最后一个赋值对象
////			RewardOrderVO rewardOrderVO = new RewardOrderVO();	
//			
//            for(Map<String, Object> obj : rewardOrderListMap){          	
//            	RewardOrderVO rewardOrderVO = new RewardOrderVO();	//
//            	try {
//					BeanUtils.populate(rewardOrderVO, obj);
//				} catch (IllegalAccessException | InvocationTargetException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//            	rewardOrderList.add(rewardOrderVO);	//接收rewardOrderVO
//            }	         
//        }else{
//            return null;
//        }	
//		//创建一个返回值对象
//		EUDataGridResult result = new EUDataGridResult();
//		result.setRows(rewardOrderList);
//		//取记录总条数
//		PageInfo<RewardOrderVO> pageInfo = new PageInfo<>(rewardOrderList);
//		result.setTotal(pageInfo.getTotal());	
//		return result;	
//	}
	
	

}
