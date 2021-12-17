package com.util;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import com.model.TOrderitem;


public class Cart
{

	protected Map<String, TOrderitem> items;

	public Cart()
	{

		if (items == null)
		{
			items = new HashMap<String, TOrderitem>();
		}
	}

	public void addCheci(String key, TOrderitem orderItem) //��ӳ���
	{
		items.put(key, orderItem);
	}
	
	public void delCheci(String key)  //ɾ������
	{
		items.remove(key);
	}
	

	public void updateCart(String key, int shuliang)  //�޸ĳ���
	{

		TOrderitem orderItem = items.get(key);
		orderItem.setShuliang(shuliang);
		items.put(key, orderItem);
	}

	public int getTotalPrice()  //����ܼ�
	{

		int totalPrice = 0;
		for (Iterator it = items.values().iterator(); it.hasNext();)
		{

			TOrderitem orderItem = (TOrderitem) it.next();
			totalPrice += orderItem.getDanjia()* orderItem.getShuliang();
		}
		return totalPrice;
	}

	public Map<String, TOrderitem> getItems()
	{
		return items;
	}

}
