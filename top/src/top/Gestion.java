package top;
import java.util.Scanner;

class Piloto {
    private int idPiloto;
    private String nomPiloto;
    private int horasVueloPiloto;
    private String rangoPiloto;

    public Piloto(int idPiloto, String nomPiloto, int horasVueloPiloto, String rangoPiloto) {
        this.idPiloto = idPiloto;
        this.nomPiloto = nomPiloto;
        this.horasVueloPiloto = horasVueloPiloto;
        this.rangoPiloto = rangoPiloto;
    }

    public int getIdPiloto() {
        return idPiloto;
    }

    public void setIdPiloto(int idPiloto) {
        this.idPiloto = idPiloto;
    }

    public String getNomPiloto() {
        return nomPiloto;
    }

    public void setNomPiloto(String nomPiloto) {
        this.nomPiloto = nomPiloto;
    }

    public int getHorasVueloPiloto() {
        return horasVueloPiloto;
    }

    public void setHorasVueloPiloto(int horasVueloPiloto) {
        this.horasVueloPiloto = horasVueloPiloto;
    }

    public String getRangoPiloto() {
        return rangoPiloto;
    }

    public void setRangoPiloto(String rangoPiloto) {
        this.rangoPiloto = rangoPiloto;
    }

    public void mostrarPiloto() {
        System.out.println("ID Piloto: " + idPiloto);
        System.out.println("Nombre Piloto: " + nomPiloto);
        System.out.println("Horas de vuelo: " + horasVueloPiloto);
        System.out.println("Rango Piloto: " + rangoPiloto);
    }
}

class Avion {
    private int idAvion;
    private String modAvion;
    private int capAvion;
    private Piloto piloto;

    public Avion(int idAvion, String modAvion, int capAvion, Piloto piloto) {
        this.idAvion = idAvion;
        this.modAvion = modAvion;
        this.capAvion = capAvion;
        this.piloto = piloto;
    }

    public int getIdAvion() {
        return idAvion;
    }

    public void setIdAvion(int idAvion) {
        this.idAvion = idAvion;
    }

    public String getModAvion() {
        return modAvion;
    }

    public void setModAvion(String modAvion) {
        this.modAvion = modAvion;
    }

    public int getCapAvion() {
        return capAvion;
    }

    public void setCapAvion(int capAvion) {
        this.capAvion = capAvion;
    }

    public Piloto getPiloto() {
        return piloto;
    }

    public void setPiloto(Piloto piloto) {
        this.piloto = piloto;
    }

    public void mostrarAvion() {
        System.out.println("ID Avion: " + idAvion);
        System.out.println("Modelo Avion: " + modAvion);
        System.out.println("Capacidad Avion: " + capAvion);
        System.out.println("Piloto Asignado:");
        piloto.mostrarPiloto();
    }
}

class Entrenamiento extends Avion {
    private boolean tieneDobleMando;

    public Entrenamiento(int idAvion, String modAvion, int capAvion, Piloto piloto, boolean tieneDobleMando) {
        super(idAvion, modAvion, capAvion, piloto);
        this.tieneDobleMando = tieneDobleMando;
    }

    public boolean isTieneDobleMando() {
        return tieneDobleMando;
    }

    public void setTieneDobleMando(boolean tieneDobleMando) {
        this.tieneDobleMando = tieneDobleMando;
    }
}

class Combate extends Avion {
    private boolean esFurtivo;

    public Combate(int idAvion, String modAvion, int capAvion, Piloto piloto, boolean esFurtivo) {
        super(idAvion, modAvion, capAvion, piloto);
        this.esFurtivo = esFurtivo;
    }

    public boolean isEsFurtivo() {
        return esFurtivo;
    }

    public void setEsFurtivo(boolean esFurtivo) {
        this.esFurtivo = esFurtivo;
    }
}

public class Gestion {
    public static void main(String[] args) {
        // Crear tres objetos de la clase Piloto
        Piloto maverick = new Piloto(1, "Pete Maverick", 10000, "Capitán");
        Piloto phoenix = new Piloto(2, "Natasha Phoenix", 3000, "Teniente");
        Piloto rooster = new Piloto(3, "Bradley Rooster", 3500, "Teniente");

        try (// Pedir al usuario que introduzca datos de dos pilotos
		Scanner scanner = new Scanner(System.in)) {
			System.out.println("Introduce los datos del cuarto piloto:");
			System.out.print("Nombre: ");
			String nombreCuartoPiloto = scanner.nextLine();
			System.out.print("Rango: ");
			String rangoCuartoPiloto = scanner.nextLine();
			System.out.print("Horas de vuelo: ");
			int horasVueloCuartoPiloto = scanner.nextInt();
			Piloto cuartoPiloto = new Piloto(4, nombreCuartoPiloto, horasVueloCuartoPiloto, rangoCuartoPiloto);

			System.out.println("Introduce los datos del quinto piloto:");
			System.out.print("Nombre: ");
			scanner.nextLine();  // Consumir la línea en blanco
			String nombreQuintoPiloto = scanner.nextLine();
			System.out.print("Rango: ");
			String rangoQuintoPiloto = scanner.nextLine();
			System.out.print("Horas de vuelo: ");
			int horasVueloQuintoPiloto = scanner.nextInt();
			Piloto quintoPiloto = new Piloto(5, nombreQuintoPiloto, horasVueloQuintoPiloto, rangoQuintoPiloto);

			// Mostrar información de algunos pilotos
			System.out.println("\nInformación de Pete Maverick:");
			maverick.mostrarPiloto();
			System.out.println("\nInformación de Bradley Rooster:");
			rooster.mostrarPiloto();

			System.out.println("\nInformación del cuarto piloto:");
			cuartoPiloto.mostrarPiloto();
			System.out.println("\nInformación del quinto piloto:");
			quintoPiloto.mostrarPiloto();

			// Crear tres objetos de la clase Avion
			Avion avionEntrenamiento1 = new Entrenamiento(1, "Entrenamiento 1", 2, maverick, true);
			Avion avionCombate2 = new Combate(3, "Combate 2", 1, rooster, true);

			// Pedir al usuario que introduzca datos de dos aviones de entrenamiento
			System.out.println("\nIntroduce los datos del primer avión de entrenamiento:");
			System.out.print("Modelo: ");
			scanner.nextLine();  // Consumir la línea en blanco
			String modeloEntrenamiento1 = scanner.nextLine();
			System.out.print("Capacidad: ");
			int capacidadEntrenamiento1 = scanner.nextInt();
			System.out.print("ID del piloto asignado: ");
			int idPilotoAsignadoEntrenamiento1 = scanner.nextInt();

			Piloto pilotoAsignadoEntrenamiento1 = buscarPilotoPorID(idPilotoAsignadoEntrenamiento1, maverick, phoenix, rooster, cuartoPiloto, quintoPiloto);

			Avion avionEntrenamiento2 = new Entrenamiento(4, modeloEntrenamiento1, capacidadEntrenamiento1, pilotoAsignadoEntrenamiento1, true);

			System.out.println("\nIntroduce los datos del segundo avión de entrenamiento:");
			System.out.print("Modelo: ");
			scanner.nextLine();  // Consumir la línea en blanco
			String modeloEntrenamiento2 = scanner.nextLine();
			System.out.print("Capacidad: ");
			int capacidadEntrenamiento2 = scanner.nextInt();
			System.out.print("ID del piloto asignado: ");
			int idPilotoAsignadoEntrenamiento2 = scanner.nextInt();

			Piloto pilotoAsignadoEntrenamiento2 = buscarPilotoPorID(idPilotoAsignadoEntrenamiento2, maverick, phoenix, rooster, cuartoPiloto, quintoPiloto);

			Avion avionEntrenamiento3 = new Entrenamiento(5, modeloEntrenamiento2, capacidadEntrenamiento2, pilotoAsignadoEntrenamiento2, false);

			// Mostrar información de algunos aviones
			System.out.println("\nInformación del primer avión de entrenamiento:");
			avionEntrenamiento1.mostrarAvion();
			System.out.println("\nInformación del segundo avión de entrenamiento:");
			avionEntrenamiento2.mostrarAvion();

			System.out.println("\nInformación de los aviones introducidos por el usuario:");
			avionEntrenamiento3.mostrarAvion();
		}
    }

    private static Piloto buscarPilotoPorID(int idPiloto, Piloto... pilotos) {
        for (Piloto piloto : pilotos) {
            if (piloto.getIdPiloto() == idPiloto) {
                return piloto;
            }
        }
        return null;
    }
}
