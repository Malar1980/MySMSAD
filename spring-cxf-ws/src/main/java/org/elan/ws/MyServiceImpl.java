package org.elan.ws;

public class MyServiceImpl implements MyService {

	@Override
	public SumResponse sum(SumRequest parameters) {
		int sum = 0;
		for(Integer i: parameters.getAddend()){
			sum += i;
			
		}
		SumResponse response = new SumResponse();
		response.setSum(sum);
		return response;
	}
	@Override
	public int sumpathparam(int add1,int add2)
		{
		
		int sum1;
		sum1=add1+add2;
		return sum1;
		
	}
	
	
}
