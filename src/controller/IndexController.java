package controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import dao.ItemDaoImpl;
import logic.Item;
import logic.Shop;

public class IndexController implements Controller {

	private Shop shopService;
	//interface�� Shop�� ShopImpl ��θ� ����.
	
	public void setShopService(Shop shopService) {
		this.shopService = shopService;
	}

	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {

		List<Item> itemList = shopService.getItemList();
		// 						����
		//	ShopImpl�� getItemList();
		// return this.itemCatalog.getItemList();
		//						����
		// ItemCatalogImpl�� getItemList();
		// return this.itemDao.findAll();
		//						����
		// ItemDaoImpl�� findAll();
		// RowMapper<Item> mapper = new BeanPropertyRowMapper<Item>(Item.class); ItemŬ���� ��ü�� �־����
		// return this.template.query(ItemDaoImpl.SELECT_ALL, mapper);

		Map<String, Object> model = new HashMap<String, Object>();
		model.put("itemList", itemList);

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("index");
		modelAndView.addAllObjects(model);

		return modelAndView;

	}

}
