package steepest;

import java.util.Arrays;

public class Steepest_lib {
	
	private double x[], objective = 0, eta = 0.1;

	public Steepest_lib(double x[]) {
		this.x = x;
	}
	
	//勾配(∂z/∂x, ∂z/∂y) = (2x,2y)
	//変位(Δx,Δy) = -η(2x,2y)
	//次座標(x(i+1),y(i+1))=(x(i),y(i))+(Δx,Δy)
	
	public void getSolution() {
		for(int i = 0; i < 1000; i++) {
			if(Math.abs(this.objective - this.getObjective(this.x)) < 0.0000000001) break;
			this.objective = this.getObjective(this.x);
			this.x = this.getVevtor(this.x);
			System.out.println("x["+i+"] = "+ Arrays.toString(this.x));
			System.out.println("Object["+i+"] = "+ this.objective);
		}
	}
	
	public double[] getVevtor(double x[]) {
		double answer[] = x;
		//目的関数をz=x^2+y^2としている
		for(int i = 0; i < x.length; i++) {
			answer[i] += -2 * eta * x[i];
		}
		return answer;
	}

	public double getObjective(double x[]) {
		double answer = 0;
		//目的関数をz=x^2+y^2としている
		for(int i = 0; i < x.length; i++) {
			answer += Math.pow(x[i],2);
		}
		return answer;
	}
	
}
