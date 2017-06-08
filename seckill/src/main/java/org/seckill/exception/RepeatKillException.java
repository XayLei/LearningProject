package org.seckill.exception;
/** 
 * 重复秒杀异常（运行期异常）
* @author Ray: 
* @version 2017年6月8日 下午9:30:40 
* 类说明 :
*/
public class RepeatKillException extends SeckillException{

	public RepeatKillException(String message) {
		super(message);
	}

	public RepeatKillException(String message, Throwable cause) {
		super(message, cause);
	}
}
