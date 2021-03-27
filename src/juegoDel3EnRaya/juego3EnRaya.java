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
			
			//depende del turno, inserta un simbolo u otro
			if(turno) {
				insertarEn(tablero, fila, columna, J1);
			}else {
				insertarEn(tablero, fila, columna, J2);
			}
			//cambio de turno
			turno = !turno;
				
			
		}
		//muestra el tablero
		mostrarMatriz(tablero);
		//mostrar el ganador
		mostrarGanador(tablero, J1, J2, vacio);
		
	}
	/*
	 * param matriz
	 * param J1
	 * param J2
	 * param simDef
	 * */
	public static void mostrarGanador(char[][]matriz, char J1, char J2, char simDef) {
		char simbolo = coincidenciaLinea(matriz, simDef);
		if(simbolo! = simDef) {
			ganador(simbolo, J1, J2, 1);
			
			return;
			}
		simbolo = coincidenciaColumna(matriz, simDef);
		if(simbolo != simDef) {
			ganador(simbolo, J1, J2, 2);
			return;
			}
		simbolo = coincidenciaDiagonal(matriz, simDef);
		if(simbolo != simDef) {
			ganador(simbolo, J1, J2, 3);
			return;
			}
		System.out.println("Hay un empate");
		}
	/*
	 * funcion auxiliar de la anterior funcion
	 * @param simbolo
	 * @param J1
	 * @param J2
	 * @param tipo
	 * */
	public static void ganador(char simbolo, char J1, char J2, int tipo) {
		switch(tipo) {
		case 1:
			if(simbolo == J1) {
				System.out.println("Ha ganado el jugador 1 por linea");
			}else {
				System.out.println("Ha ganado el jugador 2 por linea");
			}
			break;
		case 2:
			if(simbolo == J1) {
				System.out.println("Ha ganado el jugador 1 por columna");
			}else {
				System.out.println("Ha ganado el jugador 2 por columna");
			}
		}
	}
	}
	

}
