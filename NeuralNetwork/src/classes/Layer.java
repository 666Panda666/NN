package classes;

public class Layer {
    public Layer(int inputCount, int countOfNeurons){
	this.neurons = new Neuron[countOfNeurons];
	for(int i = 0; i < this.neurons.length; i++)
	    this.neurons[i] = new Neuron(inputCount);
    }
    
    public double[] respone(double[] signal){
	double[] resp = new double[this.neurons.length];
	for(int i = 0; i < this.neurons.length; i++)
	    resp[i] = this.neurons[i].respone(signal);
	return resp;
    }

    public void learn(double[] signal, double[] expectedOut, double ratio){
	for(int i = 0; i < this.neurons.length; i++)
	    this.neurons[i].learn(signal, expectedOut[i], ratio);
    }
  
    
    public Neuron[] neurons;
}
