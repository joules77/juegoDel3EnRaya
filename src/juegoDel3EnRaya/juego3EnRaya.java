package juegoDel3EnRaya;

public class juego3EnRaya {

	public static void main(String[] args) {
		jugar();

	}
	/*
	 * metodo donde comenzaremos a jugar
	 * */
	public static void jugar() {
		//representaciones de los jugadores y del simbolo vacio
		char J1 = 'X';
		char J2 = 'O'; 
		char vacio = '-';
		
		//turno actual
		//true = J1, false = J2
		boolean turno = true;
		//tablero donde vamos a jugar
		char tablero [][] = new char[3][3];
		//rellenamos la matriz con los guiones
		rellenarMatriz(tablero, vacio);
		
		int fila, columna;
		boolean posValida, correcto;
		
		//no salimos hasta que uno gane o no haya mas posibilidades
		while (!finPartida(tablero, vacio)) {
			do {
				//mostramos al jugador que le toca
				mostrarTurnoActual(turno);
				//muestro el tablero
				mostrarMatriz(tablero);
				
				correcto = false;
				fila = pedirInteger("dame la fila");
				columna = pedirInteger("dame la columna");
				//validamos la posicion
				posValida = validarPosicion(tablero, fila, columna);
				//si es valido, comprobamos que no haya ninguna marca
				if(posValida) {
					//si no ay marca, significa que es correcto
					if(!hayValorPosicion(tablero,fila, columna, vacio)) {
						correcto = true;
					}else {
						System.out.println("Ya hay una marca en esa posicion");
					}
				}else {
					System.out.println("La posicion no es valida");
				}
				//mientras no sea correcto no salgo
			}while (!correcto);
			
				
			
		}
		
	}

}
