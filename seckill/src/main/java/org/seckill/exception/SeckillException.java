package org.seckill.exception;
/** 
 * 所有秒杀业务相关异常
* @author Ray: 
* @version 2017年6月8日 下午9:37:49 
* 类说明 :
*/
public class SeckillException extends RuntimeException {

	public SeckillException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public SeckillException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

}
