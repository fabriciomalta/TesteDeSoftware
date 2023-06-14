package exercicio05b;

public class Somatoria {
	MathOps mathOps;
	 public Somatoria(MathOps mathOps) {
	 this.mathOps = mathOps;
	 }
	 
	 /**
	 * @param numeros
	 * @return a somatoria do fatorial de cada inteiro no array numeros
	 */
	 public int somaDeFatoriais(int numeros[]) {
	 var soma = 0;
	 for(var num : numeros) 
	 soma += mathOps.fatorial(num);
	 
	 return soma;
	 }
}