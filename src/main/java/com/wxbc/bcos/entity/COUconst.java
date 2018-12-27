package com.wxbc.bcos.entity;

import java.util.concurrent.atomic.AtomicInteger;

public class COUconst {
	public static final int COU_ERROR_OK = 0;
	public static final int COU_ERROR_BAD = -1;
	public static final AtomicInteger count =new AtomicInteger(0);
	public static final AtomicInteger integer =new AtomicInteger(0);
	public static long startTime ;


	//response code
	public static final int COU_CODE_OK = 0;
	public static final int COU_CODE_FAILURE = -1;	
	public static final int COU_CODE_UNKNOWN = -2;

}
