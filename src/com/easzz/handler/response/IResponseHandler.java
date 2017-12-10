package com.easzz.handler.response;

/**
 * Created by easzz on 2017/12/10 11:32
 * 处理返回数据
 */
public interface IResponseHandler {
	/**
	 * 将数据做想要的转换返回
	 * @param o
	 */
	void handler(Object o);
}
