package org.seckill.exception;
/** 
 * �ظ���ɱ�쳣���������쳣��
* @author Ray: 
* @version 2017��6��8�� ����9:30:40 
* ��˵�� :
*/
public class RepeatKillException extends SeckillException{

	public RepeatKillException(String message) {
		super(message);
	}

	public RepeatKillException(String message, Throwable cause) {
		super(message, cause);
	}
}
