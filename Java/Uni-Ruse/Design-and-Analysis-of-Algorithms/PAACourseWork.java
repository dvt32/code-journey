/*
 * Разгледайте "картата" по-долу на услугата за доставка на Фермера Джон.
 * 
 * Тя има:
 * - N реда (2 <= N <= 100) и
 * - M стълба (2 <= M <= 80)
 * 
 * 				Север
 * 		.  .  .  .  .  .  .  T
 * 		.  .  .  .  .  .  C  .
 *		.  .  .  .  C  S  .  .
 *		.  S  .  .  C  .  S  .
 *		D  C  .  .  S  .  .  .
 *
 * Фермерът Джон доставя мляко на 
 *  - своите извънградски клиенти (означени с 'C') докато пътува
 *	- от своята мандра (означена с 'D' и ВИНАГИ намираща се в ДОЛНИЯ-ЛЯВ ЪГЪЛ)
 *	- към града (означен с 'T' и ВИНАГИ намиращ се в горния-десен ъгъл)
 *
 *  Той прекосява пътищата на правоъгълната мрежа движейки се или
 *  - хоризонтално НАДЯСНО или
 *  - вертикално НАГОРЕ, но
 *  - НИКОГА ПО ДИАГОНАЛ 
 *  - Фермерът Джон НИКОГА НЕ СЕ ДВИЖИ НАЛЯВО ИЛИ НАДОЛУ.
 *  
 *  Някои пътища са блокирани от сняг (означени с 'S'), 
 *  което означава, че той НЕ МОЖЕ да преминава през тях.
 *  
 *  НАПИШЕТЕ ПРОГРАМА, която:
 *  - изчислява ОБЩИЯ брой различни маршрута за доставка от мандрата до града.
 *  
 *  Два маршрута са различни ако се различават в някоя част от пътя.
 *  Маршрутите на фермера Джон са такива, че ВСИЧКИ клиенти могат да бъдат достигнати движейки се на север и изток.
 *  
 *  Входните данни съдържат описание на картата.
 *  	На първия ред са разположени:
 *  		- 2 числа X и Y (3 <= X, Y <= 20) - координатите на града.
 *  	На втория ред са разположени:
 *  		- 2 числа C и S - съответно броя на клиентите и броя на полетата със сняг.
 *  	На следващите C реда се съдържат:
 *  		- по 2 цели числа - координати на поредния клиент
 *  	На следващите S реда се съдържат:
 *  		- по 2 цели числа - координати на поредното поле със сняг
 *  Изходът съдържа:
 *  	- 1 цяло число - брой на различните маршрути
 *  
 */

/*
Пример:
Вход:
8 5
4 4
2 1
5 2
5 3	
7 4
2 2
5 1
6 3
7 2
Изход:
4
*/

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class PAACourseWork {
	
	public static char[][] map;
	public static Scanner read;
	public static List<Character> pathToCity = new ArrayList<Character>();
	public static int numberOfValidPaths = 0;
	
	public static void initializeMap() {
		for (int i = 0; i < map.length; ++i) {
			for (int j = 0; j < map[i].length; ++j) {
				map[i][j] = '.';
			}
		}
	}
	public static void placeCityOnMap() {
		int lastColumnIndex = map[0].length - 1;
		map[0][lastColumnIndex] = 'T';
	}
	public static void placeClientsOnMap(int numberOfClients) {
		for (int i = 0; i < numberOfClients; ++i) {
			int clientX = read.nextInt();
			int clientY = read.nextInt();
			int numberOfRows = map.length;
			int clientRow = numberOfRows - clientY;
			int clientColumn = clientX - 1;
			map[clientRow][clientColumn] = 'C';
		}
	}
	public static void placeSnowOnMap(int numberOfSnowyLocations) {
		for (int i = 0; i < numberOfSnowyLocations; ++i) {
			int snowX = read.nextInt();
			int snowY = read.nextInt();
			int numberOfRows = map.length;
			int snowRow = numberOfRows - snowY;
			int snowColumn = snowX - 1;
			map[snowRow][snowColumn] = 'S';
		}
	}
	public static void printMap() {
		System.out.println();
		for (int i = 0; i < map.length; ++i) {
			for (int j = 0; j < map[i].length; ++j) {
				System.out.print(map[i][j] + "  ");
			}
			System.out.println();
		}
	}
	public static boolean inRange(int row, int col) {
		boolean rowInRange = (row >= 0);
		boolean colInRange = (col < map[0].length);
		return rowInRange && colInRange;
	}
	public static void printPath() {
		for (Character direction : pathToCity) {
			System.out.print(direction);
		}
		System.out.println();
	}
	public static void findPathsToCity(int row, int col, char direction, int numberOfClients) {
		// No path found - position is out of the map's range
		if (!inRange(row, col)) {
			return;
		}
		// Path found - reached city
		if (map[row][col] == 'T') {
			int numberOfClientsVisited = 0;
			for (Character directionInPath : pathToCity) {
				if (directionInPath == 'C') {
					numberOfClientsVisited++;
				}
				if (numberOfClientsVisited == numberOfClients) {
					numberOfValidPaths++;
					// printPath();
					break;
				}
			}
			return;
		}
		// No path found - position has been visited already or there is snow in the way
		if (map[row][col] == 'V' || map[row][col] == 'S') {
			return;
		}
		
		// If the current position is a client's location, add it to path as 'C', otherwise add the direction ('U' or 'R')
		if (map[row][col] == 'C') { 
			pathToCity.add('C'); 
		}
		else { 
			pathToCity.add(direction); 
		}
		
		// Remember current position's value, in order to restore it later
		char temp = map[row][col]; 	
		// Mark current position as visited, in order to avoid cycles
		map[row][col] = 'V'; 							
		// Recersively find all other paths by moving up and right
		findPathsToCity(row - 1, col, 'U', numberOfClients); // move up
		findPathsToCity(row, col + 1, 'R', numberOfClients); // move right
		// Restore map's original position values
		map[row][col] = temp;
		// Remove last direction from path when returning from recursion
		pathToCity.remove(pathToCity.size()-1);	
	}
	
	public static void main(String[] args) {
		read = new Scanner(System.in);
		
		int X = read.nextInt();
		int Y = read.nextInt();
		int C = read.nextInt(); // number of clients
		int S = read.nextInt(); // number of snowy locations
		
		int N = Y; // number of rows
		int M = X; // number of columns
		map = new char[N][M];
		
		initializeMap();
		placeCityOnMap();
		placeClientsOnMap(C);
		placeSnowOnMap(S);
		// printMap();
	
		int farmerPathStartRow = N-1;
		int farmerPathStartCol = 0;
		char pathStartSymbol = 'D';
		
		findPathsToCity(farmerPathStartRow, farmerPathStartCol, pathStartSymbol, C);
		
		System.out.println(numberOfValidPaths);
		
		// Close scanner
		read.close();
	}

}
