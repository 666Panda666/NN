package classes;
import java.util.*;


public class Neuron {
    public Neuron(int inputCount){
	this.weights = new double[inputCount];
	Random r = new Random();
	for(int i = 0; i < this.weights.length; i++)
	    this.weights[i] = r.nextDouble();
    }
    
    public double respone( double[] signal ){
	double resp = 0.0d;
	for(int i = 0; i < this.weights.length; i++)
	    resp += this.weights[i]*signal[i];
	return resp;
    }
    
    public void learn(double[] signal, double expectedOut, double ratio){
	double resp = this.respone(signal);
	double err = expectedOut - resp;
	for(int i = 0; i < this.weights.length; i++)
	    this.weights[i]+= ratio*err*signal[i];
    }
    
    public void Learn(double[] signals, double[] previous_weights, double error, double sigma, double ratio, double momentum)
    {
        for (int i = 0; i < this.weights.length; i++)
            this.weights[i] += ratio * sigma * signals[i] - momentum * (this.weights[i] - previous_weights[i]);
    }
    
    public double[] getWeights(){
	return this.weights;
    }
    
    public double getWeight(int index){
	return this.weights[index];
    }
    
    protected double[] weights;
}
