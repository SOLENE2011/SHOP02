package controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import logic.Item;
import logic.Shop;

@Controller
public class DetailController {

	private Shop shopService;

	public void setShopService(Shop shopService) {
		this.shopService = shopService;
	}

	@RequestMapping
	public ModelAndView detailItem(Integer itemId) {

		Item item = this.shopService.getItemByItemId(itemId);
		//						°È°È°È
		// ShopImpl¿« getItemByItemId
		// return this.itemCatalog.getItemByItemId(itemId);
		//						°È°È°È
		// ItemCatalogImpl¿« Item getItemByItemId(Integer itemId) {
		// return this.itemDao.findByPrimaryKey(itemId);
		// ItemDaoImpl¿« Item  findByPrimaryKey(Integer itemId) {
		//RowMapper<Item> mapper = new BeanPropertyRowMapper<Item>(Item.class);
		//return this.template.queryForObject(SELECT_BY_PRIMARY_KEY, mapper, itemId);
		
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("item", item);

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("detail");
		modelAndView.addAllObjects(model);

		return modelAndView;
	}

}
