import java.util.Scanner;
public class Main {

	public static void main(String[] args) {
		
		//------Estudiantes existentes-------
		Estudiante est1 = new Estudiante(null, 0, null, 0, null);
		Estudiante est2 = new Estudiante(null,0,null,0,null);
		Estudiante est3 = new Estudiante (null, 0, null, 0, null);
		Estudiante est4 = new Estudiante (null, 0, null, 0, null);
		Estudiante est5= new Estudiante (null, 0, null, 0, null);
		Estudiante Array1 [] = new Estudiante[] {est1,est2,est3,est4,est5}; //Array default
		
		// ------Estudiantes ingresados------- 
		Estudiante est6 = new Estudiante(null, 0, null, 0, null);
		Estudiante est7 = new Estudiante(null,0,null,0,null);
		Estudiante est8 = new Estudiante (null, 0, null, 0, null);
		Estudiante est9 = new Estudiante (null, 0, null, 0, null);
		Estudiante est10= new Estudiante (null, 0, null, 0, null);
		Estudiante Array2 [] = new Estudiante[] {est6,est7,est8,est9,est10}; //Array que se rellena

		est1.nombre = "Gabriel"; est1.numControl = 24; est1.materia = "Ingles"; est1.calificacion = 80; est1.estado = "Aprobado";
		
		est2.nombre = "Jennifer"; est2.numControl = 25; est2.materia = "Español"; est2.calificacion = 100; est2.estado = "Aprobado";
		
		est3.nombre = "Asabi"; est3.numControl = 26; est3.materia = "Matematicas"; est3.calificacion = 23; est3.estado = "Reprobado";
		
		est4.nombre = "Humberto";	est4.numControl = 27; est4.materia = "Formacion Civica"; est4.calificacion = 79; est4.estado = "Aprobado";

		est5.nombre = "Quebin"; est5.numControl = 28; est5.materia = "Logica"; est5.calificacion = 55; est5.estado = "Reprobado";
	
		System.out.println("------ Lista de alumnos existentes ------");
		System.out.println();
		for(int i=0;i<Array1.length;i++) {
			System.out.println((i+1)+".- "+Array1[i].nombre+" | "+Array1[i].numControl+ " | "+Array1[i].materia+" | "+Array1[i].calificacion+" | "+Array1[i].estado);
		}
		System.out.println();
		System.out.println();
		
		//------ Menu -------
		boolean salir = false;
		do {
			System.out.println();
			System.out.println("Menu: ");
			System.out.println("1.- Capturar alumnos");
			System.out.println("2.- Mostrar alumnos");
			System.out.println("3.- Cambiar calificacion");
			System.out.println("4.- Salir.");
			System.out.println();
			int opc = Capture.capturarEntero("Eliga una opcion ");

			switch(opc) {
				case 1:
					Alumno.capturarAlumno(Array2);
					break;
				case 2:
					Alumno.mostrarAlumnos(Array1, Array2);
					break;
				case 3:
					System.out.println();
					Alumno.mostrarAlumnos(Array1, Array2);
					System.out.println();
					int numero = Capture.capturarEntero("\t>> Ingrese el numero de alumno al que desea cambiar la calificación");
					Alumno.cambiarCalificacion(numero, Array1, Array2);
					break;
				case 4:
					System.out.println("-----------------");
					System.out.println("Hasta luego.");
					System.exit(1);
					break;
			}
		}while(salir!=true);
		
	
	}
}

class Capture{
	//Aquí para capturar enteros
    public static int capturarEntero(String msg){
        Scanner sc = new Scanner(System.in);
        System.out.print(""+msg+": ");
        return (sc.nextInt());
    }
    //Aquí para capturar flotantes
    public static float capturarFlotante(String msg){
        Scanner sc = new Scanner(System.in);
        System.out.print(""+msg+": ");
        return (sc.nextFloat());
    }
    //Aquí para capturar dobles
    public static double capturarDoble(String msg){
        Scanner sc = new Scanner(System.in);
        System.out.print(""+msg+": ");
        return (sc.nextDouble());
    }
    //Y finalmente aquí para capturar cadenas
    public static String capturarString(String msg){
        Scanner sc = new Scanner(System.in);
        System.out.print(""+msg+": ");
        return (sc.nextLine());
    }

}

class Alumno{
	public static double cambiarCalificacion(int num, Estudiante[] Array1, Estudiante [] Array2) {
		Scanner sc = new Scanner(System.in);
		System.out.println();
		System.out.println("\t>> Introduce la nueva calificación: ");
		int cal = sc.nextInt();
		if(num >= 1 || num <= 5) {
			Array1[num-1].calificacion = cal;
			Array1[num-1].estado = Alumno.asignarEstado(cal);
			System.out.println("La nueva calificación de "+Array1[num-1].nombre+ " es: "+Array1[num-1].calificacion);
		}
		else if(num >= 6 || num <=10) {
			Array2[num-1].calificacion = cal;
			Array2[num-1].estado = Alumno.asignarEstado(cal);
			System.out.println("La nueva calificación de "+Array2[num-1].nombre+ " es: "+Array2[num-1].calificacion);
		}
		return cal;
		
	}
	public static String asignarEstado(int calificacion) {
		String estado;
		if(calificacion<60) {
			estado = "Reprobado";
		}
		else {
			estado = "Aprobado";
		}
		return(estado);
	}
	public static String capturarAlumno(Estudiante [] Array2) {
		for(int i=0;i<Array2.length;i++) {
			
			Array2[i].nombre = Capture.capturarString("Ingrese el nombre del estudiante "+(i+1));
			Array2[i].numControl = Capture.capturarEntero("Ingrese el número de control del estudiante "+(i+1));
			Array2[i].materia = Capture.capturarString("Ingrese la materia ");
			Array2[i].calificacion = Capture.capturarEntero("Ingrese la calificacion del estudiante "+(i+1));
			Array2[i].estado = Alumno.asignarEstado(Array2[i].calificacion);
			System.out.println();
		}

		return null;
	}
	
	public static String mostrarAlumnos(Estudiante [] Array1, Estudiante [] Array2) {
		System.out.println("------ Lista de alumnos existentes ------");
		for(int i=0;i<Array1.length;i++) {
			System.out.println((i+1)+".- "+Array1[i].nombre+" | "+Array1[i].numControl+ " | "+Array1[i].materia+" | "+Array1[i].calificacion+" | "+Array1[i].estado);
		}
		int contador = 5;
		for(int i=0;i<Array2.length;i++) {
			System.out.println((contador+1)+".- "+Array2[i].nombre+" | "+Array2[i].numControl+ " | "+Array2[i].materia+" | "+Array2[i].calificacion+" | "+Array2[i].estado);
			contador++;
		}
		return null;
	}
	
}
