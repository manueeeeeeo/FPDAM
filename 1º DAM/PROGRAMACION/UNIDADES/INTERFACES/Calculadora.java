package interfaces;

public class Calculadora implements Matematicas{

	@Override
	public int suma(int a, int b) {
		// TODO Auto-generated method stub
		return a+b;
	}

	@Override
	public float suma(float a, float b) {
		// TODO Auto-generated method stub
		return a+b;
	}

	@Override
	public double suma(double a, double b) {
		// TODO Auto-generated method stub
		return a+b;
	}

	@Override
	public int multiplicacion(int a, int b) {
		// TODO Auto-generated method stub
		return a*b;
	}
}
