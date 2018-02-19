package wx.web.base.dao;

import java.util.List;

import configuration.DBO;
import wx.web.base.bean.BM;

public class BMDao {
	public static final List<BM> selectAll() {
		return DBO.service.S.select(BM.class);
	}
}
