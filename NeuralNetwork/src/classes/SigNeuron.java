package classes;

public class SigNeuron extends Neuron {

    public SigNeuron(int inputCount, double beta) {
	super(inputCount);
	// TODO Auto-generated constructor stub
	this.beta = beta;
    }
    
    public SigNeuron(int inputCount, double beta, double bias){
	this(inputCount, beta);
	this.bias = bias;
    }
    
    private double activate(double arg){
	double res = 1/(1 + Math.exp(-1*this.beta*arg - bias));
	return res;
    }
    
    @Override
    public double respone(double[] signal){
	double resp = super.respone(signal);
	double result = this.activate(resp);
	return result;
    }
    
    @Override
    public void learn(double[] signal, double expectedOut, double ratio){
	double resp = this.respone(signal);
	double err = expectedOut - resp;
	double delta = resp*(1 - resp)*err;
	for(int i = 0; i < this.getWeights().length; i++)
	    this.weights[i] +=delta*ratio*expectedOut;
    }
    
    double beta;
    double bias = 0.0d;
}
