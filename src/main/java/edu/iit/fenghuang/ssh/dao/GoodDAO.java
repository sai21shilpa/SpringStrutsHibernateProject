package edu.iit.fenghuang.ssh.dao;

import java.util.List;

import edu.iit.fenghuang.ssh.vo.GoodModel;
import edu.iit.fenghuang.ssh.vo.GoodQueryModel;

public interface GoodDAO {
	public void createGood(GoodModel um);
	public void updateGood(GoodModel um);
	public void deleteGood(int uid);
	public GoodModel queryById(int gid);
	public List<GoodModel> queryAll();
	public List<GoodModel> queryByCondition(GoodQueryModel gqm);
}
