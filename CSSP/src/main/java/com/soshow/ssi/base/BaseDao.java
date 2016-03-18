package com.soshow.ssi.base;

import java.util.List;

/**
 * 
 * @version 1.0
 * @author xieb
 * @date 2014年12月4日 上午9:47:32
 *
 */
public interface BaseDao<T,K> {

	/**
	 * @Description:创建数据对象
	 * @param po  实体对象
	 */
	public abstract Integer add(T po);

	/**
	 * @Description:批量创建数据对象
	 * @param list	 实体对象
	 */
	public abstract void insertBat(final List<T> list);
	/**
	 * @Description:单条修改数据对象
	 * @param po 实体对象
	 * @return 所影响的行数
	 */
	public abstract int update(T po);

	/**
	 * @Description:批量修改数据对象
	 * @param list  实体对象
	 * @return 所影响的行数
	 */
	public abstract void updateBatch(final List<T> list);

	/**
	 * @Description:删除数据对象
	 * @param id
	 * @return 所影响的行数
	 */
	public abstract int delete(Integer id);

	/**
	 * @Description: 根据id得到数据对象集合
	 * @return
	 */
	public abstract T findById(Integer id);

	/**
	 * <p>
	 * 批量删除数据对象
	 * @param  ids
	 * @return 所影响的行数
	 * @author libing
	 * @created 2011-09-07
	 */
	public abstract int deleteBatch(String ids);

	/**
	 * 批量添加
	 * @param method
	 * @param obj
	 * @return
	 */
	int batchAdd(String method, Object obj);

	/**
	 * 分页查询数据
	 * 
	 * @param params
	 * @param startIndex
	 * @return
	 */
	public List<T> findPageByCondition(K pc);
}
