import java.util.Scanner;
public class CodigoBarras {
	private static Scanner leer;
	public CodigoBarras() {
		// TODO Auto-generated constructor stub
	}
	public static void main(String[] args) {
		leer = new Scanner(System.in);
		System.out.println("Introduzca el código de barras");
		String codBarras=leer.next();
		if(comprobarCodigoBarras(codBarras)) System.out.println("Código de Barras Correcto");
		else System.err.println("Código de Barras Incorrecto");
	}
	public static boolean comprobarCodigoBarras(String codBarras) {
		int suma=Integer.parseInt(codBarras.substring(0,1));
		for (int x=1;x<codBarras.length()-1;x++) {
			if (x%2!=0)suma+=Integer.parseInt(codBarras.substring(x,x+1))*3;
			else suma+=Integer.parseInt(codBarras.substring(x,x+1))*1;
		}
		int DC=Integer.parseInt(codBarras.substring(codBarras.length()-1));
		int resto=suma%10;
		int decenaSuperior=0;
		if (suma%10>0) decenaSuperior=suma+(10-resto);
		int dc=decenaSuperior-suma;
		if (DC==dc) return true;
		else return false;
	}
}
