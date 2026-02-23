package test;

public class Scratch {
	public static void main(String[] args) {
		// Parameters
		double[] arregloDoubles = {1.1,2.1,3.1,4.1,5.1};
		int[] arregloEnteros = {1,2,3,4,5};
		int posicion = 4;
		int entero = 2;
		// Logic
		if (posicion >= 0 && posicion < arregloEnteros.length) {
        	int[] temp = new int[arregloEnteros.length-1];
        	if (posicion == 0) {
    			System.arraycopy(arregloEnteros, 1, temp, 0, arregloEnteros.length);
    			}
    		else if (posicion == arregloEnteros.length-1) {
    			System.arraycopy(arregloEnteros, 0, temp, 0, arregloEnteros.length-1);		
    			}
    		else {
    			System.arraycopy(arregloEnteros, 0, temp, 0, posicion);
    	    	System.arraycopy(arregloEnteros, posicion+1, temp, posicion, arregloEnteros.length-posicion);
    			}
    		arregloEnteros = temp;
		}
		//Results
		for (int i = 0; i<arregloEnteros.length;i++) 
		{
		System.out.println(arregloEnteros[i]);
		}
		System.out.println("Length: "+ arregloEnteros.length);
		int[] ar = new int[]{};
		System.out.println(ar.length);
	}
}
